package org.example;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class SearchPetFrame extends JFrame implements ActionListener{
    JFrame searchPetFrame = new JFrame("SearchPetFrame");
     JTextField searchable = new JTextField(30);
    JButton searchB = new JButton("Search");

    JButton exit = new JButton("Exit");
     JTable result = new JTable();
    private JPanel panel = new JPanel();
    private JScrollPane scrollPane = new JScrollPane(result);



    public SearchPetFrame() {
        searchPetFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        searchPetFrame.setSize(500, 500);
        searchPetFrame.getContentPane().setBackground(Color.pink);

        searchable.setPreferredSize(new Dimension(200, 30)); // Setează dimensiunea dorită pentru căsuța de căutare
        searchB.setPreferredSize(new Dimension(80, 30)); // Setează dimensiunea dorită pentru butonul de căutare
        exit.setPreferredSize(new Dimension(80,30));
        scrollPane.setPreferredSize(new Dimension(400, 300)); // Setează dimensiunea dorită pentru panoul cu scroll
        result.setBackground(Color.decode("#ffdbe0"));
        scrollPane.setBackground(Color.decode("#ffdbe0"));
        panel.setBackground(Color.PINK);
        panel.add(searchable);
        panel.add(searchB);
        panel.add(exit);
        panel.add(scrollPane);
        searchPetFrame.getContentPane().add(panel);
        searchB.setBackground(Color.decode("#ffdbe0"));
        searchB.addActionListener(this);
        exit.setBackground(Color.decode("#ffdbe0"));
        exit.addActionListener(this);
        searchPetFrame.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres";
        String password = "zara";
        String searchText = searchable.getText();


        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        System.out.println("Connected to the PostgreSQL server successfully.");
        String query = "SELECT  nume, rasa, varsta, sex, greutate, temperament, poza\n" +
                "\tFROM public.\"myTable\" WHERE rasa = ?;";

        try {
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, searchText);
            ResultSet resultSet = statement.executeQuery();

            // Crează un model pentru tabel
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Nume");
            model.addColumn("Rasa");
            model.addColumn("Varsta");
            model.addColumn("Sex");
            model.addColumn("Greutate");
            model.addColumn("Temperament");
            model.addColumn("Poza");

            // Adaugă datele din rezultatul căutării în model
            while (resultSet.next()) {
                String nume = resultSet.getString("nume");
                String rasa = resultSet.getString("rasa");
                int varsta = resultSet.getInt("varsta");
                String sex = resultSet.getString("sex");
                double greutate = resultSet.getDouble("greutate");
                String temperament = resultSet.getString("temperament");
                String poza = resultSet.getString("poza");

                model.addRow(new Object[]{nume, rasa, varsta, sex, greutate, temperament, poza});
            }

            result.setModel(model); // Setează modelul cu datele căutate în tabelul result
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

    if(e.getSource() == exit){
        searchPetFrame.setVisible(false);
    }
    }
}