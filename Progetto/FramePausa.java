import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

public class FramePausa extends JFrame implements ActionListener
{
    JButton continua;
    JButton salva;
    JButton schermataIniziale;
    JButton esci;
    int[][] matrice;
    String giocatore1;
    String giocatore2;
    int giocatore;
    Color coloreG1;
    Color coloreG2;

    
    FramePausa(int[][] matrice, String giocatore1, String giocatore2, int giocatore, Color coloreG1, Color coloreG2)
    {
        this.matrice = matrice;
        this.giocatore1 = giocatore1;
        this.giocatore2 = giocatore2;
        this.giocatore = giocatore;
        this.coloreG1 = coloreG1;
        this.coloreG2 = coloreG2;

        continua = new JButton("Continua");
        salva = new JButton("Salva ed esci");
        schermataIniziale = new JButton("Torna alla schermata iniziale");
        esci = new JButton("Esci");

        setTitle("Pausa");
        setSize(500, 530);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        continua.setBounds(150, 50, 200, 80);
        schermataIniziale.setBounds(150, 150, 200, 80);
        salva.setBounds(150, 250, 200, 80);
        esci.setBounds(150, 350, 200, 80);

        continua.addActionListener(this);
        schermataIniziale.addActionListener(this);
        salva.addActionListener(this);
        esci.addActionListener(this);

        add(continua);
        add(schermataIniziale);
        add(salva);
        add(esci);
    }

    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == continua)
        {
            dispose();
        }

        if (e.getSource() == esci)
        {
            JOptionPane information = new JOptionPane();
            int confirm = information.showConfirmDialog(rootPane,"Are you sure you want to quit without save?","EXIT",0);
            if(confirm == 0)
            {
                System.exit(0);
            }
        }

        if (e.getSource() == schermataIniziale)
        {
            //Gioco gioco = new Gioco(giocatore1, giocatore2);
            //gioco.dispose();
            
            dispose();
            new G_interface();
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
                fileSalvataggio.write(matriceStringa + "\n" + giocatore1 + "\n" + giocatore2 + "\n" + giocatore + "\n" + coloreG1 + "\n" + coloreG2);
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
