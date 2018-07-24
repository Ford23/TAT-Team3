package com.at3.demo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Hotel {
    @Id
    @GeneratedValue
    public Long Id; //Primary Key
    public String hotelName;
    public String hotelAdress;
    public Double longitude;
    public Double latitude;
    public String contactNumber;
    public Double roomPrice;

    public Hotel(String hotelName, Double longitude, Double latitude) {
        this.hotelName = hotelName;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Hotel()
    { }
    public Hotel(Long Id,String hotelName,String hotelAdress, String contactNumber,Double longitude,Double latitude,Double roomPrice)
    {
        this.Id=Id;
        this.hotelName=hotelName;
        this.hotelAdress=hotelAdress;
        this.longitude=longitude;
        this.latitude=latitude;
        this.contactNumber=contactNumber;
        this.roomPrice = roomPrice;
    }

    //Setters
    protected void setId(Long id) {
        this.Id = id;
    }

    public void setHotelName(String hotelName){
        this.hotelName = hotelName;
    }
    public void setHotelAdress(String hotelAdress){
        this.hotelAdress = hotelAdress;
    }
    public void setlongitude(Double longitude){
        this.longitude= longitude;
    }
    public void setLatitude(Double latitude){
        this.latitude = latitude;
    }
    public void setContactNumber(String contactNumber){
        this.contactNumber = contactNumber;
    }
    public void setRoomPrice(Double roomPrice){
        this.roomPrice = roomPrice;
    }
    //Getters
    public Long getId() {return Id;}
    public String getHotelName(){return hotelName;}
    public String getHotelAdress(){return hotelAdress;}
    public Double getLongitude(){return longitude;}
    public Double getLatitude(){return latitude;}
    public String getContactNumber(){return contactNumber;}
    public Double getRoomPrice(){return roomPrice;}
}