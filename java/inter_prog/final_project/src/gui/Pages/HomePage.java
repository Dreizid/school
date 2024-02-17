package gui.Pages;
import javax.swing.*;
import java.awt.*;

public class HomePage extends JPanel{
    private static HomePage instance;

    private static ImageIcon BACKGROUND_IMAGE;

    private JPanel mainPanel;
    private JPanel bottomPanel;
    private JPanel categoriesLabelPanel;
    private JPanel categoriesPanel;

    private JButton fruitvegetableButton;
    private JButton meatButton;
    private JButton fishButton;

    private JLabel backgroundPanel;

    private HomePage() {
        /*
         * TO DO:
         * Add text to the background image
         * - Blur the background?
         * - Add a panel behind text?
         * 
         * Remove button backgrounds
         * Add ImageIcons to the buttons
         * 
         * Make methods to retrive the buttons
         */
        setSize(1048, 500);
        setLayout(new BorderLayout());
        initComponents();
        setLayout();
    }

    public static HomePage getInstance() {
        if (instance == null) {
            instance = new HomePage();
        }
        return instance;
    }

    public void initializeHomePage() {

    }

    private void initComponents() {
        BACKGROUND_IMAGE = new ImageIcon("src\\gui\\static\\images\\home_background.png");
        mainPanel = new JPanel();
        bottomPanel = new JPanel();
        categoriesLabelPanel = new JPanel();
        categoriesPanel = new JPanel();
        backgroundPanel = new JLabel(BACKGROUND_IMAGE);
        fruitvegetableButton = new JButton("Fruit's & Vegetable");
        meatButton = new JButton("Meat");
        fishButton = new JButton("Fish");
    }

    private void setLayout() {
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        mainPanel.add(backgroundPanel, BorderLayout.CENTER);

        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.add(categoriesLabelPanel, BorderLayout.NORTH);
        bottomPanel.add(categoriesPanel, BorderLayout.CENTER);

        categoriesLabelPanel.setLayout(new GridBagLayout());
        
        categoriesPanel.setLayout(new GridLayout(0, 3));

        JLabel categoriesLabel = new JLabel("Categories");
        categoriesLabelPanel.add(categoriesLabel);

        categoriesPanel.add(fruitvegetableButton);
        categoriesPanel.add(meatButton);
        categoriesPanel.add(fishButton);
        
        setBorder(BorderFactory.createEmptyBorder());
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(40);
        add(scrollPane, BorderLayout.CENTER);

    }

    public static void main(String[] args) {
        HomePage homePage = new HomePage();
        homePage.initializeHomePage();
        homePage.setVisible(true);
    }
}
