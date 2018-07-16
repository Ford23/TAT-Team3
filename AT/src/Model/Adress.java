package Model;

public class Adress {
    private  String adress;
    private  String postalCode;
    private  String town;
    private  String city;

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
