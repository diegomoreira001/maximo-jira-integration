package com.dmoreira.prototypes.tools.maximojiraintegration.rest.clients.jira.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * DevStack Innovation
 * <p>
 * Created by dmoreira <diegomoreira00@gmail.com> on 9/3/17.
 */
public class CreateHelpDeskIssue {


    private HelpDeskIssueFields helpDeskIssueFields;

    @JsonProperty(value = "fields")
    public HelpDeskIssueFields getHelpDeskIssueFields() {
        return helpDeskIssueFields;
    }

    public void setHelpDeskIssueFields(HelpDeskIssueFields helpDeskIssueFields) {
        this.helpDeskIssueFields = helpDeskIssueFields;
    }
}
