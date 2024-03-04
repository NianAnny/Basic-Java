
/**
 * A program for daily profits of a small business.
 *
 * @author Anny Cui
 * @version 2021.06.01
 */
import java.util.Scanner;
import java.util.Arrays;
public class Business {
    public static void main(String[] args) {
        double[] dailyProfits = getDailyProfits();
        double averageProfit = calcAverageProfit(dailyProfits);
        double maxProfit = findMaxProfit(dailyProfits);
        double minProfit = findMinProfit(dailyProfits);
        
        //print out average profits
        System.out.print("Your average profit was $" + averageProfit + " ");
        
        //print out the standard deviation
        System.out.println("(plus or minus $" + calcStandardDeviation(dailyProfits, averageProfit) + " ).");
        
        //print out the day which gave the maxProfit
        System.out.print("The best day was Day " + findMaxDay(dailyProfits, maxProfit) + ", ");
        
        //print out the maximum profit
        System.out.println("when you made $" + maxProfit + ".");
        
        //print the worst day
        System.out.print("The worst day was Day " + findMinDay(dailyProfits, minProfit) + ", ");
        
        //print out the min profit
        System.out.println("when you made $" + minProfit + ".");
    }
    
    //get daily profits from the user
    private static double[] getDailyProfits() {
        System.out.println("Welcome to the profit-calculation program.");
        
        Scanner keyboardScanner = new Scanner(System.in);
        
        //ask how many days
        System.out.print("How many days' data do you have? ");
        int userDays = Integer.parseInt(keyboardScanner.nextLine());
        
        if(userDays <= 0) {
            do {
                if(userDays <= 0) System.out.print("Sorry, please enter a nonzero positive integer: ");
                userDays = Integer.parseInt(keyboardScanner.nextLine());
            } while(userDays <= 0);
        }
        
        double[] dailyProfits = new double[userDays];
        
        //ask for daily profits
        System.out.println("What was the profit on each days?");
        for(int i = 0; i < dailyProfits.length; i++) {
            dailyProfits[i] = Double.parseDouble(keyboardScanner.nextLine());
        }
        
        return dailyProfits;
    }
    
    //calculate the average profit
    private static double calcAverageProfit(double[] dailyProfits) {
        double averageProfit = 0.0;
        
        for(int i = 0; i < dailyProfits.length; i++) {
            averageProfit += dailyProfits[i] / dailyProfits.length;
        }
        return averageProfit;
    }
    
    //calculate the standard deviation of the profits (mean is the average)
    private static double calcStandardDeviation(double[] dailyProfits, double averageProfit) {
        double sumStandardDeviation = 0.0;
        
        for(int i = 0; i < dailyProfits.length; i++) {
            sumStandardDeviation += Math.pow(dailyProfits[i] - averageProfit, 2) / dailyProfits.length;
        }
        return Math.sqrt(sumStandardDeviation);
    }
    
    //find the maximum profit
    private static double findMaxProfit(double[] dailyProfits) {
        double maxProfit = dailyProfits[0];
        
        for(int i = 0; i < dailyProfits.length; i++) {
            if(dailyProfits[i] > maxProfit) {
                maxProfit = dailyProfits[i];
            }
        }
        return maxProfit;
    }
    
    //get the day which gave the maxProfit
    private static int findMaxDay(double[] dailyProfits, double maxProfit) {
        int maxDay = 0;
        
        for(int i = 0; i < dailyProfits.length; i++) {
            if(dailyProfits[i] == maxProfit) {
                maxDay = i + 1;
            }
        }
        return maxDay;
    }
    
    //find the minimum value
    private static double findMinProfit(double[] dailyProfits) {
        double minProfit = dailyProfits[0];
        
        for(int i = 0; i < dailyProfits.length; i++) {
            if(dailyProfits[i] < minProfit) {
                minProfit = dailyProfits[i];
            }
        }
        return minProfit;
    }
    
    //find the worst day
    private static int findMinDay(double[] dailyProfits, double minProfit) {
        int minDay = 0;
        
        for(int i = 0; i < dailyProfits.length; i++) {
            if(dailyProfits[i] == minProfit) {
                minDay = i + 1;
            }
        }
        return minDay;
    }
}
