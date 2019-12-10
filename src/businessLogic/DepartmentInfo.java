package businessLogic;

public class DepartmentInfo {

    private int deptID;        //variable to store department id
    private String deptName;   //variable to store department name
    private String addNo;      //variable to store address-no
    private String addStreet;  //variable to store address-street
    private String addCity;    //variable to store address-city
    private String tele;       //variable to store telephone no
    private String email;      //variable to store email

    public DepartmentInfo(int dID, String name, String no, String street, String city, String tele, String email) {
        this.deptID = dID;
        this.deptName = name;
        this.addNo = no;
        this.addStreet = street;
        this.addCity = city;
        this.tele = tele;
        this.email = email;
    }

    public void setDeptID(int deptID) {
        this.deptID = deptID;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
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

    public void setTele(String tele) {
        this.tele = tele;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getDeptID() {
        return deptID;
    }

    public String getDeptName() {
        return deptName;
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

    public String getTele() {
        return tele;
    }

    public String getEmail() {
        return email;
    }

}
