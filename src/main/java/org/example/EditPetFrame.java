package org.example;

import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
//import java.sql.SQLException;
public class EditPetFrame extends DeletePetFrame implements ActionListener {
    public JFrame editPet = new JFrame("EditPetFrame");
    public JButton editButton=new JButton("Edit");
    private JLabel text2=new JLabel("Enter the id and age to edit:");
    private JLabel idLabel=new JLabel("Animal ID:");
    private JLabel ageLabel=new JLabel("Animal age:");
    public  JTextField idField=new JTextField();
    public JTextField ageField = new JTextField();


    public void EditPetText(JLabel text2) {
        text2.setBounds(30, 120, 400, 200);
        text2.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 18));
    }

    public EditPetFrame(){
        editPet.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        editPet.setSize(500, 500);
        editPet.getContentPane().setBackground(Color.pink);
        EditPetText(text2);


        int frameWidth = 500;
        int frameHeight = 500;

        int labelWidth = 70;
        int fieldWidth = 200;
        int buttonWidth = 100;

        int labelHeight = 20;
        int fieldHeight = 20;
        int buttonHeight = 30;

        int horizontalGap = 50;
        int verticalGap = 20;

        int labelX = 50;
        int fieldX = labelX + labelWidth + horizontalGap - 100;
        int idLabelY = (frameHeight - (2 * (labelHeight + fieldHeight + verticalGap) + buttonHeight)) / 2;
        int idFieldY = idLabelY + labelHeight + verticalGap;
        int ageLabelY = idFieldY + fieldHeight + verticalGap;
        int ageFieldY = ageLabelY + labelHeight + verticalGap;
        int editButtonY = ageFieldY + fieldHeight + verticalGap;

        text2.setBounds((frameWidth - labelWidth - fieldWidth) / 2, idLabelY - verticalGap, labelWidth + fieldWidth + horizontalGap, labelHeight*2);
        idLabel.setBounds(labelX, idLabelY, labelWidth, labelHeight);
        idField.setBounds(fieldX, idFieldY, fieldWidth, fieldHeight);
        ageLabel.setBounds(labelX, ageLabelY, labelWidth, labelHeight);
        ageField.setBounds(fieldX, ageFieldY, fieldWidth, fieldHeight);
        editButton.setBounds(fieldX + fieldWidth / 2 - buttonWidth / 2, editButtonY, buttonWidth, buttonHeight);
        editButton.setBackground(Color.decode("#FFDBE0"));

        editPet.getContentPane().add(text2);
        editPet.getContentPane().add(idLabel);
        editPet.getContentPane().add(idField);
        editPet.getContentPane().add(ageLabel);
        editPet.getContentPane().add(ageField);
        editPet.getContentPane().add(editButton);

        editButton.addActionListener(this);
        editPet.setLayout(null);
    }
}
