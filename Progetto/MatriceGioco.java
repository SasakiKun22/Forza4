public class MatriceGioco
{
    public MatriceGioco()
    {}

    public int[][] addMove(int[][] matrice, int posizioneY, int posizioneX, int giocatore)
    {
        matrice[posizioneY][posizioneX] = giocatore;
        return matrice;
    }

    public int controllo(int[][] matrice, int giocatore)
    {
        int vittoria = 0;

        for (int y = 0; y < 6; y++)
        {
            for (int x = 0; x < 7; x++)
            {
                if (x < 4)
                {
                    if (matrice[y][x] == giocatore & matrice[y][x+1] == giocatore & matrice[y][x+2] == giocatore & matrice[y][x+3] == giocatore)
                    {
                        vittoria = giocatore;
                        break;
                    }
                }

                if (y < 3)
                {
                    if (matrice[y][x] == giocatore & matrice[y+1][x] == giocatore & matrice[y+2][x] == giocatore & matrice[y+3][x] == giocatore)
                    {
                        vittoria =  giocatore;
                        break;
                    }
                }

                if (x < 4 & y < 3)
                {
                    if (matrice[y][x] == giocatore & matrice[y+1][x+1] == giocatore & matrice[y+2][x+2] == giocatore & matrice[y+3][x+3] == giocatore)
                    {
                        vittoria = giocatore;
                        break;
                    }
                }
                
                if (x >= 3 & y < 3)
                {
                    if (matrice[y][x] == giocatore & matrice[y+1][x-1] == giocatore & matrice[y+2][x-2] == giocatore & matrice[y+3][x-3] == giocatore)
                    {
                        vittoria = giocatore;
                        break;
                    }
                }
            }
        }
        return vittoria;
    }

    public int draw(int[][] matrice)
    {
        int pareggio = 0;
        for (int y = 0; y < 6; y++)
        {
            for (int x = 0; x < 7; x++)
            {
                if (matrice[y][x] == 0)
                {
                    pareggio = 0;
                    break;
                }
                else
                {
                    pareggio = 1;
                    continue;
                }
            }
            if (pareggio == 0)
            {
                break;
            }
        }
        return pareggio;
    }
}