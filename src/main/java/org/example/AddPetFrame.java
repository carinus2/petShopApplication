package org.example;

import javax.swing.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
//import java.sql.SQLException;

public class AddPetFrame extends JFrame implements ActionListener {
    JLabel nameField = new JLabel("Name:");
    JTextField txtNameField = new JTextField();
    JLabel breedField = new JLabel("Breed:");
    JTextField txtBreedField = new JTextField();

    JLabel ageField = new JLabel("Age:");
    JTextField txtAgeField = new JTextField();

    JLabel sexField = new JLabel("Sex:");
    JTextField txtSexField = new JTextField();
    JLabel weightField = new JLabel("Weight:");
    JTextField txtWeightField = new JTextField();
    JLabel temperamentField = new JLabel("Temperament:");
    JTextField txtTemperamentField = new JTextField();

    public JButton add=new JButton("Add pet");

    JFrame addPet = new JFrame("AddPetFrame");
    public AddPetFrame() {

        addPet.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addPet.setSize(500, 500);
        addPet.getContentPane().setBackground(Color.pink);



        int frameWidth = 500;
        int frameHeight = 500;

        int labelWidth = 70;
        int fieldWidth = 200;


        int labelHeight = 20;
        int fieldHeight = 20;


        int horizontalGap = 50;
        int verticalGap = 20;



        int labelX = (frameWidth - labelWidth - fieldWidth) / 2;
        int fieldX = labelX + labelWidth + horizontalGap;
        int nameY = (frameHeight - (7 * (labelHeight + verticalGap) + fieldHeight)) / 2;
        int breedY = nameY + labelHeight + verticalGap;
        int ageY = breedY + labelHeight + verticalGap;
        int sexY = ageY + labelHeight + verticalGap;
        int weightY = sexY + labelHeight + verticalGap;
        int temperamentY = weightY + labelHeight + verticalGap;



        nameField.setBounds(labelX, nameY, labelWidth, labelHeight);
        txtNameField.setBounds(fieldX, nameY, fieldWidth, fieldHeight);
        breedField.setBounds(labelX, breedY, labelWidth, labelHeight);
        txtBreedField.setBounds(fieldX, breedY, fieldWidth, fieldHeight);
        ageField.setBounds(labelX, ageY, labelWidth, labelHeight);
        txtAgeField.setBounds(fieldX, ageY, fieldWidth, fieldHeight);
        sexField.setBounds(labelX, sexY, labelWidth, labelHeight);
        txtSexField.setBounds(fieldX, sexY, fieldWidth, fieldHeight);
        weightField.setBounds(labelX, weightY, labelWidth, labelHeight);
        txtWeightField.setBounds(fieldX, weightY, fieldWidth, fieldHeight);
        temperamentField.setBounds(labelX, temperamentY, labelWidth, labelHeight);
        txtTemperamentField.setBounds(fieldX, temperamentY, fieldWidth, fieldHeight);
        add.setBounds(labelX, temperamentY + labelHeight + verticalGap, fieldWidth, fieldHeight);
        add.setBackground(Color.decode("#ffdbe0"));

        addPet.getContentPane().add(add);
        addPet.getContentPane().add(nameField);
        addPet.getContentPane().add(txtNameField);
        addPet.getContentPane().add(breedField);
        addPet.getContentPane().add(txtBreedField);
        addPet.getContentPane().add(ageField);
        addPet.getContentPane().add(txtAgeField);
        addPet.getContentPane().add(sexField);
        addPet.getContentPane().add(txtSexField);
        addPet.getContentPane().add(weightField);
        addPet.getContentPane().add(txtWeightField);
        addPet.getContentPane().add(temperamentField);
        addPet.getContentPane().add(txtTemperamentField);

        addPet.setLayout(null);
        add.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
