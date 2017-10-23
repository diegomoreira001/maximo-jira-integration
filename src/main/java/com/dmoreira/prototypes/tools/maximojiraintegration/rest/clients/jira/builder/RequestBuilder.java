package com.dmoreira.prototypes.tools.maximojiraintegration.rest.clients.jira.builder;

import com.dmoreira.prototypes.tools.maximojiraintegration.models.MaximoIssue;
import com.dmoreira.prototypes.tools.maximojiraintegration.rest.clients.jira.models.JiraIssueFields;
import com.dmoreira.prototypes.tools.maximojiraintegration.rest.clients.jira.models.JiraIssueType;
import com.dmoreira.prototypes.tools.maximojiraintegration.rest.clients.jira.models.JiraProject;
import com.dmoreira.prototypes.tools.maximojiraintegration.rest.clients.jira.models.requests.CreateHelpDeskIssue;

/**
 * Created by dmoreira <diegomoreira00@gmail.com> on 10/22/17.
 */
public class RequestBuilder {

    private MaximoIssue issue;
    private String projectKey;

    public RequestBuilder setMaximoIssue(MaximoIssue issue) {
        this.issue = issue;
        return this;
    }
    public RequestBuilder setJiraProyectKey(String projectKey) {
        this.projectKey = projectKey;
        return this;
    }

    public CreateHelpDeskIssue build(Class clazz) throws RuntimeException {

        if (issue == null) {
            throw new RuntimeException("MaximoIssue is null. Unable to build request from null");
        }

        CreateHelpDeskIssue request;

        if (clazz.equals(CreateHelpDeskIssue.class)) {
            //Create Fields
            JiraIssueFields fields = new JiraIssueFields();
            fields.setMaximoKey(issue.getId());
            fields.setSummary(issue.getSummary());

            //Set JIRA Project
            JiraProject jiraProject = new JiraProject();
            jiraProject.setKey(projectKey);
            //Set Issue Type (SR or IN)
            JiraIssueType jiraIssueType = new JiraIssueType();
            //jiraIssueType.setId();

            fields.setJiraIssueType(jiraIssueType);
            fields.setJiraProject(jiraProject);

            //Create Issue data
            CreateHelpDeskIssue createHelpDeskIssue = new CreateHelpDeskIssue();
            createHelpDeskIssue.setJiraIssueFields(fields);
            request = createHelpDeskIssue;

        } else {
            throw new UnsupportedOperationException("Class type not supported.");
        }

        return request;

    }

}
