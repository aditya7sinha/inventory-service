package com.mapsTree.inventory.web.rest.mapper;

import com.mapsTree.inventory.domain.Event;
import com.mapsTree.inventory.model.EventCreate;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {LocationMapper.class})
public interface EventMapper{
        @Mapping(target="id",ignore = true)
        @Mapping(target="userId",source="userId")
        @Mapping(target = "name",source = "name")
        @Mapping(target = "timeOfEvent",source = "timeOfEvent")
        @Mapping(target= "shortDescription",source = "shortDescription")
        @Mapping(target = "summary", source = "summary")
        @Mapping(target="locationRef.latitude",source="eventLocation.latitude")
        @Mapping(target="locationRef.longitude",source="eventLocation.longitude")
        @Mapping(target="locationRef.address",source="eventLocation.address")
        @Mapping(target = "country", source = "country")
        @Mapping(target="support",ignore = true)
        @Mapping(target = "status", source="status")
        Event map(EventCreate eventCreate);
        @Mapping(target="userId",source="userId")
        @Mapping(target="eventId",source="eventId")
        @Mapping(target = "name",source = "name")
        @Mapping(target = "timeOfEvent",source = "timeOfEvent")
        @Mapping(target= "shortDescription",source = "shortDescription")
        @Mapping(target = "summary", source = "summary")
        @Mapping(target="eventLocation.locationId",source="locationRef.id")
        @Mapping(target="eventLocation.latitude",source="locationRef.latitude")
        @Mapping(target="eventLocation.longitude",source="locationRef.longitude")
        @Mapping(target="eventLocation.address",source="locationRef.address")
        @Mapping(target = "country", source = "country")
        @Mapping(target="support",source="support")
        @Mapping(target = "status", source="status")
        com.mapsTree.inventory.model.Event map(Event event);


}
