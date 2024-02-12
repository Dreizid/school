package gui.Pages;
import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class TopPart extends JPanel {
    JPanel topPanel;
    JTextField searchField;
    public TopPart() {
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
        setBackground(new Color(224, 227, 213));
    }

    public void initialize() {
        String TEXT_FIELD_TEXT = "Search";
        ImageIcon logo = new ImageIcon("gui\\resources\\logo.png");
        JLabel logoLabel = new JLabel(logo);
        add(logoLabel);

        JButton homeButton = new JButton("Home");
        homeButton.addActionListener(e -> {
        });
        add(homeButton);

        JButton shopButton = new JButton("Shop");
        add(shopButton);

        JButton contactButton = new JButton("Contact");
        add(contactButton);

        searchField = new JTextField(TEXT_FIELD_TEXT, 20);
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

    public static void main(String[] args) {
        TopPart topPart = new TopPart();
    }
}
