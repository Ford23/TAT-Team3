package com.at3.demo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;


@Entity
public class ReservationUser
{
    @Id
    @GeneratedValue
    public Long Id; //Primary Key
    public String userName;
    public double longitude;
    public double latitude;

    public ReservationUser()
    {
    }

    public ReservationUser(String userName, double longitude, double latitude){

        this.userName=userName;
        this.longitude=longitude;
        this.latitude=latitude;
    }
    public ReservationUser(Long Id,String userName, double longitude, double latitude){
        this.Id=Id;
        this.userName=userName;
        this.longitude=longitude;
        this.latitude=latitude;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
