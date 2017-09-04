package com.dmoreira.prototypes.tools.maximojiraintegration.rest.clients.jira.models.responses;

/**
 * DevStack Innovation
 * <p>
 * Created by dmoreira <diegomoreira00@gmail.com> on 9/3/17.
 */
public class CreateIssueResponse {

    private String id;
    private String key;

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
}
