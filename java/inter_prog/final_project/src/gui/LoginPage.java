package gui;

import javax.swing.*;

import core.Items;
import core.PersonClass;
import core.Users;

import gui.Pages.MainGui;
import gui.Pages.RegistrationPage;
import gui.widgets.*;
import java.awt.*;
import java.util.Arrays;
public class LoginPage extends JFrame{
    private int WIDTH = 1200;
    private int HEIGHT = 800;

    MainGui mainGui;
    RoundJTextField usernameField;
    RoundJPasswordField passwordField;
    JPanel loginPanel;
    JLabel background;

    JLabel NORTH;
    JLabel SOUTH;
    JLabel EAST;
    JLabel WEST;

    PersonClass person;

    Items itemList = new Items();
    public LoginPage () {
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        background = new JLabel(new ImageIcon("src\\gui\\static\\images\\login_background.png"));
        background.setLayout(new BorderLayout());
        initializeBorders();
        initializeText();
        initializeTextField();
        initializeTextFieldLabel();
        initializeButtons();
        add(background);
        setVisible(true);
    }
    public void initializeBorders() {
        NORTH = new JLabel(" ");
        SOUTH = new JLabel(" ");
        WEST = new JLabel(" ");
        EAST = new JLabel(" ");
        NORTH.setPreferredSize(new Dimension(0 ,75));
        SOUTH.setPreferredSize(new Dimension(0 ,75));
        WEST.setPreferredSize(new Dimension(700 ,0));
        EAST.setPreferredSize(new Dimension(75 ,0));
        background.add(SOUTH, BorderLayout.SOUTH);
        background.add(NORTH, BorderLayout.NORTH);      
        background.add(EAST, BorderLayout.EAST);
        background.add(WEST, BorderLayout.WEST);
    }

    public void initializeText() {
        Font signInLabelFont = new Font("Open Sans MS", Font.BOLD, 60);
        loginPanel = new RoundedCornerPanel(20);
        loginPanel.setLayout(null);
        loginPanel.setBackground(Color.WHITE);
        JLabel signInLabel = new JLabel("SIGN IN"); 
        signInLabel.setFont(signInLabelFont);
        signInLabel.setBounds(90, 25, 226, 100);
        loginPanel.add(signInLabel);
        background.add(loginPanel, BorderLayout.CENTER);
    }

    public void initializeTextField() {
        Font fieldFont = new Font("Open Sans MS", Font.PLAIN, 35);
        usernameField = new RoundJTextField(20, 45);
        passwordField = new RoundJPasswordField(20, 45);
        usernameField.setFont(fieldFont);
        usernameField.setBounds(35, 180, 347, 50); // okay na
        usernameField.setBackground(Color.LIGHT_GRAY);
        passwordField.setFont(fieldFont);
        passwordField.setBounds(35, 270, 347, 50); // okay na
        passwordField.setBackground(Color.LIGHT_GRAY);
        loginPanel.add(usernameField);
        loginPanel.add(passwordField);
    }

    public void initializeTextFieldLabel() {
        Font labelFont = new Font("Open Sans MS",Font.PLAIN, 17); // okay na
        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setFont(new Font("Open Sans MS", Font.PLAIN, 10));
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Open Sans MS", Font.PLAIN, 20));
        usernameLabel.setFont(labelFont);
        usernameLabel.setBounds(40, 140, 226, 40); // okay na
        loginPanel.add(usernameLabel);
        passwordLabel.setFont(labelFont);
        passwordLabel.setBounds(40, 230, 226, 40); // okay na
        loginPanel.add(passwordLabel);
    }

    public void initializeButtons() {
        Color LOG_IN_BUTTON_COLOR = new Color(46, 139, 87);
        JCheckBox rememberBox = new JCheckBox("Remember me?");
        rememberBox.setFont(new Font("Open Sans MS", Font.PLAIN, 17));
        rememberBox.setBounds(40, 320, 226, 40); // okay
        rememberBox.setBackground(Color.WHITE);
        loginPanel.add(rememberBox);
        RoundJButton signInButton = new RoundJButton("Log in", 50, LOG_IN_BUTTON_COLOR);
        signInButton.addActionListener(e -> {
            if (isAdmin()) {

            } else if (authenticate()) {
                setVisible(false);
                System.out.println(getUser().getFullName());
                MainGui mainGui = new MainGui(itemList, getUser(), this);
                mainGui.autheticationSuccessful();
                mainGui.setVisible(true);
            }
        });
        signInButton.setBounds(90, 370, 226, 70); // okay
        signInButton.setFont(new Font("Open Sans MS", Font.PLAIN, 30));
        signInButton.setForeground(Color.WHITE);
        signInButton.setBorderPainted(false);
        signInButton.setContentAreaFilled(false);
        signInButton.setFocusPainted(false);
        signInButton.setBackground(LOG_IN_BUTTON_COLOR); 
        loginPanel.add(signInButton);
        JButton signUpButton = new JButton("Sign up");
        signUpButton.setContentAreaFilled(false);
        signUpButton.setFocusPainted(false);
        signUpButton.addActionListener(e -> {
            RegistrationPage registrationPage = new RegistrationPage();
        });
        signUpButton.setBounds(160, 500, 90, 50); // okay
        signUpButton.setBorderPainted(false);
        loginPanel.add(signUpButton);
        signUpButton.setBackground(Color.WHITE);
    }

    private boolean authenticate() {
        char[] enteredPassword = passwordField.getPassword();
        String enteredPasswordString = new String(enteredPassword);
        for (PersonClass person: Users.users) {
            if (usernameField.getText().equals(person.getUsername()) && enteredPasswordString.equals(person.getPassword())) {
                Arrays.fill(enteredPassword, ' ');
                loginEvent(person);
                return true;
            }
        } 
        Arrays.fill(enteredPassword, ' ');
        return false;
    }

    private boolean isAdmin() {
        char[] enteredPassword = passwordField.getPassword();
        String enteredPasswordString = new String(enteredPassword);
        if (usernameField.getText().equals("admin") && enteredPasswordString.equals("admin123")) {
            Arrays.fill(enteredPassword, ' ');
            return true;
        }
        Arrays.fill(enteredPassword, ' ');
        return false;
    }

    public void loginEvent(PersonClass user) {
        person = user;
    }

    public PersonClass getUser() {
        return this.person;
    }

    public static void main(String[] args) {
        new LoginPage();
    }

}