package at3.demo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;


@Entity
public class ReservationUser
{
    @Id
    @GeneratedValue
    private Long Id; //Primary Key
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String uniqueNumber;
    private String phoneNumber;
    private String adress;

    public ReservationUser(String firstName,String lastName,Date birthDate,String uniqueNumber,String phoneNumber,String adress)
    {
        this.firstName=firstName;
        this.lastName=lastName;
        this.birthDate=birthDate;
        this.uniqueNumber=uniqueNumber;
        this.phoneNumber=phoneNumber;
        this.adress=adress;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

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
    protected void setAdress(String adress){
           this.adress=adress;
       }

         //Getters
            protected String getFirstName(){return firstName;}
    protected String getLastName(){return lastName;}
    protected Date getBirthDate(){return birthDate;}
    protected String getUniqueNumber(){return uniqueNumber;}
    protected String getPhoneNumber(){return phoneNumber;}
    protected String getAdress(){return adress;}
}
