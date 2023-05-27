package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuForAdopter extends JFrame implements ActionListener {

    public JButton optionA = new JButton("View pets");
    public JButton optionB = new JButton("Search pet");
    public JButton optionC = new JButton("My Requests");
    public JButton optionD = new JButton("Exit");

    public MenuForAdopter(){
        setTitle("MenuForAdopter");
        JPanel sidebar = new JPanel();
        sidebar.setLayout(new GridLayout(0, 1)); // aranjeaza componentele in coloane
        sidebar.setBackground(Color.pink);


        sidebar.add(optionA);
        sidebar.add(optionB);
        sidebar.add(optionC);
        sidebar.add(optionD);

        optionA.setBackground(Color.decode("#ffdbe0"));
        optionB.setBackground(Color.decode("#ffdbe0"));
        optionC.setBackground(Color.decode("#ffdbe0"));
        optionD.setBackground(Color.decode("#ffdbe0"));

        getContentPane().add(sidebar, BorderLayout.WEST);
        getContentPane().setBackground(Color.pink);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        optionA.addActionListener(this);
        optionB.addActionListener(this);
        optionC.addActionListener(this);
        optionD.addActionListener(this);

    }

    String url = "jdbc:postgresql://localhost:5432/postgres";
    String username = "postgres";
    String password = "zara";



    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == optionA) {
            new ViewPetsFrame();
        }
        if(e.getSource() == optionB) {
            new SearchPetFrame();
        }

        if(e.getSource() == optionD){
            setVisible(false);
        }
    }
}
