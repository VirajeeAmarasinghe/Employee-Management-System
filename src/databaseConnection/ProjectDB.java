package databaseConnection;

import businessLogic.ProjectInfo;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import userInterface.Project;

public class ProjectDB {

    private Connection cn;

    //connects with access using ucanaccess driver
    public ProjectDB() {
        try {
            cn = DriverManager.getConnection("jdbc:ucanaccess://emsDB.accdb");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    /*this method is for inserting project data to the database.
     first it checks whether the entered project id is already available in the DB or not.
     If there is, error message will be given.If not data will be added to the DB
     */
    public int addData(ProjectInfo pin) {
        try {
            String selectSt = "select * from Project where project_id=?";
            PreparedStatement p = cn.prepareStatement(selectSt);
            p.setInt(1, pin.getpID());
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Entered Project ID is already available.New Project was not added.");
                return 2;
            } else {
                String insertSt = "insert into Project(project_id,title,startDate,duration,client_id)values(?,?,?,?,?)";
                PreparedStatement ps = cn.prepareStatement(insertSt);

                ps.setInt(1, pin.getpID());
                ps.setString(2, pin.getTitle());
                ps.setDate(3, pin.getStartD());
                ps.setInt(4, pin.getDuration());
                ps.setInt(5, pin.getClientId());

                int result = ps.executeUpdate();
                ps.close();
                return result;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return 0;
        }
    }

    //this method is for retrieving data from db according to project id
    public ProjectInfo getData(int pID) {
        try {
            ProjectInfo e = null;
            String selectSt = "select * from Project where project_id=?";
            PreparedStatement ps = cn.prepareStatement(selectSt);
            ps.setInt(1, pID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int prID = rs.getInt("project_id");
                String title = rs.getString("title");
                Date stDate = rs.getDate("startDate");
                int dur = rs.getInt("duration");
                int clientID = rs.getInt("client_id");
                e = new ProjectInfo(pID, title, stDate, dur, clientID);
            }
            rs.close();
            ps.close();
            return e;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }

    /*this method is for deleting project records in the DB.
     first it checks whether entered project id is available in the DB or not.
     If not, error message will come. If there is the id in the DB, that record which 
     its project id matches with entered one,will be deleted.
     */
    public int deleteData(int pID) {
        try {
            String selectSt = "select * from Project where project_id=?";
            PreparedStatement p = cn.prepareStatement(selectSt);
            p.setInt(1, pID);
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                String deleteSt = "delete from Project where project_id=?";
                PreparedStatement ps = cn.prepareStatement(deleteSt);
                ps.setInt(1, pID);
                int result = ps.executeUpdate();
                ps.close();
                return result;
            } else {
                JOptionPane.showMessageDialog(null, "Entered Project ID is not available.Project was not Deleted.");
                return 2;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return 0;
        }
    }

    /*this method is for editing project records in the DB.
     first it checks whether entered project id is available in the DB or not.
     If not, error message will come. If there is the id in the DB, that record which 
     its project id matches with entered one,will be updated.
     */
    public int editData(ProjectInfo pr) {
        try {
            String selectSt = "select * from Project where project_id=?";
            PreparedStatement ps = cn.prepareStatement(selectSt);
            ps.setInt(1, pr.getpID());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String updateSt = "update Project set title=?,startDate=?,duration=?,client_id=? where project_id=?";
                PreparedStatement ps2 = cn.prepareStatement(updateSt);
                ps2.setString(1, pr.getTitle());
                ps2.setDate(2, pr.getStartD());
                ps2.setInt(3, pr.getDuration());
                ps2.setInt(4, pr.getClientId());
                ps2.setInt(5, pr.getpID());

                int result = ps2.executeUpdate();
                ps.close();
                ps2.close();
                return result;
            } else {
                JOptionPane.showMessageDialog(Project.btn_edit, "Entered Id is not available.Project was not updated.");
                return 2;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return 0;
        }
    }

    //this method is for retrieve all the project details from DB
    public ArrayList<ProjectInfo> getAllDataFromDB() {
        ArrayList<ProjectInfo> ar = new ArrayList<>();
        try {
            String selectSt = "select * from Project";
            PreparedStatement ps = cn.prepareStatement(selectSt);
            ResultSet rs = ps.executeQuery();
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
            ps.close();
            return ar;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }

    //this method is for load all the client ids to a combo box
    public void loadClientIDsFromDB() {
        try {
            String selectSt = "select * from Client";
            PreparedStatement ps = cn.prepareStatement(selectSt);
            ResultSet rs = ps.executeQuery();
            Vector v = new Vector();
            while (rs.next()) {
                v.add(rs.getInt("client_id"));
            }
            Project.combo_cID.setModel(new DefaultComboBoxModel(v));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }

    /*getNextID() method is for creating next project id. 
     so user does not need to enter the project id explicitly when add new project data.
     System automatically generates it.This avoids entering duplicate id
     */
    public long getNextID() {
        String st = "select MAX(project_id)From Project";
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

    //this method is for retrieving project details according to project title
    public ArrayList<ProjectInfo> getDataByName(String title) {
        ArrayList<ProjectInfo> ar = new ArrayList<>();
        try {
            String selectSt = "select * from Project where title like ?";
            PreparedStatement ps = cn.prepareStatement(selectSt);
            ps.setString(1, "%" + title + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int prID = rs.getInt("project_id");
                String tit = rs.getString("title");
                Date stDate = rs.getDate("startDate");
                int dur = rs.getInt("duration");
                int clientID = rs.getInt("client_id");
                ProjectInfo e = new ProjectInfo(prID, tit, stDate, dur, clientID);
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
