package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
//import java.sql.SQLException;
public class FrameForAdopter extends User implements ActionListener {

    public JFrame frameForAdopter = new JFrame();

    public JLabel fullName = new JLabel("Full name:");

    public JTextField txtFullName = new JTextField();

    public FrameForAdopter() {
        frameForAdopter.setTitle("FrameForAdopter");
        frameForAdopter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameForAdopter.setSize(500, 500);
        frameForAdopter.getContentPane().setBackground(Color.pink);
        frameForAdopter.setIconImage(myIcon.getImage());
        loginCentered(frameForAdopter);
        frameForAdopter.getContentPane().add(username);
        frameForAdopter.getContentPane().add(txtUsername);
        frameForAdopter.getContentPane().add(password);
        frameForAdopter.getContentPane().add(txtPassword);
        frameForAdopter.getContentPane().add(phoneNumber);
        frameForAdopter.getContentPane().add(txtPhoneNumber);
        frameForAdopter.getContentPane().add(fullName);
        frameForAdopter.getContentPane().add(txtFullName);
        frameForAdopter.getContentPane().add(btn1);
        frameForAdopter.getContentPane().add(btn2);
        frameForAdopter.getContentPane().setLayout(null);
        frameForAdopter.setVisible(true);
        btn1.addActionListener(this);
        btn2.addActionListener(this);

    }

    public void loginCentered(JFrame frameForAdopter) {
        super.loginCentered(frameForAdopter);
        int fullNameHeight = 20;

        int usernameY = (frameHeight - (4 * (labelHeight + verticalGap) + fieldHeight)) / 2;
        int passwordY = usernameY + labelHeight + verticalGap;
        int phoneY = passwordY + labelHeight + verticalGap;
        int fullNameY = phoneY + fieldHeight + verticalGap;
        int fieldY = fullNameY + fullNameHeight + verticalGap;
        int buttonY = fieldY + fieldHeight + verticalGap;

        int labelX = (frameWidth - labelWidth - fieldWidth) / 2;
        int fieldX = labelX + labelWidth + horizontalGap;
        fullName.setBounds(labelX, fullNameY, labelWidth, fullNameHeight);
        txtFullName.setBounds(fieldX, fullNameY, fieldWidth, fieldHeight);
        txtUsername.setBounds(fieldX, usernameY, fieldWidth, fieldHeight);
        username.setBounds(labelX, usernameY, labelWidth, labelHeight);
        txtPassword.setBounds(fieldX, passwordY, fieldWidth, fieldHeight);
        password.setBounds(labelX, passwordY, labelWidth, labelHeight);
        txtPhoneNumber.setBounds(fieldX, phoneY, fieldWidth, fieldHeight);
        phoneNumber.setBounds(labelX, phoneY, labelWidth, labelHeight);
        btn1.setBounds(labelX, buttonY, buttonWidth, buttonHeight);
        btn2.setBounds(fieldX, buttonY, buttonWidth, buttonHeight);
    }
    String url = "jdbc:postgresql://localhost:5432/postgres";
    String username1 = "postgres";
    String password1 = "zara";

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1) {
            try {
                Connection conn = DriverManager.getConnection(url, username1, password1);
                System.out.println("Connected to the PostgreSQL server successfully.");
                Statement statement = conn.createStatement();
                String selectQuery = "SELECT username, password, phone, \"fullName\"\n" +
                        "\tFROM public.\"loginForAdopters\"";

                ResultSet result = statement.executeQuery(selectQuery);
                boolean match = false;

                while (result.next()) {
                    String userNameFromDB = result.getString("username").trim();
                    String password3 = result.getString("password").trim();
                    String phone = result.getString("phone").trim();
                    String shelterName = result.getString("fullName").trim();
                    String userNameFromUi = txtUsername.getText();
                    String passwordFromUi = txtPassword.getText();
                    String phoneFromUi = txtPhoneNumber.getText();
                    String fullNameFromUi = txtFullName.getText().trim();

                    if(userNameFromUi.equals(userNameFromDB) && password3.equals(passwordFromUi) && phone.equals(phoneFromUi) && shelterName.equals(fullNameFromUi))
                        new MenuForShelter();

                }
                System.out.println(match);
                conn.close();
            }
            catch(SQLException e1){
                System.out.println("Connection failed :" + e1.getMessage());
            }
        }

        if (e.getSource() == btn2) {
            frameForAdopter.setVisible(false);
        }
    }
}
