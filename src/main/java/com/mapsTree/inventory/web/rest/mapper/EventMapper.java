package com.mapsTree.inventory.web.rest.mapper;

import com.mapsTree.inventory.domain.Event;
import com.mapsTree.inventory.model.EventCreate;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

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
        @Mapping(source="userId",target="userId")
        @Mapping(source="eventId",target="eventId")
        @Mapping(source = "name",target = "name")
        @Mapping(source = "timeOfEvent",target = "timeOfEvent")
        @Mapping(source= "shortDescription",target = "shortDescription")
        @Mapping(source = "summary", target= "summary")
        @Mapping(source="eventLocation.locationId",target="locationRef.id")
        @Mapping(source="eventLocation.latitude",target="locationRef.latitude")
        @Mapping(source="eventLocation.longitude",target="locationRef.longitude")
        @Mapping(source="eventLocation.address",target="locationRef.address")
        @Mapping(source = "country",target= "country")
        @Mapping(source="support",target="support")
        @Mapping(source = "status",target="status")
        Event map(com.mapsTree.inventory.model.Event event);

}
