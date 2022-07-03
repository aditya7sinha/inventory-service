package com.mapsTree.inventory.domain;

import javax.persistence.*;
@Entity
@Table(name="locationRef")
public class LocationRef {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name="sequenceGenerator")
    @Column(name="id")
    private Long id;
    @Column(name="latitude")
    private String latitude;
    @Column(name="longitude")
    private String longitude;
    @Column(name="address")
    private String address;

    public Long getId() {
        return id;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getAddress() {
        return address;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocationRef(Long id, String latitude, String longitude, String address) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
    }
    public LocationRef() {
    }


    @Override
    public String toString() {
        return "LocationRef{" +
                "id=" + id +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
