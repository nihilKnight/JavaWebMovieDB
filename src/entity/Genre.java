package entity;

public class Genre {
    public Integer id;
    public String genre_name;

    public Integer getId() { return this.id; }

    public String getGenreName() { return this.genre_name; }

    public void setId(Integer id) { this.id = id; }

    public void setGenreName(String genre_name) { this.genre_name=genre_name; }
}
