package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
//import java.sql.SQLException;
public abstract class User extends SelectUserFrame {
    public ImageIcon myIcon = new ImageIcon(getClass().getClassLoader().getResource("dog.jpg"));

    public JLabel username = new JLabel("Username:");
    public JTextField txtUsername = new JTextField();
    public JLabel password = new JLabel("Password:");
    public JPasswordField txtPassword = new JPasswordField();

    public JLabel phoneNumber=new JLabel("Phone:");

    public JTextField txtPhoneNumber=new JTextField();
    public JButton btn1 = new JButton("Login");
    public JButton btn2 = new JButton("Cancel");

    int frameWidth = 500;
    int frameHeight = 500;

    int labelWidth = 70;
    int fieldWidth = 200;
    int buttonWidth = 100;

    int labelHeight = 20;
    int fieldHeight = 20;
    int buttonHeight = 20;

    int horizontalGap = 50;
    int verticalGap = 20;
    public void loginCentered(JFrame myFrame) {


        int labelX = (frameWidth - labelWidth - fieldWidth) / 2;
        int fieldX = labelX + labelWidth + horizontalGap;

        int usernameY = (frameHeight - (3 * (labelHeight + verticalGap) + fieldHeight)) / 2;
        int passwordY = usernameY + labelHeight + verticalGap;
        int phoneY = passwordY + labelHeight + verticalGap;
        int buttonY = phoneY + fieldHeight + verticalGap;

        username.setBounds(labelX, usernameY, labelWidth, labelHeight);
        txtUsername.setBounds(fieldX , usernameY, fieldWidth, fieldHeight);
        password.setBounds(labelX, passwordY, labelWidth, labelHeight);
        txtPassword.setBounds(fieldX, passwordY, fieldWidth, fieldHeight);
        phoneNumber.setBounds(labelX, phoneY, labelWidth, labelHeight);
        txtPhoneNumber.setBounds(fieldX, phoneY, fieldWidth, fieldHeight);

        btn1.setBackground(Color.decode("#ffdbe0"));
        btn2.setBackground(Color.decode("#ffdbe0"));
        btn1.setBounds(labelX, buttonY, buttonWidth, buttonHeight);
        btn2.setBounds(fieldX, buttonY, buttonWidth, buttonHeight);
    }


}
