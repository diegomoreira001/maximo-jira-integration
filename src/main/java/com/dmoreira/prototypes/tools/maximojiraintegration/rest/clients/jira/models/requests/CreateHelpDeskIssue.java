package com.dmoreira.prototypes.tools.maximojiraintegration.rest.clients.jira.models.requests;

import com.dmoreira.prototypes.tools.maximojiraintegration.rest.clients.jira.models.JiraIssueFields;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * Created by dmoreira <diegomoreira00@gmail.com> on 9/3/17.
 */
public class CreateHelpDeskIssue {

    private JiraIssueFields jiraIssueFields;

    @JsonProperty(value = "fields")
    public JiraIssueFields getJiraIssueFields() {
        return jiraIssueFields;
    }

    public void setJiraIssueFields(JiraIssueFields jiraIssueFields) {
        this.jiraIssueFields = jiraIssueFields;
    }
}
