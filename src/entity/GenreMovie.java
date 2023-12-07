package entity;

import util.SQLUtil;

public class GenreMovie {
    public Integer movie_id;
    public Integer genre_id;

    /** Getters which return the attribute name, attribute type in MySQL, and the exact value. */
    public SQLUtil.DataInfo getMovieId() {
        return new SQLUtil.DataInfo("movie_id", SQLUtil.DataType.BIGINT, this.movie_id);
    }
    public SQLUtil.DataInfo getGenreId() {
        return new SQLUtil.DataInfo("genre_id", SQLUtil.DataType.BIGINT, this.genre_id);
    }

    /** Setters. */
    public void setMovieId(Integer movie_id) {
        this.movie_id = movie_id;
    }
    public void setGenreId(Integer genre_id) {
        this.genre_id = genre_id;
    }
}
