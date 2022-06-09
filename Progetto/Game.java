import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JFrame implements ActionListener
{
    JButton b1;
    JButton b2;
    JButton b3;
    JButton b4;
    JButton b5;
    JButton b6;
    JButton b7;
    JButton option;
    JTextField turni;
    int[][] matrix;
    GameMatrix gameMatrix = new GameMatrix();
    int turn = 1;
    String player1Name;
    String player2Name;
    int victory = 0;
    boolean validity = true;
    int draw = 0;

    Game(int[][] matrix, String player1Name, String player2Name, int turn)
    {   
        this.matrix = matrix;
        this.player1Name = player1Name;
        this.player1Name = player1Name;
        this.turn = turn;

        setTitle("CONNECT4: P1 vs P2");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(720, 800);
        setContentPane(new CirclesPanel(this.matrix));
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
        option = new JButton("|  |");

        if (turn == 1)
        {
            turni = new JTextField("Turn of " + this.player1Name + "(P1)");
        }
        else
        {
            turni = new JTextField("Turn of " + this.player1Name + "(P2)");
        }
        
        b1.setBounds(3, 650, 95, 50);
        b2.setBounds(104, 650, 95, 50);
        b3.setBounds(205, 650, 95, 50);
        b4.setBounds(306, 650, 95, 50);
        b5.setBounds(407, 650, 95, 50);
        b6.setBounds(508, 650, 95, 50);
        b7.setBounds(609, 650, 95, 50);
        option.setBounds(654, 710, 50, 50);
        turni.setBounds(3, 710, 640, 50);
        turni.setFont(new Font("MV Boli", Font.BOLD, 28));

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        option.addActionListener(this);
        
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b6);
        add(b7);
        add(option);
        add(turni);
        setLayout(null);
       
    }

    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == b1)
        {
            int yPosition = 5;
            for (int y = 0; y < 6; y++)
            {
                if (this.matrix[0][0] == 1 || this.matrix[0][0] == 2 )
                {
                    validity = false;
                    turni.setText("Invalid move, select another column");
                    break;
                }
                else
                {
                    validity = true;
                }
                
                if (this.matrix[y][0] == 1 || this.matrix[y][0] == 2)
                {
                    yPosition = y-1;
                    break;
                }
            }

            
            add(new CirclesPanel(this.matrix));
            repaint();

            if (validity == true)
            {
                matrix = gameMatrix.addMove(this.matrix, yPosition, 0, turn);

                victory = gameMatrix.controllo(this.matrix, turn);

                draw = gameMatrix.draw(this.matrix);
                
                if (victory == 0)
                {
                    if (draw == 0)
                    {
                        if (turn == 1)
                        {
                            turn = 2;
                            turni.setText("Turn of " + this.player1Name + "(P2)");
                        }
                        else
                        {
                            turn = 1;
                            turni.setText("Turn of " + this.player1Name + "(P1)");
                        } 
                    }
                    else
                    {
                        new DrawFrame(draw, player1Name, player1Name);
                        setEnabled(false);
                    }
                }
                else
                {
                    new VictoryFrame(victory, player1Name, player1Name);
                    setEnabled(false);
                }
            }
        }

        if (e.getSource() == b2)
        {
            int yPosition = 5;
            for (int y = 0; y < 6; y++)
            {
                if (this.matrix[0][1] == 1 || this.matrix[0][1] == 2 )
                {
                    validity = false;
                    turni.setText("Invalid move, select another column");
                    break;
                }
                else
                {
                    validity = true;
                }
                
                if (this.matrix[y][1] == 1 || this.matrix[y][1] == 2)
                {
                    yPosition = y-1;
                    break;
                }
                
            }

            add(new CirclesPanel(this.matrix));
            repaint();

            if (validity == true)
            {
                matrix = gameMatrix.addMove(this.matrix, yPosition, 1, turn);

                victory = gameMatrix.controllo(this.matrix, turn);

                draw = gameMatrix.draw(this.matrix);
                
                if (victory == 0)
                {
                    if (draw == 0)
                    {
                        if (turn == 1)
                        {
                            turn = 2;
                            turni.setText("Turn of " + this.player1Name + "(P2)");
                        }
                        else
                        {
                            turn = 1;
                            turni.setText("Turn of " + this.player1Name + "(P1)");
                        } 
                    }
                    else
                    {
                        new DrawFrame(draw, player1Name, player1Name);
                        setEnabled(false);
                    }
                }
                else
                {
                    new VictoryFrame(victory, player1Name, player1Name);
                    setEnabled(false);
                }
            }
        }

        if (e.getSource() == b3)
        {
            int yPosition = 5;
            for (int y = 0; y < 6; y++)
            {
                if (this.matrix[0][2] == 1 || this.matrix[0][2] == 2 )
                {
                    validity = false;
                    turni.setText("Invalid move, select another column");
                    break;
                }
                else
                {
                    validity = true;
                }
                
                if (this.matrix[y][2] == 1 || this.matrix[y][2] == 2)
                {
                    yPosition = y-1;
                    break;
                }
                
            }

            add(new CirclesPanel(this.matrix));
            repaint();

            if (this.validity == true)
            {
                matrix = gameMatrix.addMove(this.matrix, yPosition, 2, turn);

                victory = gameMatrix.controllo(this.matrix, turn);

                draw = gameMatrix.draw(this.matrix);
                
                if (victory == 0)
                {
                    if (draw == 0)
                    {
                        if (turn == 1)
                        {
                            turn = 2;
                            turni.setText("Turn of " + this.player1Name + "(P2)");
                        }
                        else
                        {
                            turn = 1;
                            turni.setText("Turn of " + this.player1Name + "(P1)");
                        } 
                    }
                    else
                    {
                        new DrawFrame(draw, player1Name, player1Name);
                        setEnabled(false);
                    }
                }
                else
                {
                    new VictoryFrame(victory, player1Name, player1Name);
                    setEnabled(false);
                }
            }
        }

        if (e.getSource() == b4)
        {
            int yPosition = 5;
            for (int y = 0; y < 6; y++)
            {
                if (this.matrix[0][3] == 1 || this.matrix[0][3] == 2)
                {
                    validity = false;
                    turni.setText("Invalid move, select another column");
                    break;
                }
                else
                {
                    validity = true;
                }
                
                if (this.matrix[y][3] == 1 || this.matrix[y][3] == 2)
                {
                    yPosition = y-1;
                    break;
                }
                
            }

            add(new CirclesPanel(this.matrix));
            repaint();

            if (validity == true)
            {
                matrix = gameMatrix.addMove(this.matrix, yPosition, 3, turn);

                victory = gameMatrix.controllo(this.matrix, turn);

                draw = gameMatrix.draw(this.matrix);
                
                if (victory == 0)
                {
                    if (draw == 0)
                    {
                        if (turn == 1)
                        {
                            turn = 2;
                            turni.setText("Turn of " + this.player1Name + "(P2)");
                        }
                        else
                        {
                            turn = 1;
                            turni.setText("Turn of " + this.player1Name + "(P1)");
                        } 
                    }
                    else
                    {
                        new DrawFrame(draw, player1Name, player1Name);
                        setEnabled(false);
                    }
                }
                else
                {
                    new VictoryFrame(victory, player1Name, player1Name);
                    setEnabled(false);
                }
            }
        }

        if (e.getSource() == b5)
        {
            int yPosition = 5;
            for (int y = 0; y < 6; y++)
            {
                if (this.matrix[0][4] == 1 || this.matrix[0][4] == 2)
                {
                    validity = false;
                    turni.setText("Invalid move, select another column");
                    break;
                }
                else
                {
                    validity = true;
                }
                
                if (this.matrix[y][4] == 1 || this.matrix[y][4] == 2)
                {
                    yPosition = y-1;
                    break;
                }
                
            }

            add(new CirclesPanel(this.matrix));
            repaint();

            if (validity == true)
            {
                matrix = gameMatrix.addMove(this.matrix, yPosition, 4, turn);

                victory = gameMatrix.controllo(this.matrix, turn);

                draw = gameMatrix.draw(this.matrix);
                
                if (victory == 0)
                {
                    if (draw == 0)
                    {
                        if (turn == 1)
                        {
                            turn = 2;
                            turni.setText("Turn of " + this.player1Name + "(P2)");
                        }
                        else
                        {
                            turn = 1;
                            turni.setText("Turn of " + this.player1Name + "(P1)");
                        } 
                    }
                    else
                    {
                        new DrawFrame(draw, player1Name, player1Name);
                        setEnabled(false);
                    }
                }
                else
                {
                    new VictoryFrame(victory, player1Name, player1Name);
                    setEnabled(false);
                }
            }
        }

        if (e.getSource() == b6)
        {
            int yPosition = 5;
            for (int y = 0; y < 6; y++)
            {
                if (this.matrix[0][5] == 1 || this.matrix[0][5] == 2)
                {
                    validity = false;
                    turni.setText("Invalid move, select another column");
                    break;
                }
                else
                {
                    validity = true;
                }
                
                if (this.matrix[y][5] == 1 || this.matrix[y][5] == 2)
                {
                    yPosition = y-1;
                    break;
                }
                
            }

            add(new CirclesPanel(this.matrix));
            repaint();

            if (validity == true)
            {
                matrix = gameMatrix.addMove(this.matrix, yPosition, 5, turn);

                victory = gameMatrix.controllo(this.matrix, turn);

                draw = gameMatrix.draw(this.matrix);
                
                if (victory == 0)
                {
                    if (draw == 0)
                    {
                        if (turn == 1)
                        {
                            turn = 2;
                            turni.setText("Turn of " + this.player1Name + "(P2)");
                        }
                        else
                        {
                            turn = 1;
                            turni.setText("Turn of " + this.player1Name + "(P1)");
                        } 
                    }
                    else
                    {
                        new DrawFrame(draw, player1Name, player1Name);
                        setEnabled(false);
                    }
                }
                else
                {
                    new VictoryFrame(victory, player1Name, player1Name);
                    setEnabled(false);
                }
            }
        }

        if (e.getSource() == b7)
        {
            int yPosition = 5;
            for (int y = 0; y < 6; y++)
            {
                if (this.matrix[0][6] == 1 || this.matrix[0][6] == 2)
                {
                    validity = false;
                    turni.setText("Invalid move, select another column");
                    break;
                }
                else
                {
                    validity = true;
                }
                
                if (this.matrix[y][6] == 1 || this.matrix[y][6] == 2)
                {
                    yPosition = y-1;
                    break;
                }
                
            }

            add(new CirclesPanel(this.matrix));
            repaint();

            if (validity == true)
            {
                matrix = gameMatrix.addMove(this.matrix, yPosition, 6, turn);

                victory = gameMatrix.controllo(this.matrix, turn);
                
                draw = gameMatrix.draw(this.matrix);
                
                if (victory == 0)
                {
                    if (draw == 0)
                    {
                        if (turn == 1)
                        {
                            turn = 2;
                            turni.setText("Turn of " + this.player1Name + "(P2)");
                        }
                        else
                        {
                            turn = 1;
                            turni.setText("Turn of " + this.player1Name + "(P1)");
                        } 
                    }
                    else
                    {
                        new DrawFrame(draw, player1Name, player1Name);
                        setEnabled(false);
                    }
                }
                else
                {
                    new VictoryFrame(victory, player1Name, player1Name);
                    setEnabled(false);
                }
            }
        }

        if (e.getSource() == option)
        {
            new OptionFrame(this.matrix, player1Name, player1Name, turn);
        } 
    }
}
