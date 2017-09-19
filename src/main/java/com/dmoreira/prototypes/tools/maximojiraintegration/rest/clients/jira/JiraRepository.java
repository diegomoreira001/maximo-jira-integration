package com.dmoreira.prototypes.tools.maximojiraintegration.rest.clients.jira;

import com.dmoreira.prototypes.tools.maximojiraintegration.rest.clients.jira.models.JiraIssue;
import com.dmoreira.prototypes.tools.maximojiraintegration.rest.clients.jira.models.requests.CreateHelpDeskIssue;

import java.util.List;

/**
 *
 * Created by dmoreira <diegomoreira00@gmail.com> on 9/3/17.
 */
public interface JiraRepository {

    void findOne();

    void findById();

    /**
     * Finds all available tickets by date.
     */
    void findByDate();

    List<JiraIssue> findByProjectKeyAndMaximoKey(String projectKey, String maximoKey);

    void save(CreateHelpDeskIssue issue);

    void update();

    void delete();


}
