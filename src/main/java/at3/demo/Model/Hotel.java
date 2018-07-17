package at3.demo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Hotel{
    @Id
    @GeneratedValue
    private  Long Id; //Primary Key
    private String hotelName;
    private String hotelAdress;
    private double longitude;
    private double latitude;
    private String contactNumber;
    private float roomPrice;

    public Hotel(String hotelName,String hotelAdress,double longitude,double latitude,float roomPrice)
    {
        this.hotelName=hotelName;
        this.hotelAdress=hotelAdress;
        this.longitude=longitude;
        this.latitude=latitude;
        this.roomPrice = roomPrice;
    }

    //Setters
    protected void setId(Long id) {
        this.Id = id;
    }

    protected void setHotelName(String hotelName){
        this.hotelName = hotelName;
    }
    protected void setHotelAdress(String hotelAdress){
        this.hotelAdress = hotelAdress;
    }
    protected void setlongitude(double longitude){
        this.longitude= longitude;
    }
    protected void setLatitude(double latitude){
        this.latitude = latitude;
    }
    protected void setContactNumber(String contactNumber){
        this.contactNumber = contactNumber;
    }
    protected void setRoomPrice(float roomPrice){
        this.roomPrice = roomPrice;
    }
    //Getters
    public Long getId() {return Id;}
    public String getHotelName(){return hotelName;}
    public String getHotelAdress(){return hotelAdress;}
    public double getLongitude(){return longitude;}
    public double getLatitude(){return latitude;}
    public String getContactNumber(){return contactNumber;}
    public float getRoomPrice(){return roomPrice;}
}