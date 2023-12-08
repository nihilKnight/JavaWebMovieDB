package dao;

import entity.Crew;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CrewDao {

    public void Insert(Crew crew){

    }

    public void Update(Crew crew){

    }
    public List<Crew> SelectByMovieID(Integer movie_id){
        List<Crew> personList = new ArrayList<Crew>();
        return personList;
    }

    public Crew SelectByPersonID(Integer person_id){
        Crew crew = new Crew();
        return crew;
    }
}
