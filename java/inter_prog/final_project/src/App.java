import javax.swing.*;
import java.awt.*;

public class App {
    public static void main(String[] args) {
        MeatItem beef = new MeatItem("Beef", "Beefy", "null", "1kg", 155.50);
        MeatItem chicken = new MeatItem("Chicken", "Chickey", "null", "1 whole", 127.30);
        PersonClass person1 = new PersonClass("Rei", "Rei@gmail.com", "123", "1234");
        person1.cart.addToCart(new MeatItem("Beef", "Beefy", "null", "1kg", 155.50));
        int check = person1.cart.meatCart.get(person1.cart.findIndexOf(beef)).quantity;
        System.out.println("First add: " + check);
        person1.cart.addToCart(new MeatItem("Beef", "Beefy", "null", "1kg", 155.50));
        check = person1.cart.meatCart.get(person1.cart.findIndexOf(beef)).quantity;
        System.out.println("Second add: " + check);
        person1.cart.addToCart(new MeatItem("Chicken", "Chickey", "null", "1 whole", 127.30));
        person1.cart.addToCart(new MeatItem("Chicken", "Chickey", "null", "1 whole", 127.30));
        person1.cart.addToCart(new MeatItem("Chicken", "Chickey", "null", "1 whole", 127.30));
        System.out.println("Person 1 Initial: ");
        for (MeatItem item: person1.cart.meatCart) {
            System.out.println("Item name: " + item.itemName + " Quantity: " + item.quantity);
        }
        System.out.println("Person 1: ");
        person1.cart.subtractFromCart(new MeatItem("Chicken", "Chickey", "null", "1 whole", 127.30));
        for (MeatItem item: person1.cart.meatCart) {
            System.out.println("Item name: " + item.itemName + " Quantity: " + item.quantity);
        }
        System.out.println("Person 1 Updated: ");
        person1.cart.setItemQuantity(new MeatItem("Beef", "Beefy", "null", "1kg", 155.50), 10);
        for (MeatItem item: person1.cart.meatCart) {
            System.out.println("Item name: " + item.itemName + " Quantity: " + item.quantity);
        }
    }
}
