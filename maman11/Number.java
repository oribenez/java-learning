package maman11;

import java.util.Scanner;
public class Number {
    
    /** 
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); //Create new scanner object
        System.out.print("Please enter a 4 digit number: "); // Ask from the user 4 digit number
        int num = scan.nextInt(); // reads 4 digits number from user // 4359

        if ((num >= 1000 && num <= 9999) || (num <= -1000 && num >= -9999)) { // checks if the number is 4 digit
            // print menu for the user
            System.out.print("1. Reverse sign. \n2. Reverse number. \n3. Reverse sign and number.\nPlease choose an option: ");

            int optionNum = scan.nextInt(); // reads option number (1,2,3) from the user
            if (optionNum == 1) { // user choose option 1
                System.out.println("\nThe result is:\n" + num*(-1)); // prints the opposite number sign

            } else if(optionNum == 2) { // user choose option 2
                System.out.println("\nThe result is:\n");
                
                // use arithmetic solution in order to get each digit seperatly
                //                 9          5             3            4    
                int newNum = num%10*1000 + num%100/10*100 + num/100%10*10 + num/1000;
                System.out.print(newNum); // Print the number on the opposite order

            } else if(optionNum == 3) { // user choose option 3
                System.out.println("\nThe result is:\n");

                // use arithmetic solution in order to get each digit seperatly
                //                 9             5                3            4    
                int newNum = num%10*1000 + num%100/10*100 + num/100%10*10 + num/1000;
                System.out.print(newNum*(-1)); // Print the number on the opposite order and sign

            } else { // user chose invalid number
                System.out.println("Illegal option – you must choose 1, 2 or 3");
                
            }
        } else { // user entered an illegal number
            System.out.println("Illegal number – you must enter a 4 digit number");
        }
        scan.close(); //close scanner session

    }
}
