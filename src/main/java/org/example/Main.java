package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.SocketOption;
import java.net.SocketTimeoutException;
import java.sql.SQLOutput;

class MyFrame extends JFrame implements ActionListener{
    JFrame myFrame = new JFrame("PetShopApplication");
    ImageIcon myIcon = new ImageIcon("dog.jpg");
    JLabel label1 = new JLabel("Hei");

    JLabel username = new JLabel("Username:");
    JTextField txtUsername = new JTextField();
    JLabel password = new JLabel("Password:");
    JTextField txtPassword = new JTextField();

    public JButton btn1 = new JButton("Login");
    public JButton btn2 = new JButton("Cancel");

    public void loginBound(JFrame myFrame) {
        username.setBounds(20, 10, 70, 20);
        txtUsername.setBounds(90, 10, 150, 20);
        password.setBounds(20, 40, 70, 20);
        txtPassword.setBounds(90, 40, 150, 20);
        btn1.setBounds(20, 70, 100, 20);
        btn2.setBounds(140, 70, 100, 20);
    }

    MyFrame() {
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setSize(500, 500);
        myFrame.getContentPane().setBackground(Color.pink);
        myFrame.getContentPane().add(label1);
        myFrame.setIconImage(myIcon.getImage());
        loginBound(myFrame);
        myFrame.getContentPane().add(username);
        myFrame.getContentPane().add(txtUsername);
        myFrame.getContentPane().add(password);
        myFrame.getContentPane().add(txtPassword);
        myFrame.getContentPane().add(btn1);
        myFrame.getContentPane().add(btn2);
        myFrame.getContentPane().setLayout(null);
        myFrame.setVisible(true);
        btn1.addActionListener(this);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1) {
            String username = txtUsername.getText();
            String password = txtPassword.getText();
            if ((username.equals("Carina") || username.equals("Helena")) && password.equals("Zara")) {
                System.out.println("ADMIN");
            }
        }
    }


}

public class Main extends MyFrame {
    public static void main(String[] args) {
        new MyFrame();

    }
}