package com.kosign.hdsapi.models;

public class IssuePatchModel {
    private int issue_id;
    private Boolean status;
    private Boolean muted;
//CONSTRUCTION
    public IssuePatchModel() {
    }

    public IssuePatchModel(int issue_id, Boolean status, Boolean muted) {
        this.issue_id = issue_id;
        this.status = status;
        this.muted = muted;
    }

//    Getter and Setter

    public int getIssue_id() {
        return issue_id;
    }

    public void setIssue_id(int issue_id) {
        this.issue_id = issue_id;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getMuted() {
        return muted;
    }

    public void setMuted(Boolean muted) {
        this.muted = muted;
    }

    @Override
    public String toString() {
        return "IssuePatchModel{" +
                "issue_id=" + issue_id +
                ", status=" + status +
                ", muted=" + muted +
                '}';
    }
}
