package dao;

import SQLTemplate.*;
import entity.Cast;
import entity.Person;
import util.SQLUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CastDao {

    public List<Cast> Resolve(ResultSet rs){
        List<Cast> castlist = new ArrayList<Cast>();

        /** Resolve SQL results. */
        while (true) {
            try {
                if (! rs.next()) break;
                Cast c = new Cast();
                c.setCastId(rs.getInt(1));
                c.setMovieId(rs.getInt(2));
                c.setActorId(rs.getInt(3));
                c.setCharacterName(rs.getString(4));
                c.setOrderOfAppearance(rs.getInt(5));
                castlist.add(c);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return castlist;
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
