package gui.Pages;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.*;

import gui.widgets.RoundedCornerPanel;

public class ContactPage extends JPanel{
    private static ContactPage instance;

    private Color textColor = Color.WHITE;
    private Color backgroundColor = Color.BLACK;

    private Font textFont = new Font("Arial", Font.PLAIN, 20);

    private static ImageIcon backgroundImage = new ImageIcon("src\\gui\\static\\images\\contact_page\\contact_logo.png");
    private static ImageIcon locationIcon = new ImageIcon("src\\gui\\static\\images\\contact_page\\location_icon.png");
    private static ImageIcon contactIcon = new ImageIcon("src\\gui\\static\\images\\contact_page\\contact_icon.png");
    private static ImageIcon emailIcon = new ImageIcon("src\\gui\\static\\images\\contact_page\\email_icon.png");
    private static ImageIcon websiteIcon = new ImageIcon("src\\gui\\static\\images\\contact_page\\website_icon.png");

    private JPanel logoPanel;
    private JPanel contactPanel;
    
    private JLabel backgroundPanel;
    private JLabel titleLabel;
    private JLabel addressLabel;
    private JLabel contactNumberLabel;
    private JLabel emailLabel;
    private JLabel websiteLabel;

    private RoundedCornerPanel informationPanel;

    private GridBagConstraints gbc;

    private ContactPage() {
        setLayout(new GridLayout(0, 2));
        initComponents();
        setLayout();
    }

    public static ContactPage getInstance() {
        if (instance == null) {
            instance = new ContactPage();
        }
        return instance;
    }

    private void initComponents() {
        logoPanel = new JPanel();
        backgroundPanel = new JLabel(backgroundImage);
        contactPanel = new JPanel();
        informationPanel = new RoundedCornerPanel(25);
        titleLabel = new JLabel("Contact Us");
        addressLabel = new JLabel("<HTML>" + "123 Anywhere St.<br>Imus City, ST 12345" + "</HTML>");
        contactNumberLabel = new JLabel("123-456-7890");
        emailLabel = new JLabel("shop2go@gmail.com");
        websiteLabel = new JLabel("www.shop2go.com");
        gbc = new GridBagConstraints();
    }

    private void setLayout() {
        /*
         * TO DO:
         * Add the chat icon?
         */
        logoPanel.setLayout(new BorderLayout());
        logoPanel.add(backgroundPanel, BorderLayout.CENTER);
        add(logoPanel);

        backgroundPanel.setPreferredSize(new Dimension(getWidth() / 2, 0));

        contactPanel.setLayout(new GridBagLayout());
        add(contactPanel);

        informationPanel.setBackground(backgroundColor);
        informationPanel.setLayout(new GridBagLayout());
        contactPanel.add(informationPanel);

        GridBagConstraints titlegbc = new GridBagConstraints();
        titlegbc.gridy = 0;
        titlegbc.gridx = 0;
        titlegbc.gridwidth = 2;
        titlegbc.insets = new Insets(30, 30, 20, 125);
        gbc.insets = new Insets(10, 30, 10, 0);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 50));
        titleLabel.setForeground(textColor);
        informationPanel.add(titleLabel, titlegbc);

        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridy = 1;
        addressLabel.setFont(textFont);
        addressLabel.setIcon(locationIcon);
        addressLabel.setIconTextGap(40);
        addressLabel.setForeground(textColor);
        informationPanel.add(addressLabel, gbc);

        gbc.gridy++;
        informationPanel.add(createSeperator(), gbc);

        gbc.gridy++;
        contactNumberLabel.setFont(textFont);
        contactNumberLabel.setIcon(contactIcon);
        contactNumberLabel.setIconTextGap(40);
        contactNumberLabel.setForeground(textColor);
        informationPanel.add(contactNumberLabel, gbc);

        gbc.gridy++;
        informationPanel.add(createSeperator(), gbc);

        gbc.gridy++;
        emailLabel.setForeground(textColor);
        emailLabel.setIcon(emailIcon);
        emailLabel.setIconTextGap(20);
        emailLabel.setFont(textFont);
        informationPanel.add(emailLabel, gbc);

        gbc.gridy++;
        informationPanel.add(createSeperator(), gbc);

        gbc.gridy++;
        websiteLabel.setFont(textFont);
        websiteLabel.setIcon(websiteIcon);
        websiteLabel.setIconTextGap(35);
        websiteLabel.setForeground(textColor);
        informationPanel.add(websiteLabel, gbc);

        gbc.gridy++;
        gbc.insets.bottom = 40;
        informationPanel.add(createSeperator(), gbc);

    }

    private JSeparator createSeperator() {
        JSeparator seperator = new JSeparator(JSeparator.HORIZONTAL);
        seperator.setForeground(backgroundColor);
        seperator.setPreferredSize(new Dimension(300, 1));
        seperator.setBorder(BorderFactory.createDashedBorder(textColor, 5,1));
        return seperator;
    }
}
