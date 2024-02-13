package gui.Pages;
import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class TopPart extends JPanel {
    CardLayout cardLayout;
    JPanel parentPanel;
    JPanel topPanel;
    JTextField searchField;
    String currentPage;
    Color backgroundColor = new Color(224, 227, 213);
    public TopPart(CardLayout card, JPanel panel) {
        cardLayout = card;
        parentPanel = panel;
        currentPage = "home";
        initializeTopPanel();
        initialize();
        setVisible(true);
    } 
    
    public void initializeTopPanel() {
        topPanel = new JPanel();
        JLabel emptyLabel = new JLabel(" ");
        emptyLabel.setPreferredSize(new Dimension(0, 100));
        setLayout(new FlowLayout());
        add(emptyLabel);
        setBackground(backgroundColor);
    }

    public void initialize() {
        String TEXT_FIELD_TEXT = "Search";
        ImageIcon logo = new ImageIcon("src\\gui\\static\\images\\logo.png");
        JLabel logoLabel = new JLabel(logo);
        add(logoLabel);

        JButton homeButton = new JButton("Home");
        homeButton.setBackground(backgroundColor);
        homeButton.setBorder(null);
        homeButton.setFocusPainted(false);
        homeButton.addActionListener(e -> {
            cardLayout.show(parentPanel, "homePage");
        });
        add(homeButton);

        JButton storeButton = new JButton("Shop");
        storeButton.addActionListener(e -> {
            cardLayout.show(parentPanel, "storePage");

        });
        add(storeButton);

        JButton contactButton = new JButton("Contact");
        contactButton.addActionListener(e -> {
            cardLayout.show(parentPanel, "contactPage");

        });
        add(contactButton);

        searchField = new JTextField(TEXT_FIELD_TEXT, 10);
        searchField.setForeground(Color.GRAY);
        searchField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                String currentText = searchField.getText();
                if (currentText.equals(TEXT_FIELD_TEXT)) {
                    searchField.setText("");
                    searchField.setForeground(Color.BLACK);
                } else {
                    searchField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                String currentText = searchField.getText();
                if (currentText.isEmpty()) {
                    searchField.setForeground(Color.GRAY);
                    searchField.setText(TEXT_FIELD_TEXT);
                }
            }
        });
        add(searchField);

        JButton searchButton = new JButton();

    }
}
