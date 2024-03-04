
/**
 * CSCI 161 - Lab #3; Loop Math #1.
 *
 * @author Ben Buchwald & Anny Cui
 * @version 2021.27.05
 */
import java.util.Scanner; 

public class LoopMath1 {
    //Creating a row of "x"'s.
    public static String makeXString(int length) {
        String xString = "";
        for (int i = 0; i < length; i++) {
            xString = xString + "x"; 

        }
        return xString;
    }

    public static void main(String[] args) {
        //Asking the user for what integer to input.
        Scanner keyboardScanner = new Scanner (System.in);
        System.out.println("Please input some positive integer or zero!");
        int userNum = keyboardScanner.nextInt();

        //Printing output based on which function was called.
        System.out.println("Here are your x's: " + makeXString(userNum));
        System.out.println("2^" + userNum + " = " + make2RaisedtoNumber(userNum));

        if(isPrime(userNum)) {
            System.out.println(userNum + " is prime.");
        }
        else { 
            System.out.println(userNum + " is composite.");
        }
    }   

    //Creating a power sequence for 2 raise to the integer the user input.
    private static int make2RaisedtoNumber(int number) { 
        int powerSolution = 1;
        for (int i = 0; i < number; i++) {
            powerSolution *= 2;
        }
        return powerSolution;
    }

    //Determining if the user's integer was prime or not prime (composite).
    private static boolean isPrime(int number) {        
        if((number == 0) || (number == 1)) {
            return false;   
        }
        else {
            for(int i = 2; i < number; i ++) {            
                int remainder = number % i;                        
                if(remainder == 0) return false;        
            }        
            return true;
        }
    }
}