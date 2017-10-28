import java.util.Scanner;
import java.io.Console;
/**
 * A Java Scanner class example from http://alvinalexander.com
 */
public class One710251106JavaScannerExample
{
    public static void main (String[] args)
    {
        // create a scanner so we can read the command-line input
        Scanner scanner = new Scanner(System.in);

        //  prompt for the user's name
        System.out.print("Enter your name: ");

        // get their input as a String
        String username = scanner.nextLine();

        // prompt for their age
        System.out.print("Enter your age: ");

        // get the age as an int
        int age = scanner.nextInt();

        System.out.println(String.format("%s, your age is %d", username, age));

        Console Console = System.console();

        //  prompt for the user's name
        System.out.print("Enter your name: ");

        // get their input as a String
        String username1 = Console.readLine();

        // prompt for their age
        System.out.print("Enter your age: ");

        // get the age as an int
        int age1=0;
        while(true) {
            System.out.print("Enter your age: ");
            try {
                age1 = Integer.parseInt(Console.readLine());
                break;
            } catch (NumberFormatException nfe) {
                System.out.println("Your entry is not an integer!");
            }
        }
            System.out.println(String.format("%s, your age is %d", username1, age1));
    }
}
