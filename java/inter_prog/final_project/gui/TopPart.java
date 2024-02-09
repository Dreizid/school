import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class TopPart extends JFrame {
    JPanel mainPanel;
    JTextField searchField;
    public TopPart() {
        mainPanel = new JPanel();
        JLabel emptyLabel = new JLabel(" ");
        emptyLabel.setFont(new Font("Arial" , Font.PLAIN, 100));
        mainPanel.setLayout(new FlowLayout());
        mainPanel.add(emptyLabel);
        mainPanel.setBackground(new Color(224, 227, 213));
        setLayout(new BorderLayout());
        add(mainPanel, BorderLayout.NORTH);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initialize();
    }    

    public void initialize() {
        String TEXT_FIELD_TEXT = "Search";
        ImageIcon logo = new ImageIcon("gui\\logo.png");
        JLabel logoLabel = new JLabel(logo);
        mainPanel.add(logoLabel);

        JButton homeButton = new JButton("Home");
        homeButton.addActionListener(e -> {
        });
        mainPanel.add(homeButton);

        JButton shopButton = new JButton("Shop");
        mainPanel.add(shopButton);

        JButton contactButton = new JButton("Contact");
        mainPanel.add(contactButton);

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
        mainPanel.add(searchField);

        JButton searchButton = new JButton();

    }
}
