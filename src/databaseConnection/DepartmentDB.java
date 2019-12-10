package databaseConnection;

import businessLogic.DepartmentInfo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import userInterface.Department;

public class DepartmentDB {

    private Connection con;

    //connect with Access using ucanaccess database
    public DepartmentDB() {
        try {
            con = DriverManager.getConnection("jdbc:ucanaccess://emsDB.accdb");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    /*this method is for inserting department data to the database.
     first it checks whether the entered department id is already available in the DB or not.
     If there is, error message will be given.If not data will be added to the DB
    */
    public int addData(DepartmentInfo d) {
        try {
            String selectSt = "select * from Department where dept_id=?";
            PreparedStatement p = con.prepareStatement(selectSt);
            p.setInt(1, d.getDeptID());
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Entered Department ID is already available.New Department was not added.");
                return 2;
            } else {
                String insertSt = "insert into Department(dept_id,dept_name,add_no,add_street,add_city,tele,email)values(?,?,?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(insertSt); //create statement-->convert String to sql statement
                ps.setInt(1, d.getDeptID());//insert values into table
                ps.setString(2, d.getDeptName());
                ps.setString(3, d.getAddNo());
                ps.setString(4, d.getAddStreet());
                ps.setString(5, d.getAddCity());
                ps.setString(6, d.getTele());
                ps.setString(7, d.getEmail());

                int result = ps.executeUpdate();
                ps.close();
                return result;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return 0;
        }
    }

    //this method is for retrieving dapartment data from DB using department id
    public DepartmentInfo getDataById(int dID) {
        try {
            DepartmentInfo e = null;
            String selectSt = "select * from Department where dept_id=?";
            PreparedStatement ps = con.prepareStatement(selectSt);
            ps.setInt(1, dID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int deptID = rs.getInt("dept_id");
                String deptName = rs.getString("dept_name");
                String addNo = rs.getString("add_no");
                String addStreet = rs.getString("add_street");
                String addCity = rs.getString("add_city");
                String tele = rs.getString("tele");
                String email = rs.getString("email");
                e = new DepartmentInfo(deptID, deptName, addNo, addStreet, addCity, tele, email);
            }
            rs.close();
            ps.close();
            return e;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }

    /*this method is for deleting departmet records in the DB.
     first it checks whether entered department id is available in the DB or not.
     If not, error message will come. If there is the id in the DB, that record which 
     its department id matches with entered one,will be deleted.
     */
    public int deleteData(int dID) {
        try {
            String selectSt = "select * from Department where dept_id=?";
            PreparedStatement p = con.prepareStatement(selectSt);
            p.setInt(1, dID);
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                String deleteSt = "delete * from Department where dept_id=?";
                PreparedStatement ps = con.prepareStatement(deleteSt);
                ps.setInt(1, dID);
                int result = ps.executeUpdate();
                ps.close();
                return result;
            } else {
                JOptionPane.showMessageDialog(null, "Entered Department ID is not available.Department was not Deleted.");
                return 2;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return 0;
        }
    }

    /*this method is for editing departmet records in the DB.
     first it checks whether entered department id is available in the DB or not.
     If not, error message will come. If there is the id in the DB, that record which 
     its department id matches with entered one,will be updated.
     */
    public int editData(DepartmentInfo d) {
        try {
            String selectSt = "select * from Department where dept_id=?";
            PreparedStatement ps = con.prepareStatement(selectSt);
            ps.setInt(1, d.getDeptID());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String updateSt = "update Department set dept_name=?,add_no=?,add_street=?,add_city=?,tele=?,email=? where dept_id=?";
                PreparedStatement ps2 = con.prepareStatement(updateSt);
                ps2.setString(1, d.getDeptName());
                ps2.setString(2, d.getAddNo());
                ps2.setString(3, d.getAddStreet());
                ps2.setString(4, d.getAddCity());
                ps2.setString(5, d.getTele());
                ps2.setString(6, d.getEmail());
                ps2.setInt(7, d.getDeptID());
                int result = ps2.executeUpdate();
                ps.close();
                ps2.close();
                return result;
            } else {
                JOptionPane.showMessageDialog(Department.btn_edit, "Entered Id is not available.Department not Edited.");
                return 2;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return 0;
        }
    }

    //this method is for retrieving all the department reords in the DB
    public ArrayList<DepartmentInfo> getAllData() {
        ArrayList<DepartmentInfo> ar = new ArrayList<>();
        try {
            DepartmentInfo e = null;
            String selectSt = "select * from Department";
            PreparedStatement ps = con.prepareStatement(selectSt);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int dID = rs.getInt("dept_id");
                String deptName = rs.getString("dept_name");
                String addNo = rs.getString("add_no");
                String addStreet = rs.getString("add_street");
                String addCity = rs.getString("add_city");
                String tele = rs.getString("tele");
                String email = rs.getString("email");
                e = new DepartmentInfo(dID, deptName, addNo, addStreet, addCity, tele, email);
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

    /*getNextID() method is for creating next department id. 
     so user does not need to enter the department id explicitly when add new department data.
     System automatically generates it.This avoids entering duplicate id*/
    public long getNextID() {
        String st = "select MAX(dept_id)From Department";
        try {
            PreparedStatement ps = con.prepareStatement(st);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int i = rs.getInt(1);
                long l = i + 1;
                return l;
            } else {
                return 0;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return 0;
        }
    }

    //this method is for retrieving department data using department name
    public ArrayList<DepartmentInfo> getDataByName(String dName) {
        ArrayList<DepartmentInfo> ar = new ArrayList<>();
        try {
            DepartmentInfo e = null;
            String selectSt = "select * from Department where dept_name like ?";  //in here 'like' keyword is used
            PreparedStatement ps = con.prepareStatement(selectSt);
            ps.setString(1, "%" + dName + "%");   //pattern is used.
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int deptID = rs.getInt("dept_id");
                String deptName = rs.getString("dept_name");
                String addNo = rs.getString("add_no");
                String addStreet = rs.getString("add_street");
                String addCity = rs.getString("add_city");
                String tele = rs.getString("tele");
                String email = rs.getString("email");
                e = new DepartmentInfo(deptID, deptName, addNo, addStreet, addCity, tele, email);
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
