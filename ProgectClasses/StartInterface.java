import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class StartInterface extends JFrame{
    //instantiation of variables
    private TextFieldPanel textFieldPanel;  //text input panel
    private TextArea textArea;              //text area panel
    private JButton buttonP1;               //color of Player1
    private JButton buttonP2;               //color of Player2
    private JButton start;                  //start button
    private JButton loadGame;               // load game button
    private JButton save;                   //save button
    private JMenuBar menuBar;               //menubar
    private JMenuItem help;                 //help button
    private JMenuItem exit;                 //exit button

    //first game matrix initialized with all zeros
    private int[][] matrix = {{0,0,0,0,0,0,0}, {0,0,0,0,0,0,0}, {0,0,0,0,0,0,0}, {0,0,0,0,0,0,0}, {0,0,0,0,0,0,0}, {0,0,0,0,0,0,0}};
    private final String defaultP1Name = "PLAYER1";   // default name of Player1
    private final String defaultP2Name = "PLAYER2";   // default name of Player2
    private String player1Name = "PLAYER1";
    private String player2Name = "PLAYER2";
    private int turn = 1;                      // turn of Player1, the latter starts by default

    /**This class represents the first window of the game,
    *  you can choose the name of the players, save the game,
    * reload a game, and start the game.
    */
    public StartInterface() {
        
        super("CUSTOMIZE MATCH");
        ImageIcon img = new ImageIcon("Connect4.png");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        super.setJMenuBar(createMenuBar());
        setLayout(new FlowLayout());
        setIconImage(img.getImage());
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

        /* Listeners Buttons:
         * to each listener button is attributed the corresponding event through
         */
        save.addActionListener(new SaveActionListener());
        loadGame.addActionListener(new LoadGameActionListener());
        start.addActionListener(new StartActionListener());
        /*add method adds attributes corresponding to the principal frame*/
        add(textFieldPanel,BorderLayout.CENTER);
        add(buttonP1,BorderLayout.LINE_START);
        add(buttonP2,BorderLayout.LINE_END);
        add(textArea,BorderLayout.CENTER);
        add(BorderLayout.PAGE_END,save);
        add(BorderLayout.AFTER_LAST_LINE,loadGame);
        add(BorderLayout.AFTER_LAST_LINE,start);
        setSize(700, 400);        //set the size of the frame
        setLocationRelativeTo(null);           //set the frame in the center
        setResizable(false);                   //set the impossibility of resizing the frame
        //
        //
        //finish all the execution processes of the program by clicking on 'x'
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);                      //set the visibility of the frame

    }

    /**
     * Method to create the frame menubar,
     * exit and help are defined and added to the jmenubar.
     * the corresponding actionListener is added to the two buttons
     * @method createMenuBar()
     * @return jMenuBar
    */
    protected JMenuBar createMenuBar() {

        JMenuBar jMenuBar = new JMenuBar();
        exit = new JMenuItem("Exit");
        help = new JMenuItem("Game Instructions");
        jMenuBar.add(exit);
        jMenuBar.add(help);
        exit.addActionListener(new ExitActionListener());
        help.addActionListener(new HelpActionListener());
        return jMenuBar;
    }


    /** Exit has an event associated
     *  clicking on the exit button will open an OptionPane
     *  with the message "Are you sure you want to quit?" ,
     *  if you click on yes all program processes will end. 
     * 
     *  @innerclass ExitActionListener        
     *  @method actionPerformed(ActionEvent e)
    */
    private class ExitActionListener implements ActionListener 
    {
        public void actionPerformed(ActionEvent e)
        
        {
            if(e.getSource()== exit) 
            {

                int confirm = JOptionPane.showConfirmDialog(rootPane,"Are you sure you want to quit?","EXIT",0);
                if(confirm == 0){
                    System.exit(0);
                }
            }
        }
    }

    /** Help has an event associated
     *  clicking on the help button will open an OptionPane
     *  with the instructions of the game.
     * 
     *  @innerclass HelpActionListener         
     *  @method actionPerformed(ActionEvent e)
     *   */
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
    /** Start has an event associated
     *  clicking on the start button will open
     *  the real window of the game through the command
     *  new Game(matrix, player1Name, player2Name, turn),
     *  through this command, an object of the class Game.java is created.
     * 
     *  @innerclass StartActionListener         
     *  @method actionPerformed(ActionEvent e)    
     */
    private class StartActionListener implements  ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource() == start)
            {
                
                new Game(matrix, player1Name, player2Name, turn);
                dispose();
            }
        }
    }
    /** Save has an event associated
     *  clicking on the save button will be saved
     *  the names present in the textFieldPanel,
     *  in case of not entering the names of the two players,
     *  will be considered the default names ,
     *  that is "Player1" and "Player2".
     * 
     *  @innerclass SaveActionListener         
     *  @method actionPerformed(ActionEvent e) 
    */
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

    /** Inside the actionperformed is set a string
     *  inside which there is the contents of the file "Connect4SaveFile.txt",
     *  inside the file there are the game matrix,
     *  the names of the two players,
     *  and the turn of the two players.
     *  Through the try and catch the save file is read
     *  and the game is reopened by calling the Game class
     *  set with different parameters.
     * 
     *  @innerclass LoadGameActionListener         
     *  @method actionPerformed(ActionEvent e)
    */
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