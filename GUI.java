import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Forza4: G1 vs G2");
        frame.setSize(720, 720);
        //frame.getContentPane().setBackground(Color.blue);
        frame.add(new CirclesPanel());
        frame.setVisible(true);
    }
}