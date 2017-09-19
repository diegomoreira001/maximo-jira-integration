package com.dmoreira.prototypes.tools.maximojiraintegration.rest.clients.jira.models.responses;

import com.dmoreira.prototypes.tools.maximojiraintegration.rest.clients.jira.models.JiraIssue;

import java.util.List;

/**
 *
 * Created by dmoreira <diegomoreira00@gmail.com> on 9/3/17.
 */
public class SearchIssueResponse {

    private List<JiraIssue> issues;

    public List<JiraIssue> getIssues() {
        return issues;
    }

    public void setIssues(List<JiraIssue> issues) {
        this.issues = issues;
    }
}
