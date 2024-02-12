package Pages;
import swing.*;
import javax.swing.*;
import java.awt.*;

public class LoginPage extends JFrame{
    private int WIDTH = 1200;
    private int HEIGHT = 800;
    JPanel loginPanel;
    JLabel background;

    JLabel NORTH;
    JLabel SOUTH;
    JLabel EAST;
    JLabel WEST;
    public LoginPage () {
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        background = new JLabel(new ImageIcon("gui\\resources\\login_background.png"));
        background.setLayout(new BorderLayout());
        initializeBorders();
        initializeText();
        initializeTextField();
        initializeTextFieldLabel();
        initializeButtons();
        add(background);
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
        Font signInLabelFont = new Font("Arial", Font.BOLD, 60);
        loginPanel = new RoundedCornerPanel(20);
        loginPanel.setLayout(null);
        loginPanel.setBackground(Color.RED);
        JLabel signInLabel = new JLabel("SIGN IN"); 
        signInLabel.setFont(signInLabelFont);
        signInLabel.setBounds(90, 25, 226, 100);
        loginPanel.add(signInLabel);
        background.add(loginPanel, BorderLayout.CENTER);
    }

    public void initializeTextField() {
        Font fieldFont = new Font("Arial", Font.PLAIN, 35);
        RoundJTextField usernameField = new RoundJTextField(20, 45);
        RoundJTextField passwordField = new RoundJTextField(20, 45);
        usernameField.setFont(fieldFont);
        usernameField.setBounds(40, 40, 226, 40); // Papalitan; 1st is x 2nd is y
        passwordField.setFont(fieldFont);
        passwordField.setBounds(40, 100, 226, 40); // Papalitan; 1st is x 2nd is y
        loginPanel.add(usernameField);
        loginPanel.add(passwordField);
    }

    public void initializeTextFieldLabel() {
        Font labelFont = new Font("Arial", Font.PLAIN, 35); // Papalitan
        JLabel usernameLabel = new JLabel("Username");
        JLabel passwordLabel = new JLabel("Password");
        usernameLabel.setFont(labelFont);
        usernameLabel.setBounds(40, 200, 226, 40); // Papalitan;
        loginPanel.add(usernameLabel);
        passwordLabel.setFont(labelFont);
        passwordLabel.setBounds(40, 300, 226, 40); // Papalitan;
        loginPanel.add(passwordLabel);
    }

    public void initializeButtons() {
        JCheckBox rememberBox = new JCheckBox("Remember me?");
        rememberBox.setBounds(40, 500, 226, 40); // Papalitan;
        loginPanel.add(rememberBox);
        RoundJButton signInButton = new RoundJButton("Sign in");
        signInButton.setBounds(40, 400, 226, 40); // Papalitan;
        loginPanel.add(signInButton);
        JButton signUpButton = new JButton("Sign up");
        signUpButton.setBounds(40, 350, 226, 40); // Papalitan;
        loginPanel.add(signUpButton);
    }

    public String[] loginEvent () {
        String[] temp = new String[1];
        return temp;
    }


    public static void main(String[] args) {
        LoginPage login = new LoginPage();
        login.setVisible(true);
    }
}
