/**
 * HeartRate
 */
import java.util.Scanner;
public class HeartRate {

    
    /** 
     * @param args
     */
    public static void main(String[] args) {
        //Initialize constants
        final int CONST = 220;
        final int HIGH_LIMIT = 85;
        final int LOW_LIMIT = 65;
        final int PERCENT_NUM = 100;

        Scanner scan = new Scanner (System.in); //Create new scanner object

        // Print questions
        System.out.println ("This program calculates your " + "target heart rate while exercising "); 
        System.out.print ("Enter your age: ");

        int age = scan.nextInt(); //reads the age of the user
        int highestHR = (CONST - age) * HIGH_LIMIT/PERCENT_NUM; //highest heart rate
        int lowestHR = (CONST - age) * LOW_LIMIT/PERCENT_NUM; //lowest heart rate

        //Prints to the user his estimated heart rate
        System.out.println("Your estimated target heart rate zone is " + lowestHR + " - " + highestHR + " beats per minute.");

        scan.close(); //close scanner session
    }
}