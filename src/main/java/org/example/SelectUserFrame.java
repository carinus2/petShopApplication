package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
//import java.sql.SQLException;
public class SelectUserFrame implements ActionListener {
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

