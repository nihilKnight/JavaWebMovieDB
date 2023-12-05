package dao;

import SQLTemplate.*;
import entity.Movie;
import util.SQLUtil;

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

    public List<Movie> SelectAll(Integer limit) {
        return Resolve(SQLUtil.Query(
                new SelectT(TableName.movie_table)
                        .AddOrder(new Movie().getMovieId().attri_name)
                        .Limit(limit)
                        .toSQL()
        ));
    }

    public Movie SelectById(Integer id) {
        Movie wanted = new Movie();
        wanted.setMovieId(id);

        return Resolve(SQLUtil.Query(
                new SelectT(TableName.movie_table)
                        .AddCondition(new Condition(Condition.Opt.E, wanted.getMovieId()))
                        .toSQL()
        )).get(0);
    }

    public int Insert(Movie m) {
        return SQLUtil.Update(
                new InsertT(TableName.movie_table)
                        .AddKeyValuePair(m.getMovieId())
                        .AddKeyValuePair(m.getBudget())
                        .AddKeyValuePair(m.getHomepage())
                        .AddKeyValuePair(m.getOriginalLanguage())
                        .AddKeyValuePair(m.getOriginalTitle())
                        .AddKeyValuePair(m.getOverview())
                        .AddKeyValuePair(m.getReleaseDate())
                        .AddKeyValuePair(m.getRevenue())
                        .AddKeyValuePair(m.getRuntime())
                        .AddKeyValuePair(m.getStatus())
                        .AddKeyValuePair(m.getTagline())
                        .AddKeyValuePair(m.getTitle())
                        .AddKeyValuePair(m.getVoteAverage())
                        .AddKeyValuePair(m.getVoteCount())
                        .toSQL()
        );
    }

    public int Update(Movie m) {
        return SQLUtil.Update(
                new UpdateT(TableName.movie_table)
                        .AddKeyValuePair(m.getBudget())
                        .AddKeyValuePair(m.getHomepage())
                        .AddKeyValuePair(m.getOriginalLanguage())
                        .AddKeyValuePair(m.getOriginalTitle())
                        .AddKeyValuePair(m.getOverview())
                        .AddKeyValuePair(m.getReleaseDate())
                        .AddKeyValuePair(m.getRevenue())
                        .AddKeyValuePair(m.getRuntime())
                        .AddKeyValuePair(m.getStatus())
                        .AddKeyValuePair(m.getTagline())
                        .AddKeyValuePair(m.getTitle())
                        .AddKeyValuePair(m.getVoteAverage())
                        .AddKeyValuePair(m.getVoteCount())
                        .AddCondition(new Condition(Condition.Opt.E, m.getMovieId()))
                        .toSQL()
        );
    }

    public int DeleteById(Integer id) {
        Movie wanted = new Movie();
        wanted.setMovieId(id);

        return SQLUtil.Update(
                new DeleteT(TableName.movie_table)
                        .AddCondition(new Condition(Condition.Opt.E, wanted.getMovieId()))
                        .toSQL()
        );
    }

}
