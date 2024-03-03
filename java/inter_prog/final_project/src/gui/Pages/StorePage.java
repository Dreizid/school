package gui.Pages;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import java.util.ArrayList;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.swing.*;

import core.ItemClass;
import core.Items;
import core.PersonClass;
import gui.Components.ItemGui;
import gui.Components.ShopItem;

public class StorePage extends JPanel implements TopListener, HomeListener{
    private static StorePage instance;

    private static String[] categoryList = {"All", "Fruit", "Vegetable", "Meat", "Fish"};
    private static String[] sortByList = {"Alphabetical: A to Z", "Alphabetical: Z to A", "Price: Low to High", "Price: High to Low", "Default"};

    private TopPanel topPanel;

    private JPanel leftPanel;
    private JPanel pricePanel;
    private JPanel itemsPanel;

    @SuppressWarnings("rawtypes")
    private JComboBox categories;
    @SuppressWarnings("rawtypes")
    private JComboBox sortBy;

    private JTextField lowerPrice;
    private JTextField upperPrice;

    private JButton applyButton;

    private JScrollPane scrollPane;

    private ArrayList<ItemClass> alphaList,
                                priceList;

    private SortedMap<String, String> itemNames;
    private SortedMap<Double, String> itemPrices;

    private String selectedCategory;

    private Items itemList;
                                    
    int SPACE_BETWEEN = 30;
    CardLayout cardLayout;
    PersonClass user;
    
    private StorePage(PersonClass user, TopPanel topPanel, Items item) {
        this.user = user;
        this.topPanel = topPanel;
        this.itemList = item;
        setLayout(new BorderLayout());
        initializeMaps();
        initializeComponents();
        setLayout();
        addListeners();
        loadItems(Items.itemData);
        setVisible(true);
    }

    public static StorePage getInstance(PersonClass user, TopPanel topPanel, Items item) {
        if (instance == null) {
            instance = new StorePage(user, topPanel, item);
        }
        return instance;
    }

    private void initializeMaps() {
        itemNames = new TreeMap<>();
        itemPrices = new TreeMap<>();
    }

    private void initializeComponents() {
        leftPanel = new JPanel();
        itemsPanel = new JPanel();
        pricePanel = new JPanel();
        categories = new JComboBox<>(categoryList);
        sortBy = new JComboBox<>(sortByList);
        alphaList = new ArrayList<>();
        priceList = new ArrayList<>();
        applyButton = new JButton("Apply");
        lowerPrice = new JTextField(); 
        upperPrice = new JTextField();
        scrollPane = new JScrollPane(itemsPanel);
        selectedCategory = "All";
    }

    public void setLayout() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(10, 20, 10, 20);
        gbc.gridx = 0;
        leftPanel.setLayout(new GridBagLayout());
        categories.setFont(new Font("Open Sans MS", Font.PLAIN, 20));
        categories.setBorder(BorderFactory.createEmptyBorder());
        categories.setPreferredSize(new Dimension(300, 40));
        leftPanel.add(categories, gbc);

        gbc.gridx++;
        sortBy.setFont(new Font("Open Sans MS", Font.PLAIN, 20));
        sortBy.setBorder(BorderFactory.createEmptyBorder());
        sortBy.setPreferredSize(new Dimension(300, 40));
        leftPanel.add(sortBy, gbc);
        leftPanel.setBackground(new Color(224, 227, 213));

        itemsPanel.setLayout(new GridBagLayout());
        scrollPane.getVerticalScrollBar().setUnitIncrement(20);
        add(scrollPane, BorderLayout.CENTER);
        add(leftPanel, BorderLayout.NORTH);

        gbc.gridx++;
        pricePanel.setLayout(new GridLayout(0, 3));
        pricePanel.setBackground(new Color(224, 227, 213));
        pricePanel.setPreferredSize(new Dimension(300, 35));
        lowerPrice.setFont(new Font("Open Sans MS", Font.PLAIN, 20));
        upperPrice.setFont(new Font("Open Sans MS", Font.PLAIN, 20));
        pricePanel.add(lowerPrice);
        JLabel dashLabel = new JLabel("-");
        dashLabel.setFont(new Font("Arial", Font.PLAIN, 50));
        dashLabel.setHorizontalAlignment(SwingConstants.CENTER);
        pricePanel.add(dashLabel);
        pricePanel.add(upperPrice);
        leftPanel.add(pricePanel, gbc);

