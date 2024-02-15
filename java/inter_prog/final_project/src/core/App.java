package core;
import javax.swing.*;
import java.awt.*;

public class App {
    public static void main(String[] args) {
        PersonClass person1 = new PersonClass("Rei", "Reiii", "rei@gmail.com", "123", "1234");
        
        person1.cart.addToCart(new ItemClass("Chicken", "Meat", "Whole Chicken", "src\\gui\\static\\images\\meats\\chicken.png", "800g - 1000g", 127.30));
        person1.cart.addToCart(new ItemClass("Chicken", "Meat", "Whole Chicken", "src\\gui\\static\\images\\meats\\chicken.png", "800g - 1000g", 127.30));
        for (int i = 0; i < 10; i++) {
            person1.cart.addToCart(new ItemClass("Chicken", "Meat", "Whole Chicken", "src\\gui\\static\\images\\meats\\chicken.png", "800g - 1000g", 127.30), 10);
        }
        for (int i = 0; i < 50; i++) {
            person1.cart.subtractFromCart(new ItemClass("Chicken", "Meat", "Whole Chicken", "src\\gui\\static\\images\\meats\\chicken.png", "800g - 1000g", 127.30));
        }
        person1.cart.cart.forEach((key, value) -> {
            System.out.println(key + ": " + value);
        });
    }
}
