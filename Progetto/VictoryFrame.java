import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;


public class VictoryFrame extends JFrame implements ActionListener
{
    int victory;
    String player1Name;
    String player2Name;
    JButton exit;
    JTextArea win;
    Color gold = new Color(212,175,55);


    VictoryFrame(int victory, String player1Name, String player2Name) {
        this.victory = victory;
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        exit = new JButton("EXIT");

        setSize(new Dimension(500, 300));
        setTitle("VICTORY");
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        setBackground(gold);
        setVisible(true);
        exit.setBounds(210,200,80,40);
        add(exit);
        exit.addActionListener(this);


        if (victory == 1) {
            win = new JTextArea(" "+"\n"+"   THE WINNER IS..." +"\n" + "     "+player1Name +"!!!!!");
            win.setEditable(false);
            win.setBounds(0,0,500,300);
            win.setBackground(gold);
            win.setForeground(Color.white);
            win.setFont(new Font("MV Boli", Font.BOLD, 43));
            add(win);
        } else if (victory == 2) {
            win = new JTextArea(" "+"\n"+"   THE WINNER IS..." +"\n" + "     "+player2Name +"!!!!!");
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