        gbc.gridx++;
        gbc.insets.top = 10;
        applyButton.setFont(new Font("Open Sans MS", Font.PLAIN, 20));
        applyButton.setPreferredSize(new Dimension(300, 35));
        leftPanel.add(applyButton, gbc);
        
    }

    private void addListeners() {
        categories.addActionListener(e -> {
            selectedCategory = (String) categories.getSelectedItem();
            loadCategory(selectedCategory);
        });

        sortBy.addActionListener(e -> {
            String sortingBy = (String) sortBy.getSelectedItem();
            switch (sortingBy) {
                case "Alphabetical: A to Z": {
                    loadAlphaOrder(false);
                    loadItems(alphaList);
                    break;
                }
                case "Alphabetical: Z to A": {
                    loadAlphaOrder(true);
                    loadItems(alphaList);
                    break;
                }
                case "Price: Low to High": {
                    loadByPrice(false);
                    loadItems(priceList);
                    break;
                }
                case "Price: High to Low": {
                    loadByPrice(true);
                    loadItems(priceList);
                    break;
                }
                case "Default": {
                    loadCategory(selectedCategory);
                    break;
                }
            }
        });

        applyButton.addActionListener(e -> {
            filterPrice(Double.valueOf(lowerPrice.getText()), Double.valueOf(upperPrice.getText()));
            loadItems(priceList);
        });
    }

    private void loadCategory(String category) {
        switch (category) {
            case "All": {
                loadItems(Items.itemData);
                break;
            }
            case "Fruit": {
                loadItems(Items.fruitList);
                break;
            }
            case "Vegetable": {
                loadItems(Items.vegetableList);
                break;
            }
            case "Meat": {
                loadItems(Items.meatList);
                break;
            }
            case "Fish": {
                loadItems(Items.fishList);
                break;
            }
        }
    }

    private void loadItems(ArrayList<ItemClass> list) {
        itemsPanel.removeAll();
        itemNames.clear();
        itemPrices.clear();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = 0;
        Insets inset = new Insets(SPACE_BETWEEN, SPACE_BETWEEN, SPACE_BETWEEN, SPACE_BETWEEN);
        gbc.insets = inset;
        for (int i = 0; i < list.size(); i++) {
            if (gbc.gridx == 4) {
                gbc.gridy++;
                gbc.gridx = 0;
            } else {
                gbc.gridx++;
            }
            ItemClass item = list.get(i);
            ShopItem itemGui = new ShopItem(item, user, itemList);
            itemGui.setUser(user);
            itemGui.setTopPanel(topPanel);
            setItemBackground(itemGui, item.getCategory());
            itemNames.put(item.getName(), item.getCategory());
            itemPrices.put(item.getPrice(), item.getName());
            itemsPanel.add(itemGui, gbc);
        }
        itemsPanel.repaint();
        itemsPanel.revalidate();
    }

    private void searchItem(String item) {
        itemsPanel.removeAll();
        ItemClass searchedItem = Items.loweredItems.get(item.toLowerCase());
        ShopItem itemGui = new ShopItem(searchedItem, user, itemList);
        itemGui.setUser(user);
        itemGui.setTopPanel(topPanel);
        setItemBackground(itemGui, searchedItem.getCategory());
        itemsPanel.add(itemGui);
        itemsPanel.repaint();
        itemsPanel.revalidate();
    }

    private void setItemBackground(ItemGui item, String category) {
        Color meatColor = new Color(255, 253, 208);
        Color fishColor = new Color(151, 209, 246);
        Color fruitAndVeggyColor = new Color(195, 193, 241);
        switch (category) {
            case "Meat":
                item.changeBackground(meatColor);
                break;
            case "Fish":
                item.changeBackground(fishColor);
                break;
            case "Fruit":
                item.changeBackground(fruitAndVeggyColor);
                break;
            case "Vegetable":
                item.changeBackground(fruitAndVeggyColor);
                break;
        }
    }

    public void loadByPrice(boolean reversed) {
        priceList.clear();
        if (reversed) {
            itemPrices.forEach((key, value) -> {
                priceList.add(0, Items.items.get(value));
            });
        } else {
            itemPrices.forEach((key, value) -> {
                priceList.add(Items.items.get(value));
            });
        }
    }

    public void loadAlphaOrder(boolean reversed) {
        alphaList.clear();
        if (reversed) {
            itemNames.forEach((key, value) -> {
                alphaList.add(0, Items.items.get(key));
            });
        } else {
            itemNames.forEach((key, value) -> {
                alphaList.add(Items.items.get(key));
            });
        }
    }

    private void filterPrice(double lower, double upper) {
        priceList.clear();
        itemPrices.forEach((key, value) -> {
            if (key > lower && key < upper) {
                priceList.add(Items.items.get(value));
            } 
        });
    }

    public void setTopPanel(TopPanel panel) {
        this.topPanel = panel;
    }

    public void setUser(PersonClass user) {
        this.user = user;
    }

    @Override
    public void searchButtonPressed(String text) {
        searchItem(text);
    }

    @Override
    public void fishButtonClicked() {
        loadItems(Items.fishList);
    }

    @Override
    public void meatButtonClicked() {
        System.out.println("hello from store");
        loadItems(Items.meatList);
    }

    @Override
    public void fruitButtonClick() {
        loadItems(Items.fruitList);
    }
}
