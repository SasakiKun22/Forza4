import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;


public class DrawFrame extends JFrame implements ActionListener{

    
    JButton exit;
    JTextArea drawArea;
    Color bronze = new Color(205,127,50);


    DrawFrame() 
    {
        
        exit = new JButton("EXIT");

        setSize(new Dimension(500, 300));
        setTitle("DRAW");
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        setBackground(bronze);
        setVisible(true);
        exit.setBounds(210,200,80,40);
        add(exit);
        exit.addActionListener(this);

        drawArea = new JTextArea("     THE MATCH\n     ENDED IN A\n        DRAW");
        drawArea.setEditable(false);
        drawArea.setBounds(0,0,500,300);
        drawArea.setBackground(bronze);
        drawArea.setForeground(Color.white);
        drawArea.setFont(new Font("MV Boli", Font.BOLD, 43));
        add(drawArea);  
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exit) {
            System.exit(0);
        }
    }
}