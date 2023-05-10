package org.example;

import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.sql.*;
import java.sql.SQLException;


public class MenuForShelter extends EditPetFrame implements ActionListener {
    public JButton option1 = new JButton("Add pet");
    public JButton option2 = new JButton("Delete pet");
    public JButton option3 = new JButton("Edit pet profile");
    public JButton option4 = new JButton("Exit");


    public MenuForShelter() {

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

        JLabel labelImage = new JLabel();
        labelImage.setIcon(new ImageIcon("C:\\Users\\Carina\\Desktop\\PetShopApplication\\src\\main\\resources\\adoptmedog.png"));
        Dimension size = labelImage.getPreferredSize();
        labelImage.setBounds(50,10, size.width, size.height);


        getContentPane().add(labelImage);
        getContentPane().add(sidebar, BorderLayout.WEST);
        getContentPane().setBackground(Color.pink);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        option1.addActionListener(this);
        option2.addActionListener(this);
        option3.addActionListener(this);
        option4.addActionListener(this);
    }

    String url = "jdbc:postgresql://localhost:5432/postgres";
    String username = "postgres";
    String password = "zara";


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == option1) {
            addPet.setVisible(true);
        } else if (e.getSource() == add) {
            try {
                Connection conn = DriverManager.getConnection(url, username, password);
                System.out.println("Connected to the PostgreSQL server successfully.");
                String insertQuery = "INSERT INTO public.\"myTable\"(\n" +
                        "\tnume, rasa, varsta, sex, greutate, temperament)\n" +
                        "\tVALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(insertQuery);


                pstmt.setString(1, txtNameField.getText());
                pstmt.setString(2, txtBreedField.getText());
                pstmt.setString(3, txtAgeField.getText());
                pstmt.setString(4, txtSexField.getText());
                pstmt.setString(5, txtWeightField.getText());
                pstmt.setString(6, txtTemperamentField.getText());

                int rowsInserted = pstmt.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("A new pet has been inserted successfully!");
                    JOptionPane.showMessageDialog(null, "A new pet has been inserted successfully!");
                    addPet.setVisible(false);
                }

                conn.close();
            } catch (SQLException e1) {
                System.out.println("Connection failed :" + e1.getMessage());
            }
        }

        if (e.getSource() == option2) {
            deletePet.setVisible(true);
        } else if (e.getSource() == deleteButton) {
            try {
                Connection conn = DriverManager.getConnection(url, username, password);
                System.out.println("Connected to the PostgreSQL server successfully.");
                String deleteQuery = "DELETE FROM public.\"myTable\"\n" +
                        "\tWHERE id=?";

                //Integer.valueOf(idField.getText());
                PreparedStatement pstmt = conn.prepareStatement(deleteQuery);
                pstmt.setInt(1, Integer.valueOf(idField1.getText()));


                int rowsDeleted = pstmt.executeUpdate();
                if (rowsDeleted > 0) {
                    System.out.println("The pet has been deleted successfully!");
                    JOptionPane.showMessageDialog(null, "The pet that you wanted to delete has been deleted successfully!");
                    deletePet.setVisible(false);
                }


            } catch (SQLException e1) {
                System.out.println("Connection failed :" + e1.getMessage());
            }
        }
        if (e.getSource() == option3) {
            editPet.setVisible(true);
        } else {
            if (e.getSource() == editButton) {
                try {
                    Connection conn = DriverManager.getConnection(url, username, password);
                    System.out.println("Connected to the PostgreSQL server successfully.");
                    String editQuery = "UPDATE public.\"myTable\"\n" +
                            "\tSET varsta=?\n" +
                            "\tWHERE id=?;";

                    Integer.valueOf(idField.getText());
                    Integer.valueOf(ageField.getText());

                    PreparedStatement pstmt = conn.prepareStatement(editQuery);
                    pstmt.setInt(1, Integer.valueOf(ageField.getText()));
                    pstmt.setInt(2, Integer.valueOf(idField.getText()));

                    int rowsEdited = pstmt.executeUpdate();
                    if (rowsEdited > 0) {
                        System.out.println("The pet has been edited successfully!");
                        JOptionPane.showMessageDialog(null, "The pet has aged one year :( ");
                        editPet.setVisible(false);
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }
        }

            if (e.getSource() == option4) {
                setVisible(false);
            }

    }
}