package Model;

import java.util.Date;
import Model.Reservations;

public class ReservationUser {
    private int Id; //Primary Key
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String uniqueNumber;
    private String phoneNumber;
    private Adress adress;

    //Setters
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
    protected void setAdress(Adress adress){
        this.adress=adress;
    }

    //Getters
    protected String getFirstName(){return firstName;}
    protected String getLastName(){return lastName;}
    protected Date getBirthDate(){return birthDate;}
    protected String getUniqueNumber(){return uniqueNumber;}
    protected String getPhoneNumber(){return phoneNumber;}
    protected Adress getAdress(){return adress;}
}
