public class GetData
{
    String[] dataList;

    public GetData(String[] dataList)
    {
        this.dataList = dataList;
    }


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


    public String getPlayer1Name()
    {
        String namePlayer1 = dataList[1];
        return namePlayer1;
    }


    public String getPlayer2Name()
    {
        String namePlayer2 = dataList[2];
        return namePlayer2;
    }


    public int getTurn()
    {
        String stringTurn = dataList[3];
        int turn = Integer.parseInt(stringTurn);

        return turn;
    }
}
