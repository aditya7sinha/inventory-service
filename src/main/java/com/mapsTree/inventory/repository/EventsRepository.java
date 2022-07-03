package com.mapsTree.inventory.repository;

import com.mapsTree.inventory.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EventsRepository extends JpaRepository<Event,Long> {
    @Query(value="Select * from event_data where event_id=?1",nativeQuery = true)
    Event findEventById(String id);
}
