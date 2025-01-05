package mypack;
import java.util.Scanner;

enum Directions
{
    up,
    down,
    left,
    right
}

public class Service {
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
