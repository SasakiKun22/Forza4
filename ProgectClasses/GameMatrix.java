public class GameMatrix
{
    /**
     * Adds 1 or 2 in the matrix based on the player making the move;
     * @param matrix
     * @param yPosition
     * @param xPosition
     * @param turn
     * @return the matrix with the added move.
     */
    public int[][] addMove(int[][] matrix, int yPosition, int xPosition, int turn)
    {
        matrix[yPosition][xPosition] = turn;
        return matrix;
    }

    
    /**
     * Controls the victory of one of the two players;
     * @param matrix
     * @param turn
     * @return 1 or 2 based on the winning player.
     */
    public int controllo(int[][] matrix, int turn){
        int victory = 0;

        for (int y = 0; y < 6; y++){
            for (int x = 0; x < 7; x++){
                if (x < 4){
                    if (matrix[y][x] == turn & matrix[y][x+1] == turn & matrix[y][x+2] == turn & matrix[y][x+3] == turn){
                        victory = turn;
                        break;
                    }
                }
                if (y < 3){
                    if (matrix[y][x] == turn & matrix[y+1][x] == turn & matrix[y+2][x] == turn & matrix[y+3][x] == turn){
                        victory =  turn;
                        break;
                    }
                }
                if (x < 4 & y < 3){
                    if (matrix[y][x] == turn & matrix[y+1][x+1] == turn & matrix[y+2][x+2] == turn & matrix[y+3][x+3] == turn){
                        victory = turn;
                        break;
                    }
                }
                if (x >= 3 & y < 3){
                    if (matrix[y][x] == turn & matrix[y+1][x-1] == turn & matrix[y+2][x-2] == turn & matrix[y+3][x-3] == turn)
                    {
                        victory = turn;
                        break;
                    }
                }
            }
        }
        return victory;
    }

    /**
     * Checks the draw;
     * @param matrix
     * @return 1 if draw, 0 otherwise.
     */
    public int draw(int[][] matrix)
    {
        int draw = 0;

        for (int x = 0; x < 7; x++)
        {
            if(matrix[0][x] == 0)
            {
                draw = 0;
                break;
            }
            else
            {
                draw = 1;
            }
        }
        return draw;
    }
}