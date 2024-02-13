package gui.Pages;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.HashMap;

import javax.swing.*;
import core.*;


public class StorePage extends JPanel{
    JPanel itemsPanel;
    CardLayout cardLayout;
    HashMap<String, String> itemNames;
    HashMap<Integer, String> itemPrices;
    public StorePage() {
        setLayout(new BorderLayout());
        itemNames = new HashMap<String, String>();
        itemsPanel = new JPanel();
        cardLayout = new CardLayout();
        itemsPanel.setLayout(cardLayout);
        add(itemsPanel, BorderLayout.CENTER);
        initializeLeftPanel();
        loadMeatItems();
        loadFishItems();
        loadFruitItems();
        loadVegetableItems();
        setVisible(true);
    }

    public void initializeLeftPanel() {
        String[] categoryList = {"Fruit", "Vegetable", "Meat", "Fish", "All"};
        JPanel leftPanel = new JPanel();
        JComboBox categories = new JComboBox<>(categoryList);
        categories.addActionListener(e -> {
            switch ((String)categories.getSelectedItem()) {
                case "Fruit": {
                    cardLayout.show(itemsPanel, "fruit");
                    break;
                }
                case "Vegetable": {
                    cardLayout.show(itemsPanel, "vegetable");
                    break;
                }
                case "Meat": {
                    cardLayout.show(itemsPanel, "meat");
                    break;
                }
                case "Fish": {
                    cardLayout.show(itemsPanel, "fish");
                    break;
                }
            }
        });
        leftPanel.add(categories);
        leftPanel.setBackground(Color.GRAY);
        add(leftPanel, BorderLayout.WEST);
    }

    public void loadMeatItems() {
        int SPACE_BETWEEN = 15;
        JPanel meatPanel = new JPanel();
        meatPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        Insets inset = new Insets(SPACE_BETWEEN, SPACE_BETWEEN, SPACE_BETWEEN, SPACE_BETWEEN);
        gbc.insets = inset;
        for (int i = 0; i < Items.meatList.length; i++) {
            if (gbc.gridx == 2) {
                gbc.gridx = 0;
                gbc.gridy++;
                inset.left = SPACE_BETWEEN + 10;
                inset.right = SPACE_BETWEEN + 10;
            } else {
                gbc.gridx++;
            }
            MeatItem item = Items.meatList[i];
            ItemGui itemGui = new ItemGui(item);
            itemNames.put(item.itemName, "Meat");
            meatPanel.add(itemGui, gbc);
        }
        itemsPanel.add(new JScrollPane(meatPanel), "meat");
    }

    public void loadFishItems() {
        int SPACE_BETWEEN = 15;
        JPanel fishPanel = new JPanel();
        fishPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        Insets inset = new Insets(SPACE_BETWEEN, SPACE_BETWEEN, SPACE_BETWEEN, SPACE_BETWEEN);
        gbc.insets = inset;
        for (int i = 0; i < Items.fishList.length; i++) {
            if (gbc.gridx == 2) {
                gbc.gridx = 0;
                gbc.gridy++;
                inset.left = SPACE_BETWEEN + 10;
                inset.right = SPACE_BETWEEN + 10;
            } else {
                gbc.gridx++;
            }
            FishItem item = Items.fishList[i];
            ItemGui itemGui = new ItemGui(item);
            itemNames.put(item.itemName, "Fish");
            fishPanel.add(itemGui, gbc);
        }
        itemsPanel.add(new JScrollPane(fishPanel), "fish");
    }

    public void loadFruitItems() {
        int SPACE_BETWEEN = 15;
        JPanel fruitPanel = new JPanel();
        fruitPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        Insets inset = new Insets(SPACE_BETWEEN, SPACE_BETWEEN, SPACE_BETWEEN, SPACE_BETWEEN);
        gbc.insets = inset;
        for (int i = 0; i < Items.fruitList.length; i++) {
            if (gbc.gridx == 2) {
                gbc.gridx = 0;
                gbc.gridy++;
                inset.left = SPACE_BETWEEN + 10;
                inset.right = SPACE_BETWEEN + 10;
            } else {
                gbc.gridx++;
            }
            FruitItem item = Items.fruitList[i];
            ItemGui itemGui = new ItemGui(item);
            itemNames.put(item.itemName, "Fruit");
            fruitPanel.add(itemGui, gbc);
        }
        itemsPanel.add(new JScrollPane(fruitPanel), "fruit");
    }

    public void loadVegetableItems() {
        int SPACE_BETWEEN = 15;
        JPanel vegetablePanel = new JPanel();
        vegetablePanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        Insets inset = new Insets(SPACE_BETWEEN, SPACE_BETWEEN, SPACE_BETWEEN, SPACE_BETWEEN);
        gbc.insets = inset;
        for (int i = 0; i < Items.vegetableList.length; i++) {
            if (gbc.gridx == 2) {
                gbc.gridx = 0;
                gbc.gridy++;
                inset.left = SPACE_BETWEEN + 10;
                inset.right = SPACE_BETWEEN + 10;
            } else {
                gbc.gridx++;
            }
            VegetableItem item = Items.vegetableList[i];
            ItemGui itemGui = new ItemGui(item);
            itemNames.put(item.itemName, "Vegetable");
            vegetablePanel.add(itemGui, gbc);
        }
        itemsPanel.add(new JScrollPane(vegetablePanel), "vegetable");
    }

    public void loadByPrice(boolean reversed) {

    }

    public void loadByAlphaOrder(boolean reversed) {
        itemNames.forEach((key, value) -> {
            switch (value) {
                case "Meat": {
                    
                }
            }
        });
    }

    // private ItemGui findKey(String key) {
    //     return new ItemGui(new)
    // }

    public static void main(String[] args) {
        StorePage storePage = new StorePage();
        storePage.setVisible(true);
    }
}
