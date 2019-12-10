package databaseConnection;

import businessLogic.LoginInfo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import userInterface.ChangePassword;
import userInterface.NewUserRegistration;

public class LoginDB {

    private Connection con;

    //connect Access using ucanaccess driver
    public LoginDB() {
        try {
            con = DriverManager.getConnection("jdbc:ucanaccess://emsDB.accdb");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    //this method is for retrieving login details according to user id
    public LoginInfo getLogin(String userID) {
        LoginInfo l = null;

        try {
            String select = "select * from Login where user_id=?";
            PreparedStatement ps = con.prepareStatement(select);
            ps.setString(1, userID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String password = rs.getString("password");
                String userlevel = rs.getString("user_level");
                l = new LoginInfo(userID, password, userlevel);
            }
            rs.close();
            ps.close();
            return l;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;

        }
    }

    /*
     this method is for updating passwords.
     first it checks whether eneterd user id is available in the database or not.
     If available updating is done. If not error message will come.
     */
    public int updatePassword(LoginInfo d) {
        try {
            String selectSt = "select * from Login where user_id=?";
            PreparedStatement ps = con.prepareStatement(selectSt);
            ps.setString(1, d.getUsername());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String updateSt = "update Login set password=? where user_id=?";
                PreparedStatement ps2 = con.prepareStatement(updateSt);
                ps2.setString(1, d.getPassword());
                ps2.setString(2, d.getUsername());
                int result = ps2.executeUpdate();
                ps.close();
                ps2.close();
                return result;
            } else {
                JOptionPane.showMessageDialog(ChangePassword.btn_ok, "Entered UserId is not available.Password is not updated.");
                return 2;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return 0;
        }
    }

    /*
     this method is for deleting user.
     first it checks whether eneterd user id is available in the database or not.
     If available deleting is done. If not error message will come.
     */
    public int deleteUser(String userID) {
        try {
            String select = "select * from Login where user_id=?";
            PreparedStatement p = con.prepareStatement(select);
            p.setString(1, userID);
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                String deleteSt = "delete * from Login where user_id=?";
                PreparedStatement ps = con.prepareStatement(deleteSt);
                ps.setString(1, userID);
                int result = ps.executeUpdate();
                ps.close();
                return result;
            } else {
                JOptionPane.showMessageDialog(null, "Entered User ID is not available.User was not Deleted.");
                return 2;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return 0;
        }
    }

    /*
     this method is for inserting new user login details to the Database.
     first it checks whether eneterd user id is available in the database or not.
     If available error message will come. If not insertion is done.
     */
    public int addLoginData(LoginInfo lin) {
        try {
            String select = "select * from Login where user_id=?";
            PreparedStatement p = con.prepareStatement(select);
            p.setString(1, lin.getUsername());
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Entered User ID is already available.New User was not added.");
                return 2;
            } else {
                String insertSt = "insert into Login(user_id,password,user_level)values(?,?,?)";
                PreparedStatement ps = con.prepareStatement(insertSt);

                ps.setString(1, lin.getUsername());
                ps.setString(2, lin.getPassword());
                ps.setString(3, lin.getUserLevel());

                int result = ps.executeUpdate();
                ps.close();
                return result;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(NewUserRegistration.btn_save, e.getMessage());
            return 0;
        }
    }
}
