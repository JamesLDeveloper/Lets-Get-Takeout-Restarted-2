import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Create FoodMenu class here


public class FoodMenu {

    Food food;

    private List<Food> menu;

    public FoodMenu() {


        Food bakedbeans = new Food("Baked Beans", "Delicious", 3);
        Food katsuCurry = new Food("Chicken Katsu Curry", "Chicken in breadcrumbs with rice and sauce", 8);
        Food steakAndChips = new Food("Steak and Chips", "Medium Rare Sirloin steak with garlic butter, double cooked chips and seasonal veg.", 29);


        //       menu = new ArrayList<Food>();
        menu = new ArrayList<Food>(Arrays.asList(bakedbeans, katsuCurry, steakAndChips));

//menu.add(bakedbeans);
//menu.add(katsuCurry);
//menu.add(steakAndChips);
//menu.add()


    }


//    @Override
//    public String toString(){
//        StringBuilder wholeMenu = new StringBuilder();
//for (int i = 0; i < menu.size(); i++){
//
//    wholeMenu.append(menu.indexOf(i));
//    wholeMenu.append(": ");
//    wholeMenu.append(menu.get(i).toString());
//
//}
//        return wholeMenu.toString();
//    }


//    @Override
//    public String toString() {
//        String wholeMenu = "";
//        for (int i = 0; i < menu.size(); i++) {
//
//            wholeMenu = menu.indexOf(i) + ": " + menu.get(i).toString();
//
//        }
//        return wholeMenu;
//    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < menu.size() + 1; i++) {
sb.append("\n" + i + ": " + getFood(i).toString());


        }
        return sb.toString();
    }




    public Food getFood(int index) {
        if (menu.get(index - 1) != null) {

            return menu.get(index - 1);
        } else {
            return null;
        }
    }

    public Food getLowestCostFood() {
        int lowestCostFoodCost = menu.get(0).getPrice();
        Food lowestCostFood = menu.get(0);
        for (Food foodItem : menu) {
            if (foodItem.getPrice() < lowestCostFoodCost) {
                lowestCostFood = foodItem;
                lowestCostFoodCost = foodItem.getPrice();
            }
        }
        return lowestCostFood;
    }

}