package databaseConnection;

import businessLogic.EmployeeProjectRegiInfo;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import userInterface.EmployeeProjectRegistration;

public class EmployeeProjectRegiDB {

    private Connection cn;

    //connect with Access using ucanaccess driver
    public EmployeeProjectRegiDB() {
        try {
            cn = DriverManager.getConnection("jdbc:ucanaccess://emsDB.accdb");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    /*this method is for inserting registration data to the database.
     first it checks whether the entered registration id is already available in the DB or not.
     If there is, error message will be given.If not data will be added to the DB
     */
    public int addData(EmployeeProjectRegiInfo efin) {
        try {
            String selectSt = "select * from EmployeeProject where reg_id=?";
            PreparedStatement p = cn.prepareStatement(selectSt);
            p.setInt(1, efin.getRegId());
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Entered Registration ID is already available.New Registration Data were not added.");
                return 2;
            } else {
                String insertSt = "insert into EmployeeProject(reg_id,e_id,p_id,start_date,finish_date)values(?,?,?,?,?)";
                PreparedStatement ps = cn.prepareStatement(insertSt);

                ps.setInt(1, efin.getRegId());
                ps.setInt(2, efin.geteID());
                ps.setInt(3, efin.getpID());
                ps.setDate(4, efin.getStDate());
                ps.setDate(5, efin.getfDate());

                int result = ps.executeUpdate();
                ps.close();
                return result;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return 0;
        }
    }

    //this method is for retrieving registration data according to registration id
    public EmployeeProjectRegiInfo getData(int regID) {
        try {
            EmployeeProjectRegiInfo e = null;
            String selectSt = "select * from EmployeeProject where reg_id=?";
            PreparedStatement ps = cn.prepareStatement(selectSt);
            ps.setInt(1, regID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int regiID = rs.getInt("reg_id");
                int emID = rs.getInt("e_id");
                int pId = rs.getInt("p_id");
                Date stDate = rs.getDate("start_date");
                Date fnDate = rs.getDate("finish_date");

                e = new EmployeeProjectRegiInfo(regID, emID, pId, stDate, fnDate);
            }
            rs.close();
            ps.close();
            return e;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }

    /*this method is for deleting registration records in the DB.
     first it checks whether entered registration id is available in the DB or not.
     If not, error message will come. If there is the id in the DB, that record which 
     its registration id matches with entered one,will be deleted.
     */
    public int deleteData(int regID) {
        try {
            String selectSt = "select * from EmployeeProject where reg_id=?";
            PreparedStatement p = cn.prepareStatement(selectSt);
            p.setInt(1, regID);
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                String deleteSt = "delete from EmployeeProject where reg_id=?";
                PreparedStatement ps = cn.prepareStatement(deleteSt);
                ps.setInt(1, regID);
                int result = ps.executeUpdate();
                ps.close();
                return result;
            } else {
                JOptionPane.showMessageDialog(null, "Entered Registration ID is not available.Registration Data were not Deleted.");
                return 2;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return 0;
        }
    }

    /*this method is for editing registration records in the DB.
     first it checks whether entered registration id is available in the DB or not.
     If not, error message will come. If there is the id in the DB, that record which 
     its registration id matches with entered one,will be updated.
     */
    public int editData(EmployeeProjectRegiInfo e) {
        try {
            String selectSt = "select * from EmployeeProject where reg_id=?";
            PreparedStatement ps = cn.prepareStatement(selectSt);
            ps.setInt(1, e.getRegId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String updateSt = "update EmployeeProject set e_id=?,p_id=?,start_date=?,finish_date=? where reg_id=?";
                PreparedStatement ps2 = cn.prepareStatement(updateSt);
                ps2.setInt(1, e.geteID());
                ps2.setInt(2, e.getpID());
                ps2.setDate(3, e.getStDate());
                ps2.setDate(4, e.getfDate());
                ps2.setInt(5, e.getRegId());
                int result = ps2.executeUpdate();
                ps.close();
                ps2.close();
                return result;
            } else {
                JOptionPane.showMessageDialog(EmployeeProjectRegistration.btn_edit, "Entered Id is not available.Registration not updated.");
                return 2;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return 0;
        }
    }

    //this method is for retrieving all the registration data from DB 
    public ArrayList<EmployeeProjectRegiInfo> getAllDataFromDB() {
        ArrayList<EmployeeProjectRegiInfo> ar = new ArrayList<>();
        try {
            String selectSt = "select * from EmployeeProject";
            PreparedStatement ps = cn.prepareStatement(selectSt);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int regId = rs.getInt("reg_id");
                int eId = rs.getInt("e_id");
                int pId = rs.getInt("p_id");
                Date stDate = rs.getDate("start_date");
                Date fnDate = rs.getDate("finish_date");
                EmployeeProjectRegiInfo emp = new EmployeeProjectRegiInfo(regId, eId, pId, stDate, fnDate);
                ar.add(emp);
            }
            rs.close();
            ps.close();
            return ar;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }

    /*getNextID() method is for creating next registration id. 
     so user does not need to enter the registration id explicitly when add new registration data.
     System automatically generates it.This avoids entering duplicate ids
     */
    public long getNextID() {
        String st = "select MAX(reg_id)From EmployeeProject";
        try {
            PreparedStatement ps = cn.prepareStatement(st);
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
}
