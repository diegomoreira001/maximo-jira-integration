package com.dmoreira.prototypes.tools.maximojiraintegration.rest.clients.jira;

import com.dmoreira.prototypes.tools.maximojiraintegration.rest.clients.jira.models.JiraIssue;
import com.dmoreira.prototypes.tools.maximojiraintegration.rest.clients.jira.models.requests.CreateHelpDeskIssue;

import com.dmoreira.prototypes.tools.maximojiraintegration.rest.clients.jira.models.responses.CreateIssueResponse;
import com.dmoreira.prototypes.tools.maximojiraintegration.rest.clients.jira.models.responses.SearchIssueResponse;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * DevStack Innovation
 * <p>
 * Created by dmoreira <diegomoreira00@gmail.com> on 9/3/17.
 */
public class JiraIssueRepositoryImpl implements JiraRepository {

    private RestTemplate restTemplate;
    private String jiraHost;
    private URI jiraIssueAPIUri;
    private URI jiraSearchAPIUri;

    public JiraIssueRepositoryImpl(String jiraHost, String jiraIssueAPIPath, String jiraSearchAPIPath) throws URISyntaxException {
        this.jiraIssueAPIUri = new URI(new StringBuilder()
                .append(jiraHost)
                .append(jiraIssueAPIPath).toString());

        this.jiraSearchAPIUri = new URI(new StringBuilder()
                .append(jiraHost)
                .append(jiraSearchAPIPath).toString());
    }

    @Override
    public void findOne() {

    }

    @Override
    public void findById() {

    }

    /**
     * Finds all available tickets by date.
     */
    @Override
    public void findByDate() {

    }

    public List<JiraIssue> findByProjectKeyAndMaximoKey(String projectKey, String maximoKey) {

        if (StringUtils.isEmpty(projectKey) || StringUtils.isEmpty(maximoKey)) {
            throw new RuntimeException("Something went wrong, projectKey and maximoKey cannot be bull");
        }

        String jqlQuery = String.format("project = %s AND 'Numero Ticket (PPM o Maximo)' ~ '%s'",projectKey,maximoKey);

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUri(jiraSearchAPIUri)
                .queryParam("jql", jqlQuery);

        RequestEntity request =
                new RequestEntity(HttpMethod.GET, uriComponentsBuilder.build().encode().toUri());

        ResponseEntity<SearchIssueResponse> response = restTemplate.exchange(request, SearchIssueResponse.class);
        if (!response.getStatusCode().is2xxSuccessful()) {
            throw new RuntimeException("Search request fatal error");
        }

        SearchIssueResponse responseBody = response.getBody();
        if (responseBody == null) {
            throw new RuntimeException("Search request fatal error: Body is null");
        }

        return responseBody.getIssues();

    }

    @Override
    public void save(CreateHelpDeskIssue issue) {

        RequestEntity<CreateHelpDeskIssue> request =
                new RequestEntity<>(issue, HttpMethod.POST, jiraIssueAPIUri);
        ResponseEntity<CreateIssueResponse> response = restTemplate.exchange(request, CreateIssueResponse.class);
        if (!response.getStatusCode().is2xxSuccessful()) {

        }
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }
}
