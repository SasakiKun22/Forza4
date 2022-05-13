import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

public class DisegnaCerchi extends JPanel
{
    /*int n;
    DisegnaCerchi(int n)
    {
        this.n = n;
    }*/

    protected void paintComponent(Graphics g2)
    {
        super.paintComponent(g2);
        g2.setColor(Color.RED);
        drawCircles(g2, 50, 555, 47);
        repaint();
    }

    private void drawCircles(Graphics g, int centroX, int centroY, int raggio)
    {
        g.drawOval(centroX-raggio, centroY-raggio, 2*raggio, 2*raggio);
        g.fillOval(centroX-raggio, centroY-raggio, 2*raggio, 2*raggio);
    }
    
}
