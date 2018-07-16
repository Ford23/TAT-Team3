package at3.demo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Reservation
{
    @Id
    @GeneratedValue
    private Long Id;//Primary Key
    private Date reservedFrom;
    private Date reservedTo;

    public Reservation(Date reservedFrom,Date reservedTo)
    {
        this.reservedFrom=reservedFrom;
        this.reservedTo=reservedTo;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    //Setters
    protected void setReservedFrom(Date reservedFrom){
        this.reservedFrom = reservedFrom;
    }
    protected void setReservedTo(Date reservedTo){
        this.reservedTo = reservedTo;
    }

    //Getters
    protected Date getReservedFrom(){return  reservedFrom;}
    protected Date getReservedTo(){return  reservedTo;}
}
