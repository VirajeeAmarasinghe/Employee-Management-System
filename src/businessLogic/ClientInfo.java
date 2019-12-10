package businessLogic;

public class ClientInfo {

    private int cId;          //variable to store client id
    private String cName;     //variable to store client name
    private String addNo;     //variable to store address-No
    private String addStreet; //varible to store address-Street
    private String addCity;   //varible to store address-City
    private String nic;       //varibale to store nic no
    private String tele;      //varible to store telephone no
    private String email;     //varible to store email

    public ClientInfo(int id, String name, String no, String street, String city, String nic, String tele, String email) {
        this.cId = id;
        this.cName = name;
        this.addNo = no;
        this.addStreet = street;
        this.addCity = city;
        this.nic = nic;
        this.tele = tele;
        this.email = email;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public void setAddNo(String addNo) {
        this.addNo = addNo;
    }

    public void setAddStreet(String addStreet) {
        this.addStreet = addStreet;
    }

    public void setAddCity(String addCity) {
        this.addCity = addCity;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getcId() {
        return cId;
    }

    public String getcName() {
        return cName;
    }

    public String getAddNo() {
        return addNo;
    }

    public String getAddStreet() {
        return addStreet;
    }

    public String getAddCity() {
        return addCity;
    }

    public String getNic() {
        return nic;
    }

    public String getTele() {
        return tele;
    }

    public String getEmail() {
        return email;
    }

}
