import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class Gioco extends JFrame implements ActionListener
{
    JLabel label;
    JButton b1;
    JButton b2;
    JButton b3;
    JButton b4;
    JButton b5;
    JButton b6;
    JButton b7;
    JButton pausa;
    JTextField turni;
    int[][] matrice;
    MatriceGioco matriceGioco = new MatriceGioco();
    int giocatore = 1;
    String giocatore1;
    String giocatore2;
    int vittoria = 0;
    boolean validita = true;
    int pareggio = 0;

    Gioco(int[][] matrice, String giocatore1, String giocatore2, int giocatore)
    {   
        this.matrice = matrice;
        this.giocatore1 = giocatore1;
        this.giocatore2 = giocatore2;
        this.giocatore = giocatore;

        setTitle("Forza4: P1 vs P2");
        setSize(720, 800);
        setContentPane(new CirclesPanel(this.matrice));
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        pausa = new JButton("|  |");

        if (giocatore == 1)
        {
            turni = new JTextField("Turn of " + this.giocatore1 + "(P1)");
        }
        else
        {
            turni = new JTextField("Turn of " + this.giocatore2 + "(P2)");
        }
        
        b1.setBounds(3, 650, 95, 50);
        b2.setBounds(104, 650, 95, 50);
        b3.setBounds(205, 650, 95, 50);
        b4.setBounds(306, 650, 95, 50);
        b5.setBounds(407, 650, 95, 50);
        b6.setBounds(508, 650, 95, 50);
        b7.setBounds(609, 650, 95, 50);
        pausa.setBounds(654, 710, 50, 50);
        turni.setBounds(3, 710, 640, 50);
        turni.setFont(new Font("MV Boli", Font.BOLD, 28));

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        pausa.addActionListener(this);
        
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b6);
        add(b7);
        add(pausa);
        add(turni);
        setLayout(null);
       
    }

    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == b1)
        {
            int posizioneRiga = 5;
            for (int y = 0; y < 6; y++)
            {
                if (this.matrice[0][0] == 1 || this.matrice[0][0] == 2 )
                {
                    validita = false;
                    turni.setText("Invalid move, select another column");
                    break;
                }
                else
                {
                    validita = true;
                }
                
                if (this.matrice[y][0] == 1 || this.matrice[y][0] == 2)
                {
                    posizioneRiga = y-1;
                    break;
                }
            }

            
            add(new CirclesPanel(this.matrice));
            repaint();

            if (validita == true)
            {
                matrice = matriceGioco.addMove(this.matrice, posizioneRiga, 0, giocatore);

                vittoria = matriceGioco.controllo(this.matrice, giocatore);

                pareggio = matriceGioco.draw(this.matrice);
                
                if (vittoria == 0)
                {
                    if (pareggio == 0)
                    {
                        if (giocatore == 1)
                        {
                            giocatore = 2;
                            turni.setText("Turn of " + this.giocatore2 + "(P2)");
                        }
                        else
                        {
                            giocatore = 1;
                            turni.setText("Turn of " + this.giocatore1 + "(P1)");
                        } 
                    }
                    else
                    {
                        new Pareggio(pareggio, giocatore1, giocatore2);
                        setEnabled(false);
                    }
                }
                else
                {
                    new Vittoria(vittoria, giocatore1, giocatore2);
                    setEnabled(false);
                }
            }
        }

        if (e.getSource() == b2)
        {
            int posizioneRiga = 5;
            for (int y = 0; y < 6; y++)
            {
                if (this.matrice[0][1] == 1 || this.matrice[0][1] == 2 )
                {
                    validita = false;
                    turni.setText("Invalid move, select another column");
                    break;
                }
                else
                {
                    validita = true;
                }
                
                if (this.matrice[y][1] == 1 || this.matrice[y][1] == 2)
                {
                    posizioneRiga = y-1;
                    break;
                }
                
            }

            add(new CirclesPanel(this.matrice));
            repaint();

            if (validita == true)
            {
                matrice = matriceGioco.addMove(this.matrice, posizioneRiga, 1, giocatore);

                vittoria = matriceGioco.controllo(this.matrice, giocatore);

                pareggio = matriceGioco.draw(this.matrice);
                
                if (vittoria == 0)
                {
                    if (pareggio == 0)
                    {
                        if (giocatore == 1)
                        {
                            giocatore = 2;
                            turni.setText("Turn of " + this.giocatore2 + "(P2)");
                        }
                        else
                        {
                            giocatore = 1;
                            turni.setText("Turn of " + this.giocatore1 + "(P1)");
                        } 
                    }
                    else
                    {
                        new Pareggio(pareggio, giocatore1, giocatore2);
                        setEnabled(false);
                    }
                }
                else
                {
                    new Vittoria(vittoria, giocatore1, giocatore2);
                    setEnabled(false);
                }
            }
        }

        if (e.getSource() == b3)
        {
            int posizioneRiga = 5;
            for (int y = 0; y < 6; y++)
            {
                if (this.matrice[0][2] == 1 || this.matrice[0][2] == 2 )
                {
                    validita = false;
                    turni.setText("Invalid move, select another column");
                    break;
                }
                else
                {
                    validita = true;
                }
                
                if (this.matrice[y][2] == 1 || this.matrice[y][2] == 2)
                {
                    posizioneRiga = y-1;
                    break;
                }
                
            }

            add(new CirclesPanel(this.matrice));
            repaint();

            if (this.validita == true)
            {
                matrice = matriceGioco.addMove(this.matrice, posizioneRiga, 2, giocatore);

                vittoria = matriceGioco.controllo(this.matrice, giocatore);

                pareggio = matriceGioco.draw(this.matrice);
                
                if (vittoria == 0)
                {
                    if (pareggio == 0)
                    {
                        if (giocatore == 1)
                        {
                            giocatore = 2;
                            turni.setText("Turn of " + this.giocatore2 + "(P2)");
                        }
                        else
                        {
                            giocatore = 1;
                            turni.setText("Turn of " + this.giocatore1 + "(P1)");
                        } 
                    }
                    else
                    {
                        new Pareggio(pareggio, giocatore1, giocatore2);
                        setEnabled(false);
                    }
                }
                else
                {
                    new Vittoria(vittoria, giocatore1, giocatore2);
                    setEnabled(false);
                }
            }
        }

        if (e.getSource() == b4)
        {
            int posizioneRiga = 5;
            for (int y = 0; y < 6; y++)
            {
                if (this.matrice[0][3] == 1 || this.matrice[0][3] == 2)
                {
                    validita = false;
                    turni.setText("Invalid move, select another column");
                    break;
                }
                else
                {
                    validita = true;
                }
                
                if (this.matrice[y][3] == 1 || this.matrice[y][3] == 2)
                {
                    posizioneRiga = y-1;
                    break;
                }
                
            }

            add(new CirclesPanel(this.matrice));
            repaint();

            if (validita == true)
            {
                matrice = matriceGioco.addMove(this.matrice, posizioneRiga, 3, giocatore);

                vittoria = matriceGioco.controllo(this.matrice, giocatore);

                pareggio = matriceGioco.draw(this.matrice);
                
                if (vittoria == 0)
                {
                    if (pareggio == 0)
                    {
                        if (giocatore == 1)
                        {
                            giocatore = 2;
                            turni.setText("Turn of " + this.giocatore2 + "(P2)");
                        }
                        else
                        {
                            giocatore = 1;
                            turni.setText("Turn of " + this.giocatore1 + "(P1)");
                        } 
                    }
                    else
                    {
                        new Pareggio(pareggio, giocatore1, giocatore2);
                        setEnabled(false);
                    }
                }
                else
                {
                    new Vittoria(vittoria, giocatore1, giocatore2);
                    setEnabled(false);
                }
            }
        }

        if (e.getSource() == b5)
        {
            int posizioneRiga = 5;
            for (int y = 0; y < 6; y++)
            {
                if (this.matrice[0][4] == 1 || this.matrice[0][4] == 2)
                {
                    validita = false;
                    turni.setText("Invalid move, select another column");
                    break;
                }
                else
                {
                    validita = true;
                }
                
                if (this.matrice[y][4] == 1 || this.matrice[y][4] == 2)
                {
                    posizioneRiga = y-1;
                    break;
                }
                
            }

            add(new CirclesPanel(this.matrice));
            repaint();

            if (validita == true)
            {
                matrice = matriceGioco.addMove(this.matrice, posizioneRiga, 4, giocatore);

                vittoria = matriceGioco.controllo(this.matrice, giocatore);

                pareggio = matriceGioco.draw(this.matrice);
                
                if (vittoria == 0)
                {
                    if (pareggio == 0)
                    {
                        if (giocatore == 1)
                        {
                            giocatore = 2;
                            turni.setText("Turn of " + this.giocatore2 + "(P2)");
                        }
                        else
                        {
                            giocatore = 1;
                            turni.setText("Turn of " + this.giocatore1 + "(P1)");
                        } 
                    }
                    else
                    {
                        new Pareggio(pareggio, giocatore1, giocatore2);
                        setEnabled(false);
                    }
                }
                else
                {
                    new Vittoria(vittoria, giocatore1, giocatore2);
                    setEnabled(false);
                }
            }
        }

        if (e.getSource() == b6)
        {
            int posizioneRiga = 5;
            for (int y = 0; y < 6; y++)
            {
                if (this.matrice[0][5] == 1 || this.matrice[0][5] == 2)
                {
                    validita = false;
                    turni.setText("Invalid move, select another column");
                    break;
                }
                else
                {
                    validita = true;
                }
                
                if (this.matrice[y][5] == 1 || this.matrice[y][5] == 2)
                {
                    posizioneRiga = y-1;
                    break;
                }
                
            }

            add(new CirclesPanel(this.matrice));
            repaint();

            if (validita == true)
            {
                matrice = matriceGioco.addMove(this.matrice, posizioneRiga, 5, giocatore);

                vittoria = matriceGioco.controllo(this.matrice, giocatore);

                pareggio = matriceGioco.draw(this.matrice);
                
                if (vittoria == 0)
                {
                    if (pareggio == 0)
                    {
                        if (giocatore == 1)
                        {
                            giocatore = 2;
                            turni.setText("Turn of " + this.giocatore2 + "(P2)");
                        }
                        else
                        {
                            giocatore = 1;
                            turni.setText("Turn of " + this.giocatore1 + "(P1)");
                        } 
                    }
                    else
                    {
                        new Pareggio(pareggio, giocatore1, giocatore2);
                        setEnabled(false);
                    }
                }
                else
                {
                    new Vittoria(vittoria, giocatore1, giocatore2);
                    setEnabled(false);
                }
            }
        }

        if (e.getSource() == b7)
        {
            int posizioneRiga = 5;
            for (int y = 0; y < 6; y++)
            {
                if (this.matrice[0][6] == 1 || this.matrice[0][6] == 2)
                {
                    validita = false;
                    turni.setText("Invalid move, select another column");
                    break;
                }
                else
                {
                    validita = true;
                }
                
                if (this.matrice[y][6] == 1 || this.matrice[y][6] == 2)
                {
                    posizioneRiga = y-1;
                    break;
                }
                
            }

            add(new CirclesPanel(this.matrice));
            repaint();

            if (validita == true)
            {
                matrice = matriceGioco.addMove(this.matrice, posizioneRiga, 6, giocatore);

                vittoria = matriceGioco.controllo(this.matrice, giocatore);
                
                pareggio = matriceGioco.draw(this.matrice);
                
                if (vittoria == 0)
                {
                    if (pareggio == 0)
                    {
                        if (giocatore == 1)
                        {
                            giocatore = 2;
                            turni.setText("Turn of " + this.giocatore2 + "(P2)");
                        }
                        else
                        {
                            giocatore = 1;
                            turni.setText("Turn of " + this.giocatore1 + "(P1)");
                        } 
                    }
                    else
                    {
                        new Pareggio(pareggio, giocatore1, giocatore2);
                        setEnabled(false);
                    }
                }
                else
                {
                    new Vittoria(vittoria, giocatore1, giocatore2);
                    setEnabled(false);
                }
            }
        }

        if (e.getSource() == pausa)
        {
            new FramePausa(this.matrice, giocatore1, giocatore2, giocatore);
        } 
    }
}
