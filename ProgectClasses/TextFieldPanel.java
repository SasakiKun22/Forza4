import java.awt.*;
import javax.swing.*;

public class TextFieldPanel extends JPanel {
    //instantiation of variables
    private JTextField textField1;
    private JTextField textField2;

/**The following class, which extends jpanel,
 * deals with the creation of the two textual boxes for
 * the insertion of player names.
*/
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
    /**At the end a method named getNamePlayer
     *  is created to take text from textField;
     * @param playerName the default name of the player.
     * @return name chosen by the player.
     */
    public String getNamePlayer(String playerName)
    {
        String player = "";
        if (playerName == "PLAYER1")
        {
            player = textField1.getText();
        }

        else if (playerName == "PLAYER2")
        {
            player = textField2.getText();
        }
        return player;
    }
}