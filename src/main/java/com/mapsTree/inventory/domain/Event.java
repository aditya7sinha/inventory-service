package com.mapsTree.inventory.domain;

import com.mapsTree.inventory.domain.enumeration.Status;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="event_data",uniqueConstraints = { @UniqueConstraint(name = "UniqueEventId",
        columnNames = "eventid") })
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name="sequenceGenerator")
    @Column(name="id")
    private Long id;
    @Column(name="userId")
    private String userId;
    @Column(name="eventId",unique = true)
    private String eventId;
    @Column(name="name")
    private String name;
    @Column(name="timeOfEvent")
    private String timeOfEvent;
    @Column(name="shortDescription")
    private String shortDescription;
    @Column(name="summary")
    private String summary;
    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(unique = true)
    private LocationRef locationRef;
    @Column(name="country")
    private String country;
    @Column(name="support")
    private Integer support;
    @Enumerated(EnumType.STRING)
    @Column(name="status",nullable = false)
    private Status status;

    public Long getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getEventId() {
        return eventId;
    }

    public String getName() {
        return name;
    }

    public String getTimeOfEvent() {
        return timeOfEvent;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getSummary() {
        return summary;
    }

    public LocationRef getLocationRef() {
        return locationRef;
    }

    public String getCountry() {
        return country;
    }

    public Integer getSupport() {
        return support;
    }

    public Status getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTimeOfEvent(String timeOfEvent) {
        this.timeOfEvent = timeOfEvent;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setLocationRef(LocationRef locationRef) {
        this.locationRef = locationRef;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setSupport(Integer support) {
        this.support = support;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Event(Long id, String userId, String eventId, String name, String timeOfEvent, String shortDescription, String summary, LocationRef locationRef, String country, Integer support, Status status) {
        this.id = id;
        this.userId = userId;
        this.eventId = eventId;
        this.name = name;
        this.timeOfEvent = timeOfEvent;
        this.shortDescription = shortDescription;
        this.summary = summary;
        this.locationRef = locationRef;
        this.country = country;
        this.support = support;
        this.status = status;
    }

    public Event() {
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", eventId='" + eventId + '\'' +
                ", name='" + name + '\'' +
                ", timeOfEvent='" + timeOfEvent + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", summary='" + summary + '\'' +
                ", locationRef=" + locationRef +
                ", country='" + country + '\'' +
                ", support=" + support +
                ", status=" + status +
                '}';
    }
}
