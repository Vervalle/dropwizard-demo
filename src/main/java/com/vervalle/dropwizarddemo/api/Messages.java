package com.vervalle.dropwizarddemo.api;

import javax.validation.constraints.NotNull;

public class Messages {

    @NotNull
    private String hello;

    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }
}
