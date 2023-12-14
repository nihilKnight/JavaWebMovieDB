package entity;

import util.SQLUtil;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Movie {
    public Integer movie_id = 0;
    public BigInteger budget = BigInteger.ZERO;
    public String homepage = "";
    public String original_language = "";
    public String original_title = "";
    public String overview = "";
    /**
     * The "overview" attribute is going to be treated as "TEXT" in mysql."
     */
    public double popularity = 0.0;
    public Date release_date = new Date();
    /**
     * The format of "release_date" attribute is set to be "yyyy-MM-dd"
     */
    public BigInteger revenue = BigInteger.ZERO;
    public Integer runtime = 0;
    public String status = "";
    public String tagline = "";
    /**
     * The "tagline" attribute is going to be treated as "TEXT" in mysql."
     */
    public String title = "";
    public double vote_average = 0.0;
    public Integer vote_count = 0;

    public String getRelease_date() {
        return new SimpleDateFormat("yyyy-MM-dd").format(this.release_date);
    }

    public Integer getMovie_id() {
        return movie_id;
    }

    public BigInteger getBudget() {
        return budget;
    }

    public String getHomepage() {
        return homepage;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public String getOverview() {
        return overview;
    }

    public double getPopularity() {
        return popularity;
    }

    public BigInteger getRevenue() {
        return revenue;
    }

    public Integer getRuntime() {
        return runtime;
    }

    public String getStatus() {
        return status;
    }

    public String getTagline() {
        return tagline;
    }

    public String getTitle() {
        return title;
    }

    public double getVote_average() {
        return vote_average;
    }

    public Integer getVote_count() {
        return vote_count;
    }

    /** Getters which return the attribute name, attribute type in MySQL, and the exact value. */
    public SQLUtil.DataInfo MovieId() {
        return new SQLUtil.DataInfo("id", SQLUtil.DataType.BIGINT, this.movie_id);
    }
    public SQLUtil.DataInfo Budget() {
        return new SQLUtil.DataInfo("budget", SQLUtil.DataType.BIGINT, this.budget);
    }
    public SQLUtil.DataInfo Homepage() {
        return new SQLUtil.DataInfo("homepage", SQLUtil.DataType.VARCHAR, this.homepage);
    }
    public SQLUtil.DataInfo OriginalLanguage() {
        return new SQLUtil.DataInfo("original_language", SQLUtil.DataType.VARCHAR, this.original_language);
    }
    public SQLUtil.DataInfo OriginalTitle() {
        return new SQLUtil.DataInfo("original_title", SQLUtil.DataType.VARCHAR, this.original_title);
    }
    public SQLUtil.DataInfo Overview() {
        return new SQLUtil.DataInfo("overview", SQLUtil.DataType.VARCHAR, this.overview);
    }
    public SQLUtil.DataInfo Popularity() {
        return new SQLUtil.DataInfo("popularity", SQLUtil.DataType.DECIMAL, this.popularity);
    }
    public SQLUtil.DataInfo ReleaseDate() {
        return new SQLUtil.DataInfo("release_date", SQLUtil.DataType.DATE, this.release_date);
    }
    public SQLUtil.DataInfo Revenue() {
        return new SQLUtil.DataInfo("revenue", SQLUtil.DataType.BIGINT, this.revenue);
    }
    public SQLUtil.DataInfo Runtime() {
        return new SQLUtil.DataInfo("runtime", SQLUtil.DataType.BIGINT, this.runtime);
    }
    public SQLUtil.DataInfo Status() {
        return new SQLUtil.DataInfo("status", SQLUtil.DataType.VARCHAR, this.status);
    }
    public SQLUtil.DataInfo Tagline() {
        return new SQLUtil.DataInfo("tagline", SQLUtil.DataType.VARCHAR, this.tagline);
    }
    public SQLUtil.DataInfo Title() {
        return new SQLUtil.DataInfo("title", SQLUtil.DataType.VARCHAR, this.title);
    }
    public SQLUtil.DataInfo VoteAverage() {
        return new SQLUtil.DataInfo("vote_average", SQLUtil.DataType.DECIMAL, this.vote_average);
    }
    public SQLUtil.DataInfo VoteCount() {
        return new SQLUtil.DataInfo("vote_count", SQLUtil.DataType.BIGINT, this.vote_count);
    }

    /** Setters. */
    public void setMovieId(Integer movie_id) {
        this.movie_id = movie_id;
    }
    public void setBudget(String budget) {
        this.budget = new BigInteger(budget);
    }
    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }
    public void setOriginalLanguage(String original_language) {
        this.original_language = original_language;
    }
    public void setOriginalTitle(String original_title) {
        this.original_title = original_title;
    }
    public void setOverview(String overview) {
        this.overview = overview;
    }
    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }
    public void setReleaseDate(String release_date) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.release_date = df.parse(release_date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    public void setRevenue(String revenue) {
        this.revenue = new BigInteger(revenue);
    }
    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }
    public void setVoteCount(Integer vote_count) {
        this.vote_count = vote_count;
    }
    public void setVoteAverage(double vote_average) {
        this.vote_average = vote_average;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setTagline(String tagline) {
        this.tagline = tagline;
    }
}
