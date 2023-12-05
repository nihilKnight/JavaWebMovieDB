package dao;

import entity.Person;
import entity.Movie;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MoviesDao {

    public List<Movie> Resolve(ResultSet rs) {
        List<Movie> ml = new ArrayList<>();

        /** Resolve SQL results. */
        while (true) {
            try {
                if (! rs.next()) break;
                Movie m = new Movie();
                m.setMovieId(rs.getInt(1));
                m.setBudget(rs.getInt(2));
                m.setHomepage(rs.getString(3));
                m.setOriginalLanguage(rs.getString(4));
                m.setOriginalTitle(rs.getString(5));
                m.setOverview(rs.getString(6));
                m.setPopularity(rs.getDouble(7));
                m.setReleaseDate(rs.getString(8));
                m.setRevenue(rs.getInt(9));
                m.setRuntime(rs.getInt(10));
                m.setStatus(rs.getString(11));
                m.setTagline(rs.getString(12));
                m.setTitle(rs.getString(13));
                m.setVoteAverage(rs.getDouble(14));
                m.setVoteCount(rs.getInt(15));
                ml.add(m);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return ml;
    }

    /** TODO: SelectAll, SelectById, SelectByPerson, Update, Insert, Delete. */

}
