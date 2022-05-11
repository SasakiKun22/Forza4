import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.geom.Ellipse2D;

public class CirclesPanel extends JPanel
{
    /*public void ProvaFrame() 
    {
        JPanel panel = new JPanel();
        Color bluForza4 = new Color(56, 35, 249);
        panel.setBackground(bluForza4);
        setSize(722, 618);
        
    }*/


    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Color bluForza4 = new Color(56, 35, 249);
        g.setColor(bluForza4);
        g.drawRect(0, 0, 720, 640);
        g.fillRect(0, 0, 720, 640);
        for (int j = 50; j <= 606; j+=101)
        {
            for (int i = 50; i <= 707; i+=101 )
            {
              g.setColor(Color.white);  
              drawCircles(g, i, j, 47);  
            }   
        }
    }

    private void drawCircles(Graphics g, int centroX, int centroY, int raggio)
    {
        g.drawOval(centroX-raggio, centroY-raggio, 2*raggio, 2*raggio);
        g.fillOval(centroX-raggio, centroY-raggio, 2*raggio, 2*raggio);
    }
}
