import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    private JTextField username;
    private JPasswordField password;
    private int loginAttempts = 3;

    public Login() {
        initializeComponents();
    }

    private void initializeComponents() {
        JPanel panel = new JPanel();
        JLabel usernameLabel = new JLabel("Username");
        JLabel passwordLabel = new JLabel("Password");

        username = new JTextField(15);
        password = new JPasswordField(15);

        // Action listener ofr login button
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onLoginButtonClick();
            }
        });

        // Addong components to panel
        panel.add(usernameLabel);
        panel.add(username);
        panel.add(passwordLabel);
        panel.add(password);
        panel.add(loginButton);

        add(panel);
        pack();
    }
    
    private void onLoginButtonClick() {
        String uname = username.getText();
        char[] passwordChars = password.getPassword();
        String pw = new String(passwordChars);

        // Perform authentication logic
        if (authenticate(uname, pw)) {
            JOptionPane.showMessageDialog(this, "Login successful!");
            Grading secondFrame = new Grading();
                // Make second frame visible
                secondFrame.show();
                secondFrame.setLocationRelativeTo(null);
                // Hide the current frame
                setVisible(false);
                loginAttempts = 3;
        } else {
            loginAttempts--;
            if (loginAttempts > 0) {
                JOptionPane.showMessageDialog(this, "Login failed, You have " + loginAttempts + "attempts left.");
            } else {
                JOptionPane.showMessageDialog(this, "Login attemps exceeded. Account locked.");
            }
        }

        password.setText("");
    }

    private boolean authenticate(String username, String password) {
        return username.equals("admin") && password.equals("admin123");
    }

    public static void main (String[] args) {
        Login mainframe = new Login();
        mainframe.setTitle("Login form");
        mainframe.setSize(260, 150);
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainframe.setLocationRelativeTo(null);
        mainframe.setVisible(true);
    }
}