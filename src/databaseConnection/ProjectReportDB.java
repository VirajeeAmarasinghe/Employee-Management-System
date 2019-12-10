package databaseConnection;

import businessLogic.ProjectInfo;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ProjectReportDB {

    private Connection cn;

    //connect with Access using ucanaccess driver
    public ProjectReportDB() {
        try {
            cn = DriverManager.getConnection("jdbc:ucanaccess://emsDB.accdb");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    /*this segmant of code is used in all the rest of methods.
     So to improve the code reusability, this code segment is written inside separate method.
     This code is for iterate the resultset and add that data to a arraylist
     */
    private void getData(ResultSet rs, ArrayList<ProjectInfo> ar) {
        try {
            while (rs.next()) {
                int prID = rs.getInt("project_id");
                String title = rs.getString("title");
                Date stDate = rs.getDate("startDate");
                int dur = rs.getInt("duration");
                int clientID = rs.getInt("client_id");
                ProjectInfo e = new ProjectInfo(prID, title, stDate, dur, clientID);
                ar.add(e);
            }
            rs.close();
        } catch (SQLException e) {
        }
    }

    //this method is for retrieving all the project records accroding to employee name
    public ArrayList<ProjectInfo> getAllDataFromDBAccordingToEmployee(String empFirstName, String empLastName) {
        ArrayList<ProjectInfo> ar = new ArrayList<>();
        try {
            String selectSt = "select * from Project where project_id "
                    + "in(select p_id from EmployeeProject where e_id "
                    + "in(select employee_id from Employee where e_first_name=? or e_last_name=?))";
            PreparedStatement ps = cn.prepareStatement(selectSt);
            ps.setString(1, empFirstName);
            ps.setString(2, empLastName);
            ResultSet rs = ps.executeQuery();
            getData(rs, ar);
            rs.close();
            ps.close();
            return ar;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }

    //this method is for retrieving all the project records according to department name
    public ArrayList<ProjectInfo> getAllDataFromDBAccordingToDepartment(String dept) {
        ArrayList<ProjectInfo> ar = new ArrayList<>();
        try {
            String selectSt = "select * from Project where project_id in"
                    + "(select p_id from EmployeeProject where e_id in"
                    + "(select employee_id from Employee where dept_id="
                    + "(select dept_id from Department where dept_name=?)))";
            PreparedStatement ps = cn.prepareStatement(selectSt);
            ps.setString(1, dept);
            ResultSet rs = ps.executeQuery();
            getData(rs, ar);
            rs.close();
            ps.close();
            return ar;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }

    //this method is for retrieving all the project records according to client
    public ArrayList<ProjectInfo> getAllDataFromDBAccordingToClient(String clientName) {
        ArrayList<ProjectInfo> ar = new ArrayList<>();
        try {
            String selectSt = "select * from Project where client_id=(select client_id from Client where client_name=?)";
            PreparedStatement ps = cn.prepareStatement(selectSt);
            ps.setString(1, clientName);
            ResultSet rs = ps.executeQuery();
            getData(rs, ar);
            rs.close();
            ps.close();
            return ar;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }

    //this method is for retrieving all the project details according to start date
    public ArrayList<ProjectInfo> getAllDataFromDBAccordingToStartDate(String stYear) {
        ArrayList<ProjectInfo> ar = new ArrayList<>();
        try {
            String selectSt = "select * from Project";
            PreparedStatement ps = cn.prepareStatement(selectSt);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int prID = rs.getInt("project_id");
                String title = rs.getString("title");
                Date stDate = rs.getDate("startDate");
                String startDate = String.valueOf(stDate).substring(0, 4);
                int dur = rs.getInt("duration");
                int clientID = rs.getInt("client_id");
                if (stYear.equals(startDate)) {
                    ProjectInfo e = new ProjectInfo(prID, title, stDate, dur, clientID);
                    ar.add(e);
                }
            }
            rs.close();
            ps.close();
            return ar;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }

    //this method is for retrieving all the project details according to finish date
    public ArrayList<ProjectInfo> getAllDataFromDBAccordingToFinishDate(String fnYear) {
        ArrayList<ProjectInfo> ar = new ArrayList<>();
        try {
            String selectSt = "select * from Project";
            PreparedStatement ps = cn.prepareStatement(selectSt);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int prID = rs.getInt("project_id");
                String title = rs.getString("title");
                Date stDate = rs.getDate("startDate");
                String fnDate = String.valueOf(stDate).substring(0, 4);
                int dur = rs.getInt("duration");
                int clientID = rs.getInt("client_id");
                if (fnYear.equals(fnDate)) {
                    ProjectInfo e = new ProjectInfo(prID, title, stDate, dur, clientID);
                    ar.add(e);
                }
            }
            rs.close();
            ps.close();
            return ar;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }

    //this method is for displaying number of employees in each projecta
    public ArrayList<ProjectInfo> getCount() {
        ArrayList<ProjectInfo> ar = new ArrayList<>();
        try {
            String selectSt = "select title,count(*)as[number of employees] from EmployeeProject e inner join Project p on e.p_id=p.project_id group by title";
            PreparedStatement ps = cn.prepareStatement(selectSt);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String title = rs.getString("title");
                int count = rs.getInt("number of employees");
                ProjectInfo e = new ProjectInfo(title, count);
                ar.add(e);
            }
            rs.close();
            ps.close();
            return ar;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }
}
