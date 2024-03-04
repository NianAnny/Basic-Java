
/**
 * A partners progarm.
 *
 * @author Ben Buchwald, Rob Gattiker, and Anny Cui
 * @version 2021.06.01
 */
import java.util.Scanner;
import java.util.Arrays;
public class Partners {
   //print out pairs
    public static void main(String[] args) {
       String[] names = getNames();
       
       String[] namePairs = pairUpPeople(names);
       
       printOutPairs(namePairs);
    }
   
   //get names and alphabetize them
   private static String[] getNames() {
       Scanner keyboardScanner = new Scanner(System.in);
       
       //ask for how many members in the team
       System.out.print("How many people are there? ");
       int userInput = Integer.parseInt(keyboardScanner.nextLine());
       
       String[] nameList = new String[userInput];
      
       //ask names
       System.out.println("Please enter the names of those people: ");
       
       for(int i = 0; i < nameList.length; i ++) {
           nameList[i] = keyboardScanner.nextLine();
       }
       
       Arrays.sort(nameList);
       
       return nameList;
   }
   
   //creating pairs of 2 with user's names
   private static String[] pairUpPeople(String[] names) {
       String[] peoplePairs = new String[names.length * (names.length - 1) / 2];
       
       int p = 0;
       
       for(int i = 0; i < names.length; i++) {
           for(int j = i + 1; j < names.length; j ++) {
               peoplePairs[p] = names[i] + " " + names[j];
               p ++;
           }
        }
        
        return peoplePairs;
    }
    
    //give the number of possible pairs
    private static void printOutPairs(String[] pairsOfPeople) {
        
        System.out.println("Thank you. There are " + pairsOfPeople.length + " posible pairings.");
        
        for(int i = 0; i < pairsOfPeople.length; i++) {
            System.out.println(pairsOfPeople[i]);
        }
    }
}
