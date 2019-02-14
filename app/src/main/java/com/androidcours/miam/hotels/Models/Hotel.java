package com.androidcours.miam.hotels.Models;

import java.io.Serializable;

/**
 * Created by Yassine EL HALAOUI on 2/11/19.
 */

public class Hotel implements Serializable {

    private Integer id;
    private String name;
    private String adress;
    private String city;
    private Double rank;
    private String description;
    private Double latitude;
    private Double longitude;

    // Constructors

    public Hotel(Integer id, String name, String adress, String city, Double rank, String description, Double latitude, Double longitude) {
        this.id = id;
        this.name = name;
        this.adress = adress;
        this.city = city;
        this.rank = rank;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Hotel() {  }


    // Getters & Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Double getRank() {
        return rank;
    }

    public void setRank(Double rank) {
        this.rank = rank;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
