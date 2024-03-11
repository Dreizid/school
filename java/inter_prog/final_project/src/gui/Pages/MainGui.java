package gui.Pages;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import gui.LoginPage;
import core.Items;
import core.PersonClass;

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

    private ProfilePage profilePage;

    private Items itemList;

    private PersonClass user;

    boolean isAuthenticated = false;
    private LoginPage parent;
    // PersonClass user = new PersonClass("Rei", "Rei A. Example", "Example@email.com", "123", "+63 012-345-6789");
    TopPanel topPanel;

    public MainGui(Items itemList, PersonClass user, LoginPage parent) {
        this.itemList = itemList;
        this.user = user;
        this.parent = parent;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // loadGui();
        // setVisible(true);
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
        homePage = new HomePage();
        topPanel = new TopPanel(cardLayout, cardPanel, user);
        storePage = new StorePage(user, topPanel, itemList);
        contactPage = ContactPage.getInstance();
        cartPage = new CartPage(user, itemList);
        ordersPage = new OrdersPage(user);
        profilePage = new ProfilePage(user);
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
        cardPanel.add(profilePage, "profilePage");
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(cardPanel, BorderLayout.CENTER);
        add(mainPanel);
    }

    public void autheticationSuccessful() {
        isAuthenticated = true;
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

        topPanel.getLogOut().addActionListener(e -> {
            logOut();
        });
    }

    private void logOut() {
        dispose();
        parent.setVisible(true);
    }

    /*
     * TO DO:
     * Pass around the PersonClass to the panels that need to use it such as StorePage, CartPage, Profile?
     */
    

    
}
