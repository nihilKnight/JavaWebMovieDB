package entity;

public class Cast {
    public int cast_id;
    public Integer movie_id;
    public Integer actor_id;
    public String character_name;
    public int order_of_appearance;

    public int getCastId() {
        return cast_id;
    }

    public void setCastId(int cast_id) {
        this.cast_id = cast_id;
    }

    public Integer getMovieId() {
        return movie_id;
    }

    public void setMovieId(Integer movie_id) {
        this.movie_id = movie_id;
    }

    public Integer getActorId() {
        return actor_id;
    }

    public void setActorId(Integer actor_id) {
        this.actor_id = actor_id;
    }

    public String getCharacterName() {
        return character_name;
    }

    public void setCharacterName(String character_name) {
        this.character_name = character_name;
    }

    public int getOrderOfAppearance() {
        return order_of_appearance;
    }

    public void setOrderOfAppearance(int order_of_appearance) {
        this.order_of_appearance = order_of_appearance;
    }
}
