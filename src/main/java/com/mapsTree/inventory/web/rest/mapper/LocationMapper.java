package com.mapsTree.inventory.web.rest.mapper;

import com.mapsTree.inventory.domain.LocationRef;
import com.mapsTree.inventory.model.Location;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LocationMapper {
    @Mapping(source="latitude", target="latitude")
    @Mapping(source="longitude", target="longitude")
    @Mapping(source = "address",target = "address")
    LocationRef map(Location location);
    @Mapping(source="id", target="locationId")
    @Mapping(source="latitude", target="latitude")
    @Mapping(source="longitude", target="longitude")
    @Mapping(source = "address",target = "address")
    com.mapsTree.inventory.model.LocationRef map(LocationRef locationRef);



}
