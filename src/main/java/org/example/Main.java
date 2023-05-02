package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import java.sql.SQLException;


abstract class User extends SelectUserFrame{

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



class FrameForAdopter extends User implements ActionListener{
    public JFrame frameForAdopter =new JFrame("FrameForAdopter");

    public JLabel fullName=new JLabel("Full name:");

    public JTextField txtFullName=new JTextField();
    public FrameForAdopter(){
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

    }
    public void loginCentered(JFrame frameForAdopter){
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



}
class MyFrame extends User implements ActionListener{

    public JFrame myFrame = new JFrame("PetShopApplication");

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
                try {
                    new MenuForShelter();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }

        }

    }


}

class SelectUserFrame implements ActionListener {
    JFrame selectUserFrame = new JFrame("SelectUserFrame");
    public JButton btnAdmin = new JButton("Admin");
    public JButton btnUser = new JButton("Adopter");

    public void buttonsBounds(JFrame selectUserFrame) {
        btnAdmin.setBounds(70, 250, 100, 20);
        btnUser.setBounds(320, 250, 100, 20);
    }

    JLabel selectUser = new JLabel("Select one below: ");


    public void SelectUserText(JLabel selectUser) {
        selectUser.setBounds(50, 100, 400, 200);
        selectUser.setFont(new Font("Times New Roman", Font.BOLD, 40));

    }

    ImageIcon image = new ImageIcon("adoptmedog.jpg");
    JLabel imageLabel = new JLabel();

    public void adoptMeDog() {
        imageLabel.setIcon(image);
        imageLabel.setBounds(180, 50, 120, 120);
        imageLabel.setPreferredSize(new Dimension(120, 120));

    }

    public SelectUserFrame() {

        selectUserFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        selectUserFrame.setSize(500, 500);
        selectUserFrame.getContentPane().setBackground(Color.pink);
        selectUserFrame.setVisible(true);
        buttonsBounds(selectUserFrame);
        selectUserFrame.getContentPane().add(btnAdmin);
        selectUserFrame.getContentPane().add(btnUser);
        selectUserFrame.getContentPane().setLayout(null);
        SelectUserText(selectUser);
        selectUserFrame.getContentPane().add(selectUser);
        adoptMeDog();
        selectUserFrame.getContentPane().add(imageLabel);
        btnAdmin.setBackground(Color.decode("#ffdbe0"));
        btnUser.setBackground(Color.decode("#ffdbe0"));
        btnAdmin.addActionListener(this);
        btnUser.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAdmin) {
            MyFrame frame1 = new MyFrame();
        }
        if (e.getSource() == btnUser) {
            FrameForAdopter frame2 = new FrameForAdopter();
        }
    }
}

class MenuForShelter extends JFrame implements ActionListener{


    public JButton option1 = new JButton("Add pet");
    public JButton option2 = new JButton("Delete pet");
    public JButton option3 = new JButton("Edit pet profile");
    public JButton option4 = new JButton("Exit");


    public MenuForShelter() throws SQLException {

        setTitle("MenuForShelter");
        JPanel sidebar = new JPanel();
        sidebar.setLayout(new GridLayout(0, 1)); // aranjeaza componentele in coloane
        sidebar.setBackground(Color.pink);


        sidebar.add(option1);
        sidebar.add(option2);
        sidebar.add(option3);
        sidebar.add(option4);

        option1.setBackground(Color.decode("#ffdbe0"));
        option2.setBackground(Color.decode("#ffdbe0"));
        option3.setBackground(Color.decode("#ffdbe0"));
        option4.setBackground(Color.decode("#ffdbe0"));

        getContentPane().add(sidebar, BorderLayout.WEST);
        getContentPane().setBackground(Color.pink);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

   

    Connection connection = DriverManager.getConnection("jdbc:h2:mem:pets", "carinasihelena", "zara");

   @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == option1) {

        }
        if (e.getSource() == option2) {

        }
        if (e.getSource() == option3) {

        }
        if (e.getSource() == option4) {

        }
    }


}

public class Main {
    public static void main(String[] args) {

        new SelectUserFrame();
    }
}