
/**
 * A shaker sort program.
 *
 * @author Anny Cui
 * @version 2021.06.05
 */
import java.util.Scanner;
import java.util.Arrays;
public class ShakerSort {
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
        for(int i=0; i<randomNumbers.length; i++) {
            int left = randomNumbers[0];
            int right = randomNumbers[randomNumbers.length-1];
            
            //left to right
            for(int j=i; j<randomNumbers.length-1-i; j++) {
                if(randomNumbers[j]>randomNumbers[j+1]) {
                    left = randomNumbers[j];
                    randomNumbers[j] = randomNumbers[j+1];
                    randomNumbers[j+1] = left;
                }
            }
            
            //right to left, the righmost one is fixed
            for(int k=randomNumbers.length-1-i-1; k>i; k--) {
                if(randomNumbers[k]<randomNumbers[k-1]) {
                    right = randomNumbers[k];
                    randomNumbers[k] = randomNumbers[k-1];
                    randomNumbers[k-1] = right;
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
