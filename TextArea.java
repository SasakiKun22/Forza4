import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TextArea extends JPanel{
    private JTextArea textArea;

   public TextArea(){
       textArea = new JTextArea("1) --Click on Player to change the player name\n" +
               "\n" +
               "2) --Click on the button to change the player color\n" +
               "\n" +
               "3) --Save your changes before starting");
       add(textArea);

    }


}
