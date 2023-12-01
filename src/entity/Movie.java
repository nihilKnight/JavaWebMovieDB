package entity;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

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
    /** The format of "release_date" attribute is set to be "yyyy-MM-dd" */
    public Integer revenue;
    public Integer runtime;
    public String status;
    public String tagline;
    /** The "tagline" attribute is going to be treated as "TEXT" in mysql." */
    public String title;
    public double vote_average;
    public Integer vote_count;

    public Integer getMovieId() { return movie_id; }

    public void setMovieId(Integer movie_id) { this.movie_id = movie_id; }

    public Integer getBudget() { return budget; }

    public void setBudget(Integer budget) { this.budget = budget; }

    public String getHomepage() { return homepage; }

    public void setHomepage(String homepage) { this.homepage = homepage; }

    public String getOriginalLanguage() { return original_language; }

    public void setOriginalLanguage(String original_language) { this.original_language = original_language; }

    public String getOriginalTitle() { return original_title; }

    public void setOriginalTitle(String original_title) { this.original_title = original_title; }

    public String getOverview() { return overview; }

    public void setOverview(String overview) { this.overview = overview; }

    public double getPopularity() { return popularity; }

    public void setPopularity(double popularity) { this.popularity = popularity; }

    public Date getReleaseDate() { return release_date; }

    public void setReleaseDate(String release_date) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        try {
            this.release_date = df.parse(release_date);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Integer getRevenue() { return revenue; }

    public void setRevenue(Integer revenue) { this.revenue = revenue; }

    public Integer getRuntime() { return runtime; }

    public void setRuntime(Integer runtime) { this.runtime = runtime; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public String getTagline() { return tagline; }

    public void setTagline(String tagline) { this.tagline = tagline; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public double getVoteAverage() { return vote_average; }

    public void setVoteAverage(double vote_average) { this.vote_average = vote_average; }

    public Integer getVoteCount() { return vote_count; }

    public void setVoteCount(Integer vote_count) { this.vote_count = vote_count; }
}
