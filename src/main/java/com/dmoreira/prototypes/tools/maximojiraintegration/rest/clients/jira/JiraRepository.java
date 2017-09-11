package com.dmoreira.prototypes.tools.maximojiraintegration.rest.clients.jira;

import com.dmoreira.prototypes.tools.maximojiraintegration.rest.clients.jira.models.JiraIssue;
import com.dmoreira.prototypes.tools.maximojiraintegration.rest.clients.jira.models.requests.CreateHelpDeskIssue;

import java.util.List;

/**
 * DevStack Innovation
 * <p>
 * Created by dmoreira <diegomoreira00@gmail.com> on 9/3/17.
 */
public interface JiraRepository {

    public void findOne();

    public void findById();

    /**
     * Finds all available tickets by date.
     */
    public void findByDate();

    public List<JiraIssue> findByProjectKeyAndMaximoKey(String projectKey, String maximoKey);

    public void save(CreateHelpDeskIssue issue);

    public void update();

    public void delete();


}
