package com.dmoreira.prototypes.tools.maximojiraintegration.rest.clients.jira.builder;

import com.dmoreira.prototypes.tools.maximojiraintegration.models.MaximoIssue;
import com.dmoreira.prototypes.tools.maximojiraintegration.rest.clients.jira.models.requests.CreateHelpDeskIssue;
import com.dmoreira.prototypes.tools.maximojiraintegration.utils.JsonUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

/**
 * Created by dmoreira <diegomoreira00@gmail.com> on 10/22/17.
 */
public class RequestBuilderTest {

    Logger logger = LoggerFactory.getLogger(RequestBuilderTest.class);

    /**
     * Happy path for creation of a help desk issue.
     */
    @Test
    public void testBuildCreateHelpDeskIssue() throws Exception {

        MaximoIssue issue = new MaximoIssue();
        issue.setId("IN234567");
        issue.setOwner("LATAM-HSP");
        issue.setSummary("Test summary.");
        issue.setCreatedDate("2017-12-31");

        String jiraProjectKey = "CCHSP";

        RequestBuilder builder = new RequestBuilder();
        builder.setMaximoIssue(issue).setJiraProyectKey(jiraProjectKey);

        CreateHelpDeskIssue request = builder.build(CreateHelpDeskIssue.class);

        assertNotNull(request);
        assertNotNull(request.getJiraIssueFields());
        assertTrue(request.getJiraIssueFields().getMaximoKey().equals(issue.getId()));

        logger.info(JsonUtils.POJOToPrettyString(request));

    }

}