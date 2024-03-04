
/**
 * The loop math program for homework 4.
 *
 * @author Anny Cui
 * @version 2021.05.27
 */
import java.util.Scanner;
public class LoopMath2  {
    
    private static String findPositiveLessOdd(int number) {
        
        //1st odd number is 1, except 0 as the entered number
        String positiveLessOdd = "";
        
        //when enter 0
        if(number == 0) return "";
        
        //find odd numbers
        for(int i = 1; i <= number;i += 2) {
            positiveLessOdd = positiveLessOdd + " "+ i;
        }
            
        //find odd number, a series of integers
        return positiveLessOdd;
    }
    
    //int maybe overflow, use long for factorial answer
    private static long calcFactorial(int number) {
        //original number for multiplication
        long factorial = 1;
        
        //do calculation of the factorial
        for(long i = 0; i < number; i ++) {
            factorial *= i + 1;
        }
        
        //get the factorial of the number
        return factorial;
    }
    
    //use long for nth fibonacci number
    private static long findFib(int number) {
        //declare an array for fibonacci numbers, nth number is in the (n+1) box
        int[] fibs= new int[number + 1];
        
        //when enter 0
        if(number == 0) {
            return 0;
        }
        
        //when enter 1
        else if(number == 1) {
            return 1;
        }
        
        //when enter other positive numbers
        else {
            //declare nth fibonacci number, 1st box[0] contains 0
            fibs[0] = 0;
            fibs[1] = 1;
            
            //find fibonacci number, starts with the 3rd box
            for(int i = 2; i < number + 1; i ++) {
                fibs[number] = fibs[i];
                fibs[i] = fibs[i - 1] + fibs[i - 2];
            }
        }
        
        //get the nth fibonacci number, only 1 integer, not a series of numbers
        return fibs[number];
    }
    
    public static void main(String[] args) {
        
        Scanner keyboardScanner = new Scanner(System.in);
        
        //ask for an integer
        System.out.print("Please enter a nonnegative integer: ");
        int userNum = keyboardScanner.nextInt();
        System.out.println();
        
        //prints positive odd number less than user's integer
        
        //when enter 0
        if(findPositiveLessOdd(userNum).equals("")) {
            System.out.println("There are no positive odd numbers less than or equal to 0!");
        }
        
        //find positive odd numbers
        else {
            System.out.println("Positive odd numbers less than or equal to " + userNum + ": " + findPositiveLessOdd(userNum));
        }
        
        
        //prints our the factorial of the number
        System.out.println(userNum + "!" + " = " + calcFactorial(userNum));
        
        
        //prints out the nth Fibonacci number
        
        //when enter 0
        if(findFib(userNum) == 0) {
            System.out.println("Fib(0) = 0");
        }
        
        //when enter 1
        else if(findFib(userNum) == 1) {
            System.out.println("Fib(1) = 1");
        }
        
        //get the nth fibonacci number
        else {
            System.out.println("Fib(" + userNum + ")" + " = " + findFib(userNum));
        }
    }
}
