
/**
 * An if math program.
 *
 * @author Ben Buchwald and Anny Cui
 * @version 2021.05.25
 */
import java.util.Scanner;
public class IfMath {
    public static void main(String[] args) {
        
        Scanner keyboardScanner = new Scanner(System.in);
        
        //option menu
        System.out.println("1. Even/Odd Detector");
        System.out.println("2. Quadrant Finder");
        System.out.println("3. Quadratic Solver");
        
        //get the selection from the user
        System.out.print("Please enter the number for which selection you want: ");
        String userInput = keyboardScanner.nextLine();
        
        System.out.println();
        
        
        //if the 1st option
        if(userInput.contains("1")) {
            //ask for the integer
            System.out.print("Please enter an integer: ");
            int userNumber = Integer.parseInt(keyboardScanner.nextLine());
            
            boolean isEven = (userNumber % 2) == 0;
            
            //even integer
            if(isEven) {
                System.out.println("This integer is even.");
            }
            
            //odd integer
            else {
                System.out.println("This integer is odd. ");
            }
        }
        
        
        //if the 2nd option
        else if(userInput.contains("2")) {
            //ask for x and y coordinates
            System.out.print("Please enter a decimal for x coordinate: ");
            double userX = Double.parseDouble(keyboardScanner.nextLine());
            
            System.out.print("Please enter a deccimal for y coordinate: ");
            double userY = Double.parseDouble(keyboardScanner.nextLine());
            
            //I quadrant
            if((userX > 0) && (userY > 0)) { 
                System.out.println("This point is located in the first quadrant.");
            }
            
            //II quadrant
            else if((userX < 0) && (userY > 0)) {
                System.out.println("This point is located in the second quadrant. ");
            }
            
            //III quadrant
            else if((userX < 0) && (userY < 0)) {
                System.out.println("This point is located in the third quadrant. ");
            }
            
            //IV quadrant
            else if((userX > 0) && (userY < 0)) {
                System.out.println("This point is located in the fourth quadrant. ");
            }
            
            //y-axis
            else if((userX == 0) && (userY != 0)) {
                System.out.println("This point is located on the y-axis. ");
            }
            
            //x-axis
            else if((userX != 0) && (userY == 0)) {
                System.out.println("This point is located on the x-axis. ");
            }
            
            //origin
            else {
                System.out.println("This point is the origin. ");
            }
        }
        
        
        //if the 3rd option
        else if(userInput.contains("3")) {
            //ask for numbers
            System.out.print("Please enter a decimal for a: ");
            double numA = Double.parseDouble(keyboardScanner.nextLine());
            System.out.print("What is b: ");
            double numB = Double.parseDouble(keyboardScanner.nextLine());
            System.out.print("And for c: ");
            double numC = Double.parseDouble(keyboardScanner.nextLine());
            
            //solve for x = (-b + || - sqrt(b^2 - 4ac))/2a
            
            //if (b^2-4ac) > 0
            if((numB * numB - 4 * numA * numC) > 0) {
                double root1 = (-numB + Math.sqrt(numB * numB - 4 * numA * numC)) / (2 * numA);
                double root2 = (-numB - Math.sqrt(numB * numB - 4 * numA * numC)) / (2 * numA);
                System.out.println("The 2 real roots are: " + root1 + "and " + root2 + ".");
            }
            
            //if(b^2-4ac) = 0
            else if((numB * numB - 4 * numA * numC) == 0) {
                double answer = -numB / (2 * numA);
                System.out.println("The root is: " + answer + ".");
            }
            
            //if (b^2-4ac) is negative
            else {
                System.out.println("There are not real solutions for your numbers!" );
            }
        }
        
        
        //if the user doesn't choose from the menu
        else {
            System.out.println("Sorry, that's not a valid option!" );
        }
    }
}
