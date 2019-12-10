package userInterface;

import java.sql.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.text.JTextComponent;

public class Validator {

    public boolean isPresent(JTextComponent c, String FieldName) {  //this method is for mandatory field validation
        if (c.getText().length() == 0) {
            JOptionPane.showMessageDialog(c, FieldName + " should not be empty!!!!");
            c.requestFocusInWindow();
            return false;
        }
        return true;
    }

    public boolean hasImage(JLabel lb) {  //this method is for checking image is selected or not
        if (lb.getIcon() == null) {
            JOptionPane.showMessageDialog(lb, "Choose an Image!!!!");
            return false;
        }
        return true;
    }

    public boolean isInteger(JTextComponent c, String fieldName) {  //this method is for validate integer values
        try {
            int i = Integer.parseInt(c.getText());
            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(c, fieldName + " must be an Integer");
            c.requestFocusInWindow();
            return false;
        }
    }

    public boolean isDate(JTextComponent c, String fieldName) {  //this method is for validating dates
        try {
            Date d = Date.valueOf(c.getText());
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(c, fieldName + " must be YYYY-MM-DD");
            c.requestFocusInWindow();
            return false;
        }
    }

    public boolean isValidNic(JTextComponent c, String fieldName) {  //this method is for validating NIC No
        if (c.getText().length() != 10) {
            JOptionPane.showMessageDialog(c, fieldName + " should be valid one");
            return false;
        } else if (!c.getText().substring(9, 10).equalsIgnoreCase("v")) {
            JOptionPane.showMessageDialog(c, fieldName + " should be valid one");
            return false;
        } else {
            return true;
        }
    }

    public boolean isValidTeleNo(JTextComponent c, String fieldName) {  //this method is for validating telephone no
        if (c.getText().length() != 11) {
            JOptionPane.showMessageDialog(c, fieldName + " should be valid one");
            return false;
        } else {
            return true;
        }
    }

    //this method is for checking whether gender is selected or not
    public boolean isSelectedGender(JRadioButton male, JRadioButton female, String fieldName) {
        if (!male.isSelected() && !female.isSelected()) {
            JOptionPane.showMessageDialog(female, fieldName + " should be selected");
            return false;
        }
        return true;
    }
}
