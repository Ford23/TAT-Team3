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
    public String firstName;
    public String lastName;
    public Date birthDate;
    public String uniqueNumber;
    public String phoneNumber;
    public String adress;
    public double longitude;
    public double latitude;

    public ReservationUser()
    {
    }

    public ReservationUser(String firstName, String lastName, Date birthDate, String uniqueNumber, String phoneNumber, String adress)
    {
        this.firstName=firstName;
        this.lastName=lastName;
        this.birthDate=birthDate;
        this.uniqueNumber=uniqueNumber;
        this.phoneNumber=phoneNumber;
        this.adress=adress;

    }

    public ReservationUser(String firstName, String lastName, double longitude, double latitude){
        this.firstName=firstName;
        this.lastName=lastName;
        this.longitude = longitude;
        this.latitude= latitude;
    }
    //Setters
   protected void setId(Long id) {Id = id; }
   protected void setFirstName(String firstName){
           this.firstName = firstName;
       }
   protected void setLastName(String lastName){
            this.lastName = lastName;
       }
   protected void setBirthDate(Date birthDate){
          this.birthDate = birthDate;
       }
   protected void setUniqueNumber(String uniqueNumber){
            this.uniqueNumber = uniqueNumber;
       }
   protected void setPhoneNumber(String phoneNumber){
            this.phoneNumber = phoneNumber;
       }
   protected void setAdress(String adress){
           this.adress=adress;
       }
   protected void setLongitude(double longitude) { this.longitude = longitude;}
   protected void setLatitude(double latitude) { this.latitude = latitude; }

    //Getters
    protected String getFirstName(){return firstName;}
    protected String getLastName(){return lastName;}
    protected Date getBirthDate(){return birthDate;}
    protected String getUniqueNumber(){return uniqueNumber;}
    protected String getPhoneNumber(){return phoneNumber;}
    protected String getAdress(){return adress;}
    protected double getLongitude() {return longitude; }
    protected double getLatitude() {return latitude;}
    protected Long getId() { return Id;}
}
