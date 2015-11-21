package com.jcze.uxpointer;

import com.jcze.uxpointer.api.DocumentResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class UxPointerApplication extends Application<UxPointerConfiguration> {
    public static void main(String[] args) throws Exception {
        new UxPointerApplication().run(args);
    }

    @Override
    public String getName() {
        return "ux-pointer";
    }

    @Override
    public void initialize(Bootstrap<UxPointerConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(UxPointerConfiguration configuration,
                    Environment environment) {
        final DocumentResource resource = new DocumentResource(
                configuration.getTemplate(),
                configuration.getDefaultName()
        );

        environment.jersey().register(resource);
    }

}