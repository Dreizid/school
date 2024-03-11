package core;
import java.util.HashMap;

public class Cart {
    public HashMap<String, Integer> cart;
    private int takenFromStock = 0;
    protected double cartTotal = 0;

    public Cart() {
        cart = new HashMap<>();
    }

    public void addToCart(ItemClass item) {
        if (cart.containsKey(item.getName())) {
            cart.put(item.getName(), cart.get(item.getName()) + 1);
            takenFromStock++;
            System.out.println("Added quantity");
        } else {
            cart.put(item.getName(), 1);
            takenFromStock++;
            System.out.println("Added to cart");
        }
    }

    public void subtractFromCart (ItemClass item) {
        if (cart.containsKey(item.getName()) && cart.get(item.getName()) > 1 && takenFromStock > 0) {
            cart.put(item.getName(), cart.get(item.getName()) - 1);
            takenFromStock--;
            System.out.println("Subtracted quantity");
        } else if (cart.containsKey(item.getName())) {
            cart.remove(item.getName());
            takenFromStock--;
            System.out.println("Removed from cart");
        }
    }

    public void addToCart (ItemClass item, int quantity) {
        if (cart.containsKey(item.getName())) {
            cart.put(item.getName(), cart.get(item.getName()) + quantity);
            takenFromStock += quantity;
            System.out.println("Added quantity");
        } else {
            cart.put(item.getName(), quantity);
            takenFromStock += quantity;
            System.out.println("Added to cart");
        }
    }

    public double getTotal() {
        double[] total = {0};
        cart.forEach((key, value) -> {
            total[0] += (value * Items.items.get(key).getPrice());
        });
        return total[0];
    }

    public int getAmount() {
        int[] total = {0};
        cart.forEach((key, value) -> {
            total[0] += (value);
        });
        return total[0];
    }

    public int getSize() {
        return cart.size();
    }
}
