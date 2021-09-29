package com.kosign.hdsapi.services.implementation;

import com.kosign.hdsapi.models.IssueGetModel;
import com.kosign.hdsapi.models.IssuePatchModel;
import com.kosign.hdsapi.models.IssuePostModel;
import com.kosign.hdsapi.repositories.IssuesRepo;
import com.kosign.hdsapi.services.IssuesService;
//import com.sun.org.apache.xpath.internal.operations.Bool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IssuesImplimentation implements IssuesService {
    private IssuesRepo issuesRepo;

    @Autowired
    public void setIssuesRepo(IssuesRepo issuesRepo){ this.issuesRepo=issuesRepo;}
    @Override
    public List<IssueGetModel> getAllIssues(int limit, int page) {
        return issuesRepo.getAllIssues(limit,page);
    }

    @Override
    public List<IssueGetModel> getMutedIssues(int limit, int page) {
        return issuesRepo.getMutedIssues(limit,page);
    }
    @Override
    public List<IssueGetModel> getUsersMutedIssues(int limit, int page,int id) {
        return issuesRepo.getUsersMutedIssues(limit,page,id);
    }
    @Override
    public List<IssueGetModel> getUserIssues(int id, int limit, int page) {
        return issuesRepo.getUserIssues(id,limit,page);
    }

    @Override
    public Boolean insertIssue(IssuePostModel issuePostModel){
        Boolean insertedIssue=issuesRepo.insertIssue(issuePostModel);
        return insertedIssue;
    }
    @Override
    public Boolean updateIssueStatus(IssuePatchModel issuePatchModel){
        Boolean issueUpdated=issuesRepo.updateIssueStatus(issuePatchModel);
        return issueUpdated;
    }
}
