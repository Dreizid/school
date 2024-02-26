package gui.Pages;
import javax.swing.*;

import java.util.ArrayList;

import com.formdev.flatlaf.FlatLightLaf;

import java.awt.*;

interface HomeListener {
    void fishButtonClicked();
    void meatButtonClicked();
    void fruitButtonClick();
}
public class HomePage extends JPanel{
    private static HomePage instance;

    private ArrayList<HomeListener> listener;

    private static final ImageIcon BACKGROUND_IMAGE = new ImageIcon("src\\gui\\static\\images\\home_background.png");
    private static final ImageIcon MEAT_ICON = new ImageIcon("src\\gui\\static\\images\\meatIcon.png"),
                                    FISH_ICON = new ImageIcon("src\\gui\\static\\images\\fishIcon.png"),
                                    FRUIT_ICON = new ImageIcon("src\\gui\\static\\images\\fruitIcon.png");

    private JPanel mainPanel,
                    bottomPanel;

    private JPanel categoriesLabelPanel;
    private JPanel categoriesPanel;

    private JButton fruitvegetableButton;
    private JButton meatButton;
    private JButton fishButton;

    private JLabel backgroundPanel;

    private HomePage() {
        /*
         * TO DO:
         * Add text to the background image - DONE
         * - Blur the background?
         * - Add a panel behind text?
         * 
         * Remove button backgrounds - DONE
         * Add ImageIcons to the buttons - DONE
         * 
         * Make methods to retrive the buttons - CHANGED TO INTERFACE
         */
        setSize(1048, 500);
        setLayout(new BorderLayout());
        initComponents();
        setLayout();
        addListeners();
    }

    public static HomePage getInstance() {
        if (instance == null) {
            instance = new HomePage();
        }
        return instance;
    }

    private void initComponents() {
        mainPanel = new JPanel();
        bottomPanel = new JPanel();
        categoriesLabelPanel = new JPanel();
        categoriesPanel = new JPanel();
        backgroundPanel = new JLabel(BACKGROUND_IMAGE);
        fruitvegetableButton = new JButton();
        meatButton = new JButton();
        fishButton = new JButton();
        listener = new ArrayList<>();
    }

    private void setLayout() {
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        mainPanel.add(backgroundPanel, BorderLayout.CENTER);

        backgroundPanel.setLayout(null);

        JLabel homePageTitle = new JLabel("<html>FRESH & ORGANIC<br>FOOD MARKET</hmtl>"); // Pa ayos font size and font pati color naren
        JLabel homePageText = new JLabel("<html>WE'LL PROVIDE<br>EVERYTHING<br>YOU NEED</html>"); // Pa ayos font size and font pati color naren
        homePageText.setHorizontalAlignment(SwingConstants.LEFT);
        homePageText.setBounds(10, 500, 100, 100); // Pa edit
        homePageTitle.setHorizontalAlignment(SwingConstants.LEFT);
        homePageTitle.setBounds(10, 400, 100, 100); // Pa edit
        backgroundPanel.add(homePageTitle); 
        backgroundPanel.add(homePageText);

        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.add(categoriesLabelPanel, BorderLayout.NORTH);
        bottomPanel.add(categoriesPanel, BorderLayout.CENTER);

        categoriesLabelPanel.setLayout(new GridBagLayout());
        
        categoriesPanel.setLayout(new GridLayout(0, 3));

        JLabel categoriesLabel = new JLabel("Categories");
        categoriesLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        categoriesLabel.setForeground(new Color(147, 197, 114));
        categoriesLabelPanel.add(categoriesLabel);

        fruitvegetableButton.setIcon(FRUIT_ICON);
        fruitvegetableButton.setText("Fruits & Vegetables");
        fruitvegetableButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        fruitvegetableButton.setHorizontalTextPosition(SwingConstants.CENTER);
        fruitvegetableButton.setBackground(Color.WHITE);
        fruitvegetableButton.setOpaque(false);
        fruitvegetableButton.setFocusPainted(false);
        categoriesPanel.add(fruitvegetableButton);

        meatButton.setIcon(MEAT_ICON);
        meatButton.setText("Meat");
        meatButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        meatButton.setHorizontalTextPosition(SwingConstants.CENTER);
        meatButton.setBackground(Color.WHITE);
        meatButton.setOpaque(false);
        meatButton.setFocusPainted(false);
        categoriesPanel.add(meatButton);
        
        fishButton.setIcon(FISH_ICON);
        fishButton.setText("Fish");
        fishButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        fishButton.setHorizontalTextPosition(SwingConstants.CENTER);
        fishButton.setBackground(Color.WHITE);
        fishButton.setOpaque(false);
        fishButton.setFocusPainted(false);
        categoriesPanel.add(fishButton);

        meatButton.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 1, Color.BLACK));
        fruitvegetableButton.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.BLACK));
        fishButton.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.BLACK));
        
        setBorder(BorderFactory.createEmptyBorder());
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(40);
        add(scrollPane, BorderLayout.CENTER);

        try {
            UIManager.setLookAndFeel(new FlatLightLaf()); // or FlatLightLaf()
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

    }

    private void addListeners() {
        meatButton.addActionListener(e -> {
            if (listener != null) {
                for (HomeListener listen: listener) {
                    listen.meatButtonClicked();
                }
            }
        });

        fishButton.addActionListener(e -> {
            if (listener != null) {
                for (HomeListener listen: listener) {
                    listen.fishButtonClicked();
                }
            }
        });

        fruitvegetableButton.addActionListener(e -> {
            if (listener != null) {
                for (HomeListener listen: listener) {
                    listen.fruitButtonClick();
                }
            }
        });
    }

    public void setListener(HomeListener listener) {
        this.listener.add(listener);
    }

    public static void main(String[] args) {
        HomePage homePage = HomePage.getInstance();
        homePage.setVisible(true);
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.add(homePage);    
    }
    
}