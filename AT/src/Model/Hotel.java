package Model;
import  Model.Adress;

public class Hotel{
    private  int Id; //Primary Key
    private String hotelName;
    private Adress hotelAdress;
    private int longitude;
    private int latitude;
    private String contactNumber;

    //Setters
    protected void setHotelName(String hotelName){
        this.hotelName = hotelName;
    }
    protected void setHotelAdress(Adress hotelAdress){
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
    public Adress getHotelAdress(){return hotelAdress;}
    public int getLongitude(){return longitude;}
    public int getLatitude(){return latitude;}
    public String getContactNumber(){return contactNumber;}
}
