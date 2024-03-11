package gui.Pages;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import core.PersonClass;

import java.awt.*;

public class ProfilePage extends JPanel {
    private static ProfilePage instance;

    private static int IMAGE_SIZE = 300;

    private static Color backgroundColor = Color.WHITE;

    protected JPanel profilePanel,
                    namePanel,
                    topPanel,
                    bottomPanel,
                    informationPanel,
                    fieldsPanel,
                    emptyPanel;

    protected JPanel applyChangesPanel,
                    editPanel,
                    cardPanel;

    protected JLabel profileLabel;
    
    protected ImageIcon profileIcon;

    protected JTextField emailAddressField,
                            addressField,
                            usernameField;

    protected JFormattedTextField numberField;

    protected JTextField fullNameField;

    protected JButton applyChangesButton,
                    editButton;

    protected CardLayout cardLayout;

    protected JFileChooser fileChooser;

    protected PersonClass user;

    public ProfilePage(PersonClass user) {
        this.user = user;
        initComponents();
        setLayout();
        addListeners();
    }

    public static ProfilePage getInstance(PersonClass user) {
        if (instance == null) {
            instance = new ProfilePage(user);
        }
        return instance;
    }

    private void initComponents() {
        profileIcon = new ImageIcon(user.getPicture());
        profileLabel = new JLabel(profileIcon);
        
        usernameField = new JTextField(15);
        usernameField.setText(user.getUsername());

        emailAddressField = new JTextField(15);
        emailAddressField.setText(user.getEmail());
        addressField = new JTextField(10);

        fullNameField = new JTextField(15);
        System.out.println(user.getFullName());
        fullNameField.setText(user.getFullName());

        applyChangesButton = new JButton("Apply changes");
        editButton = new JButton("Edit");

        profilePanel = new JPanel();
        topPanel = new JPanel();
        namePanel = new JPanel();
        bottomPanel = new JPanel();
        informationPanel = new JPanel();
        fieldsPanel = new JPanel();
        emptyPanel = new JPanel();

        cardLayout = new CardLayout();
        editPanel = new JPanel();
        applyChangesPanel = new JPanel();
        cardPanel = new JPanel();
        cardPanel.setLayout(cardLayout);
    }

    private void setLayout() {
        Font font = new Font("Open Sans MS", Font.PLAIN, 30);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));

        try {
            MaskFormatter formatter = new MaskFormatter("+## ###-###-####");
            formatter.setPlaceholder(user.getNumber());
            numberField = new JFormattedTextField(formatter);
            numberField.setColumns(15);
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }

        fullNameField.setEditable(false);
        usernameField.setEditable(false);
        emailAddressField.setEditable(false);
        numberField.setEditable(false);

        profilePanel.setPreferredSize(new Dimension(IMAGE_SIZE, IMAGE_SIZE));
        profilePanel.setLayout(new GridBagLayout());
        profilePanel.add(profileLabel);
        topPanel.add(profilePanel);

        namePanel.setLayout(new GridBagLayout());
        GridBagConstraints namegbc = new GridBagConstraints();
        namegbc.anchor = GridBagConstraints.WEST;
        namegbc.weightx = 1;
        fullNameField.setFont(new Font("Open Sans MS", Font.BOLD, 80));
        fullNameField.setBorder(BorderFactory.createEmptyBorder());
        fullNameField.setHorizontalAlignment(SwingConstants.LEFT);
        namePanel.add(fullNameField, namegbc);
        namePanel.setPreferredSize(new Dimension(1480, 300));
        topPanel.add(namePanel);

        add(topPanel);

        informationPanel.setLayout(new GridLayout(0, 2));
        informationPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        GridBagConstraints tempgbc = new GridBagConstraints();
        tempgbc.weightx = 1;
        tempgbc.weighty = 1;
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(30, 30, 30, 30);
        gbc.gridy = 0;
        gbc.gridx = 0;
        TitledBorder titledUsernameBorder = BorderFactory.createTitledBorder("Username");
        titledUsernameBorder.setTitleFont(new Font("Open Sans MS", Font.PLAIN, 18));
        fieldsPanel.setLayout(new GridBagLayout());
        fieldsPanel.add(usernameField, gbc);
        usernameField.setBorder(titledUsernameBorder);
        usernameField.setFont(font);
        gbc.gridx = 1;
        fieldsPanel.add(emailAddressField, gbc);
        TitledBorder titledEmailBorder = BorderFactory.createTitledBorder("Email");
        titledEmailBorder.setTitleFont(new Font("Open Sans MS", Font.PLAIN, 18));
        emailAddressField.setBorder(titledEmailBorder);
        emailAddressField.setFont(font);
        gbc.gridx = 0;
        gbc.gridy = 1;
        fieldsPanel.add(numberField, gbc);
        TitledBorder titledNumberBorder = BorderFactory.createTitledBorder("Phone number");
        titledNumberBorder.setTitleFont(new Font("Open Sans MS", Font.PLAIN, 18));
        numberField.setFont(font);
        numberField.setBorder(titledNumberBorder);
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.weightx = 1;
        editButton.setFont(font);
        editButton.setPreferredSize(new Dimension(400, 40));
        editPanel.add(editButton);
        applyChangesButton.setFont(font);
        applyChangesButton.setPreferredSize(new Dimension(400, 40));
        applyChangesPanel.add(applyChangesButton);
        cardPanel.add(editPanel, "edit");
        cardPanel.add(applyChangesPanel, "apply");
        fieldsPanel.add(cardPanel, gbc);
        informationPanel.add(fieldsPanel);
        informationPanel.add(emptyPanel);
        bottomPanel.setLayout(new GridBagLayout());
        bottomPanel.add(informationPanel, tempgbc);
        bottomPanel.setPreferredSize(new Dimension(1920, 500));
        add(bottomPanel);

        setPanelBackground(backgroundColor);
    }

    private void addListeners() {
        editButton.addActionListener(e -> {
            fullNameField.setEditable(true);
            usernameField.setEditable(true);
            emailAddressField.setEditable(true);
            numberField.setEditable(true);
            cardLayout.show(cardPanel, "apply");
        });
        applyChangesButton.addActionListener(e -> {
            user.setFullName(fullNameField.getText());
            user.setUsername(usernameField.getText());
            user.setEmail(emailAddressField.getText());
            user.setNumber(numberField.getText());
            fullNameField.setEditable(false);
            usernameField.setEditable(false);
            emailAddressField.setEditable(false);
            numberField.setEditable(false);
            cardLayout.show(cardPanel, "edit");
        });
    }

    public void setPanelBackground(Color color) {
        backgroundColor = color;
        profilePanel.setBackground(backgroundColor);
        namePanel.setBackground(backgroundColor);
        fullNameField.setBackground(backgroundColor);
        bottomPanel.setBackground(backgroundColor);
        informationPanel.setBackground(backgroundColor);
        fieldsPanel.setBackground(backgroundColor);
        emptyPanel.setBackground(backgroundColor);
        usernameField.setBackground(backgroundColor);
        emailAddressField.setBackground(backgroundColor);
        numberField.setBackground(backgroundColor);
        cardPanel.setBackground(backgroundColor);
        applyChangesPanel.setBackground(backgroundColor);
        editPanel.setBackground(backgroundColor);
    }

    public void setUser(PersonClass user) {
        this.user = user;
    }
} 
