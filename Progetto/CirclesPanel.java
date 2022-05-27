import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Color;

public class CirclesPanel extends JPanel
{
    int[][] matrice;

    CirclesPanel(int[][] matrice)
    {
        this.matrice = matrice;
    }

    protected void paintComponent(Graphics g)
    {
        super.paintComponents(g);
        Color bluForza4 = new Color(56, 35, 249);
        g.setColor(bluForza4);
        g.drawRect(0, 0, 720, 640);
        g.fillRect(0, 0, 720, 640);
        for (int y = 0; y < 6; y++)
        {
            for (int x = 0; x < 7; x++)
            {
                if (this.matrice[y][x] == 1)
                {
                    g.setColor(Color.YELLOW);
                    drawCircles(g, 50 + x*101, 50 + y*101, 47);
                }

                else if (this.matrice[y][x] == 2)
                {
                    g.setColor(Color.RED);
                    drawCircles(g, 50 + x*101, 50 + y*101, 47);
                }

                else
                {
                    g.setColor(Color.WHITE);
                    drawCircles(g, 50 + x*101, 50 + y*101, 47);
                }
            }
        }
    }

    private void drawCircles(Graphics g, int centroX, int centroY, int raggio)
    {
        g.drawOval(centroX-raggio, centroY-raggio, 2*raggio, 2*raggio);
        g.fillOval(centroX-raggio, centroY-raggio, 2*raggio, 2*raggio);
    }
}
