import java.awt.*;

public class OttieniDati 
{
    String[] listaDati;

    public OttieniDati(String[] listaDati)
    {
        this.listaDati = listaDati;
    }


    public int[][] getMatrice()
    {
        int[][] matrice = {{0,0,0,0,0,0,0}, {0,0,0,0,0,0,0}, {0,0,0,0,0,0,0}, {0,0,0,0,0,0,0}, {0,0,0,0,0,0,0}, {0,0,0,0,0,0,0}};
        String matriceStringa = listaDati[0];

        String[] splitMatrice = matriceStringa.split(" ");
        
        for (int y = 0; y < 6; y++)
        {
            String rigaMatrice = splitMatrice[y];

            for (int x = 0; x < 7; x++)
            {
                char numeroChar = rigaMatrice.charAt(x);
                int numero = Character.getNumericValue(numeroChar);

                matrice[y][x] = numero;
            }
        }
        return matrice;
    }


    public String getPlayer1Name()
    {
        String namePlayer1 = listaDati[1];
        return namePlayer1;
    }


    public String getPlayer2Name()
    {
        String namePlayer2 = listaDati[2];
        return namePlayer2;
    }


    public int getTurno()
    {
        String turnoStringa = listaDati[3];
        int turno = Integer.parseInt(turnoStringa);

        return turno;
    }


    public Color getColorG1()
    {
        String coloreStringa = listaDati[4];
        Color coloreG1 = Color.getColor(coloreStringa);

        return coloreG1;
    }


    public Color getColorG2()
    {
        String coloreStringa = listaDati[5];
        Color coloreG2 = Color.getColor(coloreStringa);

        return coloreG2;
    }
}
