
/**
 * The Sieve of Eratosthenes program.
 *
 * @author Anny Cui
 * @version 2021.06.08
 */
import java.util.Scanner;
import java.util.Arrays;
public class SieveOfEratosthenes {
    public static void main(String[] args) {
        int maxNumber = getNumber();
        
        boolean[] isPrime = makeArray(maxNumber);
        removeComposites(isPrime);
        
        System.out.println("The prime numbers from 2 to " +maxNumber+ ": ");
        printOutPrimes(isPrime);
    }
    
    //ask for the maximum number
    private static int getNumber() {
        Scanner keyboardScanner = new Scanner(System.in);
        System.out.println("Welcome to the prime number calculator!");
        
        System.out.print("Please enter a maximum number: ");
        int userNumber = Integer.parseInt(keyboardScanner.nextLine());
        if(userNumber<=1) {
            System.out.println("Sorry, this is an invalid number.");
            System.exit(0);
        }
        
        return userNumber;
    }
    
    //create a boolean array
    private static boolean[] makeArray(int maxNumber) {
        //size of the array is n+1
        boolean[] isPrime = new boolean[maxNumber+1];
        
        //set initially all numbers are prime, except 0 and 1
        for(int i=0; i<isPrime.length; i++) {
            isPrime[i] = true;
            isPrime[0] = false;
            isPrime[1] = false;
        }
        
        return isPrime;
    }
    
    //remove nonprime numbers, starting with 2
    private static void removeComposites(boolean[] isPrime) {
        for(int p=2; p*p<isPrime.length; p++) {
            if(isPrime[p]) {
                //remove prime multiples
                for(int i=p*p; i<isPrime.length; i += p) {
                    isPrime[i] = false;
                }
            }
        }
    }
    
    //print out primes
    private static void printOutPrimes(boolean[] isPrime) {
        String primes = "";
        for(int i=2; i<isPrime.length; i++) {
            if(isPrime[i]) {
                primes = primes + ", " + i;
            }
        }
        System.out.println(primes.substring(2));
    }
}
