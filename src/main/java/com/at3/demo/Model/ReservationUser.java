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
    public Double longitudee;
    public Double latitudee;

    public ReservationUser()
    {

    }
    public ReservationUser(Long Id)
    {
        this.Id=Id;
    }
    public ReservationUser(String userName, Double longitude, Double latitude){

        this.userName=userName;
        this.longitudee=longitude;
        this.latitudee=latitude;
    }
    public ReservationUser(Long Id,String userName, Double longitude, Double latitude){
        this.Id=Id;
        this.userName=userName;
        this.longitudee=longitude;
        this.latitudee=latitude;
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
        return longitudee;
    }

    public void setLongitude(Double longitude) {
        this.longitudee = longitude;
    }

    public double getLatitude() {
        return latitudee;
    }

    public void setLatitude(Double latitude) {
        this.latitudee = latitude;
    }
}
