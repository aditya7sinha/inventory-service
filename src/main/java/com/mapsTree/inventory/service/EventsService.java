package com.mapsTree.inventory.service;

import com.mapsTree.inventory.controller.error.EventNotFoundException;
import com.mapsTree.inventory.controller.error.UserNotFoundException;
import com.mapsTree.inventory.domain.Event;
import com.mapsTree.inventory.domain.LocationRef;
import com.mapsTree.inventory.repository.EventsRepository;
import com.mapsTree.inventory.web.rest.mapper.EventMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

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
        LOG.info("In eventsService insert {}", event.toString());
        event.setEventId(generateEvent().toString());
        return eventsRepository.save(event);
    }
    public UUID generateEvent(){
        return UUID.randomUUID();
    }

    public List<com.mapsTree.inventory.model.Event> getAllEvents() {
        LOG.info("In eventsService getAllEvents");
        List<com.mapsTree.inventory.model.Event> eventList=new ArrayList<com.mapsTree.inventory.model.Event>();
        List<Event> ans= eventsRepository.findAll();
        int size=ans.size();
        for(int i=0;i<size;i++){
            eventList.add(eventMapper.map(ans.get(i)));
        }
        return eventList;
    }

    public Event getEvent(String eventId){
        LOG.info("In eventsService getEvent");
        if(!eventsRepository.eventExists(eventId)){
            throw new EventNotFoundException(eventId);
        }
        return eventsRepository.findEventById(eventId);
    }

    public Event updateEvent(String eventId,Event event){
        LOG.info("In eventsService updateEvent");
        if(!eventsRepository.eventExists(eventId)){
            throw new EventNotFoundException(eventId);
        }
        Event referencedEvent= eventsRepository.findEventById(eventId);
        if(referencedEvent==null) {
            return insert(event);
        }
        if(event.getUserId()!=null)
            referencedEvent.setUserId(event.getUserId());
        if(event.getName()!=null);
            referencedEvent.setName(event.getName());
        if(event.getTimeOfEvent()!=null);
        referencedEvent.setTimeOfEvent(event.getTimeOfEvent());
        if(event.getSummary()!=null);
        referencedEvent.setSummary(event.getSummary());
        if(event.getShortDescription()!=null);
        referencedEvent.setShortDescription(event.getShortDescription());
        if(event.getLocationRef()!=null){
            LocationRef updatedLocationRef= new LocationRef();
            updatedLocationRef.setLatitude(event.getLocationRef().getLatitude());
            updatedLocationRef.setLongitude(event.getLocationRef().getLongitude());
            updatedLocationRef.setAddress(event.getLocationRef().getAddress());
            referencedEvent.setLocationRef(updatedLocationRef);
        }
        if(event.getSupport()!=null);
        referencedEvent.setSupport(event.getSupport());
        if(event.getCountry()!=null);
        referencedEvent.setCountry(event.getCountry());
        if(event.getStatus()!=null);
        referencedEvent.setStatus(event.getStatus());
        return eventsRepository.save(referencedEvent);
    }

    public List<com.mapsTree.inventory.model.Event> getEventsOfUser(Event user) {
        LOG.info("In eventsService eventsOfUser");
        if(eventsRepository.userExists(user.getUserId())){
            throw new UserNotFoundException(user.getUserId());
        }
        List<com.mapsTree.inventory.model.Event> userevents;
        return eventsRepository.findEventsByUser(user.getUserId()).stream().map( event -> eventMapper.map(event)).collect(Collectors.toList());
    }
}
