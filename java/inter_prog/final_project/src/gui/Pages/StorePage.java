package gui.Pages;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.*;
import java.lang.Math;
import core.*;

import gui.widgets.RoundJButton;

public class StorePage extends JPanel{
    JPanel itemsPanel;
    public StorePage() {
        setLayout(new BorderLayout());
        initializeLeftPanel();
        loadMeatItems();
        setVisible(true);
    }

    public void initializeLeftPanel() {
        String[] categoryList = {"Fruit", "Vegetable", "Meat", "Fish"};
        JPanel leftPanel = new JPanel();
        JComboBox categories = new JComboBox<>(categoryList);
        categories.addActionListener(e -> {
            switch ((String)categories.getSelectedItem()) {
                case "Fruit": {
                    System.out.println("Fruit");
                }
                case "Vegetable": {

                }
            }
        });
        leftPanel.add(categories);
        leftPanel.setBackground(Color.GRAY);
        add(leftPanel, BorderLayout.WEST);
    }

    public void loadMeatItems() {
        double COLUMNS = 3;
        double ROWS = 5; // Math.ceil(Items.meatList.length / COLUMNS);
        int SPACE_BETWEEN = 15;
        itemsPanel = new JPanel();
        itemsPanel.setLayout(new GridBagLayout());
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
            ItemGui itemGui = new ItemGui(Items.meatList[i]);
            itemsPanel.add(itemGui, gbc);
        }
        add(new JScrollPane(itemsPanel), BorderLayout.CENTER);
    }

    public void loadFishItems() {

    }

    public void loadFruitItems() {

    }

    public void loadVegetableItems() {
        
    }

    public static void main(String[] args) {
        StorePage storePage = new StorePage();
        storePage.setVisible(true);
    }
}
