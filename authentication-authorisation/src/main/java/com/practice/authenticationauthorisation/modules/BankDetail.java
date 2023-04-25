package com.practice.authenticationauthorisation.modules;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.security.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "bank_details")
public class BankDetail {

    //   Variables aka Columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private long accNo;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;



    // Linkages

    // Bank <---> User Linkage
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="user_id")
    private User user;




    // Getters, Setters and Constructors


    public BankDetail() {
    }

    public BankDetail(int id, long accNo, LocalDateTime createdAt, LocalDateTime updatedAt, User user) {
        this.id = id;
        this.accNo = accNo;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getAccNo() {
        return accNo;
    }

    public void setAccNo(long accNo) {
        this.accNo = accNo;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
