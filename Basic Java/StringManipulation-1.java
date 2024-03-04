
/**
 * A string manipulation program.
 *
 * @author Anny Cui
 * @version 2021.05.22
 */
import java.util.Scanner;
public class StringManipulation {
    public static void main(String[] args) {
        
        Scanner keyboardScanner = new Scanner(System.in);
        
        //1st section in instruction
        //1st string
        System.out.print("Please enter the String1: ");
        String userFirst = keyboardScanner.nextLine();
        
        //2nd string
        System.out.print("Please enter the String2: ");
        String userSecond = keyboardScanner.nextLine();
        
        //3rd string
        System.out.print("Please enter the String3: ");
        String userThird = keyboardScanner.nextLine();
        
        System.out.println();
        
        //2nd part        
        //length of the 2nd string
        int userLength = userSecond.length();
        System.out.println("The length of user's 2nd String: " + userLength);
        
        //3rd part
        //1st string concatenated with the 2nd one
        String result = userFirst + " " + userSecond;
        System.out.println(result);
        
        //4th operation
        //if the 1st and the 2nd strings are the same
        boolean isSame = userFirst.equalsIgnoreCase(userSecond);
        
        if(isSame) {
            System.out.println("true.");
        }
        else {
            System.out.println("false.");
        }
        
        
        //5th operation
        //1st index of "c" in the 1st string
        int firstIndex = userFirst.indexOf("c");
        System.out.println("The first index where the character c appears in the 1st String: " + firstIndex);
        
        //6th operation
        //3rd string appears within the 2nd one
        int indexAppear = userSecond.indexOf(userThird);
        System.out.println("The index where the 3rd String appears within the 2nd one: " + indexAppear);
        
        //7th part
        //2nd string in all capital letters
        System.out.println(userSecond.toUpperCase());
        
        //8th part
        //parse the 3rd string as an integer and add it to 10, if it is a number
        int userNumber = Integer.parseInt(userThird);
        int addTen = userNumber + 10;
        System.out.println("The result for adding the third string to 10 is: " + addTen);
    }
}
