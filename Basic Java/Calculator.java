
/**
 * A calculator program.
 *
 * @author Anny Cui
 * @version 2021.05.24
 */
import java.util.Scanner;
public class Calculator {
    public static void main(String[] args) {
        
        Scanner userInput = new Scanner(System.in);
        
        //greeting
        System.out.println("Welcome to the calculator! ");
        System.out.println();
        
        //declare number and the operation
        int numFirst, numSecond, answer;
        String operation;
        
        //ask the 1st integer
        System.out.print("Please enter your first integer: ");
        numFirst = userInput.nextInt();
        
        //ask the math operation
        System.out.print("Please choose your math operation (+, -, *, or /): ");
        operation = userInput.next();
        
        //addition
        if(operation.equals("+")) {
            System.out.print("Please take another integer: ");
            numSecond = userInput.nextInt();
            
            answer = numFirst + numSecond;
            System.out.println("Your answer is: " + numFirst + " + " + numSecond + " = " + answer + ".");
        }
        
        //subtration
        else if(operation.equals("-")) {
            System.out.print("Please take another integer: ");
            numSecond = userInput.nextInt();
            
            answer = numFirst - numSecond;
            System.out.println("Your answer is: " + numFirst + " - " + numSecond + " = " + answer + ".");
        }
        
        //multiplication
        else if(operation.equals("*")) {
            System.out.print("Please take another integer: ");
            numSecond = userInput.nextInt();
            
            answer = numFirst * numSecond;
            System.out.println("Your answer is: " + numFirst + " * " + numSecond + " = " + answer + ".");
        }
        
        //division
        else if(operation.equals("/")) {
            System.out.print("Please take another integer: ");
            numSecond = userInput.nextInt();
            
            //if divide by 0
            if(numSecond == 0) {
                System.out.println("Sorry, the denominator should not be zero! ");
            }
            
            //if 2nd integer is nonzero
            else {
                answer = numFirst / numSecond;
                int answerRemainder = numFirst % numSecond;
                
                if(answerRemainder == 0) {
                    System.out.println("Your answer is: " + numFirst + " / " + numSecond + " = " + answer + ".");
                }
                
                else {
                    System.out.println("Your answer is: " + numFirst + " / " + numSecond + " = " + answer + " R " + answerRemainder + ".");
                }
            }
        }
        
        //nonsense symbol
        else {
            System.out.println("Sorry, this is an invalid symbol! ");
        }
    }
}
