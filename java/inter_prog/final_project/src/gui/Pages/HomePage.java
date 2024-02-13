package gui.Pages;
import javax.swing.*;
import java.awt.*;

public class HomePage extends JPanel{
    JPanel mainPanel;
    JPanel bottomPanel;
    JPanel categoriesLabelPanel;
    JPanel categoriesPanel;
    public HomePage() {
        setSize(1048, 500);
        setLayout(new BorderLayout());
        initializeHomePage();
    }

    public void initializeHomePage() {
        initializePanels();
        initializeBackground();
        initializeCategoryPart();
    }

    private void initializePanels() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        categoriesLabelPanel = new JPanel();
        categoriesLabelPanel.setLayout(new GridBagLayout());
        bottomPanel.add(categoriesLabelPanel, BorderLayout.NORTH);
        categoriesPanel = new JPanel();
        categoriesPanel.setLayout(new GridLayout(0, 3));
        bottomPanel.add(categoriesPanel, BorderLayout.CENTER);

        setBorder(BorderFactory.createEmptyBorder());
        add(new JScrollPane(mainPanel), BorderLayout.CENTER);
    }

    private void initializeBackground() {
        JLabel backgroundImage = new JLabel(new ImageIcon("src\\gui\\static\\images\\home_background.png"));
        mainPanel.add(backgroundImage, BorderLayout.CENTER);
    }

    private void initializeCategoryPart() {
        JLabel categoriesLabel = new JLabel("Categories");
        categoriesLabelPanel.add(categoriesLabel);

        // Fruits & Vegetables
        JButton fruitvegetableButton = new JButton("Fruit's & Vegetable");
        categoriesPanel.add(fruitvegetableButton);

        // Meat 
        JButton meatButton = new JButton("Meat");
        categoriesPanel.add(meatButton);

        // Fish
        JButton fishButton = new JButton("Fish");
        categoriesPanel.add(fishButton);
    }

    public static void main(String[] args) {
        HomePage homePage = new HomePage();
        homePage.initializeHomePage();
        homePage.setVisible(true);
    }
}
