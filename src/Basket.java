import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Basket {
    private final String name;
    private final Map<StockItem,Integer> ShoppingList;

    public Basket(String name) {
        this.name = name;
        this.ShoppingList = new HashMap<>();
    }

    public int addToBasket(StockItem item, int quantity){
        if((item != null) && (quantity > 0)){
            int inBasket = ShoppingList.getOrDefault(item,0);
            ShoppingList.put(item, inBasket + quantity);
            return inBasket;
        }
        return 0;
    }

    public Map<StockItem, Integer> Items() {
        return Collections.unmodifiableMap(ShoppingList);
    }

    @Override
    public String toString() {
        String s = "\nShopping basket " + name + " contains " + ShoppingList.size() + " items\n";
        double totalCost = 0.0;
        for (Map.Entry<StockItem, Integer> item : ShoppingList.entrySet()) {
            s = s + item.getKey() + ". " + item.getValue() + " purchased\n";
            totalCost += item.getKey().getPrice() * item.getValue();
        }
        return s + "Total cost " + totalCost;
    }
}
