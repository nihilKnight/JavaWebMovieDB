package dao;

import SQLTemplate.*;
import entity.Genre;
import util.SQLUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GenreDao {
    public List<Genre> SelectAll(){
        List<Genre> genreList = new ArrayList<Genre>();
        return genreList;
    }
}
