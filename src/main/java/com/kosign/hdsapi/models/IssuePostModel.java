package com.kosign.hdsapi.models;

import java.util.Date;

public class IssuePostModel {
    private String issue_title;
    private int user_id;
    private String issue_purpose;
    private String priority;
    private String description;
    private Date start_date;
    private String type;
    public IssuePostModel() {
    }

    public IssuePostModel(String issue_title, int user_id, String issue_purpose, String priority, String description, Date start_date, String type) {
        this.issue_title = issue_title;
        this.user_id = user_id;
        this.issue_purpose = issue_purpose;
        this.priority = priority;
        this.description = description;
        this.start_date = start_date;
        this.type = type;
    }

    public IssuePostModel(String issue_title, int user_id, String issue_purpose, String priority, String description, Date start_date) {
        this.issue_title = issue_title;
        this.user_id = user_id;
        this.issue_purpose = issue_purpose;
        this.priority = priority;
        this.description = description;
        this.start_date = start_date;
    }

    public IssuePostModel(String issue_title, int user_id, String priority, String description) {
        this.issue_title = issue_title;
        this.user_id = user_id;
        this.priority = priority;
        this.description = description;
    }

    public String getIssue_purpose() {
        return issue_purpose;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setIssue_purpose(String issue_purpose) {
        this.issue_purpose = issue_purpose;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    //Getter Setter
    public String getIssue_title() {
        return issue_title;
    }

    public void setIssue_title(String issue_title) {
        this.issue_title = issue_title;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "IssuePostModel{" +
                "issue_title='" + issue_title + '\'' +
                ", user_id=" + user_id +
                ", issue_purpose='" + issue_purpose + '\'' +
                ", priority='" + priority + '\'' +
                ", description='" + description + '\'' +
                ", start_date=" + start_date +
                ", type='" + type + '\'' +
                '}';
    }
}
