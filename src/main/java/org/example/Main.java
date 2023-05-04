package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
//import java.sql.SQLException;


abstract class User extends SelectUserFrame{

    public ImageIcon myIcon = new ImageIcon(getClass().getClassLoader().getResource("dog.jpg"));

    public JLabel username = new JLabel("Username:");
    public JTextField txtUsername = new JTextField();
    public JLabel password = new JLabel("Password:");
    public JPasswordField txtPassword = new JPasswordField();

    public JLabel phoneNumber=new JLabel("Phone:");

    public JTextField txtPhoneNumber=new JTextField();
    public JButton btn1 = new JButton("Login");
    public JButton btn2 = new JButton("Cancel");

    int frameWidth = 500;
    int frameHeight = 500;

    int labelWidth = 70;
    int fieldWidth = 200;
    int buttonWidth = 100;

    int labelHeight = 20;
    int fieldHeight = 20;
    int buttonHeight = 20;

    int horizontalGap = 50;
    int verticalGap = 20;
    public void loginCentered(JFrame myFrame) {


        int labelX = (frameWidth - labelWidth - fieldWidth) / 2;
        int fieldX = labelX + labelWidth + horizontalGap;

        int usernameY = (frameHeight - (3 * (labelHeight + verticalGap) + fieldHeight)) / 2;
        int passwordY = usernameY + labelHeight + verticalGap;
        int phoneY = passwordY + labelHeight + verticalGap;
        int buttonY = phoneY + fieldHeight + verticalGap;

        username.setBounds(labelX, usernameY, labelWidth, labelHeight);
        txtUsername.setBounds(fieldX , usernameY, fieldWidth, fieldHeight);
        password.setBounds(labelX, passwordY, labelWidth, labelHeight);
        txtPassword.setBounds(fieldX, passwordY, fieldWidth, fieldHeight);
        phoneNumber.setBounds(labelX, phoneY, labelWidth, labelHeight);
        txtPhoneNumber.setBounds(fieldX, phoneY, fieldWidth, fieldHeight);

        btn1.setBackground(Color.decode("#ffdbe0"));
        btn2.setBackground(Color.decode("#ffdbe0"));
        btn1.setBounds(labelX, buttonY, buttonWidth, buttonHeight);
        btn2.setBounds(fieldX, buttonY, buttonWidth, buttonHeight);
    }

}



class FrameForAdopter extends User implements ActionListener{
    public JFrame frameForAdopter =new JFrame("FrameForAdopter");

    public JLabel fullName=new JLabel("Full name:");

    public JTextField txtFullName=new JTextField();
    public FrameForAdopter(){
        frameForAdopter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameForAdopter.setSize(500, 500);
        frameForAdopter.getContentPane().setBackground(Color.pink);
        frameForAdopter.setIconImage(myIcon.getImage());
        loginCentered(frameForAdopter);
        frameForAdopter.getContentPane().add(username);
        frameForAdopter.getContentPane().add(txtUsername);
        frameForAdopter.getContentPane().add(password);
        frameForAdopter.getContentPane().add(txtPassword);
        frameForAdopter.getContentPane().add(phoneNumber);
        frameForAdopter.getContentPane().add(txtPhoneNumber);
        frameForAdopter.getContentPane().add(fullName);
        frameForAdopter.getContentPane().add(txtFullName);
        frameForAdopter.getContentPane().add(btn1);
        frameForAdopter.getContentPane().add(btn2);
        frameForAdopter.getContentPane().setLayout(null);
        frameForAdopter.setVisible(true);
        btn1.addActionListener(this);

    }
    public void loginCentered(JFrame frameForAdopter){
        super.loginCentered(frameForAdopter);
        int fullNameHeight = 20;

        int usernameY = (frameHeight - (4 * (labelHeight + verticalGap) + fieldHeight)) / 2;
        int passwordY = usernameY + labelHeight + verticalGap;
        int phoneY = passwordY + labelHeight + verticalGap;
        int fullNameY = phoneY + fieldHeight + verticalGap;
        int fieldY = fullNameY + fullNameHeight + verticalGap;
        int buttonY = fieldY + fieldHeight + verticalGap;

        int labelX = (frameWidth - labelWidth - fieldWidth) / 2;
        int fieldX = labelX + labelWidth + horizontalGap;
        fullName.setBounds(labelX, fullNameY, labelWidth, fullNameHeight);
        txtFullName.setBounds(fieldX, fullNameY, fieldWidth, fieldHeight);
        txtUsername.setBounds(fieldX, usernameY, fieldWidth, fieldHeight);
        username.setBounds(labelX, usernameY, labelWidth, labelHeight);
        txtPassword.setBounds(fieldX, passwordY, fieldWidth, fieldHeight);
        password.setBounds(labelX, passwordY, labelWidth, labelHeight);
        txtPhoneNumber.setBounds(fieldX, phoneY, fieldWidth, fieldHeight);
        phoneNumber.setBounds(labelX, phoneY, labelWidth, labelHeight);
        btn1.setBounds(labelX, buttonY, buttonWidth, buttonHeight);
        btn2.setBounds(fieldX, buttonY, buttonWidth, buttonHeight);
    }



}
class MyFrame extends User implements ActionListener{

