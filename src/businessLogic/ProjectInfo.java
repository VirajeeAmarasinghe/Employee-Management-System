package businessLogic;

import java.sql.Date;

public class ProjectInfo {

    private int pID;        //variable to store project id
    private String title;   //variable to store title/project name
    private Date startD;    //variable to store start date of the project
    private int duration;   //variable to store duration of the project.number of months is the unit
    private int client_id;  //variable to store client id
    private int count = 0;    //variable to store number of employees in each project--->this is useful in ProjectReportDB class.

    public ProjectInfo(int pID, String title, Date startD, int duration, int clientId) {
        this.pID = pID;
        this.title = title;
        this.startD = startD;
        this.duration = duration;
        this.client_id = clientId;
    }

    public ProjectInfo(String title, int countEmployees) {   //this constructor is useful in ProjectReportDB class-->getCount()method
        this.title = title;
        this.count = countEmployees;
    }

    public void setClientId(int clientId) {
        this.client_id = clientId;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setStartD(Date startD) {
        this.startD = startD;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setpID(int pID) {
        this.pID = pID;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getClientId() {
        return client_id;
    }

    public int getDuration() {
        return duration;
    }

    public Date getStartD() {
        return startD;
    }

    public String getTitle() {
        return title;
    }

    public int getpID() {
        return pID;
    }

    public int getCount() {
        return count;
    }

}
