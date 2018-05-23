import java.util.Scanner;
public class AdventureRunner
{
    public static void main(String args[])
    {
        Scanner keyboard = new Scanner(System.in);
        AdventureGame test = new AdventureGame();
        
        while(test.gameOver() == false)
        {
            System.out.println();
            test.areaDescription();
            System.out.println("What do you want to do? ");
            test.nextCommand(keyboard.next());
        }
    }
}
