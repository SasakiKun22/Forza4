import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

public class OptionFrame extends JFrame implements ActionListener
{
    JButton save;
    JButton saveExit;
    JButton exit;
    int[][] matrix;
    String player1Name;
    String player2Name;
    int turn;
    
    OptionFrame(int[][] matrix, String player1Name, String player2Name, int turn)
    {
        this.matrix = matrix;
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        this.turn = turn;

        save = new JButton("Save");
        saveExit = new JButton("Save and exit");
        exit = new JButton("Exit");

        setTitle("Option");
        setSize(500, 430);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        save.setBounds(150, 50, 200, 80);
        saveExit.setBounds(150, 150, 200, 80);
        exit.setBounds(150, 250, 200, 80);
        
        save.addActionListener(this);
        saveExit.addActionListener(this);
        exit.addActionListener(this);

        add(save);
        add(saveExit);
        add(exit);
    }

    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == save)
        {
            String stringMatrix = "";
            for (int y = 0; y < 6; y++)
            {
                for (int x = 0; x < 7; x++)
                {
                    stringMatrix += matrix[y][x];
                }
                if (y != 5)
                {
                    stringMatrix += " "; 
                }
            }
            try
            {
                FileWriter saveFile = new FileWriter("Connect4SaveFile.txt");
                saveFile.write(stringMatrix + "\n" + player1Name + "\n" + player2Name + "\n" + turn);
                saveFile.close();
            }
            catch (IOException error)
            {
                error.printStackTrace();
            }
            dispose();
        }

        if (e.getSource() == exit)
        {
            int confirm = JOptionPane.showConfirmDialog(rootPane,"Are you sure you want to quit without save?","EXIT",0);
            if(confirm == 0)
            {
                System.exit(0);
            }
        }

        if (e.getSource() == saveExit)
        {
            String stringMatrix = "";
            for (int y = 0; y < 6; y++)
            {
                for (int x = 0; x < 7; x++)
                {
                    stringMatrix += matrix[y][x];
                }
                if (y != 5)
                {
                    stringMatrix += " "; 
                }
            }
            try
            {
                FileWriter saveFile = new FileWriter("Connect4SaveFile.txt");
                saveFile.write(stringMatrix + "\n" + player1Name + "\n" + player2Name + "\n" + turn);
                saveFile.close();
            }
            catch (IOException error)
            {
                error.printStackTrace();
            }
            System.exit(0);
        }
    }
}
