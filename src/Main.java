import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.Integer.valueOf;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your name.");
        String customerName = input.nextLine();
        System.out.println("Please enter your budget to spend as an integer.");


        boolean notEnteredCorrectly = true;
        int money = 0;
        while (notEnteredCorrectly) {
            try {
                    money = input.nextInt();
                    notEnteredCorrectly = false;
            } catch (InputMismatchException e) {

                System.out.println("Sorry that was not valid. Please enter your amount to spend as an integer e.g. 50");
                input.next();
              //  input.nextLine();
            }
            }


        Customer customer = new Customer(customerName, money);
        TakeOutSimulator takeOutSimulator = new TakeOutSimulator(customer, input);
        takeOutSimulator.startTakeOutSimulator();










    }
}