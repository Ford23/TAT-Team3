package at3.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;



@Entity
public class Reservation
{
    @Id
    @GeneratedValue
    private Long Id;//Primary Key
    private Date reservedFrom;
    private Date reservedTo;

    @ManyToOne(fetch=FetchType.LAZY,optional=false)
    @JoinColumn(name="hotel_id",nullable=false)
    @OnDelete(action=OnDeleteAction.CASCADE)
    @JsonIgnore
    private Hotel hotel;

    @ManyToOne(fetch=FetchType.LAZY,optional=false)
    @JoinColumn(name="user_id",nullable=false)
    @OnDelete(action=OnDeleteAction.CASCADE)
    @JsonIgnore
    private ReservationUser user;

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
