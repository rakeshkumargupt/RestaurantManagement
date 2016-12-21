package com.sample;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Created by rakeshgupta on 12/21/16.
 */
public class RSManagement extends Application<Configuration> {

    public static void main(String[] args) throws Exception {
        new com.sample.RSManagement().run(args);
    }
    @Override
    public void initialize(Bootstrap<Configuration> b) {
    }

    @Override
    public void run(Configuration configuration, Environment environment) throws Exception {
    environment.jersey().register(new RSController());
    }
}
