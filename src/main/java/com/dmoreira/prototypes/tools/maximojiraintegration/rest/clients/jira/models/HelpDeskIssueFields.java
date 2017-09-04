package com.dmoreira.prototypes.tools.maximojiraintegration.rest.clients.jira.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * DevStack Innovation
 * <p>
 * Created by dmoreira <diegomoreira00@gmail.com> on 9/3/17.
 */
public class HelpDeskIssueFields {

    private JiraProject jiraProject;
    private String summary;
    private String description;
    private JiraIssueType jiraIssueType;

    @JsonProperty(value = "project")
    public JiraProject getJiraProject() {
        return jiraProject;
    }

    public void setJiraProject(JiraProject jiraProject) {
        this.jiraProject = jiraProject;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty(value = "issuetype")
    public JiraIssueType getJiraIssueType() {
        return jiraIssueType;
    }

    public void setJiraIssueType(JiraIssueType jiraIssueType) {
        this.jiraIssueType = jiraIssueType;
    }
}
