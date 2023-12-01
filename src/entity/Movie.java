package entity;

import java.util.Date;

public class Movie {
    public Integer movie_id;
    public Integer budget;
    public String homepage;
    public String original_language;
    public String original_title;
    public String overview;
    /** The "overview" attribute is going to be treated as "TEXT" in mysql." */
    public double popularity;
    public Date release_date;
    /** The format of "release_date" attribute is set to be "yyyy-mm-dd" */
    public Integer revenue;
    public Integer runtime;
    public String status;
    public String tagline;
    /** The "tagline" attribute is going to be treated as "TEXT" in mysql." */
    public String title;
    public double vote_average;
    public Integer vote_count;


}
