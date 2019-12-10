
package businessLogic;

import java.sql.Date;

public class EmployeeProjectRegiInfo {
    private int regId;    //variable to store registration id
    private int eID;      //variable to store employee id
    private int pID;      //variable to store project id
    private Date fDate;   //varibale to store finish date 
    private Date stDate;  //variable to store start date

    
    public EmployeeProjectRegiInfo(int regId, int eID, int pID, Date stDate, Date fDate) {
        this.regId = regId;
        this.eID = eID;
        this.pID = pID;
        this.fDate = fDate;
        this.stDate = stDate;
    }

    public void setRegId(int regId) {
        this.regId = regId;
    }

    public void setStDate(Date stDate) {
        this.stDate = stDate;
    }

    public void seteID(int eID) {
        this.eID = eID;
    }

    public void setfDate(Date fDate) {
        this.fDate = fDate;
    }

    public void setpID(int pID) {
        this.pID = pID;
    }

    public int getRegId() {
        return regId;
    }

    public Date getStDate() {
        return stDate;
    }

    public int geteID() {
        return eID;
    }

    public Date getfDate() {
        return fDate;
    }

    public int getpID() {
        return pID;
    }
    
    
}
