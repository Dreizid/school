package core;
import java.util.HashMap;

public class Cart {
    public HashMap<String, Integer> cart;
    public HashMap<String, Integer> finalCart;
    public Items itemList;
    int takenFromStock = 0;
    double cartTotal = 0;

    public Cart() {
        cart = new HashMap<>();
        itemList = new Items();
    }

    public void addToCart(ItemClass item) {
        if (cart.containsKey(item.getName()) && itemList.inStock(item.getName(), 1)) {
            cart.put(item.getName(), cart.get(item.getName()) + 1);
            itemList.subtractFromStock(item.getName(), 1);
            takenFromStock++;
            System.out.println("Added quantity");
        } else if (itemList.inStock(item.getName(), 1)) {
            cart.put(item.getName(), 1);
            itemList.subtractFromStock(item.getName(), 1);
            takenFromStock++;
            System.out.println("Added to cart");
        }
        System.out.println(itemList.itemStock.get(Items.items.get(item.getName())));
    }

    public void subtractFromCart (ItemClass item) {
        if (cart.containsKey(item.getName()) && cart.get(item.getName()) > 0 && takenFromStock > 0) {
            cart.put(item.getName(), cart.get(item.getName()) - 1);
            itemList.addToStock(item.getName(), 1);
            takenFromStock--;
            System.out.println("Subtracted quantity");
        } else if (cart.containsKey(item.getName()) && takenFromStock > 0) {
            cart.remove(item.getName());
            itemList.addToStock(item.getName(), 1);
            takenFromStock--;
            System.out.println("Removed from cart");
        }
        System.out.println(itemList.itemStock.get(Items.items.get(item.getName())));
    }

    public void addToCart (ItemClass item, int quantity) {
        if (cart.containsKey(item.getName()) && itemList.inStock(item.getName(), quantity)) {
            cart.put(item.getName(), cart.get(item.getName()) + quantity);
            itemList.subtractFromStock(item.getName(), quantity);
            takenFromStock += quantity;
            System.out.println("Added quantity");
        } else if (itemList.inStock(item.getName(), quantity)) {
            cart.put(item.getName(), quantity);
            itemList.subtractFromStock(item.getName(), quantity);
            takenFromStock += quantity;
            System.out.println("Added to cart");
        }
        System.out.println(itemList.itemStock.get(Items.items.get(item.getName())));
    }
}
