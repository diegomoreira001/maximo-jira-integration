package com.dmoreira.prototypes.tools.maximojiraintegration.rest.clients.maximo;

import com.ibm.maximo.oslc.MaximoConnector;
import com.ibm.maximo.oslc.ResourceSet;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * Created by dmoreira <diegomoreira00@gmail.com> on 9/3/17.
 */
public class MaximoRepositoryImpl implements MaximoRepository {

    private MaximoConnector maximoConnector;
    private ResourceSet resourceSet;

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

    public MaximoConnector getMaximoConnector() {
        return maximoConnector;
    }

    @Autowired
    public void setMaximoConnector(MaximoConnector maximoConnector) {
        this.maximoConnector = maximoConnector;
    }

    @Autowired
    public void setResourceSet(ResourceSet resourceSet) {
        this.resourceSet = resourceSet;
    }
}
