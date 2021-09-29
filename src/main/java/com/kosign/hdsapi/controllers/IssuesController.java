package com.kosign.hdsapi.controllers;

import com.kosign.hdsapi.models.*;
import com.kosign.hdsapi.services.IssuesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class IssuesController {
    private IssuesService issuesService;

    @Autowired
    public void setIssueService(IssuesService issuesService){
        this.issuesService=issuesService;
    }

    @GetMapping("/issues")
    public ResponseEntity<BaseApiResponseModel<List<IssueGetModel>>> getAllIssues(
            @RequestParam("limit") int limit,
            @RequestParam("page") int page
    ){
        BaseApiResponseModel<List<IssueGetModel>> response = new BaseApiResponseModel<>();
        response.setMessage("You have got all issues of the page successfully!");
        response.setData(issuesService.getAllIssues(limit,(page-1)*limit));
        response.setStatus(HttpStatus.OK);
        response.setTime( new Timestamp(System.currentTimeMillis()));
        return ResponseEntity.ok(response);
    }
    @GetMapping("/issuesUser")
    public ResponseEntity<BaseApiResponseModel<List<IssueGetModel>>> getUserIssues(
            @RequestParam("id") int id,
            @RequestParam("limit") int limit,
            @RequestParam("page") int page
    ){
        BaseApiResponseModel<List<IssueGetModel>> response = new BaseApiResponseModel<>();
        response.setMessage("You have got own issues of the page successfully!");
        response.setData(issuesService.getUserIssues(id,limit,(page-1)*limit));
        response.setStatus(HttpStatus.OK);
        response.setTime( new Timestamp(System.currentTimeMillis()));
        return ResponseEntity.ok(response);
    }
    @GetMapping("/issuesMuted")
    public ResponseEntity<BaseApiResponseModel<List<IssueGetModel>>> getMutedIssues(

            @RequestParam("limit") int limit,
            @RequestParam("page") int page
    ){
        BaseApiResponseModel<List<IssueGetModel>> response = new BaseApiResponseModel<>();
        response.setMessage("You have got all issues of the page successfully!");
        response.setData(issuesService.getMutedIssues(limit,(page-1)*limit));
        response.setStatus(HttpStatus.OK);
        response.setTime( new Timestamp(System.currentTimeMillis()));
        return ResponseEntity.ok(response);
    }
    @GetMapping("/issuesUsersMuted")
    public ResponseEntity<BaseApiResponseModel<List<IssueGetModel>>> getUsersMutedIssues(
            @RequestParam("id") int id,
            @RequestParam("limit") int limit,
            @RequestParam("page") int page
    ){
        BaseApiResponseModel<List<IssueGetModel>> response = new BaseApiResponseModel<>();
        response.setMessage("You have got all issues of the page successfully!");
        response.setData(issuesService.getUsersMutedIssues(limit,(page-1)*limit,id));
        response.setStatus(HttpStatus.OK);
        response.setTime( new Timestamp(System.currentTimeMillis()));
        return ResponseEntity.ok(response);
    }
    @PostMapping("/issues")
    public ResponseEntity<BaseApiResponseModel<Boolean>> insertIssue(
            @RequestBody IssuePostModel issuePostModel
            ){
        BaseApiResponseModel<Boolean> response =new BaseApiResponseModel<>();
        if(issuesService.insertIssue(issuePostModel)) {
            response.setMessage("You Have Submitted New Issue To HDS");
            response.setData(true);
        }
        else{
            response.setMessage("Your Issue Have Submitted Failed");
            response.setData(false);
        }
        response.setStatus(HttpStatus.OK);
        response.setTime(new Timestamp(System.currentTimeMillis()));

        return ResponseEntity.ok(response);
    }
    @PatchMapping("/issues")
    public ResponseEntity<BaseApiResponseModel<Boolean>> updateIssueStatus(
            @RequestBody IssuePatchModel issuePatchModel
            ){
        BaseApiResponseModel<Boolean> response=new BaseApiResponseModel<>();
        if(issuesService.updateIssueStatus(issuePatchModel)) {
            response.setMessage("The Issue Status Have Been Change");
            response.setData(true);
        }
        else{
            response.setMessage("The Issue Status Change Is Failed");
            response.setData(false);
        }
        response.setStatus(HttpStatus.OK);
        response.setTime(new Timestamp(System.currentTimeMillis()));
        return ResponseEntity.ok(response);
    }
}
