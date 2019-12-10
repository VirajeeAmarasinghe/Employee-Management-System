package databaseConnection;

import businessLogic.ClientInfo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ClientReportDB {

    private Connection cn;

    //connect with DB using ucanaccess driver
    public ClientReportDB() {
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
    private void getData(ResultSet rs, ArrayList<ClientInfo> ar) {
        try {
            while (rs.next()) {
                int clID = rs.getInt("client_id");
                String clName = rs.getString("client_name");
                String addNo = rs.getString("add_no");
                String addStreet = rs.getString("add_street");
                String addCity = rs.getString("add_city");
                String nic = rs.getString("nic");
                String tele = rs.getString("tele");
                String email = rs.getString("email");
                ClientInfo e = new ClientInfo(clID, clName, addNo, addStreet, addCity, nic, tele, email);
                ar.add(e);
            }
            rs.close();
        } catch (SQLException e) {
        }
    }

    //this method is for retrieving client data from DB according to city
    public ArrayList<ClientInfo> getAllDataFromDBAccordingToCity(String city) {
        ArrayList<ClientInfo> ar = new ArrayList<>();
        try {
            String selectSt = "select * from Client where add_city like ?";
            PreparedStatement ps = cn.prepareStatement(selectSt);
            ps.setString(1, "%" + city + "%");
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

    //this method is for retrieving client data from DB according to project
    public ArrayList<ClientInfo> getAllDataFromDBAccordingToProject(String project) {
        ArrayList<ClientInfo> ar = new ArrayList<>();
        try {
            String selectSt = "select * from Client where client_id in(select client_id from Project where title=?)";
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

}
