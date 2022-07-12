import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Color;

public class CirclesPanel extends JPanel
{
    private int[][] matrix;

    /**
     * Draw the grid from the matrix.
     * @param matrix
     */
    public CirclesPanel(int[][] matrix)
    {
        this.matrix = matrix;
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponents(g);
        Color connect4 = new Color(56, 35, 249);
        g.setColor(connect4);
        g.drawRect(0, 0, 720, 640);
        g.fillRect(0, 0, 720, 640);
        for (int y = 0; y < 6; y++)
        {
            for (int x = 0; x < 7; x++)
            {
                if (this.matrix[y][x] == 1)
                {
                    g.setColor(Color.YELLOW);
                    drawCircles(g, 50 + x*101, 50 + y*101, 47);
                }

                else if (this.matrix[y][x] == 2)
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
    /**
     * Draws and fills the circle with the color to which it is set Graphics g.
     * @param g
     * @param centroX
     * @param centroY
     * @param raggio
     */
    private void drawCircles(Graphics g, int centroX, int centroY, int raggio)
    {
        g.drawOval(centroX-raggio, centroY-raggio, 2*raggio, 2*raggio);
        g.fillOval(centroX-raggio, centroY-raggio, 2*raggio, 2*raggio);
    }
}
