import java.util.Scanner;

// Create TakeOutSimulator class here

public class TakeOutSimulator {

    private Customer customer;
    private FoodMenu menu;
    private Scanner input;

    public TakeOutSimulator(Customer customer, Scanner input, FoodMenu menu) {
        this.customer = customer;
        this.menu = menu;
        this.input = input;
    }

    private <T> T getOutputOnIntInput(String userInputPrompt, IntUserInputRetriever intUserInputRetriever) {
        while (true) {
            System.out.println(userInputPrompt);
            try {
                if (input.hasNextInt()) {
                    return (T) intUserInputRetriever.produceOutputOnUserInput(input.nextInt());
                }

            } catch (IllegalArgumentException e) {
                if (input.hasNextInt()) {
                    System.out.println("Sorry your input was not valid. Please try again.");
                    menu.toString();
                    input.next();
                } else {
                    System.out.println("Sorry your input was not valid. Please try an integer e.g. 4.");
                    input.next();
                }


            }
        }

    }

    public boolean shouldSimulate() {
        String userPrompt = "If you would like to proceed enter 1. If you would like to exit please enter 0.";
        IntUserInputRetriever<?> intUserInputRetriever = selection -> {
            try {
                if (selection == 1 && customer.getMoney() >= menu.getLowestCostFood().getPrice()) {
                    return true;
                } else if (selection == 1 && customer.getMoney() < menu.getLowestCostFood().getPrice()) {
                    System.out.println("Sorry you don't have enough money for that. Exiting online ordering system.");
                    return false;
                } else {
                    System.out.println("Goodbye, we hope you will order with us again soon.");
                    return false;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Sorry that is not a valid selection. If you would like to proceed please enter 1. If you would like to exit please enter 0.");
                return true;
            }
        };
    }
}