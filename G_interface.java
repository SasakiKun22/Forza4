import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;




public class G_interface extends JFrame implements ActionListener{

    private TextFieldPanel textfieldpanel;
    private TextArea textArea;

    private JButton button_g1;
    private JButton button_g2;
    private JButton button_start;
    private JButton save;
    private JMenuBar menuBar;
    private JMenuItem Help;
    private JMenuItem Exit;
    private JOptionPane information;
    private Gioco gioco;
    private String controllo1 = "PLAYER1";
    private String controllo2 = "PLAYER2";
    private String giocatore1;
    private String giocatore2;
    private Color coloreG1;
    private Color coloreG2;



    G_interface() {
        super("CUSTOMIZE MATCH");
        super.setJMenuBar(createMenuBar());

        setLayout(new FlowLayout());
        textfieldpanel = new TextFieldPanel();
        textArea = new TextArea();
        button_g1 = new JButton("COLOR");
        button_g1.setBackground(Color.YELLOW);
        button_g1.setPreferredSize(new Dimension(270,80));
        button_g2 = new JButton("COLOR");
        button_g2.setBackground(Color.RED);
        button_g2.setPreferredSize(new Dimension(270,80));
        save = new JButton("SAVE");
        save.setPreferredSize(new Dimension(100,40));
        button_start=new JButton("START");
        button_start.setPreferredSize(new Dimension(100,40));
        menuBar = new JMenuBar();

//       listeners button
        button_g1.addActionListener(this);
        button_g2.addActionListener(this);
        save.addActionListener(new SaveActionListener());
        button_start.addActionListener(new StarActionListener());

        add(textfieldpanel,BorderLayout.CENTER);
        add(button_g1,BorderLayout.LINE_START);
        add(button_g2,BorderLayout.LINE_END);
        add(textArea,BorderLayout.CENTER);
        add(BorderLayout.PAGE_END,save);
        add(BorderLayout.AFTER_LAST_LINE,button_start);
        setSize(700, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    protected JMenuBar createMenuBar() {
        JMenuBar jmenubar = new JMenuBar();
        Exit = new JMenuItem("Exit");
        Help = new JMenuItem("Game Instructions");
        jmenubar.add(Exit);
        jmenubar.add(Help);
        Exit.addActionListener(new ExitActionListener());
        Help.addActionListener(new HelpActionListener());
        return jmenubar;
    }


    private class ExitActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()== Exit) {
                information = new JOptionPane();
                int confirm = information.showConfirmDialog(rootPane,"Are you sure you want to quit?","EXIT",0);
                if(confirm == 0){
                    System.exit(0);
                }
            }
        }
    }

    private class HelpActionListener implements  ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == Help){
                JOptionPane.showMessageDialog(rootPane, "Forza 4 is played by two, and to win you must form an uninterrupted row of 4 pieces of your color, horizontally, vertically or diagonally.\nThe first player clicks on one of the 7 buttons and \"lets it slide, thanks to gravity, to the bottom\",\nthen the turn passes to his opponent, who must click a button to place the pawn of his color.\n The game continues in this way until one of the two players manages to form a row of 4 pieces of his color.\n When it's your turn, always be careful, as you may favor the other player!\n" +"\n"+
                        "Good fun!" ,"GAME ISTRUCTION",1);

            }
        }
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button_g1) {
            JColorChooser colorChooser = new JColorChooser();
            Color color = JColorChooser.showDialog(null, "Pick a color", Color.black);
            button_g1.setBackground(color);
        } else if (e.getSource() == button_g2) {
            JColorChooser colorChooser = new JColorChooser();
            Color color = JColorChooser.showDialog(null, "Pick a color", Color.black);
            button_g2.setBackground(color);
        }
    }

    private class StarActionListener implements  ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource() == button_start)
            {
                dispose();
                gioco = new Gioco();
            }
        }
    }

    private class SaveActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource() == save)
            {
                giocatore1 = textfieldpanel.getNamePlayer(controllo1);
                giocatore2 = textfieldpanel.getNamePlayer(controllo2);
                coloreG1 = button_g1.getBackground();
                coloreG2 = button_g2.getBackground();
                System.out.println(coloreG1);
                System.out.println(coloreG2);
            }
        }
    }
}
