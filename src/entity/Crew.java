package entity;

public class Crew {
    public int crew_id;
    public Integer movie_id;
    public Integer crew_member_id;
    public String job;
    public String department;

    public int getCrewId() {
        return crew_id;
    }

    public void setCrewId(int crew_id) {
        this.crew_id = crew_id;
    }

    public Integer getMovieId() {
        return movie_id;
    }

    public void setMovieId(Integer movie_id) {
        this.movie_id = movie_id;
    }

    public Integer getCrewMemberId() {
        return crew_member_id;
    }

    public void setCrewMemberId(Integer crew_member_id) {
        this.crew_member_id = crew_member_id;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
