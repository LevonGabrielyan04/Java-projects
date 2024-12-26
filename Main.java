import java.util.Scanner;
enum Directions
{
    up,
    down,
    left,
    right
}
class Service
{
    public void Start()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the bordes length: ");
        int BoardSizeX = scanner.nextInt();
        System.out.print("Enter the borders height: ");
        int BoardSizeY = scanner.nextInt();
        Turtule turtule = new Turtule();
        Board board = new Board(BoardSizeX, BoardSizeY);
        while(true){
            System.out.println("Enter a direction (up, down, left, right, or quit) and a step, for example 'up 3' or enter 'cp' to change the pen position: ");
            String input = scanner.nextLine().toLowerCase();
            String[] parts = input.split(" ");
            if (input.equals("QUIT")) {
                break;
            }
            try {
                Directions direction = Directions.valueOf(parts[0]);
                int step = Integer.parseInt(parts[1]);
                turtule.Move(direction,step,board);
                board.Print();
            } catch (Exception e) {
                if(parts[0].equals("cp"))
                {
                    turtule.IsPenDown = !turtule.IsPenDown;
                }
                else
                {
                    System.out.println("Invalid input");
                }
            }  
        }
        scanner.close();
    }
}
class Main
{
    public static void  main(String[] args)
    {
       Service service = new Service();
       service.Start();
    }
}
class Board
{
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
class Turtule
{
    public int CurrentX;
    public int CurrentY;
    public boolean IsPenDown;
    
    public Turtule()
    {
        CurrentX = 0;
        CurrentY = 0;
        IsPenDown = true;


    }
    public void Move(Directions direction, int step,Board board)
    {
        switch (direction)
        {
            case Directions.up:
                try
                {
                    if (IsPenDown)
                    {
                        for (int i = CurrentY; i <= step + CurrentY; i++)
                        {
                            board.DotsCordinates[CurrentX][i] = '|';
                        }
                    }
                    CurrentY += step;
                    if (CurrentY > board.BoardSizeY)
                        throw new Exception("Reached boards border");
                }
                catch (Exception e)
                {
                    CurrentY = board.BoardSizeY -1;
                }
                break;
            case Directions.down:
                try
                {
                    if (IsPenDown)
                    {
                        for (int i = CurrentY; i >= CurrentY - step; i--)
                        {
                            board.DotsCordinates[CurrentX][i] = '|';
                        }
                    }
                    CurrentY -= step;
                    if (CurrentY < 0)
                        throw new Exception("Reached boards border");
                }
                catch (Exception e)
                {
                    CurrentY = 0;
                }
                break;
            case Directions.left:
                try
                {
                    if (IsPenDown)
                    {
                        for (int i = CurrentX; i >= CurrentX - step; i--)
                        {
                            board.DotsCordinates[i][CurrentY] = '-';
                        }
                    }
                    CurrentX -= step;
                    if (CurrentX < 0)
                        throw new Exception("Reached boards border");
                }
                catch (Exception e)
                {
                    CurrentX = 0;
                }
                break;
            case Directions.right:
                try
                {
                    if (IsPenDown)
                    {
                        for (int i = CurrentX; i <= step + CurrentX; i++)
                        {
                            board.DotsCordinates[i][CurrentY] = '-';
                        }
                    }
                    CurrentX += step;
                    if (CurrentX > board.BoardSizeX)
                        throw new Exception("Reached boards border");
                }
                catch (Exception e)
                {
                    CurrentX = board.BoardSizeX -1;
                }
                break;
            //default:
                //throw new Exception("Invalid direction");
        }
    }
    public void SwitchPenPosition(boolean  isPenDown)
    {
        this.IsPenDown = isPenDown;
    }
}
