package com.zti.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@Entity(name="pin")
@Table(name = "pin")
public class Pin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pinId;


    private String creatorUid;

    private double latitude;

    private double longitude;

    private String pinText;

    private String category;

    // Constructors, getters, and setters
    public Pin(String creatorUid) {
        creatorUid = creatorUid;
    }

    public Pin(String creatorUid, double latitude, double longitude, String pinText, String category) {
        this.creatorUid = creatorUid;
        this.latitude = latitude;
        this.longitude = longitude;
        this.pinText = pinText;
        this.category = category;
    }

    public Pin() {

    }


}