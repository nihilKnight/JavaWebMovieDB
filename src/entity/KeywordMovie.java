package entity;

import util.SQLUtil;

public class KeywordMovie {
    public Integer movie_id;
    public Integer keyword_id;

    /** Getters which return the attribute name, attribute type in MySQL, and the exact value. */
    public SQLUtil.DataInfo getMovieId() {
        return new SQLUtil.DataInfo("movie_id", SQLUtil.DataType.BIGINT, this.movie_id);
    }
    public SQLUtil.DataInfo getKeywordId() {
        return new SQLUtil.DataInfo("keyword_id", SQLUtil.DataType.BIGINT, this.keyword_id);
    }

    /** Setters. */
    public void setMovieId(Integer movie_id) {
        this.movie_id = movie_id;
    }
    public void setKeywordId(Integer keyword_id) {
        this.keyword_id = keyword_id;
    }
}
