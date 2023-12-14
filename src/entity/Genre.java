package entity;

import util.SQLUtil;

import java.util.Objects;

public class Genre {
    public Integer id = 0;
    public String genre_name = "";

    public Integer getId() {
        return id;
    }

    public String getGenre_name() {
        return genre_name;
    }

    /** Getters which return the attribute name, attribute type in MySQL, and the exact value. */
    public SQLUtil.DataInfo Id() {
        return new SQLUtil.DataInfo("id", SQLUtil.DataType.BIGINT, this.id);
    }
    public SQLUtil.DataInfo GenreName() {
        return new SQLUtil.DataInfo("genre_name", SQLUtil.DataType.VARCHAR, this.genre_name);
    }

    /** Setters. */
    public void setId(Integer id) {
        this.id = id;
    }
    public void setGenreName(String genre_name) {
        this.genre_name = genre_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genre genre = (Genre) o;
        return Objects.equals(id, genre.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
