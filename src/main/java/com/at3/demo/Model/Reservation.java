package com.at3.demo.Model;

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
    public Date reservedFrom;
    public Date reservedTo;

    @ManyToOne(fetch=FetchType.LAZY,optional=false)
    @JoinColumn(name="hotel_id",nullable=false)
    @OnDelete(action=OnDeleteAction.CASCADE)
    private Hotel hotel;

    @ManyToOne(fetch=FetchType.LAZY,optional=false)
    @JoinColumn(name="user_id",nullable=false)
    @OnDelete(action=OnDeleteAction.CASCADE)
    private ReservationUser user;

    public Reservation() {
    }

    public Reservation(Long Id,Date reservedFrom, Date reservedTo, Hotel IdHotela, ReservationUser IdUser)
    {

        this.Id=Id;
        this.reservedFrom=reservedFrom;
        this.reservedTo=reservedTo;
        this.hotel.Id= IdHotela.Id;
        this.user.Id=IdUser.Id;
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

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public ReservationUser getUser() {
        return user;
    }

    public void setUser(ReservationUser user) {
        this.user = user;
    }
}
