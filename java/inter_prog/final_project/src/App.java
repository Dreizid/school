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

        check = person1.cart.meatCart.get(person1.cart.findIndexOf(chicken)).quantity;
        System.out.println("Third add: " + check);
        for (MeatItem item: person1.cart.meatCart) {
            System.out.println("Item name: " + item.itemName + " Quantity: " + item.quantity);
        }

        PersonClass person2 = new PersonClass("Hart", "hart@gmail.com", "345", "3456");
        person2.cart.addToCart(new MeatItem("Chicken", "Chickey", "null", "1 whole", 127.30));
        for (MeatItem item: person2.cart.meatCart) {
            System.out.println("Item name: " + item.itemName + " Quantity: " + item.quantity);
        }

        person1.cart.subtractFromCart(new MeatItem("Chicken", "Chickey", "null", "1 whole", 127.30));
        for (MeatItem item: person1.cart.meatCart) {
            System.out.println("Person 1: " + "Item name: " + item.itemName + " Quantity: " + item.quantity);
        }
        person1.cart.setItemQuantity(new MeatItem("Beef", "Beefy", "null", "1kg", 155.50), 10);
        for (MeatItem item: person1.cart.meatCart) {
            System.out.println("Person 1: " + "Item name: " + item.itemName + " Quantity: " + item.quantity);
        }

    }
}
