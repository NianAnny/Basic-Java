
/**
 * A rabbit and fox simulation program.
 *
 * @author Tristenne Cranford and Anny Cui
 * @version 2021.06.08
 */

import java.util.Scanner;
import java.util.Arrays;
public class RabbitsAndFoxes {
    public static void main(String[] args) {
        int[][] animalArrays = makeSimulationArrays();
        int[] rabbitArray = (int[])(animalArrays[0]);
        int[] foxArray = (int[])(animalArrays[1]);
        
        int[][] animalPopulations = calcAnimalPopulations(rabbitArray, foxArray);
        
        int[] rabbitPopulation = (int[])(animalPopulations[0]);
        int[] foxPopulation = (int[])(animalPopulations[1]);
        
        printOutPopulations(rabbitPopulation, foxPopulation);
        
        System.out.println("Rabbit population: " +Arrays.toString(rabbitPopulation));
        System.out.println("Fox population: " +Arrays.toString(foxPopulation));
        System.out.println("Goodbye!");
    }
    
    //ask for years and make initial animal arrays
    private static int[][] makeSimulationArrays() {
        Scanner keyboardScanner = new Scanner(System.in);
        System.out.println("Welcome to the rabbit and fox program!");
        
        //ask for how many years of simulation
        System.out.print("How many years of simulation do you want? ");
        int years = Integer.parseInt(keyboardScanner.nextLine());
        if(years<=0) {
            System.out.println("Sorry, this number is invalid!");
            System.exit(0);
        }
        
        int[] rabbitArray = new int[years+1];
        int[] foxArray = new int[years+1];
        
        //ask for initial rabbit population
        System.out.print("Please enter the initial rabbit population: ");
        int rabbitInitial = Integer.parseInt(keyboardScanner.nextLine());
        if(rabbitInitial<0) {
            System.out.println("Sorry, this is an invalid number!");
            System.exit(0);
        }
        rabbitArray[0] = rabbitInitial;
        
        //ask for initial fox number
        System.out.print("Please enter the initial fox population: ");
        int foxInitial = Integer.parseInt(keyboardScanner.nextLine());
        if(foxInitial<0) {
            System.out.println("Sorry, this is an invalid number!");
            System.exit(0);
        }
        foxArray[0] = foxInitial;
        
        int[][] animalArrays = new int[2][];
        animalArrays[0] = rabbitArray;
        animalArrays[1] = foxArray;
        
        return animalArrays;
    }
    
    //calculate rabbits and foxes
    private static int[][] calcAnimalPopulations(int[] rabbitArray, int[] foxArray) {
        int[][] animalPopulations = new int[2][];
        
        int[] rabbitPopulation = rabbitArray;
        final double RABBIT_BIRTH = 0.2;
        final double RABBIT_DEATH = 0.005;
        
        int[] foxPopulation = foxArray;
        final double FOX_BIRTH = 0.001;
        final double FOX_DEATH = 0.2;
        
        for(int i=1; i<rabbitArray.length; i++) {
            rabbitPopulation[i] = (int)(Math.round(rabbitPopulation[i-1] + (RABBIT_BIRTH * rabbitPopulation[i-1]) - (RABBIT_DEATH * rabbitPopulation[i-1] * foxPopulation[i-1])));
            if(rabbitPopulation[i]<=0) {
                rabbitPopulation[i] = 0;
            }
            
            foxPopulation[i] = (int)(Math.round(foxPopulation[i-1] + (FOX_BIRTH * rabbitPopulation[i-1] * foxPopulation[i-1]) - (FOX_DEATH * foxPopulation[i-1])));
            if(foxPopulation[i]<=0) {
                foxPopulation[i] = 0;
            }
        }
        
        animalPopulations[0] = rabbitPopulation;
        animalPopulations[1] = foxPopulation;
        
        return animalPopulations;
    }
    
    //print out numbers of rabbits and foxes in each year
    private static void printOutPopulations(int[] rabbitPopulation, int[] foxPopulation) {
        for(int i=0; i<rabbitPopulation.length; i++ ) {
            System.out.println("Year " +i+ ": " +rabbitPopulation[i]+ " rabbits, " +foxPopulation[i]+ " foxes.");
        }
    }
}
