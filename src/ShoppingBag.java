import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// Create ShoppingBag class here

public class ShoppingBag <T extends PricedItem<Integer>> {

    private Map<T, Integer> shoppingBag;

    public ShoppingBag() {
        shoppingBag = new HashMap<>();
    }

    public void addItem(T item) {
        if (shoppingBag.containsKey(item)) {
            Integer numberInBag = shoppingBag.get(item);
            shoppingBag.put(item, (numberInBag + 1));

        } else {
            shoppingBag.put(item, 1);
        }


    }

    public int getAmountInBasket(T item) {
        if (shoppingBag.get(item) != null) {
            return shoppingBag.get(item);
        } else {
            return 0;
        }
    }

    public int getTotalPrice(){
        int totalPrice = 0;
        for (Map.Entry<T, Integer> pair : shoppingBag.entrySet()){
           totalPrice += pair.getValue() * pair.getKey().getPrice();
        }
        return totalPrice;
    }

}