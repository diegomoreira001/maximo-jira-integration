package com.dmoreira.prototypes.tools.maximojiraintegration.rest.clients.jira;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by dmoreira <diegomoreira00@gmail.com> on 10/22/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JiraIssueRepositoryImplSpringTest {

    @Autowired
    private JiraRepository jiraRepository;

    @Test
    public void findByProjectKeyAndMaximoKey() throws Exception {
    }

    @Configuration
    public static class TestConfig{
        @Bean
        public JiraRepository jiraRepository() {



            return new JiraIssueRepositoryImpl()
        }
    }

}