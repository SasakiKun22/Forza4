import javax.swing.*;

/**This class represents the textarea of the StartInterface */
public class TextArea extends JPanel
{
    private JTextArea textArea;    //istance of JTextArea

    /**A constructor is defined in which, through the new JTextArea() command,
     * the previously instantiated varaiabile is modified.
     * JTextArea inside takes a text , in this case there are the rescue instructions.
     */
   public TextArea()
   {
       textArea = new JTextArea(
            "1) --Click on Player to change the player name\n" +
               "\n" +
               "2) --Save your changes before starting\n" +
               "\n" +
               "3) --Load a previously saved game");
       add(textArea);       //the add method adds the text area to the jpanel
    }
}
