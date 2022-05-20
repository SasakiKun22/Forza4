public class MatriceGioco
{
    

    public MatriceGioco()
    {}

    public int[][] addMove(int[][] matrice, int posizioneY, int posizioneX, int giocatore)
    {
        matrice[posizioneY][posizioneX] = giocatore;
        return matrice;
    }

    public String controllo(int[][] matrice, int giocatore)
    {
        String vittoria = "";

        for (int y = 0; y < 6; y++)
        {
            for (int x = 0; x < 7; x++)
            {
                if (x < 4)
                {
                    if (matrice[y][x] == giocatore & matrice[y][x+1] == giocatore & matrice[y][x+2] == giocatore & matrice[y][x+3] == giocatore)
                    {
                        vittoria = "vittoria " + giocatore;
                        break;
                    }
                }

                if (y < 3)
                {
                    if (matrice[y][x] == giocatore & matrice[y+1][x] == giocatore & matrice[y+2][x] == giocatore & matrice[y+3][x] == giocatore)
                    {
                        vittoria = "vittoria " + giocatore;
                        break;
                    }
                }

                if (x < 4 & y < 3)
                {
                    if (matrice[y][x] == giocatore & matrice[y+1][x+1] == giocatore & matrice[y+2][x+2] == giocatore & matrice[y+3][x+3] == giocatore)
                    {
                        vittoria = "vittoria " + giocatore;
                        break;
                    }
                }
                
                if (x >= 3 & y < 3)
                {
                    if (matrice[y][x] == giocatore & matrice[y+1][x-1] == giocatore & matrice[y+2][x-2] == giocatore & matrice[y+3][x-3] == giocatore)
                    {
                        vittoria = "vittoria " + giocatore;
                        break;
                    }
                }
            }
        }
        return vittoria;
    }

    public String draw(int[][] matrice)
    {
        String pareggio = "";
        for (int y = 0; y < 6; y++)
        {
            for (int x = 0; x < 7; x++)
            {
                if (matrice[y][x] == 0)
                {
                    pareggio = "";
                    break;
                }
                else
                {
                    pareggio = "Pareggio";
                    continue;
                }
            }
            if (pareggio == "")
            {
                break;
            }
        }
        return pareggio;
    }
}