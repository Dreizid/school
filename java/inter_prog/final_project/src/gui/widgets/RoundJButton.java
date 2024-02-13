package gui.widgets;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JButton;


public class RoundJButton extends JButton {
    private Shape shape;
    private int arch;
    private Color borderColor;
    public RoundJButton(String name, int arch, Color bordercolor) {
        super(name); 
        this.borderColor = bordercolor;
        this.arch = arch;       
        setOpaque(false);
    }
    protected void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, arch, arch);
        super.paintComponent(g);
    }
    protected void paintBorder(Graphics g) {
        g.setColor(borderColor);
        g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, arch, arch);
    }
    public boolean contains(int x, int y) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, arch, arch);
        }
        return shape.contains(x, y);
    }

}

