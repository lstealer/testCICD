package com.kosign.hdsapi.repositories;

import com.kosign.hdsapi.models.IssueGetModel;
import com.kosign.hdsapi.models.IssuePatchModel;
import com.kosign.hdsapi.models.IssuePostModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IssuesRepo {
    @Select("SELECT issue_id,issue_title,issue_purpose,username,department,priority,created_time,description,start_time,type " +
            "FROM issues " +
            "INNER JOIN users ON users.user_id = issues.user_id " +
            "WHERE " +
            "issues.status = false AND issues.muted =false AND issues.user_id = ${id} LIMIT ${limit} OFFSET ${page}")
    public List<IssueGetModel> getUserIssues(int id,int limit,int page);


    @Select("SELECT issue_id,issue_title,issue_purpose,username,department,priority,created_time,description,start_time,type " +
            "FROM issues " +
            "INNER JOIN users ON users.user_id = issues.user_id " +
            "WHERE " +
            "issues.status = false AND issues.muted =false LIMIT ${limit} OFFSET ${page}")
    public List<IssueGetModel> getAllIssues(int limit,int page);

    @Select("SELECT issue_id,issue_title,issue_purpose,username,department,priority,created_time,description,start_time,type " +
            "FROM issues " +
            "INNER JOIN users ON users.user_id = issues.user_id " +
            "WHERE issues.status = false AND issues.muted =true AND id = ${id} LIMIT ${limit} OFFSET ${page}")
    public List<IssueGetModel> getUsersMutedIssues(int limit,int page,int id);
    @Select("SELECT issue_id,issue_title,issue_purpose,username,department,priority,created_time,description,start_time,type " +
            "FROM issues " +
            "INNER JOIN users ON users.user_id = issues.user_id " +
            "WHERE issues.status = false AND issues.muted =true LIMIT ${limit} OFFSET ${page}")
    public List<IssueGetModel> getMutedIssues(int limit,int page);


    @Insert({"INSERT INTO issues(issue_title,issue_purpose,user_id,priority,description,start_time,type)" +
            "VALUES('${issue_title}','${issue_purpose}','${user_id}','${priority}','${description}','${start_date}','${type}')"})
    public Boolean insertIssue(IssuePostModel issuePostModel);


    @Update("UPDATE issues SET status=${status},muted=${muted} WHERE issue_id=${issue_id}")
    public Boolean updateIssueStatus(IssuePatchModel issuePatchModel);
}
