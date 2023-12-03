package entity;

import util.SQLUtil;

public class Crew {
    public int crew_id;
    public Integer movie_id;
    public Integer crew_member_id;
    public String job;
    public String department;

    /** Getters which return the attribute name, attribute type in MySQL, and the exact value. */
    public SQLUtil.DataInfo getCrewId() {
        return new SQLUtil.DataInfo("crew_id", SQLUtil.DataType.INT, this.crew_id);
    }
    public SQLUtil.DataInfo getMovieId() {
        return new SQLUtil.DataInfo("movie_id", SQLUtil.DataType.BIGINT, this.movie_id);
    }
    public SQLUtil.DataInfo getCrewMemberId() {
        return new SQLUtil.DataInfo("crew_member_id", SQLUtil.DataType.BIGINT, this.crew_member_id);
    }
    public SQLUtil.DataInfo getJob() {
        return new SQLUtil.DataInfo("job", SQLUtil.DataType.VARCHAR, this.job);
    }
    public SQLUtil.DataInfo getDepartment() {
        return new SQLUtil.DataInfo("department", SQLUtil.DataType.VARCHAR, this.department);
    }

    /** Setters. */
    public void setCrewId(int crew_id) {
        this.crew_id = crew_id;
    }
    public void setMovieId(Integer movie_id) {
        this.movie_id = movie_id;
    }
    public void setCrewMemberId(Integer crew_member_id) {
        this.crew_member_id = crew_member_id;
    }
    public void setJob(String job) {
        this.job = job;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
}
