import java.awt.*;
import javax.swing.*;


/* The following class, which extends jpanel,
 * deals with the creation of the two textual boxes for
 * the insertion of player names.
 */


public class TextFieldPanel extends JPanel {
    //instantiation of variables
    private JTextField textField1;
    private JTextField textField2;

/**@costructor TextFieldPanel()
 * The two textAree are defined by assigning a default text.
 * The size, background color and text font are set using the
 * setSize(), setBackground(), setfont() methods.
 * A Layout is defined and is set as FlowLayout().
 * In addition, the two textField (textField1 and textField2 )
 * are added to the jpanel via the add method.*/



    public TextFieldPanel() {

    textField1 = new JTextField("PLAYER1   ");
    textField1.setSize(new Dimension(270,100));
    textField1.setBackground(Color.CYAN);
    textField2 = new JTextField("PLAYER2   ");
    textField2.setSize(new Dimension(270,100));
    textField2.setBackground(Color.CYAN);
    textField1.setFont(new Font("MV Boli", Font.BOLD, 43));
    textField2.setFont(new Font("MV Boli", Font.BOLD, 43));
    setLayout(new FlowLayout());
    add(textField1);
    add(textField2);
    }
    /**@method getNamePLayer()
     *  At the end a method named getNamePlayer
     *  is created to take text from textField
     * @param playerName the name of the player
     */
    public String getNamePlayer(String playerName)
    {
        if (playerName == "PLAYER1")
        {
            return textField1.getText();
        }

        else
        {
            return textField2.getText();
        }
    }
}
