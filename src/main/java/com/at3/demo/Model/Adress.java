package com.at3.demo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Adress {
    @Id
    @GeneratedValue
    private Long id;
    private  String adress;
    private  String postalCode;
    private  String town;
    private  String city;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //Setters
    protected void setAdress(String adress){
        this.adress = adress;
    }
    protected void setPostalCode(String postalCode){
        this.postalCode = postalCode;
    }
    protected void setTown(String town){
        this.town = town;
    }
    protected void setCity(String city){
        this.city = city;
    }
    //Getters
    protected String getAdress(){return adress;}
    protected String getPostalCode(){return postalCode;}
    protected String getTown(){return town;}
    protected String getCity(){return city;}

}