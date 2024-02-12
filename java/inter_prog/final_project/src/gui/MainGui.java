package gui;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import gui.Pages.HomePage;
import gui.Pages.TopPart;

public class MainGui extends JFrame{
    public MainGui() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JScrollPane scrollPane = new JScrollPane();
        JPanel mainPanel = new JPanel();
        setSize(1057, 600);
        TopPart topPart = new TopPart();
        HomePage homePage = new HomePage();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(topPart, BorderLayout.NORTH);
        mainPanel.add(homePage, BorderLayout.CENTER);
        setVisible(true);
        scrollPane.setViewportView(mainPanel);
        scrollPane.setBorder(null);
        add(scrollPane);
    }

    public static void main(String[] args) {
        MainGui mainGui = new MainGui();
    }
    
}
