import java.util.Scanner;

// Create TakeOutSimulator class here

public class TakeOutSimulator {

    private Customer customer;
    private FoodMenu menu;
    private Scanner input;

    private ShoppingBag shoppingBag;

    public TakeOutSimulator(Customer customer, Scanner input) {
        this.customer = customer;
        this.menu = new FoodMenu();
        this.input = input;
        this.shoppingBag = new ShoppingBag<>();
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
            //           try {
            if (selection == 1 && customer.getMoney() >= menu.getLowestCostFood().getPrice()) {
                System.out.println("You have chosen to proceed and have enough money to purchase the lowest cost item which is " + menu.getLowestCostFood());
                return true;
            } else if (selection == 1 && customer.getMoney() < menu.getLowestCostFood().getPrice()) {
                System.out.println("Sorry you don't have enough money for that. Exiting online ordering system.");
                return false;
            } else if (selection == 0) {
                System.out.println("Goodbye, we hope you will order with us again soon.");
                return false;
            } else {
                throw new IllegalArgumentException("Sorry that is not a valid selection. If you would like to proceed please enter 1. If you would like to exit please enter 0.");
//            } catch (IllegalArgumentException e)
        }
//                System.out.println("Sorry that is not a valid selection. If you would like to proceed please enter 1. If you would like to exit please enter 0.");
      //          return true;
      //      }
        };
        return getOutputOnIntInput(userPrompt, intUserInputRetriever);
    }

    public Food getMenuSelection() {
        String userPrompt = "Please choose an item from the menu by entering it's item number as an integer. e.g. 1\n Today's menu is:" + menu.toString() + "\n0 to checkout.";
        IntUserInputRetriever<?> intUserInputRetriever = selection -> {
            try{
                if(selection == 0) {
                    checkoutCustomer(shoppingBag);
                    return null;}
                else if (menu.getFood(selection) != null) { return menu.getFood(selection);}
                else {throw new IllegalArgumentException("Sorry that choice is not valid please try again using the item number as an integer.");}
        } catch (IndexOutOfBoundsException e) {
               System.out.println("Sorry that choice is not valid please choose an valid item number from the menu.");
               return getMenuSelection();
               // return null;
            }


        };
        return getOutputOnIntInput(userPrompt, intUserInputRetriever);
    }

    public boolean isStillOrderingFood(){
        String userPrompt ="If you would like to continue shopping please enter 1. If you would like to checkout please enter 0. If you would like to exit please enter 2.";
        IntUserInputRetriever<?> intUserInputRetriever = selection -> {
            if (selection == 1){
                return true;
            } else if (selection == 0){
                checkoutCustomer(shoppingBag);
                return false;
            } else if (selection == 2) {
                System.out.println("You have chosen to leave without ordering. Please come again soon.");
                System.exit(0);
             return false;
            } else {
                System.out.println("Invalid input.");
                isStillOrderingFood();
                throw new IllegalArgumentException("Invalid input. Please enter 1 to continue shopping. Please enter 0 to checkout.");
            }

        };
        return getOutputOnIntInput(userPrompt, intUserInputRetriever);
    }

public void checkoutCustomer(ShoppingBag<Food> shoppingBag){
        System.out.println("Payment processing");
        customer.setMoney(customer.getMoney()-shoppingBag.getTotalPrice());
        System.out.println("You have spent " + shoppingBag.getTotalPrice());
        System.out.println("You have " + customer.getMoney() + " left.");
        System.out.println("Please enjoy your meal");
        System.exit(0);
}

public void takeOutPrompt() {
    while (isStillOrderingFood()) {
//        ShoppingBag<Food> shoppingBag = new ShoppingBag<>();
        int customerMoneyLeft = customer.getMoney();
        System.out.println("You have " + customerMoneyLeft);
        Food choice = getMenuSelection();
        if (choice.getPrice() <= customerMoneyLeft){
            shoppingBag.addItem(choice);
            customerMoneyLeft -= choice.getPrice();
//            break;
//            isStillOrderingFood();
        } else {
            System.out.println("Sorry you don't have enough money for that");
//            break;
//            isStillOrderingFood();
        }

    }
    checkoutCustomer(shoppingBag);
}

public void startTakeOutSimulator(){
    System.out.println("Welcome to Globodine " + customer.getName() + "!");
        while(shouldSimulate()){
        takeOutPrompt();
        }
}

}