package com.vervalle.dropwizarddemo;

/**
 * EventResource is responsible for for handling HTTP requests. When it needs to access or modify data, it delegates
 * this concern to an instance of EventRepository.
 * DummyEventRepository is an implementation of EventRepository and it will act as an in-memory data store.
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import com.vervalle.dropwizarddemo.api.Event;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;

public class DummyEventRepository implements EventRepository {

    private static final String DATA_SOURCE = "dummy_data.json";

    private List<Event> events;

    public DummyEventRepository() {
        try {
            initData();
        } catch (IOException e) {
            throw new RuntimeException(
                    DATA_SOURCE + " missing or is unreadable", e);
        }
    }

    public List<Event> findAll() {
        return events;
    }


    public java.util.Optional<Event> findById(Long id) {
        return events.stream().filter(e -> e.getId() == id).findFirst();
    }

    public Event save(Event event) {
        Optional<Long> maxId = events.stream()
                .map(Event::getId)
                .max(Long::compare);
        long nextId = maxId.map(x -> x + 1).orElse(1L);
        event.setId(nextId);
        events.add(event);
        return event;
    }

    public Optional<Event> update(Long id, Event event) {
        Optional<Event> existingEvent = findById(id);
        existingEvent.ifPresent(e -> e.updateExceptId(event));
        return existingEvent;
    }

    public void delete(Long id) {
        events.removeIf(e -> e.getId() == id);
    }


    private void initData() throws IOException {
        URL url = Resources.getResource(DATA_SOURCE);
        String json = Resources.toString(url, Charsets.UTF_8);
        ObjectMapper mapper = new ObjectMapper();
        CollectionType type = mapper
                .getTypeFactory()
                .constructCollectionType(List.class, Event.class);
        events = mapper.readValue(json, type);
    }

}
