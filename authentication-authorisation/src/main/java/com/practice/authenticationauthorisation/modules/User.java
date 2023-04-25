package com.practice.authenticationauthorisation.modules;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.security.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    // Variables aka Columns
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private float ratings;
    private String name;
    private Long mobNo;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;


    // Linkages
    // User <---> Bank Linkage
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<BankDetail> bankDetailList;
    // User <---> Location Linkage
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<LocationDetail> locationDetailList;













    // Getters, Setters and Constructors

    public User() {
    }
    public User(int id, float ratings, String name, Long mobNo, LocalDateTime createdAt, LocalDateTime updatedAt, List<BankDetail> bankDetailList, List<LocationDetail> locationDetailList) {
        this.id = id;
        this.ratings = ratings;
        this.name = name;
        this.mobNo = mobNo;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.bankDetailList = bankDetailList;
        this.locationDetailList = locationDetailList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getRatings() {
        return ratings;
    }

    public void setRatings(float ratings) {
        this.ratings = ratings;
    }

    public List<BankDetail> getBankDetailList() {
        return bankDetailList;
    }

    public void setBankDetailList(List<BankDetail> bankDetailList) {
        this.bankDetailList = bankDetailList;
    }

    public List<LocationDetail> getLocationDetailList() {
        return locationDetailList;
    }

    public void setLocationDetailList(List<LocationDetail> locationDetailList) {
        this.locationDetailList = locationDetailList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getMobNo() {
        return mobNo;
    }

    public void setMobNo(Long mobNo) {
        this.mobNo = mobNo;
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
}
