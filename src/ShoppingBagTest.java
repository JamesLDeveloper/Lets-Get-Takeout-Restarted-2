import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
class ShoppingBagTest extends ShoppingBag {

    @Test
public void addItemTest(){

        Food bakedbeans = new Food("Baked Beans", "Delicious", 3 );
        ShoppingBagTest shoppingBag1 = new ShoppingBagTest();
        shoppingBag1.addItem(bakedbeans);
            shoppingBag1.addItem(bakedbeans);

        assertEquals(2, shoppingBag1.getAmountInBasket(bakedbeans));


        }


  @Test
  public void getTotalPriceTest(){

      Food bakedbeans = new Food("Baked Beans", "Delicious", 3 );
      Food katsuCurry = new Food("Chicken Katsu Curry", "Chicken in breadcrumbs with rice and sauce", 8);
      Food steakAndChips = new Food("Steak and Chips", "Medium Rare Sirloin steak with garlic butter, double cooked chips and seasonal veg.", 29);

      ShoppingBagTest shoppingBag2 = new ShoppingBagTest();
        shoppingBag2.addItem(bakedbeans);
        shoppingBag2.addItem(katsuCurry);
        shoppingBag2.addItem(steakAndChips);
        shoppingBag2.addItem(steakAndChips);
        shoppingBag2.addItem(bakedbeans);

        int testamount = 3+8+29+29+3;

        assertEquals(testamount, shoppingBag2.getTotalPrice());

  }



}