package com.kosign.hdsapi.services;


import com.kosign.hdsapi.models.IssueGetModel;
import com.kosign.hdsapi.models.IssuePatchModel;
import com.kosign.hdsapi.models.IssuePostModel;

import java.util.List;

public interface IssuesService {
    public List<IssueGetModel> getAllIssues(int limit,int page );
    public List<IssueGetModel> getMutedIssues(int limit,int page );
    public List<IssueGetModel> getUsersMutedIssues(int limit,int page, int id );
    public List<IssueGetModel> getUserIssues(int id,int limit,int page );
    public Boolean insertIssue(IssuePostModel issuePostModel);
    public Boolean updateIssueStatus(IssuePatchModel issuePatchModel);
}
