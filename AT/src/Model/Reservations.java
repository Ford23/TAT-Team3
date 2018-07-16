package Model;

import java.util.Date;
import Model.Hotel;

public class Reservations {
    private int Id;//Primary Key
    private Date reservedFrom;
    private Date reservedTo;

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
