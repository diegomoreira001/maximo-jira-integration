package com.dmoreira.prototypes.tools.maximojiraintegration.rest.clients.maximo;

/**
 *
 * Created by dmoreira <diegomoreira00@gmail.com> on 9/3/17.
 */
public interface MaximoRepository {

    void findOne();

    void findById();

    /**
     * Finds all available tickets by date.
     */
    void findByDate();


}
