package com.mapsTree.inventory.repository;

import com.mapsTree.inventory.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventsRepository extends JpaRepository<Event,Long>, JpaSpecificationExecutor<Event> {
//    @Query(value="Select * from event_data where event_id=?1",nativeQuery = true)

    @Query( value="Select Case WHEN COUNT(e)>0 THEN TRUE ELSE FALSE END FROM event_data e where e.event_id=?1", nativeQuery = true)
    Boolean eventExists(String eventId);
    @Query( value="Select * from event_data where event_id=?1", nativeQuery = true)
    Event findEventById(String eventId);
    @Query(value="Select * from event_data where user_id=?1", nativeQuery = true)
    List<Event> findEventsByUser(String userid);
    @Query(value="Select Case WHEN Count(e)>0 THEN TRUE ELSE FALSE END FROM event_data e where e.event_id=?1", nativeQuery = true)
    Boolean userExists(String userId);
}
