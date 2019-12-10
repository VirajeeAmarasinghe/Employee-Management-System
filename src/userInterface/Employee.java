package userInterface;

import businessLogic.DepartmentInfo;
import businessLogic.EmployeeInfo;
import databaseConnection.DepartmentDB;
import databaseConnection.EmployeeDB;
import java.awt.print.PrinterException;
import java.io.File;
import java.sql.Date;
import java.text.MessageFormat;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Employee extends javax.swing.JFrame {

    //this variable is for storing path of folder which has employee images
    public static String path = "D:\\Assignments\\OOP\\employeeManagementSystem\\employeeImage";
    private ArrayList<EmployeeInfo> arrayListEmployee;
    private DefaultTableModel dtm;
    private EmployeeDB edb;
    private DepartmentDB depDB;
    private ArrayList<DepartmentInfo> arrayDept;

    public Employee() {
        initComponents();
        setLocationRelativeTo(null);

        edb = new EmployeeDB();
        arrayListEmployee = new ArrayList<>();

        dtm = new DefaultTableModel();
        tbl_employee.setModel(dtm);
        dtm.addColumn("Employee ID");
        dtm.addColumn("Employee First Name");
        dtm.addColumn("Employee Last Name");
        dtm.addColumn("NIC");
        dtm.addColumn("Gender");
        dtm.addColumn("Date of Birth");
        dtm.addColumn("Address-No");
        dtm.addColumn("Address-Street");
        dtm.addColumn("Address-City");
        dtm.addColumn("Telephone-Home");
        dtm.addColumn("Telephone-Mobile");
        dtm.addColumn("E-mail");
        dtm.addColumn("Position");
        dtm.addColumn("Department ID");

        depDB = new DepartmentDB();
        txt_employeeID.setText(edb.getNextID() + "");
        txt_fname.grabFocus();
        rbtn_male.setSelected(true);

        //loading department ids to the combo box
        arrayDept = depDB.getAllData();
        for (DepartmentInfo d : arrayDept) {
            combo_dept.addItem(d.getDeptID());
        }
        setAccessPrivileges();
    }

    //this method is for establishing access privileges
    private void setAccessPrivileges() {
        if (UserLevel.userLevel.equals("normal user")) {
            btn_add.setEnabled(false);
            btn_del.setEnabled(false);
            btn_edit.setEnabled(false);
            btn_browse.setEnabled(false);
        }
    }

    //this method is for getting system date and time
    private String setDate() {
        String d = new java.util.Date().toString();
        String day = d.split(" ")[2];
        String month = d.split(" ")[1];
        String year = d.split(" ")[5];
        String date = day + "/" + month + "/" + year;
        String time = d.split(" ")[3];
        return date + ":" + time;
    }

    //this method is for validating the form
    private boolean isValidForm() {
        Validator v = new Validator();
        if (!v.isPresent(txt_employeeID, "Employee ID")) {
            return false;
        }
        if (!v.isPresent(txt_fname, "Employee First Name")) {
            return false;
        }
        if (!v.isPresent(txt_lname, "Employee Last Name")) {
            return false;
        }
        if (!v.isPresent(txt_nic, "NIC")) {
            return false;
        }
        if (!v.isSelectedGender(rbtn_male, rbtn_female, "Gender")) {
            return false;
        }
        if (!v.isPresent(txt_dob, "Date of Birth")) {
            return false;
        }
        if (!v.isPresent(txt_addStreet, "Address-Street")) {  //Filling Address-No field is not compulsary
            return false;
        }
        if (!v.isPresent(txt_addCity, "Address-City")) {
            return false;
        }
        if (!v.isPresent(txt_teleHome, "Telephone No(Home)")) {
            return false;
        }
        if (!v.isPresent(txt_email, "E-mail")) {
            return false;
        }
        if (!v.hasImage(lb_image)) {
            return false;
        }
        if (!v.isValidNic(txt_nic, "NIC No")) {
            return false;
        }
        if (!v.isDate(txt_dob, "Date of Birth")) {
            return false;
        }
        if (!v.isValidTeleNo(txt_teleHome, "Telephone No(Home)")) {
            return false;
        }
        if (!"".equals(txt_mobile.getText())) {
            if (!v.isValidTeleNo(txt_mobile, "Telephone No(Mobile)")) {
                return false;
            }
        }
        if (!v.isInteger(txt_employeeID, "Employee ID")) {
            return false;
        }
        return true;
    }

    //this method is for refreshing the window
    private void clearFields() {
        txt_fname.setText("");
        txt_lname.setText("");
        txt_nic.setText("");
        rbtn_male.setSelected(true);
        txt_dob.setText("");
        txt_addNo.setText("");
        txt_addStreet.setText("");
        txt_addCity.setText("");
        txt_teleHome.setText("");
        txt_mobile.setText("");
        txt_email.setText("");
        combo_pos.setSelectedIndex(0);
        lb_image.setIcon(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        pnl_main = new javax.swing.JPanel();
        pnl_second = new javax.swing.JPanel();
        pnl_third = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_addNo = new javax.swing.JTextField();
        txt_addStreet = new javax.swing.JTextField();
        txt_addCity = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txt_employeeID = new javax.swing.JTextField();
        txt_fname = new javax.swing.JTextField();
        txt_lname = new javax.swing.JTextField();
        txt_nic = new javax.swing.JTextField();
        rbtn_male = new javax.swing.JRadioButton();
        rbtn_female = new javax.swing.JRadioButton();
        txt_dob = new javax.swing.JTextField();
        txt_teleHome = new javax.swing.JTextField();
        txt_mobile = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        combo_pos = new javax.swing.JComboBox();
        lb_image = new javax.swing.JLabel();
        btn_browse = new javax.swing.JButton();
        btn_add = new javax.swing.JButton();
        btn_findID = new javax.swing.JButton();
        btn_del = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        btn_display = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        btn_close = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        scrlPneEmployee = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_employee = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        btn_findName = new javax.swing.JButton();
        combo_dept = new javax.swing.JComboBox();
        jLabel18 = new javax.swing.JLabel();
        btn_print = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        pnl_main.setBackground(new java.awt.Color(0, 153, 255));
        pnl_main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_second.setBackground(new java.awt.Color(255, 255, 255));
        pnl_second.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_third.setBackground(new java.awt.Color(0, 153, 255));
        pnl_third.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Employee ID:");
        pnl_third.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("First Name:");
        pnl_third.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Last Name:");
        pnl_third.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("NIC No:");
        pnl_third.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Gender:");
        pnl_third.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Date of Birth:");
        pnl_third.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("No:");
        pnl_third.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Street:");
        pnl_third.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("City:");
        pnl_third.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, -1));

        txt_addNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_addNoKeyPressed(evt);
            }
        });
        pnl_third.add(txt_addNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 180, -1));

        txt_addStreet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_addStreetKeyPressed(evt);
            }
        });
        pnl_third.add(txt_addStreet, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 180, -1));

        txt_addCity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_addCityKeyPressed(evt);
            }
        });
        pnl_third.add(txt_addCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, 180, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Address:");
        pnl_third.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        jLabel8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        pnl_third.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 260, 100));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Telephone No(Home):");
        pnl_third.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Mobile No:");
        pnl_third.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("E-mail: ");
        pnl_third.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Position:");
        pnl_third.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, -1, -1));

        txt_employeeID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_employeeIDKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_employeeIDKeyTyped(evt);
            }
        });
        pnl_third.add(txt_employeeID, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 180, -1));

        txt_fname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_fnameKeyPressed(evt);
            }
        });
        pnl_third.add(txt_fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 180, -1));

        txt_lname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_lnameKeyPressed(evt);
            }
        });
        pnl_third.add(txt_lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 180, -1));

        txt_nic.setToolTipText("NIC Format:XXXXXXXXXV");
        txt_nic.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_nicKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nicKeyTyped(evt);
            }
        });
        pnl_third.add(txt_nic, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 180, -1));

        rbtn_male.setBackground(new java.awt.Color(0, 153, 255));
        buttonGroup1.add(rbtn_male);
        rbtn_male.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rbtn_male.setForeground(new java.awt.Color(255, 255, 255));
        rbtn_male.setText("Male");
        pnl_third.add(rbtn_male, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, -1, -1));

        rbtn_female.setBackground(new java.awt.Color(0, 153, 255));
        buttonGroup1.add(rbtn_female);
        rbtn_female.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rbtn_female.setForeground(new java.awt.Color(255, 255, 255));
        rbtn_female.setText("Female");
        pnl_third.add(rbtn_female, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, -1, -1));

        txt_dob.setToolTipText("Date format:YYYY-MM-DD");
        txt_dob.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_dobKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_dobKeyTyped(evt);
            }
        });
        pnl_third.add(txt_dob, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 180, -1));

        txt_teleHome.setToolTipText("Tele No format:XXX-XXXXXXX");
        txt_teleHome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_teleHomeKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_teleHomeKeyTyped(evt);
            }
        });
        pnl_third.add(txt_teleHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, 180, -1));

        txt_mobile.setToolTipText("Mobile No format: XXX-XXXXXXX");
        txt_mobile.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_mobileKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_mobileKeyTyped(evt);
            }
        });
        pnl_third.add(txt_mobile, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 380, 180, -1));

        txt_email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_emailKeyPressed(evt);
            }
        });
        pnl_third.add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 410, 180, -1));

        combo_pos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Manager", "HR Manager", "Accountant", "IS Coordinator", "Assistant Manager", "Project Manager", "Software Developer", "Tester", "Marketing Executive", "Network Administrator", "Office Assistant", " " }));
        pnl_third.add(combo_pos, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 440, 180, -1));

        lb_image.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        pnl_third.add(lb_image, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, 110, 120));

        btn_browse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/user.gif"))); // NOI18N
        btn_browse.setMnemonic('B');
        btn_browse.setText("Browse");
        btn_browse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_browse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_browseActionPerformed(evt);
            }
        });
        pnl_third.add(btn_browse, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 160, -1, -1));

        btn_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/floppy_disk_red.png"))); // NOI18N
        btn_add.setMnemonic('A');
        btn_add.setText("Add");
        btn_add.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });
        pnl_third.add(btn_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 210, 90, -1));

        btn_findID.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/find-icon.png"))); // NOI18N
        btn_findID.setMnemonic('I');
        btn_findID.setText("ID");
        btn_findID.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_findID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_findIDActionPerformed(evt);
            }
        });
        pnl_third.add(btn_findID, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 360, 90, -1));

        btn_del.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/database_del.png"))); // NOI18N
        btn_del.setMnemonic('D');
        btn_del.setText("Delete");
        btn_del.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_del.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delActionPerformed(evt);
            }
        });
        pnl_third.add(btn_del, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 250, 90, -1));

        btn_edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/edit_but.gif"))); // NOI18N
        btn_edit.setMnemonic('E');
        btn_edit.setText("Edit");
        btn_edit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });
        pnl_third.add(btn_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 290, 90, -1));

        btn_display.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/display.jpg"))); // NOI18N
        btn_display.setMnemonic('P');
        btn_display.setText("Display");
        btn_display.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_display.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_displayActionPerformed(evt);
            }
        });
        pnl_third.add(btn_display, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 440, -1, 30));

        btn_clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/clear.png"))); // NOI18N
        btn_clear.setMnemonic('C');
        btn_clear.setText("Clear");
        btn_clear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });
        pnl_third.add(btn_clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 480, 90, -1));

        btn_close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/exit.png"))); // NOI18N
        btn_close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_closeActionPerformed(evt);
            }
        });
        pnl_third.add(btn_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, 30, 30));

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Image");
        pnl_third.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 140, -1, -1));

        tbl_employee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_employee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_employeeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_employee);

        scrlPneEmployee.setViewportView(jScrollPane1);

        pnl_third.add(scrlPneEmployee, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 530, 510, 90));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Department:");
        pnl_third.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, -1, -1));

        btn_findName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/find-icon.png"))); // NOI18N
        btn_findName.setMnemonic('N');
        btn_findName.setText("Name");
        btn_findName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_findNameActionPerformed(evt);
            }
        });
        pnl_third.add(btn_findName, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 390, 90, -1));

        pnl_third.add(combo_dept, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 470, 180, -1));

        jLabel18.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Find", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        pnl_third.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 340, 120, 90));

        btn_print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/printer_red (1).png"))); // NOI18N
        btn_print.setMnemonic('R');
        btn_print.setText("Print");
        btn_print.setToolTipText("");
        btn_print.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_printActionPerformed(evt);
            }
        });
        pnl_third.add(btn_print, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, -1, -1));

        pnl_second.add(pnl_third, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 550, 630));

        pnl_main.add(pnl_second, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 570, 650));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_main, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnl_main, javax.swing.GroupLayout.PREFERRED_SIZE, 669, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_browseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_browseActionPerformed
        JFileChooser fc = new JFileChooser();
        int i = fc.showOpenDialog(this);
        if (i == 0) {
            File f = fc.getSelectedFile();
            path = f.getAbsolutePath();
            lb_image.setIcon(new ImageIcon(path));
        }
    }//GEN-LAST:event_btn_browseActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        if (isValidForm()) {
            String gender;
            if (rbtn_female.isSelected()) {
                gender = "Female";
            } else if (rbtn_male.isSelected()) {
                gender = "Male";
            } else {
                gender = "";
            }
            EmployeeInfo d = new EmployeeInfo(Integer.parseInt(txt_employeeID.getText()), txt_fname.getText(), txt_lname.getText(), txt_nic.getText(), gender, Date.valueOf(txt_dob.getText()), txt_addNo.getText(), txt_addStreet.getText(), txt_addCity.getText(), txt_teleHome.getText(), txt_mobile.getText(), txt_email.getText(), String.valueOf(combo_pos.getSelectedItem()), Integer.parseInt(combo_dept.getSelectedItem().toString()));
            int result = edb.addData(d);
            if (result == 1) {
                JOptionPane.showMessageDialog(btn_add, "New Employee added successfully");
                clearFields();
                txt_employeeID.setText(edb.getNextID() + "");
                txt_fname.grabFocus();
            } else if (result == 0) {
                JOptionPane.showMessageDialog(btn_add, "Some Error Occurred.New Employee was not added");
            }
        }
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_displayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_displayActionPerformed
        dtm.setRowCount(0);
        ArrayList<EmployeeInfo> ar = edb.getAllDataFromDB();
        if (ar != null) {
            for (EmployeeInfo em : ar) {
                int eId = em.geteID();
                String fName = em.getfName();
                String lName = em.getlName();
                String nic = em.getNic();
                String gender = em.getGender();
                Date dob = em.getDob();
                String addNo = em.getAddNo();
                String addStreet = em.getAddStreet();
                String addCity = em.getAddCity();
                String teleHome = em.getTeleHome();
                String teleMobile = em.getTeleMobile();
                String email = em.getEmail();
                String pos = em.getPosition();
                int dID = em.getDeptID();
                dtm.addRow(new Object[]{eId, fName, lName, nic, gender, dob, addNo, addStreet, addCity, teleHome, teleMobile, email, pos, dID});
            }
        }
    }//GEN-LAST:event_btn_displayActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        if (isValidForm()) {
            EmployeeInfo eminfo = null;
            String gender = "";
            int eID = Integer.parseInt(txt_employeeID.getText());
            String fName = txt_fname.getText();
            String lName = txt_lname.getText();
            String nic = txt_nic.getText();
            if (rbtn_male.isSelected()) {
                gender = "Male";
            } else if (rbtn_female.isSelected()) {
                gender = "Female";
            }
            Date dob = Date.valueOf(txt_dob.getText());
            String addNo = txt_addNo.getText();
            String addStreet = txt_addStreet.getText();
            String addCity = txt_addCity.getText();
            String teleHome = txt_teleHome.getText();
            String teleMobile = txt_mobile.getText();
            String mail = txt_email.getText();
            String pos = String.valueOf(combo_pos.getSelectedItem());
            int dID = Integer.parseInt(combo_dept.getSelectedItem().toString());

            eminfo = new EmployeeInfo(eID, fName, lName, nic, gender, dob, addNo, addStreet, addCity, teleHome, teleMobile, mail, pos, dID);

            int result = edb.editData(eminfo);
            if (result == 1) {
                JOptionPane.showMessageDialog(btn_edit, "Employee edited successfully");
                clearFields();
                txt_employeeID.setText(edb.getNextID() + "");
            } else if (result == 0) {
                JOptionPane.showMessageDialog(btn_edit, "Employee not edited.Some Error Occurred.");
            }
        }
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_findIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_findIDActionPerformed
        String input = JOptionPane.showInputDialog("Enter Valid Employee ID");
        if (input != null) {
            int eID = Integer.parseInt(input);
            EmployeeInfo e = edb.getData(eID);
            if (e != null) {
                txt_employeeID.setText(e.geteID() + "");
                txt_fname.setText(e.getfName());
                txt_lname.setText(e.getlName());
                txt_nic.setText(e.getNic());
                if (e.getGender().equalsIgnoreCase("male")) {
                    rbtn_male.setSelected(true);
                } else if (e.getGender().equalsIgnoreCase("female")) {
                    rbtn_female.setSelected(true);
                }
                txt_dob.setText(e.getDob() + "");
                txt_addNo.setText(e.getAddNo());
                txt_addStreet.setText(e.getAddStreet());
                txt_addCity.setText(e.getAddCity());
                txt_teleHome.setText(e.getTeleHome());
                txt_mobile.setText(e.getTeleMobile());
                txt_email.setText(e.getEmail());
                combo_pos.setSelectedItem(e.getPosition());
                combo_dept.setSelectedItem(e.getDeptID());
            } else {
                JOptionPane.showMessageDialog(btn_findID, "Entered Number is not available");
            }
        }
    }//GEN-LAST:event_btn_findIDActionPerformed

    private void btn_delActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delActionPerformed
        String input = JOptionPane.showInputDialog("Enter Valid Employee ID");
        if (input != null) {
            int inputYesNo = JOptionPane.showConfirmDialog(btn_del, "Are U Sure U want to delete this Record?");
            if (inputYesNo == 0) {
                int eID = Integer.parseInt(input);
                int result = edb.deleteData(eID);
                if (result == 1) {
                    JOptionPane.showMessageDialog(btn_del, "Employee deleted successfully");
                    clearFields();
                    txt_employeeID.setText(edb.getNextID() + "");
                } else if (result == 0) {
                    JOptionPane.showMessageDialog(btn_del, "Employee not deleted.Some Error Occurred");
                }
            }
        }
    }//GEN-LAST:event_btn_delActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        clearFields();
        txt_employeeID.setText(edb.getNextID() + "");
        int i = tbl_employee.getRowCount();
        for (int j = 0; j < i; j++) { //removing table rows one by one
            dtm.removeRow(0);
        }
        txt_fname.grabFocus();
    }//GEN-LAST:event_btn_clearActionPerformed

    private void btn_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_closeActionPerformed
        this.dispose();
        Home h = new Home();
        h.setVisible(true);
    }//GEN-LAST:event_btn_closeActionPerformed

    private void tbl_employeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_employeeMouseClicked
        int i = tbl_employee.getSelectedRow();
        int id = (int) dtm.getValueAt(i, 0);
        String fName = (String) dtm.getValueAt(i, 1);
        String lName = (String) dtm.getValueAt(i, 2);
        String nic = (String) dtm.getValueAt(i, 3);
        String gender = (String) dtm.getValueAt(i, 4);
        Date dob = (Date) dtm.getValueAt(i, 5);
        String addNo = (String) dtm.getValueAt(i, 6);
        String addStreet = (String) dtm.getValueAt(i, 7);
        String addCity = (String) dtm.getValueAt(i, 8);
        String teleHome = (String) dtm.getValueAt(i, 9);
        String teleMobile = (String) dtm.getValueAt(i, 10);
        String mail = (String) dtm.getValueAt(i, 11);
        String pos = (String) dtm.getValueAt(i, 12);
        int dID = Integer.valueOf(dtm.getValueAt(i, 13).toString());

        txt_employeeID.setText(id + "");
        txt_fname.setText(fName);
        txt_lname.setText(lName);
        txt_nic.setText(nic);
        if (gender.equalsIgnoreCase("male")) {
            rbtn_male.setSelected(true);
        } else if (gender.equalsIgnoreCase("female")) {
            rbtn_female.setSelected(true);
        }
        txt_dob.setText(dob + "");
        txt_addNo.setText(addNo);
        txt_addStreet.setText(addStreet);
        txt_addCity.setText(addCity);

        txt_teleHome.setText(teleHome);
        txt_mobile.setText(teleMobile);
        txt_email.setText(mail);
        combo_pos.setSelectedItem(pos);
        combo_dept.setSelectedItem(dID);

        edb.getImage(id);
    }//GEN-LAST:event_tbl_employeeMouseClicked

    private void txt_employeeIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_employeeIDKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_employeeIDKeyTyped

    private void txt_nicKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nicKeyTyped
        if ((!Character.isDigit(evt.getKeyChar()) && !(evt.getKeyChar() == 'v')) && !(evt.getKeyChar() == 'V')) {
            evt.consume();
        }
        if (txt_nic.getText().length() > 9) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_nicKeyTyped

    private void txt_dobKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dobKeyTyped
        if (!Character.isDigit(evt.getKeyChar()) && !(evt.getKeyChar() == '-')) {
            evt.consume();
        }
        if (txt_dob.getText().length() > 9) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_dobKeyTyped

    private void txt_teleHomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_teleHomeKeyTyped
        if (!Character.isDigit(evt.getKeyChar()) && !(evt.getKeyChar() == '-')) {
            evt.consume();
        }
        if (txt_teleHome.getText().length() > 10) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_teleHomeKeyTyped

    private void txt_mobileKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_mobileKeyTyped
        if (!Character.isDigit(evt.getKeyChar()) && !(evt.getKeyChar() == '-')) {
            evt.consume();
        }
        if (txt_mobile.getText().length() > 10) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_mobileKeyTyped

    private void txt_employeeIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_employeeIDKeyPressed
        if (evt.getKeyCode() == 10) {
            txt_fname.grabFocus();
        }
        if (evt.getKeyCode() == 40) {
            txt_fname.grabFocus();
        }
    }//GEN-LAST:event_txt_employeeIDKeyPressed

    private void txt_fnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_fnameKeyPressed
        if (evt.getKeyCode() == 10) {
            txt_lname.grabFocus();
        }
        if (evt.getKeyCode() == 40) {
            txt_lname.grabFocus();
        }
        if (evt.getKeyCode() == 38) {
            txt_employeeID.grabFocus();
        }
    }//GEN-LAST:event_txt_fnameKeyPressed

    private void txt_lnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_lnameKeyPressed
        if (evt.getKeyCode() == 10) {
            txt_nic.grabFocus();
        }
        if (evt.getKeyCode() == 40) {
            txt_nic.grabFocus();
        }
        if (evt.getKeyCode() == 38) {
            txt_fname.grabFocus();
        }
    }//GEN-LAST:event_txt_lnameKeyPressed

    private void txt_nicKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nicKeyPressed
        if (evt.getKeyCode() == 10) {
            txt_dob.grabFocus();
        }
        if (evt.getKeyCode() == 40) {
            txt_dob.grabFocus();
        }
        if (evt.getKeyCode() == 38) {
            txt_lname.grabFocus();
        }
    }//GEN-LAST:event_txt_nicKeyPressed

    private void txt_dobKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dobKeyPressed
        if (evt.getKeyCode() == 10) {
            txt_addNo.grabFocus();
        }
        if (evt.getKeyCode() == 40) {
            txt_addNo.grabFocus();
        }
        if (evt.getKeyCode() == 38) {
            txt_nic.grabFocus();
        }
    }//GEN-LAST:event_txt_dobKeyPressed

    private void txt_addNoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_addNoKeyPressed
        if (evt.getKeyCode() == 10) {
            txt_addStreet.grabFocus();
        }
        if (evt.getKeyCode() == 40) {
            txt_addStreet.grabFocus();
        }
        if (evt.getKeyCode() == 38) {
            txt_dob.grabFocus();
        }
    }//GEN-LAST:event_txt_addNoKeyPressed

    private void txt_addStreetKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_addStreetKeyPressed
        if (evt.getKeyCode() == 10) {
            txt_addCity.grabFocus();
        }
        if (evt.getKeyCode() == 40) {
            txt_addCity.grabFocus();
        }
        if (evt.getKeyCode() == 38) {
            txt_addNo.grabFocus();
        }
    }//GEN-LAST:event_txt_addStreetKeyPressed

    private void txt_addCityKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_addCityKeyPressed
        if (evt.getKeyCode() == 10) {
            txt_teleHome.grabFocus();
        }
        if (evt.getKeyCode() == 40) {
            txt_teleHome.grabFocus();
        }
        if (evt.getKeyCode() == 38) {
            txt_addStreet.grabFocus();
        }
    }//GEN-LAST:event_txt_addCityKeyPressed

    private void txt_teleHomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_teleHomeKeyPressed
        if (evt.getKeyCode() == 10) {
            txt_mobile.grabFocus();
        }
        if (evt.getKeyCode() == 40) {
            txt_mobile.grabFocus();
        }
        if (evt.getKeyCode() == 38) {
            txt_addCity.grabFocus();
        }
    }//GEN-LAST:event_txt_teleHomeKeyPressed

    private void txt_mobileKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_mobileKeyPressed
        if (evt.getKeyCode() == 10) {
            txt_email.grabFocus();
        }
        if (evt.getKeyCode() == 40) {
            txt_email.grabFocus();
        }
        if (evt.getKeyCode() == 38) {
            txt_teleHome.grabFocus();
        }
    }//GEN-LAST:event_txt_mobileKeyPressed

    private void txt_emailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_emailKeyPressed
        if (evt.getKeyCode() == 38) {
            txt_mobile.grabFocus();
        }
    }//GEN-LAST:event_txt_emailKeyPressed

    private void btn_findNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_findNameActionPerformed
        String input = JOptionPane.showInputDialog("Enter Valid Employee Name");
        if (input != null) {
            String firstName = "";
            String lastName = "";
            if (input.contains(" ")) {
                firstName = input.split(" ")[0];
                lastName = input.split(" ")[1];
            } else {
                firstName = input;
                lastName = "";
            }
            dtm.setRowCount(0);
            ArrayList<EmployeeInfo> ar = edb.getDataByName(firstName, lastName);
            if (ar != null) {
                for (EmployeeInfo em : ar) {
                    int eId = em.geteID();
                    String fName = em.getfName();
                    String lName = em.getlName();
                    String nic = em.getNic();
                    String gender = em.getGender();
                    Date dob = em.getDob();
                    String addNo = em.getAddNo();
                    String addStreet = em.getAddStreet();
                    String addCity = em.getAddCity();
                    String teleHome = em.getTeleHome();
                    String teleMobile = em.getTeleMobile();
                    String email = em.getEmail();
                    String pos = em.getPosition();
                    int dID = em.getDeptID();
                    dtm.addRow(new Object[]{eId, fName, lName, nic, gender, dob, addNo, addStreet, addCity, teleHome, teleMobile, email, pos, dID});
                }
            }
        }

    }//GEN-LAST:event_btn_findNameActionPerformed

    private void btn_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printActionPerformed
        MessageFormat header = new MessageFormat("Details of all the Employees");
        MessageFormat footer = new MessageFormat("Page{0,number,integer}" + "                       " + setDate());
        try {
            tbl_employee.print(JTable.PrintMode.NORMAL, header, footer);
        } catch (PrinterException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btn_printActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Employee().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_browse;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_close;
    private javax.swing.JButton btn_del;
    private javax.swing.JButton btn_display;
    public static javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_findID;
    private javax.swing.JButton btn_findName;
    private javax.swing.JButton btn_print;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox combo_dept;
    private javax.swing.JComboBox combo_pos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel lb_image;
    private javax.swing.JPanel pnl_main;
    private javax.swing.JPanel pnl_second;
    private javax.swing.JPanel pnl_third;
    private javax.swing.JRadioButton rbtn_female;
    private javax.swing.JRadioButton rbtn_male;
    private javax.swing.JScrollPane scrlPneEmployee;
    private javax.swing.JTable tbl_employee;
    private javax.swing.JTextField txt_addCity;
    private javax.swing.JTextField txt_addNo;
    private javax.swing.JTextField txt_addStreet;
    private javax.swing.JTextField txt_dob;
    private javax.swing.JTextField txt_email;
    public static javax.swing.JTextField txt_employeeID;
    private javax.swing.JTextField txt_fname;
    private javax.swing.JTextField txt_lname;
    private javax.swing.JTextField txt_mobile;
    private javax.swing.JTextField txt_nic;
    private javax.swing.JTextField txt_teleHome;
    // End of variables declaration//GEN-END:variables
}
