package io.dropwizard.archetypes;

import io.dropwizard.archetypes.resources.*;
import io.dropwizard.archetypes.health.*;
import io.dropwizard.archetypes.api.*;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class dropwizardApiApplication extends Application<dropwizardApiConfiguration> {

    public static void main(final String[] args) throws Exception {
        new dropwizardApiApplication().run(args);
    }

    @Override
    public String getName() {
        return "dropwizardApiApplication";
    }

    @Override
    public void initialize(Bootstrap<dropwizardApiConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(dropwizardApiConfiguration configuration,
                    Environment environment) {
        final HelloWorldResource resource = new HelloWorldResource(
        configuration.getTemplate(),
        configuration.getDefaultName()
        );
        final TemplateHealthCheck healthCheck =
            new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(resource);
    }

}
