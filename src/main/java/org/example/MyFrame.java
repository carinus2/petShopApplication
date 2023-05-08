package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
//import java.sql.SQLException;
public class MyFrame extends User implements ActionListener {
    public JFrame myFrame = new JFrame("MyFrame");

    public JLabel shelterName=new JLabel("Shelter:");

    public JTextField txtShelterName=new JTextField();

    MyFrame() {
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setSize(500, 500);
        myFrame.getContentPane().setBackground(Color.pink);
        myFrame.setIconImage(myIcon.getImage());
        loginCentered(myFrame);
        myFrame.getContentPane().add(username);
        myFrame.getContentPane().add(txtUsername);
        myFrame.getContentPane().add(password);
        myFrame.getContentPane().add(txtPassword);
        myFrame.getContentPane().add(phoneNumber);
        myFrame.getContentPane().add(txtPhoneNumber);
        myFrame.getContentPane().add(shelterName);
        myFrame.getContentPane().add(txtShelterName);
        myFrame.getContentPane().add(btn1);
        myFrame.getContentPane().add(btn2);
        myFrame.getContentPane().setLayout(null);
        myFrame.setVisible(true);
        btn1.addActionListener(this);

    }

    public void loginCentered(JFrame myFrame) {
        super.loginCentered(myFrame);

        int shelterNameHeight = 20;
        int usernameY = (frameHeight - (4 * (labelHeight + verticalGap) + fieldHeight)) / 2;
        int passwordY = usernameY + labelHeight + verticalGap;
        int phoneY = passwordY + labelHeight + verticalGap;
        int fullNameY = phoneY + fieldHeight + verticalGap;
        int fieldY = fullNameY + shelterNameHeight + verticalGap;
        int buttonY = fieldY + fieldHeight + verticalGap;

        int labelX = (frameWidth - labelWidth - fieldWidth) / 2;
        int fieldX = labelX + labelWidth + horizontalGap;
        shelterName.setBounds(labelX, fullNameY, labelWidth, shelterNameHeight);
        txtShelterName.setBounds(fieldX, fullNameY, fieldWidth, fieldHeight);
        txtUsername.setBounds(fieldX, usernameY, fieldWidth, fieldHeight);
        username.setBounds(labelX, usernameY, labelWidth, labelHeight);
        txtPassword.setBounds(fieldX, passwordY, fieldWidth, fieldHeight);
        password.setBounds(labelX, passwordY, labelWidth, labelHeight);
        txtPhoneNumber.setBounds(fieldX, phoneY, fieldWidth, fieldHeight);
        phoneNumber.setBounds(labelX, phoneY, labelWidth, labelHeight);
        btn1.setBounds(labelX, buttonY, buttonWidth, buttonHeight);
        btn2.setBounds(fieldX, buttonY, buttonWidth, buttonHeight);
    }




    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1) {
            String username = txtUsername.getText();
            String password = txtPassword.getText();
            if ((username.equals("Carina") || username.equals("Helena")) && password.equals("Zara")) {
                new MenuForShelter();
            }
        }

    }

}
