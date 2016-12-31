package com.vervalle.dropwizarddemo;

/**
 * Dropwizard is a framework for building RESTful web services in Java.
 * In essence, it is a glue framework which bundles together popular and battle-tested Java libraries and frameworks
 * to make it easier to start building new RESTful web services.
 *
 * to implement and run, read: https://www.sitepoint.com/tutorial-getting-started-dropwizard/
 * to implement and run, see: https://www.youtube.com/watch?v=UonVxuAOznc

 */

import com.vervalle.dropwizarddemo.resources.*;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class SampleApplication extends Application<SampleConfiguration> {

    public static void main(String[] args) throws Exception {
        new SampleApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<SampleConfiguration> bootstrap) {}

    @Override
    public String getName() {
        return "demo microServives";
    }

    @Override
    public void run(SampleConfiguration configuration, Environment environment) throws Exception {
        final GreetingsResource resource_name = new GreetingsResource();
        environment.jersey().register(resource_name);

        final HelloworldResource resource_world = new HelloworldResource(configuration.getMessages());
        environment.jersey().register(resource_world);

        final EchoResource resource_echo = new EchoResource();
        environment.jersey().register(resource_echo);
//        http://localhost:8080/echo?echo=Garett Lebeau

        final TaskListResource resource_taskList = new TaskListResource(
                configuration.getMaxLength()
        );
        environment.jersey().register(resource_taskList);
//        http://localhost:8080/task-list?contains=chrome
//        http://localhost:8080/task-list

        DateFormat eventDateFormat = new SimpleDateFormat(configuration.getDateFormat());
        environment.getObjectMapper().setDateFormat(eventDateFormat);

        EventRepository repository = new DummyEventRepository();

        final EventResource resource_event = new EventResource(repository);
        environment.jersey().register(resource_event);
//        http://localhost:8080/events
//        http://localhost:8080/events/2

        System.out.println(getName() + " is now running on " +
                configuration.getEnvironment() + " environnement");

    }
}
