import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bottoni extends JFrame implements ActionListener
{
    JFrame frame;
    JLayeredPane layerPane;
    JButton b1;
    JButton b2;
    JButton b3;
    JButton b4;
    JButton b5;
    JButton b6;
    JButton b7;

    Bottoni()
    {   
        layerPane = new JLayeredPane();
        layerPane.setSize(720, 740);
        frame = new JFrame("Forza4: G1 vs G2");
        frame.setSize(720, 740);
        //frame.getContentPane().setBackground(Color.blue);
        frame.setContentPane(new CirclesPanel());
        //frame.setLayout(null);
        frame.setVisible(true);
        
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");

        b1.setBounds(3, 650, 95, 50);
        b2.setBounds(104, 650, 95, 50);
        b3.setBounds(205, 650, 95, 50);
        b4.setBounds(306, 650, 95, 50);
        b5.setBounds(407, 650, 95, 50);
        b6.setBounds(508, 650, 95, 50);
        b7.setBounds(609, 650, 95, 50);

        b1.addActionListener(this);
        b2.addActionListener(this);
        
        frame.add(b1);
        frame.add(b2);
        frame.add(b3);
        frame.add(b4);
        frame.add(b5);
        frame.add(b6);
        frame.add(b7);
        frame.setLayout(null);
        //layerPane.add(frame, 1);

    }

    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == b1)
        {
            //JPanel frame2 = new JPanel();
            DisegnaCerchi cerchio = new DisegnaCerchi();
            //frame2.add(cerchio);
            layerPane.add(cerchio, 0);
            frame.add(layerPane);
            frame.setVisible(true);
            System.out.println("Ciao");
        }
    }
}
