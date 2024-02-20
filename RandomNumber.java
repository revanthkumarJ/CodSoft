import java.util.Scanner;
import java.util.Random;

public class RandomNumber
{
    public static void RandomGuess()
    {
        System.out.println("\nCodSoft Task-1:Random Number Guessing:");
        Scanner sc=new Scanner(System.in);
        String playAgain="yes";
        Random r=new Random();
        int maxGuesses=10;
        while(playAgain.equals("yes"))
        {
            int guess=r.nextInt(500);
            System.out.println("\nGuess a Number between 0-500:");
            int num=-1;
            for(int i=1;i<=maxGuesses;i++)
            {
                System.out.print("Enter your Guess:");
                num=sc.nextInt();
                if(num==guess)
                {
                    System.out.println("\nWow! You guessed right");
                    System.out.println("The number is:"+guess);
                    System.out.println("It took you only "+i+" guesses");
                    System.out.println("Score:"+((10-i)*10)+"/100");
                    System.out.print("Would you like to play again(yes/no):  ");
                    playAgain=sc.next().toLowerCase();
                    break;
                }
                else if(num>guess)
                    System.out.println("Your guess is too high.Try again!");
                else
                    System.out.println("Your guess is too low.Try again!");
            }
            if(num!=guess)
            {
                System.out.println("\nSorry, you're out of guesses. The correct number was: " + guess);
                System.out.print("Would you like to play again(yes/no):  ");
                playAgain=sc.next().toLowerCase();
            }
        }
        System.out.println("\n************************************");
        System.out.println("\n Hope you love this Game.Thank You ");
        sc.close();
    }
    public static void main(String[] args) 
    {
        RandomGuess();
    }
}