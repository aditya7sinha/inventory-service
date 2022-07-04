package com.mapsTree.inventory.controller;

import com.mapsTree.inventory.api.EventApi;
import com.mapsTree.inventory.api.EventApiDelegate;
import com.mapsTree.inventory.model.Event;
import com.mapsTree.inventory.model.EventCreate;
import com.mapsTree.inventory.service.EventsService;
import com.mapsTree.inventory.web.rest.mapper.EventMapper;
import jdk.internal.org.jline.utils.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EventsApiController implements EventApi {
    static final Logger LOG = LoggerFactory.getLogger(EventsApiController.class);
    private final EventsService eventsService;
    @Autowired
    private final EventMapper eventMapper;

    EventsApiController(final EventsService eventsService,final EventMapper eventMapper){
        this.eventsService=eventsService;
        this.eventMapper=eventMapper;
    }

    @Override
    public ResponseEntity<Event> eventEventidGet(String eventid) {
        LOG.info("GET /event/{id}");
        LOG.info("payload {}",eventid);
        com.mapsTree.inventory.domain.Event event= new com.mapsTree.inventory.domain.Event();
        event.setEventId(eventid);
        return new ResponseEntity<>(eventMapper.map(eventsService.getEvent(event)),HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<Event>> eventGet() {
        LOG.info("GET /event/");
        List<Event> eventList= new ArrayList<Event>();
        eventList=eventsService.getAllEvents();
        return new ResponseEntity<>(eventList,HttpStatus.CREATED);
    }


    @Override
    public ResponseEntity<Event> eventPost(EventCreate body) {
        LOG.info("POST /event");
        String payload = body.toString();
        LOG.info("payload: {}",payload);
        com.mapsTree.inventory.domain.Event savedEvent = eventsService.insert(eventMapper.map(body));
        LOG.info("Saved {}", savedEvent.toString());
        return new ResponseEntity<>(eventMapper.map(savedEvent), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Event> eventEventidPatch(String eventid, Event body) {
        LOG.info("PATCH /event/{eventid}");
        String payload=body.toString();
        LOG.info("payload {}",payload);
        com.mapsTree.inventory.domain.Event updatedEvent = eventsService.updateEvent(eventid,eventMapper.map(body));


        return new ResponseEntity<>(eventMapper.map(updatedEvent), HttpStatus.CREATED);
    }
}
