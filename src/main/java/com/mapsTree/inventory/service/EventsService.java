package com.mapsTree.inventory.service;

import com.mapsTree.inventory.domain.Event;
import com.mapsTree.inventory.repository.EventsRepository;
import com.mapsTree.inventory.web.rest.mapper.EventMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EventsService {
    static final Logger LOG= LoggerFactory.getLogger(EventsService.class);
    private final EventsRepository eventsRepository;
    @Autowired
    private final EventMapper eventMapper;
    public EventsService(EventsRepository eventsRepository,EventMapper eventMapper){
        this.eventsRepository=eventsRepository;
        this.eventMapper= eventMapper;
    }

    public Event insert(Event event){
        LOG.info("In eventsService {}", event.toString());
        event.setEventId(generateEvent().toString());
        return eventsRepository.save(event);
    }
    public UUID generateEvent(){
        return UUID.randomUUID();
    }

    public List<com.mapsTree.inventory.model.Event> getAllEvents() {
        LOG.info("In eventsService");
        List<com.mapsTree.inventory.model.Event> eventList=new ArrayList<com.mapsTree.inventory.model.Event>();
        List<Event> ans= eventsRepository.findAll();
        int size=ans.size();
        for(int i=0;i<size;i++){
            eventList.add(eventMapper.map(ans.get(i)));
        }
        return eventList;
    }

    public Event getEvent(Event event){
        LOG.info("In eventsService");
        return eventsRepository.findEventById(event.getEventId());
    }
}
