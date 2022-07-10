import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

/* A tie from a game.
 * In the event of a tie , a panel will open with a text
 * symbolizing that the game ended with a tie */
public class DrawFrame extends JFrame implements ActionListener{

    //instantiation of variables
    JButton exit;
    JTextArea drawArea;
    Color bronze = new Color(205,127,50);

    /**@costructor DrawFrame()
    /* inside the constructor, are set the size, the title, the position ,
    the layout ,the background color ,the visibility of the window and is denied the possibility
    of resizing the window, all this through the methods:
    setSize(), settitle(), setResizable(), setLocationRelativeTo(),setLayout(), setBackground(),   setVisible().
    Below is set the position of the exit button from the program via the setBounds() method,
    then insert the button in the panel through the add method. Exit is also assigned an ActionListener
    in order to carry out the process of closing all windows through the actionperformed method
    that takes an event and as argument e , in case of click on the exit button the program will end.
    At this point , in the event of a draw, a window will open in which there is the drawArea ,
    to the latter the following text is inserted:
    "THE MATCH ENDED IN A DRAW".
    Then the position, the background color, the possibility of editability, the color of the text (foreground)
    and the font of the drawArea are set and then add the latter inside the window through the add method
     */
    DrawFrame() 
    {
        
        exit = new JButton("EXIT");

        setSize(new Dimension(500, 300));  //set the dimension of the frame
        setTitle("DRAW");                               //set title of the frame
        setResizable(false);                            //set the impossibility of resizing the frame
        setLocationRelativeTo(null);                    //set the frame in the center
        setLayout(null);                                // set the Layout to null
        setBackground(bronze);                          // set the color of background
        setVisible(true);                               //set the visibility of the frame
        exit.setBounds(210,200,80,40);     //set dimensions of the button
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

    /**@method actionPerformed()
     * exit has an event associated
     * clicking on the exit button
     * all program processes will end */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exit) {
            System.exit(0);
        }
    }
}
