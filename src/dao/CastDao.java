package dao;

import SQLTemplate.*;
import entity.Cast;
import entity.Person;
import util.DBConnector;
import util.SQLUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CastDao {

    public static List<Cast> QueryAndResolve(String sql){
        List<Cast> cl = new ArrayList<Cast>();
        Connection conn = DBConnector.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        /** Query. */
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Cast c = new Cast();
                c.setCastId(rs.getInt(1));
                c.setMovieId(rs.getInt(2));
                c.setActorId(rs.getInt(3));
                c.setCharacterName(rs.getString(4));
                c.setOrderOfAppearance(rs.getInt(5));
                cl.add(c);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBConnector.closeConnection(conn, pstmt, rs);
        }

        return cl;
    }

    public List<Cast> SelectByMovieID(Integer movie_id){
        List<Cast> personList = new ArrayList<Cast>();
        return personList;
    }

    public Cast SelectByPersonID(Integer person_id){
        Cast cast = new Cast();
        return cast;
    }
}
