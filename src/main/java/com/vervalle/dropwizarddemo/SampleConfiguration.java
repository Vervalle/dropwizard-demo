package com.vervalle.dropwizarddemo;

/*
A class that is responsible for reading the properties stored into configuration.yml file and storing it's value:
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vervalle.dropwizarddemo.api.Messages;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;

public class SampleConfiguration extends Configuration{

    // for Resource GreetingsResource
    @Valid
    private Messages messages;

    public Messages getMessages() {
        return messages;
    }

    public void setMessages(Messages messages) {
        this.messages = messages;
    }

    // for Resource EchoResource
    @NotEmpty
    private String environment;

    @JsonProperty
    public String getEnvironment() {
        return environment;
    }

    @JsonProperty
    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    // for Resource Task List
    private int maxLength;

    @JsonProperty
    public int getMaxLength() {
        return maxLength;
    }

    @JsonProperty
    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    // for Resource Event
    @NotEmpty
    private String dateFormat;

    public String getDateFormat() {
        return dateFormat;
    }

}