import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

/* The WinFrame.java class is about a player’s victory.
 * In case of victory , a panel will open with a text symbolizing
 * the victory of one of the two players.*/
public class VictoryFrame extends JFrame implements ActionListener
{
    //instantiation of variables
    int victory;
    String player1Name;
    String player2Name;
    JButton exit;
    JTextArea win;
    Color gold = new Color(212,175,55);

    /**@costructor VictoryFrame()

    the size, title, position , layout ,background color and window visibility are set through the methods: setSize(),
    settitle(), setResizable(), setLocationRelativeTo(),setLayout(), setBackground(), setVisible().
    the position of the exit button from the program is set via the setBounds() method,
    and then the button is inserted in the panel via the add method.
    exit is also assigned an ActionListener in order to carry out the process of closing all windows through
    the actionperformed method that takes an event and as argument e , in case of click on the exit button the program will end.
    At this point they are divided into cases where the winner is the player 1 or player 2:
    if victory =1 , will be awarded to player 1 and will open the window with the text  "THE WINNER IS " plus the name of the player
    otherwise if victory = 2 will be awarded to the player always with the same text but with the player’s name2.*/

    VictoryFrame(int victory, String player1Name, String player2Name)
    /**@param victory 1 represents the winner of the player1
    2 represents the player’s victory 2
     * @param player1Name represents player1
     * @param player2Name represents player2
     */
    {
        this.victory = victory;
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        exit = new JButton("EXIT");

        setSize(new Dimension(500, 300));           //set the dimension of the frame
        setTitle("VICTORY");                                     //set title of the frame
        setResizable(false);                                     //set the impossibility of resizing the frame
        setLocationRelativeTo(null);                             //set the frame in the center
        setLayout(null);                                         //set the Layout to null
        setBackground(gold);                                     //set the color of background
        setVisible(true);                                        //set the visibility of the frame
        exit.setBounds(210,200,80,40);        //set dimensions of the button
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
/** @method actionPerformed()
 * exit has an event associated
 * clicking on the exit button
 * all program processes will end */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exit) {
            System.exit(0);
        }
    }

}
