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
        background = new JLabel(new ImageIcon("gui\\login_background.png"));
        background.setLayout(new BorderLayout());
        initializeBorders();
        initialize();
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
    public void initialize () {
        Font signInLabelFont = new Font("Arial", Font.BOLD, 60);
        loginPanel = new RoundedCornerPanel(20);
        loginPanel.setLayout(null);
        loginPanel.setBackground(Color.WHITE);
        JLabel signInLabel = new JLabel("SIGN IN"); 
        signInLabel.setFont(signInLabelFont);
        signInLabel.setBounds(90, 25, 226, 100);
        loginPanel.add(signInLabel);
        background.add(loginPanel, BorderLayout.CENTER);
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
