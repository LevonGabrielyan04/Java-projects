package mypack;
public class Board {
    public int BoardSizeX;
    public int BoardSizeY;
    public char[][] DotsCordinates;
    public Board(int boardSizeX, int boardSizeY)
    {
        BoardSizeX = boardSizeX;
        BoardSizeY = boardSizeY;
       DotsCordinates = new char[BoardSizeX][BoardSizeY];
        for (int i = 0; i < BoardSizeX; i++)
        {
            for (int j = 0; j < BoardSizeY; j++)
            {
                DotsCordinates[i][j] = '0';
            }
        }
    }
    public void Print()
    {
        for (int i = BoardSizeY - 1; i >= 0; i--) {
            for (int j = 0; j < BoardSizeX; j++) {
                System.out.print(DotsCordinates[j][i]);
            }
            System.out.println();
        }
    }
}
