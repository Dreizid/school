package gui.Pages;

import javax.swing.*;

import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import core.PersonClass;
import gui.widgets.BadgeButton;

interface TopListener {
    void searchButtonPressed(String text);
}

public class TopPanel extends JPanel implements CartListener, HomeListener{
    private static TopPanel instance;

    private static final Font FONT = new Font("Arial", Font.PLAIN, 30);

    private static final Color SELECTED_PAGE_COLOR = new Color(0, 100, 0); // 34, 139, 34
    private static final Color BACKGROUND_COLOR = new Color(224, 227, 213);

    private static final ImageIcon TOP_LOGO = new ImageIcon("src\\gui\\static\\images\\logo.png");
    private static final ImageIcon CART_ICON = new ImageIcon("src\\gui\\static\\images\\cart.png");
    private static final ImageIcon CART_SELECTED_ICON = new ImageIcon("src\\gui\\static\\images\\cartopen.png");

    private static final String SEARCH_FIELD_TEXT = "Search";

    private CardLayout cardLayout;

    private TopListener listener;

    private JPanel parentPanel;

    private JTextField searchField;
    private JTextField balanceField;
    
    private JButton homeButton;
    private JButton storeButton;
    private JButton contactButton;
    private JButton searchButton;
    private JButton walletButton;
    private JButton profileButton;

    private BadgeButton cartButton;


    private JPopupMenu walletMenu;
    private JPopupMenu profileMenu;

    private JMenuItem walletAddBalance;
    private JMenuItem viewOrder;
    private JMenuItem viewInformation;
    private JMenuItem logOut;

    private PersonClass user;

    private TopPanel(CardLayout card, JPanel panel, PersonClass user) {
        this.cardLayout = card;
        this.parentPanel = panel;
        this.user = user;
        initComponents();
        setLayout();
        addListeners();
    } 

    public static TopPanel getInstance(CardLayout card, JPanel panel, PersonClass user) {
        if (instance == null) {
            instance = new TopPanel(card, panel, user);
        }
        return instance;
    }

