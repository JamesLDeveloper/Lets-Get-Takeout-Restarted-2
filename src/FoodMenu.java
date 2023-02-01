import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Create FoodMenu class here


public class FoodMenu{

    Food food;

    private List<Food> menu;

    public FoodMenu(){


        Food bakedbeans = new Food("Baked Beans", "Delicious", 3 );
        Food katsuCurry = new Food("Chicken Katsu Curry", "Chicken in breadcrumbs with rice and sauce", 8);
        Food steakAndChips = new Food("Steak and Chips", "Medium Rare Sirloin steak with garlic butter, double cooked chips and seasonal veg.", 29);


 //       menu = new ArrayList<Food>();
        menu = new ArrayList<Food>(Arrays.asList(bakedbeans, katsuCurry, steakAndChips));

//menu.add(bakedbeans);
//menu.add(katsuCurry);
//menu.add(steakAndChips);
//menu.add()


    }


    @Override
    public String toString(){
        StringBuilder wholeMenu = new StringBuilder();
for (int i = 0; i < menu.size(); i++){

    wholeMenu.append(menu.indexOf(i));
    wholeMenu.append(": ");
    wholeMenu.append(menu.get(i).toString());

}
        return wholeMenu.toString();
    }

}