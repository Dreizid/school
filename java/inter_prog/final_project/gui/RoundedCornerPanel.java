import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundedCornerPanel extends JPanel {
    private int cornerRadius;

    public RoundedCornerPanel(int cornerRadius) {
        this.cornerRadius = cornerRadius;
        // Ensure that the panel is transparent
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Create a rounded rectangle shape
        RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float(
                0, 0, getWidth() - 1, getHeight() - 1, cornerRadius, cornerRadius);

        Graphics2D g2d = (Graphics2D) g.create();

        // Set rendering hints for smoother edges
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        // Set the background color of the panel
        g2d.setColor(getBackground());

        // Fill the rounded rectangle with the panel's background color
        g2d.fill(roundedRectangle);

        // Dispose the graphics context
        g2d.dispose();
    }
}
