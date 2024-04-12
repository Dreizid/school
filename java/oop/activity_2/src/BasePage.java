import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class BasePage extends JPanel{
    protected abstract void initComponents();
    protected abstract void loadLayout();
    protected abstract void addListeners(); 
}