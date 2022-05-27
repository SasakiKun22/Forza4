import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

public class FramePausa extends JFrame implements ActionListener
{
    JButton salva;
    JButton esci;
    int[][] matrice;
    String giocatore1;
    String giocatore2;
    int giocatore;
    Color coloreG1;
    Color coloreG2;

    
    FramePausa(int[][] matrice, String giocatore1, String giocatore2, int giocatore)
    {
        this.matrice = matrice;
        this.giocatore1 = giocatore1;
        this.giocatore2 = giocatore2;
        this.giocatore = giocatore;

        salva = new JButton("Save and exit");
        esci = new JButton("Exit");

        setTitle("Option");
        setSize(500, 330);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        salva.setBounds(150, 50, 200, 80);
        esci.setBounds(150, 150, 200, 80);
        
        salva.addActionListener(this);
        esci.addActionListener(this);

        add(salva);
        add(esci);
    }

    public void actionPerformed(ActionEvent e) 
    {
        
        if (e.getSource() == esci)
        {
            JOptionPane information = new JOptionPane();
            int confirm = information.showConfirmDialog(rootPane,"Are you sure you want to quit without save?","EXIT",0);
            if(confirm == 0)
            {
                System.exit(0);
            }
        }

        if (e.getSource() == salva)
        {
            String matriceStringa = "";
            for (int y = 0; y < 6; y++)
            {
                for (int x = 0; x < 7; x++)
                {
                   matriceStringa += matrice[y][x];
                }
                if (y != 5)
                {
                   matriceStringa += " "; 
                }
            }
            try
            {
                FileWriter fileSalvataggio = new FileWriter("salvataggioForza4.txt");
                fileSalvataggio.write(matriceStringa + "\n" + giocatore1 + "\n" + giocatore2 + "\n" + giocatore);
                fileSalvataggio.close();
            }
            catch (IOException error)
            {
                error.printStackTrace();
            }
            System.exit(0);
        }
    }
}
