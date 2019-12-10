package databaseConnection;

import businessLogic.ClientInfo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import userInterface.Client;

public class ClientDB {

    private Connection cn;

    public ClientDB() {
        try {
            cn = DriverManager.getConnection("jdbc:ucanaccess://emsDB.accdb"); //connect with access database.ucanaccess driver is used here.
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public int addData(ClientInfo cin) {  //this method is for insering data to the database
        try {
            String selectSt = "select * from Client where client_id=?";
            PreparedStatement p = cn.prepareStatement(selectSt);
            p.setInt(1, cin.getcId());
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Entered Client ID is already available.New Client was not added.");
                return 2;
            } else {
                String insertSt = "insert into Client(client_id,client_name,add_no,add_street,add_city,nic,tele,email)values(?,?,?,?,?,?,?,?)";
                PreparedStatement ps = cn.prepareStatement(insertSt);

                ps.setInt(1, cin.getcId());
                ps.setString(2, cin.getcName());
                ps.setString(3, cin.getAddNo());
                ps.setString(4, cin.getAddStreet());
                ps.setString(5, cin.getAddCity());
                ps.setString(6, cin.getNic());
                ps.setString(7, cin.getTele());
                ps.setString(8, cin.getEmail());

                int result = ps.executeUpdate();
                ps.close();
                return result;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return 0;
        }
    }

    public ClientInfo getDataById(int cID) {  //this method is for retrieving data from database using client id
        try {
            ClientInfo e = null;
            String selectSt = "select * from Client where client_id=?";
            PreparedStatement ps = cn.prepareStatement(selectSt);
            ps.setInt(1, cID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int clID = rs.getInt("client_id");
                String cName = rs.getString("client_name");
                String addNo = rs.getString("add_no");
                String addStreet = rs.getString("add_street");
                String addCity = rs.getString("add_city");
                String nic = rs.getString("nic");
                String tele = rs.getString("tele");
                String email = rs.getString("email");
                e = new ClientInfo(clID, cName, addNo, addStreet, addCity, nic, tele, email);
            }
            rs.close();
            ps.close();
            return e;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }

    public int deleteData(int cID) {  //this method is for deleting client records in the database
        try {
            String selectSt = "select * from Client where client_id=?";
            PreparedStatement p = cn.prepareStatement(selectSt);
            p.setInt(1, cID);
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                String deleteSt = "delete from Client where client_id=?";
                PreparedStatement ps = cn.prepareStatement(deleteSt);
                ps.setInt(1, cID);
                int result = ps.executeUpdate();
                ps.close();
                return result;
            } else {
                JOptionPane.showMessageDialog(null, "Entered Client ID is not available.Client was not Deleted.");
                return 2;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return 0;
        }
    }

    public int editData(ClientInfo cl) {   //this method is for updating client records in the database
        try {
            String selectSt = "select * from Client where client_id=?";
            PreparedStatement ps = cn.prepareStatement(selectSt);
            ps.setInt(1, cl.getcId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String updateSt = "update Client set client_name=?,add_no=?,add_street=?,add_city=?,nic=?,tele=?,email=? where client_id=?";
                PreparedStatement ps2 = cn.prepareStatement(updateSt);
                ps2.setString(1, cl.getcName());
                ps2.setString(2, cl.getAddNo());
                ps2.setString(3, cl.getAddStreet());
                ps2.setString(4, cl.getAddCity());
                ps2.setString(5, cl.getNic());
                ps2.setString(6, cl.getTele());
                ps2.setString(7, cl.getEmail());
                ps2.setInt(8, cl.getcId());
                int result = ps2.executeUpdate();
                ps.close();
                ps2.close();
                return result;
            } else {
                JOptionPane.showMessageDialog(Client.btn_edit, "Entered Id is not available.Client not Edited.");
                return 2;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return 0;
        }
    }

    public ArrayList<ClientInfo> getAllDataFromDB() {   //this method is for retrieving all the client data form DB
        ArrayList<ClientInfo> ar = new ArrayList<>();
        try {
            String selectSt = "select * from Client";
            PreparedStatement ps = cn.prepareStatement(selectSt);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int clID = rs.getInt("client_id");
                String cName = rs.getString("client_name");
                String addNo = rs.getString("add_no");
                String addStreet = rs.getString("add_street");
                String addCity = rs.getString("add_city");
                String nic = rs.getString("nic");
                String tele = rs.getString("tele");
                String email = rs.getString("email");
                ClientInfo e = new ClientInfo(clID, cName, addNo, addStreet, addCity, nic, tele, email);
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

    /*getNextID() method is for creating next client id. 
     so user does not need to enter the client id explicitly.
     System automatically generates it.This avoids entering duplicate id*/
    public long getNextID() {
        String st = "select MAX(client_id)From Client";
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

    public ArrayList<ClientInfo> getDataByName(String name) { //this method is for retrieving data from database using client name
        ArrayList<ClientInfo> ar = new ArrayList<>();
        try {
            String selectSt = "select * from Client where client_name like ?"; //in here 'like' keyword is used. 
            PreparedStatement ps = cn.prepareStatement(selectSt);
            ps.setString(1, "%" + name + "%");  //pattern is used.
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int clID = rs.getInt("client_id");
                String cName = rs.getString("client_name");
                String addNo = rs.getString("add_no");
                String addStreet = rs.getString("add_street");
                String addCity = rs.getString("add_city");
                String nic = rs.getString("nic");
                String tele = rs.getString("tele");
                String email = rs.getString("email");
                ClientInfo e = new ClientInfo(clID, cName, addNo, addStreet, addCity, nic, tele, email);
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
