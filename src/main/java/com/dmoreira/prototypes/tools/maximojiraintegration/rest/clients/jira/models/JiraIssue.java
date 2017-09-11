package com.dmoreira.prototypes.tools.maximojiraintegration.rest.clients.jira.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * DevStack Innovation
 * <p>
 * Created by dmoreira <diegomoreira00@gmail.com> on 9/10/17.
 */
public class JiraIssue {

    private String id;
    private String key;

    private JiraIssueFields jiraIssueFields;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @JsonProperty("fields")
    public JiraIssueFields getJiraIssueFields() {
        return jiraIssueFields;
    }

    public void setJiraIssueFields(JiraIssueFields jiraIssueFields) {
        this.jiraIssueFields = jiraIssueFields;
    }
}
