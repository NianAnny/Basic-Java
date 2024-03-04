
/**
 * A SelectionSort program.
 *
 * @author Tristenne Cranford and Anny Cui
 * @version 2021.06.02
 */
import java.util.Scanner;
import java.util.Arrays;
public class SelectionSort {
   public static void main(String[] args) {
       
       int sortingTime = timeNumbers();
       
       System.out.println("Time taken to sort: " + sortingTime + " ms");
   }
   
   //get the array size and give numbers randomly
   private static int[] makeRandomArray() {
       Scanner keyboardScanner = new Scanner(System.in);
       
       System.out.print("Please enter the array size: ");
       int userSize = Integer.parseInt(keyboardScanner.nextLine());
       
       if(userSize <= 0) {
           System.out.println("Sorry, this is an invalid array size.");
           System.exit(0);
       }
       
       
       int[] randomNumbers = new int[userSize];
       
       for(int i = 0; i < randomNumbers.length; i++) {
           randomNumbers[i] = (int)(Math.random() * randomNumbers.length + 1);
       }
       
       return randomNumbers;
   }
   
   //sort numbers in the array
   private static void arrangeNumbers(int[] randomNumbers) {
       
       for(int i = randomNumbers.length; i > 1; i--) {
           //find the greatest element...
           int max = randomNumbers[0];
           int maxJ = 0;
           for(int j = 0; j < i; j++) {
               if(max < randomNumbers[j]) {
                   maxJ = j;
                   max = randomNumbers[j];
               }
           }
           //...and swap to the end
           randomNumbers[maxJ] = randomNumbers[i - 1];
           randomNumbers[i - 1] = max;
       }
   }
   
   //time the sorting process
   private static int timeNumbers() {
       int[] randomNumbers = makeRandomArray();
       if(randomNumbers.length <= 100) System.out.println("Unsorted: " + Arrays.toString(randomNumbers));
       
       long startTime = System.currentTimeMillis();
       arrangeNumbers(randomNumbers);
       long endTime = System.currentTimeMillis();
       
       int sortingTime = (int)(endTime - startTime);
       
       if(randomNumbers.length <= 100) System.out.println("Sorted: " + Arrays.toString(randomNumbers));
       return sortingTime;
   }
}
