package dao;

import SQLTemplate.*;
import entity.*;
import util.DBConnector;
import util.SQLUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MoviesDao {

    public static List<Movie> QueryAndResolve(String sql) {
        List<Movie> ml = new ArrayList<>();
        Connection conn = DBConnector.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
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
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBConnector.closeConnection(conn, pstmt, rs);
        }

        return ml;
    }

    public List<Movie> SelectAll(Integer limit) {
        return QueryAndResolve(
                new SelectT(TableName.movie_table)
                        .AddOrder(new Movie().getMovieId().attri_name)
                        .Limit(limit)
                        .toSQL()
        );
    }

    public Movie SelectById(Integer id) {
        Movie wanted = new Movie();
        wanted.setMovieId(id);

        return QueryAndResolve(
                new SelectT(TableName.movie_table)
                        .AddCondition(new Condition(Condition.Opt.E, wanted.getMovieId()))
                        .toSQL()
        ).get(0);
    }

    public List<Movie> SelectByKeyword(String keyword) {
        Keyword wanted = new Keyword();
        wanted.setKeywordName(keyword);

        return QueryAndResolve(
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
        );
    }

    public List<Movie> SelectByCast(Person p) {
        return QueryAndResolve(
                new SelectT(List.of(TableName.person_table, TableName.cast_table, TableName.movie_table))
                        .toSQL()
        );
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
    public List<Movie> TopPopular(Integer page){
        return QueryAndResolve(
                new SelectT(TableName.movie_table)
                        .AddOrder(new Movie().getPopularity().attri_name, SelectT.OrderType.DESC)
                        .Limit((page-1) * 20, 20)
                        .toSQL()
        );
    }

    public List<Movie> TopLatest(Integer page){
        return QueryAndResolve(
                new SelectT(TableName.movie_table)
                        .AddOrder(new Movie().getReleaseDate().attri_name, SelectT.OrderType.DESC)
                        .Limit((page-1) * 20, 20)
                        .toSQL()
        );
    }

    public List<Movie> getGenre(Integer genre_id, Integer page) {
        return QueryAndResolve(
                new SelectT(List.of(TableName.movie_table, TableName.genre_table, TableName.movie_genre_table))
                        .AddColumn(TableName.movie_table, "*")
                        .AddOrder(new Movie().getPopularity().attri_name, SelectT.OrderType.DESC)
                        .AddOrder(new Movie().getReleaseDate().attri_name, SelectT.OrderType.DESC)
                        .Limit((page-1) * 20, 20)
                        .AddCondition(new Condition(Condition.Opt.E,
                                TableName.movie_table, new Movie().getMovieId().attri_name,
                                TableName.movie_genre_table, new GenreMovie().getMovieId().attri_name))
                        .AddCondition(new Condition(Condition.Opt.E,
                                TableName.genre_table, new Genre().getId().attri_name,
                                TableName.movie_genre_table, new GenreMovie().getGenreId().attri_name))
                        .AddCondition(new Condition(Condition.Opt.E, TableName.genre_table,
                                new Genre().getId().attri_name, String.valueOf(genre_id)))
                        .toSQL()
        );
    }

    public List<Movie> selectName(String name, Integer page) {
        Movie wanted = new Movie();
        /** Movie title contains {name}. */
        wanted.setTitle("'%" + name + "'%");
        return QueryAndResolve(
                new SelectT(TableName.movie_table)
                        .AddCondition(new Condition(Condition.Opt.LI, wanted.getTitle()))
                        .toSQL()
        );
    }

    public List<Movie> selectByPersonID(Integer personId) {

    }

    public Movie selectID(Integer movieId) {
        Movie wanted = new Movie();
        wanted.setMovieId(movieId);
        return QueryAndResolve(
                new SelectT(TableName.movie_table)
                        .AddCondition(new Condition(Condition.Opt.E, wanted.getMovieId()))
                        .toSQL()
        ).get(0);
    }

}
