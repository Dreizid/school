package core;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Items {
    // name: Name, description: Kahit wala muna lagay nyolang null, imagePath: format src\\gui\\static\\images\\(itemname).png, unit: kung ilang kg, price: price

    ArrayList<ItemClass> itemData = new ArrayList<ItemClass>(Arrays.asList(
        // Meat Items
        new ItemClass("Chicken", "Meat", "Whole Chicken", "src\\gui\\static\\images\\meats\\chicken.png", "800g - 1000g", 127.30),
        new ItemClass("Beef Sukiyaki Cut", "Meat", "Sukiyaki Sliced Beef", "src\\gui\\static\\images\\meats\\sukiyaki.png", "500g - 550g", 255.75),
        new ItemClass("Ground Pork", "Meat", "Ground Pork Meat", "src\\gui\\static\\images\\meats\\groundpork.png", "500g - 550g", 139.70),
        new ItemClass("Pork Adobo Cut", "Meat", "null", "src\\gui\\static\\images\\meats\\adobo.png", "500g - 550g", 158.40),
        new ItemClass("Pork Sinigang Cut",  "Meat", "null", "src\\gui\static\\images\\meats\\sinigang.png", "400g - 500g", 98.50),
        new ItemClass("Chicken Tinola Cut",  "Meat", "null", "src\\gui\\static\\images\\meats\\tinola.png", "500g - 550g", 81.40),
        new ItemClass("Cicken Breast Fillet",  "Meat", "null", "src\\gui\\static\\images\\meats\\breast.png", "500g - 550g", 141.35),
        new ItemClass("Chicken Thigh Fillet",  "Meat", "null", "src\\gui\\static\\images\\meats\\cthighs.png", "500g - 550g", 152.90),
        new ItemClass("Ground Beef",  "Meat", "null", "src\\gui\\static\\images\\meats\\groundbeef.png", "500g - 550g", 167.20),
        new ItemClass("Beef Cubes",  "Meat", "null", "src\\gui\\static\\images\\meats\\bcubes.png", "500g - 550g", 207.35),
        new ItemClass("Pork Kasim Cut",  "Meat", "null", "src\\gui\\static\\images\\meats\\pkasim.png", "500g - 550g", 145.75),
        new ItemClass("Pork Liempo Cut",  "Meat", "null", "src\\gui\\static\\images\\meats\\liempo.png", "400g - 500g", 172.50),
        new ItemClass("Pork Menudo Cut",  "Meat", "null", "src\\gui\\static\\images\\meats\\pmenudo.png", "500g - 550g", 169.40),
        new ItemClass("Pork Cubes",  "Meat", "null", "src\\gui\\static\\images\\meats\\pcubes.png", "500g - 550g", 159.50),
        new ItemClass("Pork Chop",  "Meat", "null", "src\\gui\\static\\images\\meats\\chop.png", "400g - 500g", 142.50),

        // Fish Items
        new ItemClass("Daing na Bangus", "Fish", "null", "src\\gui\\static\\images\\fish\\Daing na Bangus.png", "400g| 3 pcs", 177.00),
        new ItemClass("Tilapia Large", "Fish",  "null", "src\\gui\\static\\images\\fish\\Tilapia.png", "350g - 438g", 74.6),
        new ItemClass("Galunggong Tunay", "Fish", "null", "src\\gui\\static\\images\\fish\\Galunggong Tunay.png", "450g - 500g", 183.50),
        new ItemClass("Pink Salmon Steak", "Fish", "null", "src\\gui\\static\\images\\fish\\Pink Salmon Steak.png", "450g - 500g", 497.50),
        new ItemClass("Oceans Harvest Salmon Belly Strip", "Fish", "null", "src\\gui\\static\\images\\fish\\Salmon Belly Strip.png", "1kg", 344.00),
        new ItemClass("Creamdory Fish Fillet", "Fish", "null", "src\\gui\\static\\images\\fish\\Fish Fillet.png", "900g-1000g", 120.00),
        new ItemClass("Seaking Bangus Unseasoned", "Fish", "null", "src\\gui\\static\\images\\fish\\Seaking Bangus.png", "520g", 238.00),
        new ItemClass("Fisher Farms Nobashi Ebi Shrimps", "Fish", "null", "src\\gui\\static\\images\\fish\\Ebi Shrimps.png", "200-240g", 237.00),
        new ItemClass("Suahe", "Fish", "null", "src\\gui\\static\\images\\fish\\Suahe.png", "450g-500g", 249.50),
        new ItemClass("Pink Salmon Belly", "Fish", "null", "src\\gui\\static\\images\\fish\\Pink Salmon Belly.png", "450g-500g", 216.00),
        new ItemClass("Fisher Farms Shrimp Kurin Peeled", "Fish", "null", "src\\gui\\static\\images\\fish\\Shrimp Kurin.png", "500g", 310.00),
        new ItemClass("Bangus Boneless", "Fish", "null", "src\\gui\\static\\images\\fish\\Bangus Boneless.png", "350g-500g", 164.00),
        new ItemClass("Pampano White", "Fish", "null", "src\\gui\\static\\images\\fish\\Pampano White.png", "1kg", 609.00),
        new ItemClass("Galungong Big", "Fish", "null", "src\\gui\\static\\images\\fish\\Galungong Big.png", "1kg", 350.00),
        new ItemClass("Lapu Lapu Red", "Fish", "null", "src\\gui\\static\\images\\fish\\Lapu Lapu.png", "1kg", 650.00),

        // Fruit Items
        new ItemClass("Fuji Apple", "Fruit", "null", "src\\gui\\static\\images\\fruits\\fuji.png", "6 pcs", 169.00),
        new ItemClass("Cavendish Banana", "Fruit", "null", "src\\gui\\static\\images\\fruits\\bcavender.png", "1100g - 1300g", 128.70),
        new ItemClass("Lemon", "Fruit", "null", "src\\gui\\static\\images\\fruits\\lemon.png", "3 pcs", 70.00),
        new ItemClass("Banana Lacatan", "Fruit", "null", "src\\gui\\static\\images\\fruits\\blacatan.png", "1100g - 1300g", 195.00),
        new ItemClass("Mandarin Oranges", "Fruit", "null", "src\\gui\\static\\images\\fruits\\mandarin.png", "6 pcs", 232.00),
        new ItemClass("Honeydew", "null", "Fruit", "src\\gui\\static\\images\\fruits\\honeydew.png", "100g - 1500g", 247.50),
        new ItemClass("Banana Saba", "null", "Fruit", "src\\gui\\static\\images\\fruits\\bsaba.png", "1000g - 1500g", 103.50),
        new ItemClass("Avocado", "Fruit", "null", "src\\gui\\static\\images\\fruits\\avocado.png", "900g - 1000g", 299.00),
        new ItemClass("Mango Ripe", "Fruit", "null", "src\\gui\\static\\images\\fruits\\ripemango.png", "900g - 1000g", 290.00),
        new ItemClass("Gala Apple", "Fruit", "null", "src\\gui\\static\\images\\fruits\\gala.png", "3 pcs", 148.00),
        new ItemClass("Flame Red Seedless Grapes", "Fruit", "null", "src\\gui\\static\\images\\fruits\\frgrapes.png", "700g - 800g", 349.60),
        new ItemClass("Lanzones", "Fruit", "null", "src\\gui\\static\\images\\fruits\\lanzones.png", "900g - 1000g", 350.00),
        new ItemClass("Crimson Seedless Grapes", "Fruit", "null", "src\\gui\\static\\images\\fruits\\crimson.png", "700g - 800g", 205.80),
        new ItemClass("Green Kiwi", "Fruit", "null", "src\\gui\\static\\images\\fruits\\kiwi.png", "6 pcs", 272.00),
        new ItemClass("Pineapple", "Fruit", "null", "src\\gui\\static\\images\\fruits\\pineapple.png", "pc", 133.00),

        // Vegetable items
        new ItemClass("Ampalaya", "Vegetable", "null", "src\\gui\\static\\images\\vegetables\\Ampalaya.png", "500g-600g", 73.20),
        new ItemClass("Carrot", "Vegetable", "null", "src\\gui\\static\\images\\vegetables\\Carrot.png", "0.344kg", 150.00),
        new ItemClass("Cabbage", "Vegetable", "null", "src\\gui\\static\\images\\vegetables\\Cabbage.png", "0.34kg", 46.10),
        new ItemClass("Lettuce", "Vegetable", "null", "src\\gui\\static\\images\\vegetables\\Lettuce.png", "0.366kg", 91.50),
        new ItemClass("Red Chili Pepper", "Vegetable", "null", "src\\gui\\static\\images\\vegetables\\Red Chili.png", "0.88kg", 51.70),
        new ItemClass("Baguio Beans", "Vegetable", "null", "src\\gui\\static\\images\\vegetables\\Baguio Beans.png", "0.258kg", 41.95),
        new ItemClass("Pechay Baguio", "Vegetable", "null", "src\\gui\\static\\images\\vegetables\\Pechay Baguio.png", "0.438kg", 87.50),
        new ItemClass("Pechay Tagalog", "Vegetable", "null", "src\\gui\\static\\images\\vegetables\\Pechay Tagalog.png", "150g - 200g", 15.80),
        new ItemClass("Kangkong", "null", "Vegetable", "src\\gui\\static\\images\\vegetables\\Kangkong.png", "350g - 400g", 22.80),
        new ItemClass("Okra", "Vegetable", "null", "src\\gui\\static\\images\\vegetables\\Okra.png", "350g - 400g", 36.00),
        new ItemClass("Tomatoes", "Vegetable", "null", "src\\gui\\static\\images\\vegetables\\Tomatoes.png", "350g - 400g", 45.60),
        new ItemClass("EggPlant", "Vegetable", "null", "src\\gui\\static\\images\\vegetables\\Eggplant.png", "500g - 600g", 46.80),
        new ItemClass("Cucumber", "Vegetable", "null", "src\\gui\\static\\images\\vegetables\\Cucumber.png", "400g - 500g", 43.50),
        new ItemClass("Cauliflower", "Vegetable", "null", "src\\gui\\static\\images\\vegetables\\Cauliflower.png", "200g - 300g", 50.70),
        new ItemClass("Broccoli", "Vegetable", "null", "src\\gui\\static\\images\\vegetables\\Broccoli.png", "400g - 500g", 148.00),
        new ItemClass("Garlic", "Vegetable", "null", "src\\gui\\static\\images\\vegetables\\Garlic.png", "350g-400g", 64.00),
        new ItemClass("White Radish", "Vegetable", "null", "src\\gui\\static\\images\\vegetables\\Radish.png", "400g - 500g", 48.50),
        new ItemClass("Potatoes", "Vegetable", "null", "src\\gui\\static\\images\\vegetables\\Potatoes.png", "450g - 500g", 67.50)
    ));

    HashMap<String, ItemClass> items = new HashMap<>();
    HashMap<ItemClass, Integer> itemStock = new HashMap<>();

    public Items() {
        for (ItemClass item: itemData) {
            items.put(item.getName(), item);
        }
        items.forEach((key, value) -> {
            itemStock.put(value, 100);
        });
    }

    public boolean inStock(String item, int quantity) {
        if (itemStock.get(items.get(item)) > quantity) {
            return true;
        }
        return false;
    }

    public void addToStock(String item, int quantity) {
        itemStock.put(items.get(item), itemStock.get(items.get(item)) + quantity);
        System.out.println("Returned to stock");
    }

    public void subtractFromStock(String item, int quantity) {
        itemStock.put(items.get(item), itemStock.get(items.get(item)) - quantity);
        System.out.println("Subtracted from stock");
    }

    public void loadItems() {
        int[] count = {0};
        items.forEach((key, value) -> {
            System.out.println(key);
            count[0]++;
        });

        itemStock.forEach((key, value) -> {
            System.out.println(value);
        });
        System.out.println(count[0]);
    }

    public static void main(String[] args) {
        Items item = new Items();
        item.loadItems();
    }


}
