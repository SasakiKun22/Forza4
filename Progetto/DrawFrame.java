import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;


public class DrawFrame extends JFrame implements ActionListener{

    int draw;
    String player1Name;
    String player2Name;
    JButton exit;
    JTextArea win;
    Color bronze = new Color(205,127,50);


    DrawFrame(int draw, String player1Name, String player2Name) 
    {
        this.draw = draw;
        this.player1Name = player1Name;
        this.player2Name = player2Name;
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


        if (draw == 1) 
        {
            win = new JTextArea("     THE MATCH\n     ENDED IN A\n        DRAW");
            win.setEditable(false);
            win.setBounds(0,0,500,300);
            win.setBackground(bronze);
            win.setForeground(Color.white);
            win.setFont(new Font("MV Boli", Font.BOLD, 43));
            add(win);
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exit) {
            System.exit(0);
        }
    }
}