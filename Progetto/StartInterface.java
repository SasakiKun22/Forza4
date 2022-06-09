import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class StartInterface extends JFrame implements ActionListener{

    private TextFieldPanel textFieldPanel;
    private TextArea textArea;
    private JButton buttonP1;
    private JButton buttonP2;
    private JButton start;
    private JButton loadGame;
    private JButton save;
    private JMenuBar menuBar;
    private JMenuItem help;
    private JMenuItem exit;
    private int[][] matrix = {{0,0,0,0,0,0,0}, {0,0,0,0,0,0,0}, {0,0,0,0,0,0,0}, {0,0,0,0,0,0,0}, {0,0,0,0,0,0,0}, {0,0,0,0,0,0,0}};
    private String defaultP1Name = "PLAYER1";
    private String defaultP2Name = "PLAYER2";
    private String player1Name = "PLAYER1";
    private String player2Name = "PLAYER2";
    private int turn = 1;

    StartInterface() {
        super("CUSTOMIZE MATCH");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        super.setJMenuBar(createMenuBar());

        setLayout(new FlowLayout());
        textFieldPanel = new TextFieldPanel();
        textArea = new TextArea();
        buttonP1 = new JButton("COLOR");
        buttonP1.setBackground(Color.YELLOW);
        buttonP1.setPreferredSize(new Dimension(270,80));
        buttonP2 = new JButton("COLOR");
        buttonP2.setBackground(Color.RED);
        buttonP2.setPreferredSize(new Dimension(270,80));
        save = new JButton("Save");
        save.setPreferredSize(new Dimension(100,40));
        start=new JButton("Start");
        start.setPreferredSize(new Dimension(100,40));
        loadGame = new JButton("Load");
        loadGame.setPreferredSize(new Dimension(100, 40));
        menuBar = new JMenuBar();

//       listeners button
        save.addActionListener(new SaveActionListener());
        loadGame.addActionListener(new LoadGameActionListener());
        start.addActionListener(new StartActionListener());

        add(textFieldPanel,BorderLayout.CENTER);
        add(buttonP1,BorderLayout.LINE_START);
        add(buttonP2,BorderLayout.LINE_END);
        add(textArea,BorderLayout.CENTER);
        add(BorderLayout.PAGE_END,save);
        add(BorderLayout.AFTER_LAST_LINE,loadGame);
        add(BorderLayout.AFTER_LAST_LINE,start);
        setSize(700, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    protected JMenuBar createMenuBar() {
        JMenuBar jmenubar = new JMenuBar();
        exit = new JMenuItem("Exit");
        help = new JMenuItem("Game Instructions");
        jmenubar.add(exit);
        jmenubar.add(help);
        exit.addActionListener(new ExitActionListener());
        help.addActionListener(new HelpActionListener());
        return jmenubar;
    }

    public void actionPerformed(ActionEvent e){}



    private class ExitActionListener implements ActionListener 
    {
        public void actionPerformed(ActionEvent e) 
        {
            if(e.getSource()== exit) 
            {
                //information = new JOptionPane();
                int confirm = JOptionPane.showConfirmDialog(rootPane,"Are you sure you want to quit?","EXIT",0);
                if(confirm == 0){
                    System.exit(0);
                }
            }
        }
    }

    private class HelpActionListener implements  ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == help)
            {
                JOptionPane.showMessageDialog(rootPane, "Connect4 is played by two, and to win you must form an uninterrupted row of 4 pieces of your color, horizontally, vertically or diagonally.\nThe first player clicks on one of the 7 buttons and \"lets it slide, thanks to gravity, to the bottom\",\nthen the turn passes to his opponent, who must click a button to place the pawn of his color.\n The game continues in this way until one of the two players manages to form a row of 4 pieces of his color.\n When it's your turn, always be careful, as you may favor the other player!\n" +"\n"+
                        "Have fun!" ,"GAME INSTRUCTION",1);

            }
        }
    }

    private class StartActionListener implements  ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource() == start)
            {
                dispose();
                new Game(matrix, player1Name, player2Name, turn);
            }
        }
    }

    private class SaveActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource() == save)
            {
                player1Name = textFieldPanel.getNamePlayer(defaultP1Name);
                player2Name = textFieldPanel.getNamePlayer(defaultP2Name);
            }
        }
    }


    private class LoadGameActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String savaData;
            ReadFile fileReader = new ReadFile();

            try 
            {
                savaData = fileReader.readFileAsString("Connect4SaveFile.txt");
                String[] splitDati = savaData.split("\n");

                GetData getData = new GetData(splitDati);
                matrix = getData.getMatrice();
                player1Name = getData.getPlayer1Name();
                player2Name = getData.getPlayer2Name();
                turn = getData.getTurn();

                dispose();
                new Game(matrix, player1Name, player2Name, turn);

            } 
            catch (Exception e1) 
            {
                JOptionPane.showMessageDialog(rootPane, "No save file found, make sure:\n 1) You have already saved a previous game;\n 2) that the save file 'salvataggioForza4' and the code are in the same folder.", "ERROR ON SAVE FILE", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
