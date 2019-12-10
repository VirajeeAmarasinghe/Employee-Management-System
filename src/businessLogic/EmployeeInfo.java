package businessLogic;

import java.sql.Date;

public class EmployeeInfo {

    private int eID;          //variable to store employee id
    private String fName;     //variable to store first name
    private String lName;     //variable to store last name
    private String nic;       //varibale to store nic no
    private String gender;    //variable to store gender
    private Date dob;         //variable to atore date of birth
    private String addNo;     //variable to store address-no
    private String addStreet; //varible to store address-street
    private String addCity;   //variable to store addree-city
    private String teleHome;  //varaible to store home telephone no
    private String teleMobile;//variable to store mobile telephone no
    private String email;     //variable to store email
    private String position;  //variable to stre position
    private int deptID;       //varaible to store department id

    public EmployeeInfo(int eID, String fName, String lName, String nic, String gender, Date dob, String addNo, String addStreet, String addCity, String teleHome, String teleMobile, String email, String position, int deptID) {
        this.eID = eID;
        this.fName = fName;
        this.lName = lName;
        this.nic = nic;
        this.gender = gender;
        this.dob = dob;
        this.addNo = addNo;
        this.addStreet = addStreet;
        this.addCity = addCity;
        this.teleHome = teleHome;
        this.teleMobile = teleMobile;
        this.email = email;
        this.position = position;
        this.deptID = deptID;

    }

    public void seteID(int eID) {
        this.eID = eID;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
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

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setTeleHome(String teleHome) {
        this.teleHome = teleHome;
    }

    public void setTeleMobile(String teleMobile) {
        this.teleMobile = teleMobile;
    }

    public void setDeptID(int deptID) {
        this.deptID = deptID;
    }

    public int getDeptID() {
        return deptID;
    }

    public String getAddCity() {
        return addCity;
    }

    public String getAddNo() {
        return addNo;
    }

    public String getAddStreet() {
        return addStreet;
    }

    public Date getDob() {
        return dob;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getNic() {
        return nic;
    }

    public String getPosition() {
        return position;
    }

    public String getTeleHome() {
        return teleHome;
    }

    public String getTeleMobile() {
        return teleMobile;
    }

    public int geteID() {
        return eID;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

}
