import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;


public class Vittoria extends JFrame implements ActionListener
{
    int vittoria;
    String giocatore1;
    String giocatore2;
    JButton exit;
    JTextArea win;
    Color gold = new Color(212,175,55);


    Vittoria(int vittoria, String giocatore1, String giocatore2) {
        this.vittoria = vittoria;
        this.giocatore1 = giocatore1;
        this.giocatore2 = giocatore2;
        exit = new JButton("EXIT");

        setSize(new Dimension(500, 300));
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        setBackground(gold);
        setVisible(true);
        exit.setBounds(210,200,80,40);
        add(exit);
        exit.addActionListener(this);


        if (vittoria == 1) {
            win = new JTextArea(" "+"\n"+"   THE WINNER IS..." +"\n" + "     "+giocatore1 +"!!!!!");
            win.setEditable(false);
            win.setBounds(0,0,500,300);
            win.setBackground(gold);
            win.setForeground(Color.white);
            win.setFont(new Font("MV Boli", Font.BOLD, 43));
            add(win);
        } else if (vittoria == 2) {
            win = new JTextArea(" "+"\n"+"   THE WINNER IS..." +"\n" + "     "+giocatore2 +"!!!!!");
            win.setEditable(false);
            win.setBounds(0,0,500,300);
            win.setBackground(gold);
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