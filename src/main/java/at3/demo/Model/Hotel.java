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
    private int longitude;
    private int latitude;
    private String contactNumber;

    public Hotel(String hotelName,String hotelAdress,int longitude,int latitude)
    {
        this.hotelName=hotelName;
        this.hotelAdress=hotelAdress;
        this.longitude=longitude;
        this.latitude=latitude;

    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    //Setters
    protected void setHotelName(String hotelName){
        this.hotelName = hotelName;
    }
    protected void setHotelAdress(String hotelAdress){
        this.hotelAdress = hotelAdress;
    }
    protected void setlongitude(int longitude){
        this.longitude= longitude;
    }
    protected void setLatitude(int latitude){
        this.latitude = latitude;
    }
    protected void setContactNumber(String contactNumber){
        this.contactNumber = contactNumber;
    }
    //Getters
    public String getHotelName(){return hotelName;}
    public String getHotelAdress(){return hotelAdress;}
    public int getLongitude(){return longitude;}
    public int getLatitude(){return latitude;}
    public String getContactNumber(){return contactNumber;}
}