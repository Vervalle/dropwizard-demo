package com.vervalle.dropwizarddemo.models.inMemory;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Event {

    private long id;
    private String name;
    private String description;
    private String location;
    private Date date;

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getName() {
        return name;
    }

    @JsonProperty
    public String getDescription() {
        return description;
    }

    @JsonProperty
    public String getLocation() {
        return location;
    }

    @JsonProperty
    public Date getDate() {
        return date;
    }

    @Override
    public String toString(){
        return String.format("Event:%s, name=%s, Desc=%s, Loc=%s, at:%s",
                this.id, this.name, this.description, this.location, this.date);
    }

    public void updateExceptId(Event that) {
        this.setName(that.getName());
        this.setDescription(that.getDescription());
        this.setLocation(that.getLocation());
        this.setDate(that.getDate());
    }
}
