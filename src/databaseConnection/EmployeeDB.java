package databaseConnection;

import businessLogic.EmployeeInfo;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import userInterface.Employee;

public class EmployeeDB {

    private Connection cn;

//connect with Access using ucanaccess driver
    public EmployeeDB() {
        try {
            cn = DriverManager.getConnection("jdbc:ucanaccess://emsDB.accdb");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    /*this method is for inserting employee data to the database.
     first it checks whether the entered employee id is already available in the DB or not.
     If there is, error message will be given.If not data will be added to the DB
    */
    public int addData(EmployeeInfo ein) {
        try {
            String selectSt = "select * from employee where employee_id=?";
            PreparedStatement p = cn.prepareStatement(selectSt);
            p.setInt(1, ein.geteID());
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Entered Employee ID is already available.New Employee was not added.");
                return 2;
            } else {
                String insertSt = "insert into Employee(employee_id,e_first_name,e_last_name,"
                        + "nic,gender,dob,add_no,add_street,add_city,tele_home,tele_mobile,"
                        + "email,position,image,dept_id)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement ps = cn.prepareStatement(insertSt);

                String s1 = "img" + Employee.txt_employeeID.getText() + ".jpg";
                File image = new File("D:\\Assignments\\OOP\\employeeManagementSystem\\employeeImage", s1);
                FileInputStream fis = new FileInputStream(image);

                ps.setInt(1, ein.geteID());
                ps.setString(2, ein.getfName());
                ps.setString(3, ein.getlName());
                ps.setString(4, ein.getNic());
                ps.setString(5, ein.getGender());
                ps.setDate(6, ein.getDob());
                ps.setString(7, ein.getAddNo());
                ps.setString(8, ein.getAddStreet());
                ps.setString(9, ein.getAddCity());
                ps.setString(10, ein.getTeleHome());
                ps.setString(11, ein.getTeleMobile());
                ps.setString(12, ein.getEmail());
                ps.setString(13, ein.getPosition());
                ps.setBinaryStream(14, (InputStream) fis, (int) (image.length()));
                ps.setInt(15, ein.getDeptID());

                int result = ps.executeUpdate();
                ps.close();
                return result;
            }

        } catch (FileNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return 0;
        }
    }

    //this method is for retrieving employee data using employee id
    public EmployeeInfo getData(int eID) {
        try {
            EmployeeInfo emp = null;
            BufferedImage bufImg = null;
            String selectSt = "select * from employee where employee_id=?";
            PreparedStatement ps = cn.prepareStatement(selectSt);
            ps.setInt(1, eID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                InputStream in = rs.getBinaryStream("image");
                try {
                    bufImg = ImageIO.read(in);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(Employee.lb_image, ex.getMessage());
                }
                Employee.lb_image.setIcon(new ImageIcon(bufImg));

                int emID = rs.getInt("employee_id");
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
                emp = new EmployeeInfo(emID, eFname, eLname, nic, gender, dob, addNo, addStreet, addCity, teleHome, teleMobile, email, pos, dID);
            }
            rs.close();
            ps.close();
            return emp;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }

    /*this method is for deleting employee records in the DB.
     first it checks whether entered employee id is available in the DB or not.
     If not, error message will come. If there is the id in the DB, that record which 
     its employee id matches with entered one,will be deleted.
     */
    public int deleteData(int eID) {
        try {
            String selectSt = "select * from employee where employee_id=?";
            PreparedStatement p = cn.prepareStatement(selectSt);
            p.setInt(1, eID);
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                String deleteSt = "delete from Employee where employee_id=?";
                PreparedStatement ps = cn.prepareStatement(deleteSt);
                ps.setInt(1, eID);
                int result = ps.executeUpdate();
                ps.close();
                return result;
            } else {
                JOptionPane.showMessageDialog(null, "Entered Employee ID is not available.Employee was not Deleted.");
                return 2;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return 0;
        }
    }

    //this method is for retrieving all the employee records in the DB
    public ArrayList<EmployeeInfo> getAllDataFromDB() {
        ArrayList<EmployeeInfo> ar = new ArrayList<>();
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
            ps.close();
            return ar;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }

    /*this method is for editing employee records in the DB.
     first it checks whether entered employee id is available in the DB or not.
     If not, error message will come. If there is the id in the DB, that record which 
     its employee id matches with entered one,will be updated.
     */
    public int editData(EmployeeInfo em) {
        try {
            String selectSt = "select * from Employee where employee_id=?";
            PreparedStatement ps = cn.prepareStatement(selectSt);
            ps.setInt(1, em.geteID());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String updateSt = "update Employee set e_first_name=?,e_last_name=?,nic=?,gender=?,dob=?,add_no=?,add_street=?,add_city=?,tele_home=?,tele_mobile=?,email=?,position=?,image=?,dept_id=? where employee_id=?";
                PreparedStatement ps2 = cn.prepareStatement(updateSt);
                ps2.setString(1, em.getfName());
                ps2.setString(2, em.getlName());
                ps2.setString(3, em.getNic());
                ps2.setString(4, em.getGender());
                ps2.setDate(5, em.getDob());
                ps2.setString(6, em.getAddNo());
                ps2.setString(7, em.getAddStreet());
                ps2.setString(8, em.getAddCity());
                ps2.setString(9, em.getTeleHome());
                ps2.setString(10, em.getTeleMobile());
                ps2.setString(11, em.getEmail());
                ps2.setString(12, em.getPosition());

                String s1 = "img" + Employee.txt_employeeID.getText() + ".jpg";
                File image = new File("D:\\Assignments\\OOP\\employeeManagementSystem\\employeeImage", s1);
                FileInputStream fis;
                try {
                    fis = new FileInputStream(image);
                    ps2.setBinaryStream(13, (InputStream) fis, (int) (image.length()));
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(Employee.lb_image, ex.getMessage());
                }

                ps2.setInt(14, em.getDeptID());
                ps2.setInt(15, em.geteID());

                int result = ps2.executeUpdate();
                ps.close();
                ps2.close();
                return result;
            } else {
                JOptionPane.showMessageDialog(Employee.btn_edit, "Entered Id is not available.Employee Data were not edited.");
                return 2;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return 0;
        }
    }

    //this method is for retrieving employee image according to employee id
    public void getImage(int eID) {
        BufferedImage bufImg = null;
        try {
            String selectSt = "select * from employee where employee_id=?";
            PreparedStatement ps = cn.prepareStatement(selectSt);
            ps.setInt(1, eID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                InputStream in = rs.getBinaryStream("image");
                try {
                    bufImg = ImageIO.read(in);
                } catch (IOException e) {
                }
                Employee.lb_image.setIcon(new ImageIcon(bufImg));
            }
        } catch (SQLException e) {
        }
    }


    /*getNextID() method is for creating next employee id. 
     so user does not need to enter the employee id explicitly when add new employee data.
     System automatically generates it.This avoids entering duplicate id
    */
    public long getNextID() {
        String st = "select MAX(employee_id)From Employee";
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

    //this method is for retriveing employee data accroding to employee name
    public ArrayList<EmployeeInfo> getDataByName(String fName, String lName) {
        ArrayList<EmployeeInfo> ar = new ArrayList<>();
        PreparedStatement ps = null;
        try {
            if (!lName.equals("")) {
                String selectSt = "select * from Employee where e_first_name like ? or e_last_name like ?";
                ps = cn.prepareStatement(selectSt);
                ps.setString(1, "%" + fName + "%");
                ps.setString(2, "%" + lName + "%");
            } else if (lName.equals("")) {
                String selectSt = "select * from Employee where e_first_name like ?";
                ps = cn.prepareStatement(selectSt);
                ps.setString(1, "%" + fName + "%");
            }

            ResultSet rs = ps.executeQuery();
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
            ps.close();
            return ar;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }
}
