package core;
import java.util.HashMap;

public class Items {
    // public static HashMap<String, MeatItem> meatList = new HashMap<>();
    public static MeatItem[] meatList = {new MeatItem("Chicken", "Chickey", "null", "1 whole", 127.30),
                                        new MeatItem("Beef", "Beefy", "src\\gui\\static\\images\\beef.png", "1kg", 155.50),
                                        new MeatItem("Pork", "", "", "1kg", 230.5)
};
    public Items() {

    }

    public void loadItems() {
        
    }


}
