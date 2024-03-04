
/**
 * A conversation program for group.
 *
 * @author Ben Buchwald and Anny Cui
 * @version 2021.05.20
 */
import java.util.Scanner;
public class Conversation {
    public static void main(String [] args) {
        Scanner keyboardScanner = new Scanner (System.in);
        
        // Get the user's name
        System.out.println("Hi! What's your name? "); 
        String userInput = keyboardScanner.nextLine();
        System.out.print("Hello, " + userInput + ". It's nice to meet you. ");
        
        // Get the user's birthday
        System.out.println("What's your birthday? ");
        userInput = keyboardScanner.nextLine();
        
        // What the user want for birthday
        System.out.println("What you want for your birthday? ");
        userInput = keyboardScanner.nextLine();
        
        // Cost of the gift
        System.out.println("Great, is that your favorite gift? How much is it cost?");
        String costString = keyboardScanner.nextLine();
        double userCost = Double.parseDouble(costString);
        
        // How much we would pay
        double wePay = userCost - 1;
        System.out.println("That's too expensive! We will pay " + wePay + ".");
        System.out.println();
        
        // Rate of the conversation
        System.out.println("Thank you talking to me! Please rate today's conversation. From 1 (unsatisfied) to 10 (satisfied).");
        String rateString = keyboardScanner.nextLine();
        int userRate = Integer.parseInt(rateString);
        
        // Ending
        System.out.println("Thanks for your time! See you!");
    }
}