package com.jobmatch;

public class MatchRequest {
    private String resume;
    private String jobDesc;

    // Getters and Setters (This allows Java to read/write the data)
    public String getResume() { return resume; }
    public void setResume(String resume) { this.resume = resume; }

    public String getJobDesc() { return jobDesc; }
    public void setJobDesc(String jobDesc) { this.jobDesc = jobDesc; }
}