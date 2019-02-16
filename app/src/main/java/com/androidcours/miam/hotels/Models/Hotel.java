package com.androidcours.miam.hotels.Models;

import java.io.Serializable;

/**
 * Created by Yassine EL HALAOUI on 2/11/19.
 */

public class Hotel implements Serializable {

    // Database parameters
    public static final String TABLE_NAME       = "hotel";
    public static final String COLUMN_ID        = "id";
    public static final String COLUMN_NAME      = "name";
    public static final String COLUMN_ADDRESS   = "address";
    public static final String COLUMN_CITY      = "city";
    public static final String COLUMN_RANK      = "rank";
    public static final String COLUMN_PHONE     = "phone";
    public static final String COLUMN_LAT       = "lat";
    public static final String COLUMN_LON       = "lon";

    public static final String CREATE_TABLE = "CREATE TABLE "
            + TABLE_NAME + " ( `"
            + COLUMN_ID + "` INTEGER PRIMARY KEY AUTOINCREMENT, `"
            + COLUMN_NAME + "` TEXT, `"
            + COLUMN_ADDRESS + "` TEXT, `"
            + COLUMN_CITY + "` TEXT, `"
            + COLUMN_RANK + "` REAL, `"
            + COLUMN_PHONE + "` TEXT, `"
            + COLUMN_LAT + "` REAL, `"
            + COLUMN_LON + "` REAL )";

    private Integer id;
    private String name;
    private String address;
    private String city;
    private Double rank;
    private String phone;
    private Double latitude;
    private Double longitude;

    // Constructors

    public Hotel(Integer id, String name, String address, String city, Double rank, String phone, Double latitude, Double longitude) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.rank = rank;
        this.phone = phone;
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

    public String getaddress() {
        return address;
    }

    public void setaddress(String address) {
        this.address = address;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
