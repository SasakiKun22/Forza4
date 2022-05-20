import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gioco extends JFrame implements ActionListener
{
    JFrame frame;
    JLabel label;
    JButton b1;
    JButton b2;
    JButton b3;
    JButton b4;
    JButton b5;
    JButton b6;
    JButton b7;
    int[][] matrice = {{0,0,0,0,0,0,0}, {0,0,0,0,0,0,0}, {0,0,0,0,0,0,0}, {0,0,0,0,0,0,0}, {0,0,0,0,0,0,0}, {0,0,0,0,0,0,0}};
    MatriceGioco matriceGioco = new MatriceGioco();
    int giocatore = 1;
    int giocatore1 = 1;
    int giocatore2 = 2;
    String vittoria = "";
    String validita = "";
    String pareggio = "";

    Gioco()
    {   
        label = new JLabel();
        label.setSize(720, 740);
        frame = new JFrame("Forza4: G1 vs G2");
        frame.setSize(720, 740);
        //frame.getContentPane().setBackground(Color.blue);
        frame.setContentPane(new CirclesPanel());
        //frame.setLayout(null);
        frame.setVisible(true);
        
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");

        b1.setBounds(3, 650, 95, 50);
        b2.setBounds(104, 650, 95, 50);
        b3.setBounds(205, 650, 95, 50);
        b4.setBounds(306, 650, 95, 50);
        b5.setBounds(407, 650, 95, 50);
        b6.setBounds(508, 650, 95, 50);
        b7.setBounds(609, 650, 95, 50);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        
        frame.add(b1);
        frame.add(b2);
        frame.add(b3);
        frame.add(b4);
        frame.add(b5);
        frame.add(b6);
        frame.add(b7);
        frame.setLayout(null);
        //layerPane.add(frame, 1);

    }

    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == b1)
        {
            int posizioneRiga = 5;
            for (int y = 0; y < 6; y++)
            {
                if (matrice[0][0] == giocatore1 || matrice[0][0] == giocatore2 )
                {
                    validita = "Mossa non valide\nSelezionare un'altra colonna";
                    System.out.println(validita);
                    break;
                }
                
                if (matrice[y][0] == giocatore1 || matrice[y][0] == giocatore2)
                {
                    posizioneRiga = y-1;
                    break;
                }
                
            }
            if (validita == "")
            {
                matrice = matriceGioco.addMove(matrice, posizioneRiga, 0, giocatore);

                vittoria = matriceGioco.controllo(matrice, giocatore);

                pareggio = matriceGioco.draw(matrice);
                
                if (vittoria == "")
                {
                    if (pareggio == "")
                    {
                        if (giocatore == 1)
                        {
                            giocatore = giocatore2;
                        }
                        else
                        {
                            giocatore = giocatore1;
                        } 
                    }
                    else
                    {
                        System.out.println(pareggio);
                    }
                }
                else
                {
                    System.out.println(vittoria);
                }
            }
                
            for (int i = 0; i < 6; i++) 
            {
                for (int j = 0; j < 7; j++) 
                {
                    System.out.print(matrice[i][j] + " ");
                }
                System.out.println();
            }
        }

        if (e.getSource() == b2)
        {
            int posizioneRiga = 5;
            for (int y = 0; y < 6; y++)
            {
                if (matrice[0][1] == giocatore1 || matrice[0][1] == giocatore2 )
                {
                    validita = "Mossa non valide\nSelezionare un'altra colonna";
                    System.out.println(validita);
                    break;
                }
                
                if (matrice[y][1] == giocatore1 || matrice[y][1] == giocatore2)
                {
                    posizioneRiga = y-1;
                    break;
                }
                
            }
            if (validita == "")
            {
                matrice = matriceGioco.addMove(matrice, posizioneRiga, 1, giocatore);

                vittoria = matriceGioco.controllo(matrice, giocatore);
                pareggio = matriceGioco.draw(matrice);
                
                if (vittoria == "")
                {
                    if (pareggio == "")
                    {
                        if (giocatore == 1)
                        {
                            giocatore = giocatore2;
                        }
                        else
                        {
                            giocatore = giocatore1;
                        } 
                    }
                    else
                    {
                        System.out.println(pareggio);
                    }
                }
                else
                {
                    System.out.println(vittoria);
                }

                for (int i = 0; i < 6; i++) 
                {
                    for (int j = 0; j < 7; j++) 
                    {
                        System.out.print(matrice[i][j] + " ");
                    }
                    System.out.println();
                }
            }
        }

        if (e.getSource() == b3)
        {
            int posizioneRiga = 5;
            for (int y = 0; y < 6; y++)
            {
                if (matrice[0][2] == giocatore1 || matrice[0][2] == giocatore2 )
                {
                    validita = "Mossa non valide\nSelezionare un'altra colonna";
                    System.out.println(validita);
                    break;
                }
                
                if (matrice[y][2] == giocatore1 || matrice[y][2] == giocatore2)
                {
                    posizioneRiga = y-1;
                    break;
                }
                
            }
            if (validita == "")
            {
                matrice = matriceGioco.addMove(matrice, posizioneRiga, 2, giocatore);

                vittoria = matriceGioco.controllo(matrice, giocatore);

                pareggio = matriceGioco.draw(matrice);
                
                if (vittoria == "")
                {
                    if (pareggio == "")
                    {
                        if (giocatore == 1)
                        {
                            giocatore = giocatore2;
                        }
                        else
                        {
                            giocatore = giocatore1;
                        } 
                    }
                    else
                    {
                        System.out.println(pareggio);
                    }
                }
                else
                {
                    System.out.println(vittoria);
                }

                for (int i = 0; i < 6; i++) 
                {
                    for (int j = 0; j < 7; j++) 
                    {
                        System.out.print(matrice[i][j] + " ");
                    }
                    System.out.println();
                }
            }
        }

        if (e.getSource() == b4)
        {
            int posizioneRiga = 5;
            for (int y = 0; y < 6; y++)
            {
                if (matrice[0][3] == giocatore1 || matrice[0][3] == giocatore2)
                {
                    validita = "Mossa non valide\nSelezionare un'altra colonna";
                    System.out.println(validita);
                    break;
                }
                
                if (matrice[y][3] == giocatore1 || matrice[y][3] == giocatore2)
                {
                    posizioneRiga = y-1;
                    break;
                }
                
            }
            if (validita == "")
            {
                matrice = matriceGioco.addMove(matrice, posizioneRiga, 3, giocatore);

                vittoria = matriceGioco.controllo(matrice, giocatore);

                pareggio = matriceGioco.draw(matrice);
                
                if (vittoria == "")
                {
                    if (pareggio == "")
                    {
                        if (giocatore == 1)
                        {
                            giocatore = giocatore2;
                        }
                        else
                        {
                            giocatore = giocatore1;
                        } 
                    }
                    else
                    {
                        System.out.println(pareggio);
                    }
                }
                else
                {
                    System.out.println(vittoria);
                }
                for (int i = 0; i < 6; i++) 
                {
                    for (int j = 0; j < 7; j++) 
                    {
                        System.out.print(matrice[i][j] + " ");
                    }
                    System.out.println();
                }
            }
        }

        if (e.getSource() == b5)
        {
            int posizioneRiga = 5;
            for (int y = 0; y < 6; y++)
            {
                if (matrice[0][4] == giocatore1 || matrice[0][4] == giocatore2)
                {
                    validita = "Mossa non valide\nSelezionare un'altra colonna";
                    System.out.println(validita);
                    break;
                }
                
                if (matrice[y][4] == giocatore1 || matrice[y][4] == giocatore2)
                {
                    posizioneRiga = y-1;
                    break;
                }
                
            }
            if (validita == "")
            {
                matrice = matriceGioco.addMove(matrice, posizioneRiga, 4, giocatore);

                vittoria = matriceGioco.controllo(matrice, giocatore);

                pareggio = matriceGioco.draw(matrice);
                
                if (vittoria == "")
                {
                    if (pareggio == "")
                    {
                        if (giocatore == 1)
                        {
                            giocatore = giocatore2;
                        }
                        else
                        {
                            giocatore = giocatore1;
                        } 
                    }
                    else
                    {
                        System.out.println(pareggio);
                    }
                }
                else
                {
                    System.out.println(vittoria);
                }

                for (int i = 0; i < 6; i++) 
                {
                    for (int j = 0; j < 7; j++) 
                    {
                        System.out.print(matrice[i][j] + " ");
                    }
                    System.out.println();
                }
            }
        }

        if (e.getSource() == b6)
        {
            int posizioneRiga = 5;
            for (int y = 0; y < 6; y++)
            {
                if (matrice[0][5] == giocatore1 || matrice[0][5] == giocatore2)
                {
                    validita = "Mossa non valide\nSelezionare un'altra colonna";
                    System.out.println(validita);
                    break;
                }
                
                if (matrice[y][5] == giocatore1 || matrice[y][5] == giocatore2)
                {
                    posizioneRiga = y-1;
                    break;
                }
                
            }
            if (validita == "")
            {
                matrice = matriceGioco.addMove(matrice, posizioneRiga, 5, giocatore);

                vittoria = matriceGioco.controllo(matrice, giocatore);

                pareggio = matriceGioco.draw(matrice);
                
                if (vittoria == "")
                {
                    if (pareggio == "")
                    {
                        if (giocatore == 1)
                        {
                            giocatore = giocatore2;
                        }
                        else
                        {
                            giocatore = giocatore1;
                        } 
                    }
                    else
                    {
                        System.out.println(pareggio);
                    }
                }
                else
                {
                    System.out.println(vittoria);
                }

                for (int i = 0; i < 6; i++) 
                {
                    for (int j = 0; j < 7; j++) 
                    {
                        System.out.print(matrice[i][j] + " ");
                    }
                    System.out.println();
                }
            }
        }

        if (e.getSource() == b7)
        {
            int posizioneRiga = 5;
            for (int y = 0; y < 6; y++)
            {
                if (matrice[0][6] == giocatore1 || matrice[0][6] == giocatore2)
                {
                    validita = "Mossa non valide\nSelezionare un'altra colonna";
                    System.out.println(validita);
                    break;
                }
                
                if (matrice[y][6] == giocatore1 || matrice[y][6] == giocatore2)
                {
                    posizioneRiga = y-1;
                    break;
                }
                
            }
            if (validita == "")
            {
                matrice = matriceGioco.addMove(matrice, posizioneRiga, 6, giocatore);

                vittoria = matriceGioco.controllo(matrice, giocatore);
                
                pareggio = matriceGioco.draw(matrice);
                
                if (vittoria == "")
                {
                    if (pareggio == "")
                    {
                        if (giocatore == 1)
                        {
                            giocatore = giocatore2;
                        }
                        else
                        {
                            giocatore = giocatore1;
                        } 
                    }
                    else
                    {
                        System.out.println(pareggio);
                    }
                }
                else
                {
                    System.out.println(vittoria);
                }

                for (int i = 0; i < 6; i++) 
                {
                    for (int j = 0; j < 7; j++) 
                    {
                        System.out.print(matrice[i][j] + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
}
