import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class DrawFrame extends JFrame implements ActionListener{

    //instantiation of variables
    JButton exit;
    JTextArea drawArea;
    Color bronze = new Color(205,127,50);

    /**The following class has been created with respect to the draw of a match.
     * In the event of a tie , a panel will open with a text
     * symbolizing that the game ended with a tie.
     */
    public DrawFrame() 
    {
        
        exit = new JButton("EXIT");
        
        ImageIcon img = new ImageIcon("Connect4.png");
        setIconImage(img.getImage());
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

    /**Exit has an event associated
     * clicking on the exit button
     * all program processes will end.
     * @method actionPerformed()
    */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exit) {
            System.exit(0);
        }
    }
}