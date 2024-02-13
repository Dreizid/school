package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

import core.Cart;
import gui.Pages.CartPage;
import gui.Pages.ContactPage;
import gui.Pages.HomePage;
import gui.Pages.StorePage;
import gui.Pages.TopPart;

public class MainGui extends JFrame{
    public MainGui() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JScrollPane scrollPane = new JScrollPane();
        JPanel mainPanel = new JPanel();
        JPanel homePanel = new JPanel();
        homePanel.setLayout(new BorderLayout());
        JPanel storePanel = new JPanel();
        storePanel.setLayout(new BorderLayout());
        JPanel cardPanel = new JPanel();
        setSize(1058, 600);
        CardLayout cardLayout = new CardLayout();
        cardPanel.setLayout(cardLayout);
        mainPanel.setLayout(new BorderLayout());
        HomePage homePage = new HomePage();
        StorePage storePage = new StorePage();
        ContactPage contactPage = new ContactPage();
        CartPage cartPage = new CartPage();
        TopPart topPart = new TopPart(cardLayout, cardPanel);
        homePanel.add(new TopPart(cardLayout, cardPanel), BorderLayout.NORTH);
        homePanel.add(homePage, BorderLayout.CENTER);
        storePanel.add(new TopPart(cardLayout, cardPanel), BorderLayout.NORTH);
        storePanel.add(storePage, BorderLayout.CENTER);
        JScrollPane scrollStore = new JScrollPane(storePanel);
        JScrollPane scrollHome = new JScrollPane(homePanel);
        cardPanel.add(scrollHome, "homePage");
        cardPanel.add(storePanel, "storePage");
        cardPanel.add(contactPage, "contactPage");
        cardPanel.add(cartPage, "cartPage");
        // mainPanel.add(topPart, BorderLayout.NORTH);
        mainPanel.add(cardPanel, BorderLayout.CENTER);


        setVisible(true);

        add(mainPanel);
    }

    public static void main(String[] args) {
        MainGui mainGui = new MainGui();
    }
    
}
