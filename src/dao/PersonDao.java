package dao;

import SQLTemplate.*;
import entity.Movie;
import entity.Person;
import util.DBConnector;
import util.SQLUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonDao {

    public static List<Person> QueryAndResolve(String sql) {
        List<Person> pl = new ArrayList<>();
        Connection conn = DBConnector.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Person p = new Person();
                p.setId(rs.getInt(1));
                p.setName(rs.getString(2));
                p.setGender(rs.getInt(3));
                pl.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBConnector.closeConnection(conn, pstmt, rs);
        }

        return pl;
    }

    public List<Person> selectName(String name, Integer Page){
        List<Person> personList = new ArrayList<Person>();
        return personList;
    }

    public List<Person> SelectAll(Integer limit) {
        return QueryAndResolve(
                new SelectT(TableName.person_table)
                        .AddOrder(new Person().getId().attri_name)
                        .Limit(limit)
                        .toSQL()
        );
    }

    public Person SelectById(Integer id) {
        Person wanted = new Person();
        wanted.setId(id);

        return QueryAndResolve(
                new SelectT(TableName.person_table)
                        .AddCondition(new Condition(Condition.Opt.E, wanted.getId()))
                        .toSQL()
        ).get(0);
    }

    public int Insert(Person p) {
        return SQLUtil.Update(
                new InsertT(TableName.person_table)
                        .AddKeyValuePair(p.getId())
                        .AddKeyValuePair(p.getName())
                        .AddKeyValuePair(p.getGender())
                        .toSQL()
        );
    }

    public int Update(Person p) {
        return SQLUtil.Update(
                new UpdateT(TableName.person_table)
                        .AddKeyValuePair(p.getName())
                        .AddKeyValuePair(p.getGender())
                        .AddCondition(new Condition(Condition.Opt.E, p.getId()))
                        .toSQL()
        );
    }

    public int DeleteById(Integer id) {
        Person wanted = new Person();
        wanted.setId(id);

        return SQLUtil.Update(
                new DeleteT(TableName.person_table)
                        .AddCondition(new Condition(Condition.Opt.E, wanted.getId()))
                        .toSQL()
        );
    }

}
