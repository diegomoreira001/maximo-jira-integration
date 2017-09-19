package com.dmoreira.prototypes.tools.maximojiraintegration.services;

import com.dmoreira.prototypes.tools.maximojiraintegration.models.MaximoIssue;
import com.dmoreira.prototypes.tools.maximojiraintegration.rest.clients.jira.JiraRepository;
import com.dmoreira.prototypes.tools.maximojiraintegration.rest.clients.jira.models.JiraIssue;
import com.dmoreira.prototypes.tools.maximojiraintegration.rest.clients.jira.models.JiraIssueFields;
import com.dmoreira.prototypes.tools.maximojiraintegration.rest.clients.jira.models.JiraIssueType;
import com.dmoreira.prototypes.tools.maximojiraintegration.rest.clients.jira.models.JiraProject;
import com.dmoreira.prototypes.tools.maximojiraintegration.rest.clients.jira.models.requests.CreateHelpDeskIssue;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * Created by dmoreira <diegomoreira00@gmail.com> on 9/3/17.
 */
@Service
public class MaximoCsvPoller {

    //private Integrator integrator;
    private static final String JIRA_PROJECT_KEY = "CCHSP";
    private JiraRepository jiraRepository;

    @Scheduled(fixedDelay = 180000)
    private void poll() {

        //Step 1: Poll all files with current date on their names
        File file = new File("/maximo/reports/created/");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String formattedCurrentDate = sdf.format(Calendar.getInstance().getTime());

        String regexFilterString = String.format("maximo_created_%s_.*csv", formattedCurrentDate);

        FilenameFilter filter = (dir, name) -> name.matches(regexFilterString);

        File[] polledFiles = file.listFiles(filter);
        if (polledFiles == null || polledFiles.length == 0) {
            // Didn't find any files
            return;
        }

        //Step 2: Process all candidates
        process(polledFiles);


    }


    public void process(File[] polledFiles) {

        if (polledFiles == null || polledFiles.length == 0) {
            throw new RuntimeException("Something went wrong: No files available to process");
        }

        //Step 3: Parse each file, then integrate its data with JIRA,
        //and finally mark the file as PROCESSED and move it.
        for (File file : polledFiles) {

            List<MaximoIssue> issues = parse(file);
            if (issues != null && !issues.isEmpty()) {
                integrate(issues);
            } else {

            }

            moveProcessedFile(file);
        }

    }


    public List<MaximoIssue> parse(File file) {
        CsvToBean<MaximoIssue> maximoIssueCsvToBean = new CsvToBean<>();
        Map<String, String> columnMapping = new HashMap<>();

        columnMapping.put("id","id");
        columnMapping.put("summary","summary");
        columnMapping.put("description","description");
        columnMapping.put("createdDate","createdDate");
        columnMapping.put("status","status");
        columnMapping.put("owner","owner");

        HeaderColumnNameTranslateMappingStrategy<MaximoIssue> strategy = new HeaderColumnNameTranslateMappingStrategy<>();
        strategy.setColumnMapping(columnMapping);

        List<MaximoIssue> maximoIssues = null;

        try {

            CSVReader csvReader = new CSVReader(new FileReader(file));

            maximoIssues = maximoIssueCsvToBean.parse(strategy, csvReader);

        } catch (FileNotFoundException fileE) {
            // File not found?
            throw new RuntimeException(fileE.getMessage());
        }

        return maximoIssues;
    }

    public void integrate(List<MaximoIssue> issues) {
        for(MaximoIssue issue : issues) {
            integrate(issue);
        }
    }

    public void integrate(MaximoIssue issue) {
        List<JiraIssue> existingIssues = jiraRepository.findByProjectKeyAndMaximoKey(JIRA_PROJECT_KEY, issue.getId());
        //If the Issue does not exist already, create a new one
        if (existingIssues == null || existingIssues.isEmpty()) {

            //Create Fields
            JiraIssueFields fields = new JiraIssueFields();
            fields.setMaximoKey(issue.getId());
            fields.setSummary(issue.getSummary());

            //Set JIRA Project
            JiraProject jiraProject = new JiraProject();
            jiraProject.setKey(JIRA_PROJECT_KEY);
            //Set Issue Type (SR or IN)
            JiraIssueType jiraIssueType = new JiraIssueType();
            jiraIssueType.setId();

            fields.setJiraIssueType(jiraIssueType);
            fields.setJiraProject(jiraProject);

            //Create Issue data
            CreateHelpDeskIssue createHelpDeskIssue = new CreateHelpDeskIssue();
            createHelpDeskIssue.setJiraIssueFields(fields);

            //Create Issue in JIRA
            jiraRepository.save(createHelpDeskIssue);
        }
    }

    public void moveProcessedFile(File file) {
        return;
    }

    public JiraRepository getJiraRepository() {
        return jiraRepository;
    }

    @Autowired
    public void setJiraRepository(JiraRepository jiraRepository) {
        this.jiraRepository = jiraRepository;
    }
}