    public JFrame myFrame = new JFrame("MyFrame");

    public JLabel shelterName=new JLabel("Shelter:");

    public JTextField txtShelterName=new JTextField();

    MyFrame() {
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setSize(500, 500);
        myFrame.getContentPane().setBackground(Color.pink);
        myFrame.setIconImage(myIcon.getImage());
        loginCentered(myFrame);
        myFrame.getContentPane().add(username);
        myFrame.getContentPane().add(txtUsername);
        myFrame.getContentPane().add(password);
        myFrame.getContentPane().add(txtPassword);
        myFrame.getContentPane().add(phoneNumber);
        myFrame.getContentPane().add(txtPhoneNumber);
        myFrame.getContentPane().add(shelterName);
        myFrame.getContentPane().add(txtShelterName);
        myFrame.getContentPane().add(btn1);
        myFrame.getContentPane().add(btn2);
        myFrame.getContentPane().setLayout(null);
        myFrame.setVisible(true);
        btn1.addActionListener(this);

    }

    public void loginCentered(JFrame myFrame) {
        super.loginCentered(myFrame);

        int shelterNameHeight = 20;
        int usernameY = (frameHeight - (4 * (labelHeight + verticalGap) + fieldHeight)) / 2;
        int passwordY = usernameY + labelHeight + verticalGap;
        int phoneY = passwordY + labelHeight + verticalGap;
        int fullNameY = phoneY + fieldHeight + verticalGap;
        int fieldY = fullNameY + shelterNameHeight + verticalGap;
        int buttonY = fieldY + fieldHeight + verticalGap;

        int labelX = (frameWidth - labelWidth - fieldWidth) / 2;
        int fieldX = labelX + labelWidth + horizontalGap;
        shelterName.setBounds(labelX, fullNameY, labelWidth, shelterNameHeight);
        txtShelterName.setBounds(fieldX, fullNameY, fieldWidth, fieldHeight);
        txtUsername.setBounds(fieldX, usernameY, fieldWidth, fieldHeight);
        username.setBounds(labelX, usernameY, labelWidth, labelHeight);
        txtPassword.setBounds(fieldX, passwordY, fieldWidth, fieldHeight);
        password.setBounds(labelX, passwordY, labelWidth, labelHeight);
        txtPhoneNumber.setBounds(fieldX, phoneY, fieldWidth, fieldHeight);
        phoneNumber.setBounds(labelX, phoneY, labelWidth, labelHeight);
        btn1.setBounds(labelX, buttonY, buttonWidth, buttonHeight);
        btn2.setBounds(fieldX, buttonY, buttonWidth, buttonHeight);
    }




    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1) {
            String username = txtUsername.getText();
            String password = txtPassword.getText();
            if ((username.equals("Carina") || username.equals("Helena")) && password.equals("Zara")) {
                new MenuForShelter();
                }
            }

        }

    }

class SelectUserFrame implements ActionListener {
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

class MenuForShelter extends DeletePetFrame implements ActionListener{


    public JButton option1 = new JButton("Add pet");
    public JButton option2 = new JButton("Delete pet");
    public JButton option3 = new JButton("Edit pet profile");
    public JButton option4 = new JButton("Exit");



    public MenuForShelter()  {

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
        } else
            if (e.getSource() == add) {
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
        }
        else
            if(e.getSource() == deleteButton) {
                try {
                    Connection conn = DriverManager.getConnection(url, username, password);
                    System.out.println("Connected to the PostgreSQL server successfully.");
                    String deleteQuery = "DELETE FROM public.\"myTable\"\n" +
                            "\tWHERE id=?";

                    //Integer.valueOf(idField.getText());
                    PreparedStatement pstmt = conn.prepareStatement(deleteQuery);
                    pstmt.setInt(1,Integer.valueOf(idField.getText()));


                    int rowsDeleted = pstmt.executeUpdate();
                    if (rowsDeleted > 0) {
                        System.out.println("The pet has been deleted successfully!");
                        JOptionPane.showMessageDialog(null, "The pet that you wanted to delete has been deleted successfully!");
                        deletePet.setVisible(false);
                    }


                }catch (SQLException e1){
                    System.out.println("Connection failed :" + e1.getMessage());
                }
            }
        if (e.getSource() == option3) {

        }
        if (e.getSource() == option4) {

        }
    }


}

class DeletePetFrame extends AddPetFrame implements ActionListener{

    public JFrame deletePet = new JFrame("DeletePetFrame");

    JButton deleteButton = new JButton("Delete pet");
    JLabel idLabel = new JLabel("Type the PET ID you want to delete:");
    JTextField idField = new JTextField();

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


        idField.setBounds(fieldX, idFieldY, fieldWidth, fieldHeight);
        deletePet.add(idField);

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

class AddPetFrame extends JFrame implements ActionListener {
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
        //addPet.setVisible(true);
        add.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
public class Main {
    public static void main(String[] args) {//throws SQLException {
        new SelectUserFrame();
    }
}