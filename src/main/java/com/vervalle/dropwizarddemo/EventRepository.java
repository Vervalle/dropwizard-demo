package com.vervalle.dropwizarddemo;

import com.vervalle.dropwizarddemo.models.Event;

import java.util.List;

public interface EventRepository {
    List<Event> findAll();

    java.util.Optional<Event> findById(Long id);

    Event save(Event event);

    java.util.Optional<Event> update(Long id, Event event);

    void delete(Long id);
}
