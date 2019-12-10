package databaseConnection;

import businessLogic.EmployeeInfo;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class EmployeeReportDB {

    private Connection cn;

    //connect with Access using ucanaccess driver 
    public EmployeeReportDB() {
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
    private void getData(ResultSet rs, ArrayList<EmployeeInfo> ar) {
        try {
            while (rs.next()) {
                int eID = rs.getInt("employee_id");
                String eFname = rs.getString("e_first_name");
                String eLname = rs.getString("e_last_name");
                String nic = rs.getString("nic");
                String gender = rs.getString("gender");
                Date dob = rs.getDate("dob");
                String addNo = rs.getString("add_no");
                String addStreet = rs.getString("add_street");
                String addCity = rs.getString("add_city");
                String teleHome = rs.getString("tele_home");
                String teleMobile = rs.getString("tele_mobile");
                String email = rs.getString("email");
                String pos = rs.getString("position");
                int dID = rs.getInt("dept_id");
                EmployeeInfo e = new EmployeeInfo(eID, eFname, eLname, nic, gender, dob, addNo, addStreet, addCity, teleHome, teleMobile, email, pos, dID);
                ar.add(e);
            }
            rs.close();
        } catch (SQLException e) {
        }

    }

    //this method is for retrieving all the employee data according to position
    public ArrayList<EmployeeInfo> getAllDataFromDBAccordingToPos(String position) {
        ArrayList<EmployeeInfo> ar = new ArrayList<>();
        try {
            String selectSt = "select * from Employee where position=?";
            PreparedStatement ps = cn.prepareStatement(selectSt);
            ps.setString(1, position);
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

    //this method is for retrieving all the employee data according to department name
    public ArrayList<EmployeeInfo> getAllDataFromDBAccordingToDept(String department) {
        ArrayList<EmployeeInfo> ar = new ArrayList<>();
        try {
            String selectSt = "select * from Employee where dept_id=(select dept_id from Department where dept_name=?)";
            PreparedStatement ps = cn.prepareStatement(selectSt);
            ps.setString(1, department);
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

    /*this method is for retrieving all the employee data accroding to age. 
     This is very useful for searching who are near to retire from the company
     */
    public ArrayList<EmployeeInfo> getAllDataFromDBAccordingToAge(int age) {
        ArrayList<EmployeeInfo> ar = new ArrayList<>();
        String currentDate = new java.util.Date().toString();
        String currentYear = currentDate.split(" ")[5];
        int intcurrentYear = Integer.parseInt(currentYear);
        int beforeYear = intcurrentYear - age;
        String beforeYear2 = String.valueOf(beforeYear);
        try {
            String selectSt = "select * from Employee";
            PreparedStatement ps = cn.prepareStatement(selectSt);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int eID = rs.getInt("employee_id");
                String eFname = rs.getString("e_first_name");
                String eLname = rs.getString("e_last_name");
                String nic = rs.getString("nic");
                String gender = rs.getString("gender");
                Date dob = rs.getDate("dob");
                String dobYear = String.valueOf(dob).substring(0, 4);
                String addNo = rs.getString("add_no");
                String addStreet = rs.getString("add_street");
                String addCity = rs.getString("add_city");
                String teleHome = rs.getString("tele_home");
                String teleMobile = rs.getString("tele_mobile");
                String email = rs.getString("email");
                String pos = rs.getString("position");
                int dID = rs.getInt("dept_id");
                if (beforeYear2.equals(dobYear)) {
                    EmployeeInfo e = new EmployeeInfo(eID, eFname, eLname, nic, gender, dob, addNo, addStreet, addCity, teleHome, teleMobile, email, pos, dID);
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

    /*this method is for retrieving all the employee data accroding to residential city.
     so this method is useful for searching who is coming from which city
     */
    public ArrayList<EmployeeInfo> getAllDataFromDBAccordingToCity(String city) {
        ArrayList<EmployeeInfo> ar = new ArrayList<>();
        try {
            String selectSt = "select * from Employee where add_city=?";
            PreparedStatement ps = cn.prepareStatement(selectSt);
            ps.setString(1, city);
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

    //this method is for retrieving all the employee data according to project.
    public ArrayList<EmployeeInfo> getAllDataFromDBAccordingToProject(String project) {
        ArrayList<EmployeeInfo> ar = new ArrayList<>();
        try {
            String selectSt = "select * from Employee where employee_id in(select e_id from EmployeeProject where p_id=(select project_id from Project where title=?))";
            PreparedStatement ps = cn.prepareStatement(selectSt);
            ps.setString(1, project);
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

    //this method is for retrieving all the employee data according to position and department
    public ArrayList<EmployeeInfo> getAllDataFromDBAccordingToPosAndDept(String pos, String dept) {
        ArrayList<EmployeeInfo> ar = new ArrayList<>();
        try {
            String selectSt = "select * from Employee where position=? and dept_id=(select dept_id from Department where dept_name=?)";
            PreparedStatement ps = cn.prepareStatement(selectSt);
            ps.setString(1, pos);
            ps.setString(2, dept);
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

    //this method is for retrieving all the employee data according to department and age.
    public ArrayList<EmployeeInfo> getAllDataFromDBAccordingToDeptAndAge(String dept, int age) {
        ArrayList<EmployeeInfo> ar = new ArrayList<>();
        String currentDate = new java.util.Date().toString();
        String currentYear = currentDate.split(" ")[5];
        int intcurrentYear = Integer.parseInt(currentYear);
        int beforeYear = intcurrentYear - age;
        String beforeYear2 = String.valueOf(beforeYear);
        try {
            String selectSt = "select * from Employee where dept_id=(select dept_id from Department where dept_name=?)";
            PreparedStatement ps = cn.prepareStatement(selectSt);
            ps.setString(1, dept);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int eID = rs.getInt("employee_id");
                String eFname = rs.getString("e_first_name");
                String eLname = rs.getString("e_last_name");
                String nic = rs.getString("nic");
                String gender = rs.getString("gender");
                Date dob = rs.getDate("dob");
                String dobYear = String.valueOf(dob).substring(0, 4);
                String addNo = rs.getString("add_no");
                String addStreet = rs.getString("add_street");
                String addCity = rs.getString("add_city");
                String teleHome = rs.getString("tele_home");
                String teleMobile = rs.getString("tele_mobile");
                String email = rs.getString("email");
                String pos = rs.getString("position");
                int dID = rs.getInt("dept_id");
                if (beforeYear2.equals(dobYear)) {
                    EmployeeInfo e = new EmployeeInfo(eID, eFname, eLname, nic, gender, dob, addNo, addStreet, addCity, teleHome, teleMobile, email, pos, dID);
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

    //this method is for retrieving all the employee data according to department and city
    public ArrayList<EmployeeInfo> getAllDataFromDBAccordingToDeptAndCity(String city, String dept) {
        ArrayList<EmployeeInfo> ar = new ArrayList<>();
        try {
            String selectSt = "select * from Employee where add_city=? and dept_id=(select dept_id from Department where dept_name=?)";
            PreparedStatement ps = cn.prepareStatement(selectSt);
            ps.setString(1, city);
            ps.setString(2, dept);
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

    //this method is for retrieving all the employee data according to project and department
    public ArrayList<EmployeeInfo> getAllDataFromDBAccordingToProjectAndDept(String project, String dept) {
        ArrayList<EmployeeInfo> ar = new ArrayList<>();
        try {
            String selectSt = "select * from Employee where employee_id "
                    + "in(select e_id from EmployeeProject where p_id="
                    + "(select project_id from Project where title=?))and dept_id="
                    + "(select dept_id from Department where dept_name=?))";
            PreparedStatement ps = cn.prepareStatement(selectSt);
            ps.setString(1, project);
            ps.setString(2, dept);
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

    //this method is for retrieving all the employee data accroding to project,department and position
    public ArrayList<EmployeeInfo> getAllDataFromDBAccordingToProjectAndDeptAndPos(String project, String dept, String pos) {
        ArrayList<EmployeeInfo> ar = new ArrayList<>();
        try {
            String selectSt = "select * from Employee where employee_id "
                    + "in(select e_id from EmployeeProject where p_id="
                    + "(select project_id from Project where title=?))and dept_id="
                    + "(select dept_id from Department where dept_name=?)and position=?)";
            PreparedStatement ps = cn.prepareStatement(selectSt);
            ps.setString(1, project);
            ps.setString(2, dept);
            ps.setString(3, pos);
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
}
