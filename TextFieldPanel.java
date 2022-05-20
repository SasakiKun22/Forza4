import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TextFieldPanel extends JPanel {
    private JTextField textField1;
    private JTextField textField2;

    public TextFieldPanel() {

    textField1 = new JTextField("  PLAYER1   ");
    textField1.setSize(new Dimension(270,100));
    textField1.setBackground(Color.CYAN);
    textField2 = new JTextField("   PLAYER2  ");
    textField2.setSize(new Dimension(270,100));
    textField2.setBackground(Color.CYAN);
    textField1.setFont(new Font("MV Boli", Font.BOLD, 43));
    textField2.setFont(new Font("MV Boli", Font.BOLD, 43));
    setLayout(new FlowLayout());
    add(textField1);
    add(textField2);
    }
}