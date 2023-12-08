package dao;

import SQLTemplate.*;
import entity.*;
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

    public List<Movie> selectName(String name, Integer Page) {
        List<Movie> ml = new ArrayList<Movie>();
        return ml;
    }
    public List<Movie> SelectByKeyword(String keyword) {
        Keyword wanted = new Keyword();
        wanted.setKeywordName(keyword);

        return Resolve(SQLUtil.Query(
                new SelectT(List.of(TableName.keyword_table, TableName.movie_keyword_table, TableName.movie_table))
                        .AddColumn(TableName.movie_table, "*")
                        .AddCondition(new Condition(Condition.Opt.E,
                                TableName.keyword_table, new Keyword().getId().attri_name,
                                TableName.movie_keyword_table, new KeywordMovie().getKeywordId().attri_name
                        ))
                        .AddCondition(new Condition(Condition.Opt.E,
                                TableName.movie_table, new Movie().getMovieId().attri_name,
                                TableName.movie_keyword_table, new KeywordMovie().getMovieId().attri_name
                        ))
                        .AddCondition(new Condition(Condition.Opt.E, wanted.getKeywordName()))
                        .toSQL()
        ));
    }

    public List<Movie> SelectByCast(Person p) {
        return Resolve(SQLUtil.Query(
                new SelectT(List.of(TableName.person_table, TableName.cast_table, TableName.movie_table))
                        .toSQL()
        ));
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

    /** TOP AND MOST RECENT MOVIES*/
    public List<Movie> TopPopular(Integer Page){
        return Resolve(SQLUtil.Query(
                new SelectT(TableName.movie_table)
                        .toSQL()
        ));
    }

    public List<Movie> TopLatest(Integer Page){
        List<Movie> ml = new ArrayList<Movie>();
        return ml;
    }

    public List<Movie> getGenre(Integer genre_id, Integer Page) {
        List<Movie> ml = new ArrayList<Movie>();
        return ml;
    }

    public List<Movie> searchName(String name, Integer Page){
        List<Movie> ml = new ArrayList<Movie>();
        return ml;
    }

    public List<Movie> selectByPersonID(Integer personId) {
        List<Movie> ml = new ArrayList<Movie>();
        return ml;
    }

    public Movie selectID(Integer movieId) {
        return new Movie();
    }
}