    private void initComponents() {
        homeButton = new JButton("Home");
        storeButton = new JButton("Shop");
        contactButton = new JButton("Contact");
        searchField = new JTextField(SEARCH_FIELD_TEXT, 10);
        searchButton = new JButton(new ImageIcon("src\\gui\\static\\images\\search.png"));
        cartButton = new BadgeButton();
        walletMenu= new JPopupMenu();
        walletAddBalance = new JMenuItem("Add balance");
        walletButton = new JButton(new ImageIcon("src\\gui\\static\\images\\wallet.png"));
        profileMenu = new JPopupMenu();
        viewInformation = new JMenuItem("View information");
        viewOrder = new JMenuItem("View order's");
        logOut = new JMenuItem("Log out");
        ImageIcon profileIcon = new ImageIcon(user.getPicture());
        Image scaledImage = profileIcon.getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);
        ImageIcon scaledProfileIcon = new ImageIcon(scaledImage);
        profileButton = new JButton(scaledProfileIcon);
    }

    private void setLayout() {
        /*
         * TO DO:
         * Improve the design and colors
         */
        JLabel topLogoLabel = new JLabel(TOP_LOGO);
        add(topLogoLabel);
        add(Box.createHorizontalStrut(100));

        homeButton.setFont(FONT);
        homeButton.setBackground(BACKGROUND_COLOR);
        homeButton.setForeground(SELECTED_PAGE_COLOR);
        homeButton.setContentAreaFilled(false);
        homeButton.setBorder(null);
        homeButton.setFocusPainted(false);
        add(homeButton);
        add(Box.createHorizontalStrut(45));

        storeButton.setFont(FONT);
        storeButton.setBackground(BACKGROUND_COLOR);
        storeButton.setContentAreaFilled(false);
        storeButton.setBorder(null);
        storeButton.setFocusPainted(false);
        add(storeButton);
        add(Box.createHorizontalStrut(45));

        contactButton.setFont(FONT);
        contactButton.setBackground(BACKGROUND_COLOR);
        contactButton.setContentAreaFilled(false);
        contactButton.setBorder(null);
        contactButton.setFocusPainted(false);
        add(contactButton);
        add(Box.createHorizontalStrut(45));

        searchField.setForeground(Color.GRAY);
        searchField.setFont(new Font("Arial", Font.PLAIN, 23));
        searchField.setBorder(BorderFactory.createEmptyBorder());
        searchField.setBackground(BACKGROUND_COLOR);

        searchButton.setBorder(BorderFactory.createEmptyBorder());
        searchButton.setBackground(BACKGROUND_COLOR); 

        JPanel searchPanel = new JPanel();
        searchPanel.setBackground(BACKGROUND_COLOR);
        searchPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        searchPanel.setLayout(new GridBagLayout());
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        add(searchPanel);
        add(Box.createHorizontalStrut(45));

        cartButton.setIcon(CART_ICON);
        cartButton.setBadgeColor(new Color(200, 100, 100));
        cartButton.setText("0");
        // cartButton.setBorder(BorderFactory.createEmptyBorder(15, 13, 10, 11));
        add(cartButton);
        add(Box.createHorizontalStrut(25));

        walletMenu.add(loadBalance());
        walletMenu.add(walletAddBalance);
        walletButton.setBackground(BACKGROUND_COLOR);
        walletButton.setBorder(BorderFactory.createEmptyBorder());
        add(walletButton); 
        add(Box.createHorizontalStrut(25));

        profileMenu.add(viewInformation);
        profileMenu.add(viewOrder);
        profileMenu.add(logOut);

        profileButton.setBackground(BACKGROUND_COLOR);
        profileButton.setBorder(BorderFactory.createEmptyBorder());
        add(profileButton);
        add(Box.createHorizontalStrut(25));

        setPreferredSize(new Dimension(1058, 150));
        setLayout(new GridBagLayout());
        setBackground(BACKGROUND_COLOR);
        setVisible(true);
    }

    private void addListeners() {
        homeButton.addActionListener(e -> {
            homeButton.setForeground(SELECTED_PAGE_COLOR);
            storeButton.setForeground(Color.BLACK);
            contactButton.setForeground(Color.BLACK);
            cartButton.setIcon(CART_ICON);
            cardLayout.show(parentPanel, "homePage");
        });

        storeButton.addActionListener(e -> {
            homeButton.setForeground(Color.BLACK);
            storeButton.setForeground(SELECTED_PAGE_COLOR);
            contactButton.setForeground(Color.BLACK);
            cartButton.setIcon(CART_ICON);
            cardLayout.show(parentPanel, "storePage");

        });

        contactButton.addActionListener(e -> {
            homeButton.setForeground(Color.BLACK);
            storeButton.setForeground(Color.BLACK);
            contactButton.setForeground(SELECTED_PAGE_COLOR);
            cartButton.setIcon(CART_ICON);
            cardLayout.show(parentPanel, "contactPage");

        });

        searchField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                String currentText = searchField.getText();
                if (currentText.equals(SEARCH_FIELD_TEXT)) {
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
                    searchField.setText(SEARCH_FIELD_TEXT);
                }
            }
        });

        searchButton.addActionListener(e -> {
            if (listener != null) {
                listener.searchButtonPressed(searchField.getText());
                cardLayout.show(parentPanel, "storePage");
            }
        });

        cartButton.addActionListener(e -> {
            homeButton.setForeground(Color.BLACK);
            storeButton.setForeground(Color.BLACK);
            contactButton.setForeground(Color.BLACK);
            cartButton.setIcon(CART_SELECTED_ICON);
            cardLayout.show(parentPanel,"cartPage");
        });

        walletButton.addActionListener(e -> {
            if (e.getSource() == walletButton) {
                walletMenu.show(walletButton, 0, walletButton.getHeight());
                balanceField.setText("₱ " + String.format("%.2f", this.user.getWallet().getBalance()));
            }
        });

        walletAddBalance.addActionListener(e -> {
            openAddBalanceFrame(user);
        });

        viewOrder.addActionListener(e -> {
            cardLayout.show(parentPanel, "ordersPage");
        });

        profileButton.addActionListener(e -> {
            if (e.getSource() == profileButton) {
                profileMenu.show(profileButton, 0, profileButton.getHeight());
            }
        });

        viewInformation.addActionListener(e -> {
            cardLayout.show(parentPanel, "profilePage");
        });

        logOut.addActionListener(e -> {

        });
    }


    private static void openAddBalanceFrame(PersonClass user) {
        JFrame newFrame = new JFrame("Add balance");
        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JButton add1k = new JButton("Add 1,000");
        add1k.addActionListener(e -> {
            user.getWallet().addBalance(1000);
        });
        JButton add10k = new JButton("Add 10,000");
        add10k.addActionListener(e -> {
            user.getWallet().addBalance(10000);
        });
        JButton clear = new JButton("Remove Balance");
        clear.addActionListener(e -> {
            user.getWallet().subtractBalance(user.getWallet().getBalance());
        });

        JPanel panel = new JPanel();
        panel.add(add1k);
        panel.add(add10k);
        panel.add(clear);

        newFrame.getContentPane().add(panel, BorderLayout.CENTER);

        newFrame.pack();
        newFrame.setLocationRelativeTo(null);
        newFrame.setVisible(true);
    }

    private JPanel loadBalance() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        JLabel text = new JLabel("Balance: ");
        text.setBackground(Color.WHITE);
        balanceField = new JTextField("₱ " + String.format("%.2f", this.user.getWallet().getBalance()));
        balanceField.setEditable(false); 
        panel.add(text);
        panel.add(balanceField);
        return panel;
    }

    public String getSearchedItem() {
        return searchField.getText();
    }

    public JButton getSearchButton() {
        return this.searchButton;
    }

    public JButton getCartButton() {
        return this.cartButton;
    }

    public JMenuItem getViewOrders() {
        return this.viewOrder;
    }

    public JMenuItem getLogOut() {
        return this.logOut;
    }

    public void setUser(PersonClass user) {
        this.user = user;
    }

    public void setListener(TopListener listener) {
        this.listener = listener;
    }

    @Override
    public void purchaseEvent() {
        cartButton.setText("0");
    }

    @Override
    public void fishButtonClicked() {
        storeButton.doClick();
    }

    @Override
    public void meatButtonClicked() {
        storeButton.doClick();
    }

    @Override
    public void fruitButtonClick() {
        storeButton.doClick();
    }
} 
