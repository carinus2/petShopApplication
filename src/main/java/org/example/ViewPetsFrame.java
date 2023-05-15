package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.*;

public class ViewPetsFrame extends JFrame implements ActionListener {
    public JFrame viewPets = new JFrame();
    String url = "jdbc:postgresql://localhost:5432/postgres";
    String username = "postgres";
    String password = "zara";
    public void connectToDB() {
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT  nume, rasa, varsta, sex, greutate, temperament\n" +
                    "\tFROM public.\"myTable\";");
        } catch (SQLException e1) {
            System.out.println("Connection failed :" + e1.getMessage());
        }
    }



    public ViewPetsFrame() {
            viewPets.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            viewPets.setSize(500, 500);
            viewPets.getContentPane().setBackground(Color.pink);


            viewPets.setVisible(true);
        }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
