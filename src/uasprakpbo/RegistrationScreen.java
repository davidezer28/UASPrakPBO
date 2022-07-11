/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uasprakpbo;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class RegistrationScreen extends JFrame implements ActionListener, ItemListener  {
    public RegistrationScreen(String uname, String Nickname, String Email) {
        register(uname, Nickname, Email);
    }
    JFrame frame;
    JLabel label_datadiri, label_Username, label_Nickname, label_email, label_Password, label_combobox1, label_combobox2;
    JComboBox combobox;
    JButton button_Register, button_Login, chooseFile;
    JTextField TF_Username, TF_Nickname, TF_Email;
    JPasswordField passwordfield;
    Boolean Username_filled = false, Nickname_filled = false, Email_filled = false, Pass_filled = false;
    JFileChooser choosePhotos;
    File photos;
    String pathPhotos;

    private void register(String uname, String Nickname, String Email) {
        frame = new JFrame("Register Form");
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);

        label_datadiri = new JLabel("Silahkan isi data diri anda : ");
        label_datadiri.setForeground(Color.blue);
        label_datadiri.setFont(new Font("Serif", Font.BOLD, 20));
        label_datadiri.setBounds(100, 30, 400, 30);

        label_Username = new JLabel("Kategori User ");
        label_Username.setBounds(80, 70, 200, 30);
        
        // array of string containing cities
        String s1[] = { "Pengguna","Admin" };
 
        // create checkbox
        combobox = new JComboBox(s1);
 
        // add ItemListener
        combobox.addItemListener(this);
 
        // create labels
        label_combobox1 = new JLabel("select your category ");
        label_combobox2 = new JLabel("Pengguna selected");

        label_Nickname = new JLabel("Nama ");
        label_Nickname.setBounds(80, 110, 200, 30);

        TF_Nickname = new JTextField(Nickname);
        TF_Nickname.setBounds(300, 110, 200, 30);
        TF_Nickname.setColumns(20);

        label_email = new JLabel("Email ");
        label_email.setBounds(80, 150, 200, 30);

        TF_Email = new JTextField(Email);
        TF_Email.setBounds(300, 150, 200, 30);

        label_Password = new JLabel("Password ");
        label_Password.setBounds(80, 190, 200, 30);

        passwordfield = new JPasswordField(20);
        passwordfield.setBounds(300, 190, 200, 30);
        passwordfield.setColumns(20);
        
        chooseFile = new JButton("Choose File");
        chooseFile.setBounds(240, 250, 120, 30);
        chooseFile.addActionListener(this);

        button_Register = new JButton("Register");
        button_Register.setBounds(270, 300, 100, 30);
        button_Register.addActionListener(this);

        button_Login = new JButton("Back To Main Menu Screen");
        button_Login.setBounds(125, 300, 350, 30);
        button_Login.addActionListener(this);
        button_Login.setFocusPainted(false);
        button_Login.setBorderPainted(false);
        button_Login.setContentAreaFilled(false);
        button_Login.setOpaque(false);
        button_Login.setActionCommand("To Main Menu");
 
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(label_combobox1);
        panel.add(label_combobox2);
        panel.add(combobox);
        panel.setBounds(300, 70, 200, 100);
        frame.add(panel);

        frame.add(button_Register);
        frame.add(button_Login);

        frame.add(label_datadiri);
        frame.add(label_Username);
        frame.add(label_Nickname);
        frame.add(label_email);
        frame.add(label_Password);

        frame.add(TF_Nickname);
        frame.add(TF_Email);
        frame.add(passwordfield);
        frame.add(chooseFile);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
}
    
    @Override
    public void itemStateChanged(ItemEvent e)
    {
        if (e.getSource() == combobox) {
 
            label_combobox2.setText(combobox.getSelectedItem() + " selected");
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        switch (command) {
            case "Register":
                break;
            case "Choose File":
                choosePhotos = new JFileChooser();
                choosePhotos.showOpenDialog(null);
                photos = choosePhotos.getSelectedFile();
                pathPhotos = photos.getAbsolutePath();
                break;
            case "To Main Menu":
                frame.setVisible(false);
                new MainMenuScreen();
                break;
            default:
                break;
        }
    }
}