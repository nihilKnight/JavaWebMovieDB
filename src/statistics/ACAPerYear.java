package statistics;

import SQLTemplate.SelectT;
import dao.GenreDao;
import dao.MoviesDao;
import dao.TableName;
import exce.XDimensionParameterException;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * This file is to illustrate the contribution of movies of every director/actor per year.
 */

public class ACAPerYear {
    public static final int xDimension = 10;
    public List<String> xLabels = new ArrayList<>();
    public List<String> yLabels = new ArrayList<>();

    public ACAPerYear() {
        Set<String> xSet = new HashSet<>();
        Set<String> ySet = new HashSet<>();

        MoviesDao.QueryAndResolve(
                new SelectT(TableName.movie_table).toSQL()
        ).forEach( movie -> xSet.add(new SimpleDateFormat("yyyy").format(movie.release_date)));
        this.xLabels.addAll(xSet);
        this.xLabels.sort(Collections.reverseOrder());
        try {
            if (this.xLabels.size() < xDimension)
                throw new XDimensionParameterException();
        } catch (XDimensionParameterException xdpe) {
            xdpe.printStackTrace();
        }

//        GenreDao.QueryAndResolve(
//                new SelectT(TableName.cast_table, ).toSQL()
//        ).forEach( genre -> ySet.add(genre.genre_name));
//        this.yLabels.addAll(ySet);
//        Collections.sort(this.yLabels);
    }
}
