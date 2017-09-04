package com.dmoreira.prototypes.tools.maximojiraintegration.services;

import com.dmoreira.prototypes.tools.maximojiraintegration.models.MaximoIssue;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * DevStack Innovation
 * <p>
 * Created by dmoreira <diegomoreira00@gmail.com> on 9/3/17.
 */
@Service
public class MaximoCsvPoller {

    //private Integrator integrator;
    @Scheduled
    private void poll() {

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


        //TODO: get file from fs
        CSVReader csvReader = new CSVReader(/*new InputStreamReader(ClassLoader.getSystemResourceAsStream("test.csv"))*/);

        List<MaximoIssue> maximoIssues = maximoIssueCsvToBean.parse(strategy,csvReader);
        if (maximoIssues != null) {
            // integrate.....
        }

    }

    public void parseCsv() {

    }

    public void integrate() {

    }
}
