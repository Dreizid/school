package gui.Pages;

import javax.swing.*;
import javax.swing.text.MaskFormatter;

import core.PersonClass;
import core.Users;
import gui.widgets.RoundJButton;

import java.awt.*;

public class RegistrationPage extends JFrame{
    private static RegistrationPage instance;

    protected JFormattedTextField nameField,
                                phoneField;
    
    public RegistrationPage() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setSize(1048, 550);
        setLayout(new BorderLayout());
        initializeRight();
        initializeLeft();
        setVisible(true);
    }

    public static RegistrationPage getInstance() {
        if (instance == null) {
            instance = new RegistrationPage();
        }
        return instance;
    }

    public void initializeRight() {
        JLabel backgroundImage = new JLabel(new ImageIcon("src\\gui\\static\\images\\registration_background.png"));
        add(backgroundImage, BorderLayout.EAST);
    }

    public void initializeLeft() {
        /*
         * TO DO:
         * Left align the labels
         * limit phone number to integers; optional - have a formatted textfield
         * add sign up and back buttons; back - return to login page, sign up - pop up dialogue to inform user registered and return to login page
         */
        Color backgroundColor = new Color(208,241,193);
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new GridBagLayout());
        leftPanel.setBackground(backgroundColor);

        // Gridbagcons
        GridBagConstraints labelgbc = new GridBagConstraints();
        labelgbc.gridx = 0;
        labelgbc.gridy = 0;
        labelgbc.gridwidth = 2;
        labelgbc.anchor = GridBagConstraints.WEST;
        labelgbc.insets = new Insets(15, 0, 0, 30);
        GridBagConstraints fieldgbc = new GridBagConstraints();
        fieldgbc.gridx = 0;
        fieldgbc.gridy = 0;
        fieldgbc.gridwidth = 2;
        fieldgbc.anchor = GridBagConstraints.WEST;
        

        // Username field
        JLabel usernameLabel = new JLabel("Username");
        JTextField usernameField = new JTextField(17);
        leftPanel.add(usernameLabel, labelgbc);
        fieldgbc.gridy = labelgbc.gridy + 1;
        leftPanel.add(usernameField, fieldgbc);

        // Name field
        JLabel nameLabel = new JLabel("Name");
        try {
            MaskFormatter formatter = new MaskFormatter(repeatCharacter('*', 61));
            formatter.setValidCharacters(".- abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
            nameField = new JFormattedTextField(formatter);
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        labelgbc.gridy += 2;
        leftPanel.add(nameLabel, labelgbc);
        fieldgbc.gridy = labelgbc.gridy + 1;
        leftPanel.add(nameField, fieldgbc);

        // Email field
        JLabel emailLabel = new JLabel("Email address");
        JTextField emailField = new JTextField(17);
        labelgbc.gridy += 2;
        leftPanel.add(emailLabel, labelgbc);
        fieldgbc.gridy = labelgbc.gridy + 1;
        leftPanel.add(emailField, fieldgbc);

        // Phone field
        /*
         * TO DO:
         * turn black when focus in / when replacing the placeholder text
         */
        JLabel phoneLabel = new JLabel("Phone number");
        try {
            MaskFormatter formatter = new MaskFormatter("+## ###-###-####");
            formatter.setPlaceholder("+63 012-345-6789");
            phoneField = new JFormattedTextField(formatter);
            phoneField.setForeground(Color.GRAY);
            phoneField.setColumns(17);
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        labelgbc.gridy += 2;
        leftPanel.add(phoneLabel, labelgbc);
        fieldgbc.gridy = labelgbc.gridy + 1;
        leftPanel.add(phoneField, fieldgbc);

        // Password field
        JLabel passwordLabel = new JLabel("Password");
        JTextField passwordField = new JTextField(17);
        labelgbc.gridy += 2;
        leftPanel.add(passwordLabel, labelgbc);
        fieldgbc.gridy = labelgbc.gridy + 1;
        leftPanel.add(passwordField, fieldgbc);

        // Confirm password field
        JLabel confirmPasswordLabel = new JLabel("Confirm password");
        JTextField confirmPasswordField = new JTextField(17);
        labelgbc.gridy += 2;
        leftPanel.add(confirmPasswordLabel, labelgbc);
        fieldgbc.gridy = labelgbc.gridy + 1;
        leftPanel.add(confirmPasswordField, fieldgbc);

        // Buttons
        RoundJButton signUpButton = new RoundJButton("Sign up", 20, Color.GREEN);
        signUpButton.addActionListener(e -> {
            if (passwordField.getText().equals(confirmPasswordField.getText())) {
                Users.users.add(new PersonClass(usernameField.getText(), nameField.getText().trim(), emailField.getText(), passwordField.getText(), phoneField.getText()));
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Password's don't match", "Error", JOptionPane.WARNING_MESSAGE);
            }
        });
        signUpButton.setBackground(Color.GREEN);
        labelgbc.gridy += 2;
        leftPanel.add(signUpButton, labelgbc);
        RoundJButton backButton = new RoundJButton("Back", 20, Color.GRAY);
        backButton.addActionListener(e -> {
            dispose();
        });
        backButton.setBackground(Color.GRAY);
        labelgbc.anchor = GridBagConstraints.EAST;
        labelgbc.gridx = 1;
        leftPanel.add(backButton, labelgbc);

        add(leftPanel, BorderLayout.CENTER);
        
    }

    private String repeatCharacter(char character, int n) {
        return new String(new char[n]).replace('\0', character);
    }
}
