package com.kosign.hdsapi.models;

import java.util.Date;

public class IssueGetModel {
    private int issue_id;
    private String issue_title;
    private String issue_purpose;
    private Date start_time;
    private String username;
    private String department;
    private String priority;
    private Date created_time;
    private String description;
    private String type;

   //Constructor
    public IssueGetModel() {
    }

    public IssueGetModel(int issue_id, String issue_title, String username, String department, String priority, Date created_time, String description) {
        this.issue_id = issue_id;
        this.issue_title = issue_title;
        this.username = username;
        this.department = department;
        this.priority = priority;
        this.created_time = created_time;
        this.description = description;
    }

    public IssueGetModel(int issue_id, String issue_title, String issue_purpose, Date start_time, String username, String department, String priority, Date created_time, String description) {
        this.issue_id = issue_id;
        this.issue_title = issue_title;
        this.issue_purpose = issue_purpose;
        this.start_time = start_time;
        this.username = username;
        this.department = department;
        this.priority = priority;
        this.created_time = created_time;
        this.description = description;
    }

    public IssueGetModel(int issue_id, String issue_title, String issue_purpose, Date start_time, String username, String department, String priority, Date created_time, String description, String type) {
        this.issue_id = issue_id;
        this.issue_title = issue_title;
        this.issue_purpose = issue_purpose;
        this.start_time = start_time;
        this.username = username;
        this.department = department;
        this.priority = priority;
        this.created_time = created_time;
        this.description = description;
        this.type = type;
    }
    //Getter and Setter


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getIssue_id() {
        return issue_id;
    }

    public void setIssue_id(int issue_id) {
        this.issue_id = issue_id;
    }

    public String getIssue_title() {
        return issue_title;
    }

    public void setIssue_title(String issue_title) {
        this.issue_title = issue_title;
    }

    public String getIssue_purpose() {
        return issue_purpose;
    }

    public void setIssue_purpose(String issue_purpose) {
        this.issue_purpose = issue_purpose;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Date getCreated_time() {
        return created_time;
    }

    public void setCreated_time(Date created_time) {
        this.created_time = created_time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "IssueGetModel{" +
                "issue_id=" + issue_id +
                ", issue_title='" + issue_title + '\'' +
                ", issue_purpose='" + issue_purpose + '\'' +
                ", start_time=" + start_time +
                ", username='" + username + '\'' +
                ", department='" + department + '\'' +
                ", priority='" + priority + '\'' +
                ", created_time=" + created_time +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
