package Pages;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.*;

import swing.RoundJButton;

public class StorePage extends JFrame{
    public StorePage() {
        setLayout(new GridBagLayout());
        RoundJButton test = new RoundJButton("Test", 20);
        setSize(400, 400);
        add(test);
        setVisible(true);
    }

    public static void main(String[] args) {
        StorePage storePage = new StorePage();
    }
}