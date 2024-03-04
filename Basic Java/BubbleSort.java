
/**
 * A bubble sort program.
 *
 * @author Anny Cui
 * @version 2021.06.04
 */
import java.util.Scanner;
import java.util.Arrays;
public class BubbleSort {
    public static void main(String[] args) {
        int sortingTime = timeSorting();
        System.out.println("Time taken to sort: " + sortingTime + " ms.");
    }
    
    //ask for the array size and make the array with random numbers
    private static int[] makeRandomArray() {
        Scanner keyboardScanner = new Scanner(System.in);
        
        System.out.print("Please enter the array size: ");
        int arraySize = Integer.parseInt(keyboardScanner.nextLine());
        
        if(arraySize <= 0) {
            System.out.println("Sorry, this is an invalid size!");
            System.exit(0);
        }
        
        int[] randomNumbers = new int[arraySize];
        
        for(int i=0; i<randomNumbers.length; i++) {
            randomNumbers[i] = (int)(Math.random() * randomNumbers.length + 1);
        }
        
        return randomNumbers;
    }
    
    //sort the random numbers
    private static void arrangeNumbers(int[] randomNumbers) {
        for(int i=0; i<randomNumbers.length-1; i++) {
            int max = randomNumbers[0];
            
            for(int j=i+1; j<randomNumbers.length; j++) {
                if(randomNumbers[i]>randomNumbers[j]) {
                    max = randomNumbers[i];
                    randomNumbers[i] = randomNumbers[j];
                    randomNumbers[j] = max;
                }
            }
        }
    }
    
    //time the sorting process
    private static int timeSorting() {
        int[] randomNumbers = makeRandomArray();
        if(randomNumbers.length <= 100) System.out.println("Unsorted: " + Arrays.toString(randomNumbers));
        
        long startTime = System.currentTimeMillis();
        arrangeNumbers(randomNumbers);
        long endTime = System.currentTimeMillis();
        
        if(randomNumbers.length <= 100) System.out.println("Sorted: " + Arrays.toString(randomNumbers));
        
        return (int)(endTime - startTime);
    }
}
