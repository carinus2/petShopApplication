package org.example;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
//import java.sql.SQLException;
public class DeletePetFrame extends AddPetFrame implements ActionListener {
    public JFrame deletePet = new JFrame("DeletePetFrame");

    JButton deleteButton = new JButton("Delete pet");
    JLabel idLabel = new JLabel("Type the PET ID you want to delete:");
    JTextField idField1 = new JTextField();

    public void DeletePetId(JLabel idLabel) {
        idLabel.setBounds(50, 100, 400, 200);
        idLabel.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 20));

    }

    public DeletePetFrame(){
        deletePet.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        deletePet.setSize(500, 500);
        deletePet.getContentPane().setBackground(Color.pink);

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

        int labelX = (frameWidth - labelWidth - fieldWidth) / 2;
        int fieldX = labelX + labelWidth + horizontalGap - 100;
        int idLabelY = (frameHeight - (labelHeight + fieldHeight + buttonHeight)) / 2;
        int idFieldY = idLabelY + labelHeight + verticalGap;
        int deleteButtonY = idFieldY + fieldHeight + verticalGap;

        idLabel.setBounds(labelX, idLabelY, labelWidth, labelHeight);
        deletePet.add(idLabel);


        idField1.setBounds(fieldX, idFieldY, fieldWidth, fieldHeight);
        deletePet.add(idField1);

        deleteButton.setBounds(fieldX + fieldWidth / 2 - buttonWidth / 2, deleteButtonY, buttonWidth, buttonHeight);
        deleteButton.setBackground(Color.decode("#ffdbe0"));
        deleteButton.addActionListener(this);
        deletePet.add(deleteButton);
        DeletePetId(idLabel);
        deletePet.setLayout(null);

    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
