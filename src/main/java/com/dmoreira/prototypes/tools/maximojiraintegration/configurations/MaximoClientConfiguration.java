package com.dmoreira.prototypes.tools.maximojiraintegration.configurations;

import org.springframework.context.annotation.Configuration;

/**
 *
 * Created by dmoreira <diegomoreira00@gmail.com> on 9/3/17.
 */
@Configuration
public class MaximoClientConfiguration {

    /**
     *
     * Sets the connection options for Maximo Connector client
     *
     * @return Options
     */
/*    @Bean
    public Options maximoConnectionOptions() {

        //TODO: set options from properties
        Options options = new Options();
        options.host().port();
        options.user();
        options.password();

        return options;

    }
*/
    /**
     * Creates a MaximoConnector based client
     * @return MaximoConnector
     */
/*    @Bean
    public MaximoConnector maximoConnector() throws IOException, OslcException {

        MaximoConnector connector = new MaximoConnector(maximoConnectionOptions());
        connector.debug(true);
        connector.connect();
        return connector;

    }
*/
}
