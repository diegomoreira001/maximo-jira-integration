package com.dmoreira.prototypes.tools.maximojiraintegration.rest.clients.jira;

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

    public void save();

    public void update();

    public void delete();


}
