package mypack;

public class Turtule {
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
