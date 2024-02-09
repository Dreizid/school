import javax.swing.*;
import java.awt.*;

public class HomePage extends TopPart{
    JPanel mainPanel;
    JPanel bottomPanel;
    JPanel categoriesLabelPanel;
    JPanel categoriesPanel;
    public HomePage() {
        super();
        setSize(1058, 500);

    }

    public void initilizeHomePage() {
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

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(mainPanel);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void initializeBackground() {
        JLabel backgroundImage = new JLabel(new ImageIcon("gui\\home_background.png"));
        mainPanel.add(backgroundImage, BorderLayout.CENTER);
    }

    private void initializeCategoryPart() {
        JLabel categoriesLabel = new JLabel("Categories");
        categoriesLabelPanel.add(categoriesLabel);

        // Fruits & Vegetables
        JButton fruitvegetableButton = new JButton();
        categoriesPanel.add(fruitvegetableButton);

        // Meat 
        JButton meatButton = new JButton();
        categoriesPanel.add(meatButton);

        // Fish
        JButton fishButton = new JButton();
        categoriesPanel.add(fishButton);
    }

    public static void main(String[] args) {
        HomePage homePage = new HomePage();
        homePage.initilizeHomePage();
        homePage.setVisible(true);
    }
}
