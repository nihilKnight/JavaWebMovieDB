package dao;

import util.DBConnector;
import entity.Movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MoviesDao {
    public int insert(Movie m){
        int count = 0;
        Connection conn = DBConnector.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            pstmt = conn.prepareStatement("insert into movies("+
                    "movie_id" +
                    "budget" +
                    "homepage" +
                    "original_language" +
                    "original_title" +
                    "overview" +
                    "popularity" +
                    "release_date" +
                    "revenue" +
                    "runtime" +
                    "status" +
                    "tagline" +
                    "title" +
                    "vote_average" +
                    "vote_count" +
                    ") values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
            pstmt.setInt(1, m.getBudget());
            pstmt.setString(2, m.getHomepage());
            pstmt.setString(3, m.getOriginalLanguage());
            count = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnector.closeConnection(conn, pstmt, rs);
        }
        return count;
    }
}
