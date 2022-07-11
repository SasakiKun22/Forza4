public class GetData
{
    String[] dataList;

    /**
     * Extracts the information from the saving file.
     * @param dataList
     */
    public GetData(String[] dataList)
    {
        this.dataList = dataList;
    }

    /**
     * Takes the index 0 element to reconstruct the matrix;
     * @return the saved matrix
     */
    public int[][] getMatrice()
    {
        int[][] matrix = {{0,0,0,0,0,0,0}, {0,0,0,0,0,0,0}, {0,0,0,0,0,0,0}, {0,0,0,0,0,0,0}, {0,0,0,0,0,0,0}, {0,0,0,0,0,0,0}};
        String stringMatrix = dataList[0];

        String[] splitMatrix = stringMatrix.split(" ");
        
        for (int y = 0; y < 6; y++)
        {
            String rowMatrix = splitMatrix[y];

            for (int x = 0; x < 7; x++)
            {
                char numChar = rowMatrix.charAt(x);
                int num = Character.getNumericValue(numChar);

                matrix[y][x] = num;
            }
        }
        return matrix;
    }

    /**
     * Takes the index 1 element to get the player1 name;
     * @return the player1 name.
     */
    public String getPlayer1Name()
    {
        String namePlayer1 = dataList[1];
        return namePlayer1;
    }

    /**
     * Takes the index 2 element to get the player2 name;
     * @return the player2 name.
     */
    public String getPlayer2Name()
    {
        String namePlayer2 = dataList[2];
        return namePlayer2;
    }

    /**
     * Takes the index 3 element to get from which player will resume the game;
     * @return 1 or 2 based on the starting player.
     */
    public int getTurn()
    {
        String stringTurn = dataList[3];
        int turn = Integer.parseInt(stringTurn);

        return turn;
    }
}
