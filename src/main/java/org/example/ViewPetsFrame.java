package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.*;

import static org.example.Utils.buildTableModel;

public class ViewPetsFrame extends JFrame implements ActionListener {
    public JFrame viewPets = new JFrame();
    String url = "jdbc:postgresql://localhost:5432/postgres";
    String username = "postgres";
    String password = "zara";

    JButton butonExit = new JButton("Exit");
    public void connectToDB(JFrame viewPets) {
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT  nume, rasa, varsta, sex, greutate, temperament, poza\n" +
                    "\tFROM public.\"myTable\";");

            JTable table = new JTable(buildTableModel(resultSet));
            table.setRowHeight(30);
            table.setBackground(Color.pink);
            viewPets.add(new JScrollPane(table));



        } catch (SQLException e1) {
            System.out.println("Connection failed :" + e1.getMessage());
        }
    }



    public ViewPetsFrame() {
            viewPets.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            viewPets.setSize(500, 500);
            viewPets.getContentPane().setBackground(Color.pink);
            connectToDB(viewPets);
            Dimension buttonSize = new Dimension(20, 20);
            butonExit.setPreferredSize(buttonSize);
            viewPets.getContentPane().add(butonExit,BorderLayout.SOUTH);
            butonExit.addActionListener(this);
            butonExit.setBackground(Color.decode("#ffdbe0"));
            viewPets.setVisible(true);
        }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == butonExit)
            viewPets.setVisible(false);
    }
}
