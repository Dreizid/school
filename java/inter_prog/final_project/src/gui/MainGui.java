package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import core.PersonClass;
import gui.Pages.CartPage;
import gui.Pages.ContactPage;
import gui.Pages.HomePage;
import gui.Pages.LoginPage;
import gui.Pages.OrdersPage;
import gui.Pages.StorePage;
import gui.Pages.TopPanel;

public class MainGui extends JFrame{
    private JPanel mainPanel,
                    homePanel,
                    storePanel,
                    cardPanel;
    
    private CardLayout cardLayout;

    private HomePage homePage;

    private StorePage storePage;

    private CartPage cartPage;

    private ContactPage contactPage;

    private OrdersPage ordersPage;


    boolean isAuthenticated = false;
    LoginPage loginPage;
    PersonClass user = new PersonClass("Rei", "Rei A. Example", "Example@email.com", "123", "+63 012-345-6789");
    TopPanel topPanel;

    public MainGui() {
        loginPage = new LoginPage(this);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void loadGui() {
        initComponents();
        setLayout();
        addListeners();
    }

    private void initComponents() {
        mainPanel = new JPanel();
        homePanel = new JPanel();
        storePanel = new JPanel();
        cardPanel = new JPanel();
        cardLayout = new CardLayout();
        homePage = HomePage.getInstance();
        topPanel = TopPanel.getInstance(cardLayout, cardPanel, user);
        storePage = new StorePage(user, topPanel);
        contactPage = ContactPage.getInstance();
        cartPage = CartPage.getInstance(user);
        ordersPage = OrdersPage.getInstance(user);
    }

    private void setLayout() {
        homePanel.setLayout(new BorderLayout());
        storePanel.setLayout(new BorderLayout());
        cardPanel.setLayout(cardLayout);
        mainPanel.setLayout(new BorderLayout());
        homePanel.add(homePage, BorderLayout.CENTER);
        storePanel.add(storePage, BorderLayout.CENTER);
        cardPanel.add(homePanel, "homePage");
        cardPanel.add(storePanel, "storePage");
        cardPanel.add(contactPage, "contactPage");
        cardPanel.add(cartPage, "cartPage");
        cardPanel.add(ordersPage, "ordersPage");
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(cardPanel, BorderLayout.CENTER);
        add(mainPanel);
    }

    public void autheticationSuccessful() {
        isAuthenticated = true;
        user = loginPage.getUser();
        loadGui();
        setVisible(true);
    }

    private void addListeners() {
        JButton cartButton = topPanel.getCartButton();
        cartButton.addActionListener(e -> {
            cartPage.reloadPage();
        });
        homePage.setListener(topPanel);
        homePage.setListener(storePage);
        topPanel.setListener(storePage);
        cartPage.setListener(topPanel);

        topPanel.getViewOrders().addActionListener(e -> {
            ordersPage.loadOrders();
        });
    }

    /*
     * TO DO:
     * Pass around the PersonClass to the panels that need to use it such as StorePage, CartPage, Profile?
     */
    

    public static void main(String[] args) {
        new MainGui();
    }
    
}
