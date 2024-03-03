package gui.Pages;

import javax.swing.*;

import gui.widgets.RoundJTextField;

import java.awt.*;

public class ProfilePage extends JPanel {
    private static ProfilePage instance;

    protected JPanel profilePanel,
                    namePanel,
                    informationPanel;

    protected JLabel profileLabel;
    
    protected ImageIcon profileIcon;

    protected RoundJTextField emailAddressField,
                            addressField;

    protected JFormattedTextField numberField;

    protected JTextField fullNameField;

    protected JButton applyChangesButton;

    protected JFileChooser fileChooser;

    protected ProfilePage() {

    }

    public ProfilePage getInstance() {
        if (instance == null) {
            instance = new ProfilePage();
        }
        return instance;
    }

    private void initComponents() {
        profileLabel = new JLabel();
        profileIcon = new ImageIcon();

        emailAddressField = new RoundJTextField(10, 8);
        addressField = new RoundJTextField(10, 8);

        numberField = new JFormattedTextField();

        fullNameField = new JTextField();

        
    }

    private void setLayout() {

    }
} 
