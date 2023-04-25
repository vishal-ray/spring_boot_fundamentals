package com.practice.authenticationauthorisation.modules;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "cities")
public class City {

    //   Variables aka Columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    // Linkages
    //  City <---> Location Linkage
    @OneToMany(mappedBy = "city",cascade = CascadeType.ALL)
    private List<LocationDetail> locationDetailsList;
    // City <---> State Linkage
    @ManyToOne()
    @JoinColumn()
    private State state;



    // Getters, Setters and Constructors

    public City() {
    }

    public City(int id, String name, LocalDateTime createdAt, LocalDateTime updatedAt, List<LocationDetail> locationDetailsList, State state) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.locationDetailsList = locationDetailsList;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<LocationDetail> getLocationDetailsList() {
        return locationDetailsList;
    }

    public void setLocationDetailsList(List<LocationDetail> locationDetailsList) {
        this.locationDetailsList = locationDetailsList;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
