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
    public Double longitude;
    public Double latitude;

    public ReservationUser()
    {

    }
    public ReservationUser(Long Id)
    {
        this.Id=Id;
    }
    public ReservationUser(String userName, Double longitude, Double latitude){

        this.userName=userName;
        this.longitude=longitude;
        this.latitude=latitude;
    }
    public ReservationUser(Long Id,String userName, Double longitude, Double latitude){
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

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
}
