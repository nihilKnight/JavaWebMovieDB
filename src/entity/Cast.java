package entity;

import util.SQLUtil;

public class Cast {
    public int cast_id;
    public Integer movie_id;
    public Integer actor_id;
    public String character_name;
    public int order_of_appearance;

    /** Getters which return the attribute name, attribute type in MySQL, and the exact value. */
    public SQLUtil.DataInfo getCastId() {
        return new SQLUtil.DataInfo("cast_id", SQLUtil.DataType.INT, this.cast_id);
    }
    public SQLUtil.DataInfo getMovieId() {
        return new SQLUtil.DataInfo("movie_id", SQLUtil.DataType.BIGINT, this.movie_id);
    }
    public SQLUtil.DataInfo getActorId() {
        return new SQLUtil.DataInfo("actor_id", SQLUtil.DataType.BIGINT, this.actor_id);
    }
    public SQLUtil.DataInfo getCharacterName() {
        return new SQLUtil.DataInfo("actor_id", SQLUtil.DataType.VARCHAR, this.character_name);
    }
    public SQLUtil.DataInfo getOrderOfAppearance() {
        return new SQLUtil.DataInfo("actor_id", SQLUtil.DataType.INT, this.order_of_appearance);
    }

    /** Setters. */
    public void setCastId(int cast_id) {
        this.cast_id = cast_id;
    }
    public void setMovieId(Integer movie_id) {
        this.movie_id = movie_id;
    }
    public void setActorId(Integer actor_id) {
        this.actor_id = actor_id;
    }
    public void setCharacterName(String character_name) {
        this.character_name = character_name;
    }
    public void setOrderOfAppearance(int order_of_appearance) {
        this.order_of_appearance = order_of_appearance;
    }
}
