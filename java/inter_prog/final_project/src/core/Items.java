package core;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Items {
    // name: Name, description: Kahit wala muna lagay nyolang null, imagePath: format src\\gui\\static\\images\\(itemname).png, unit: kung ilang kg, price: price

    public static ArrayList<ItemClass> itemData = new ArrayList<ItemClass>(Arrays.asList(
        
        // Fruit Items
        new ItemClass("Fuji Apple", "Fruit", "null", "src\\gui\\static\\images\\fruits\\fuji.png", "6 pcs", 169.00),
        new ItemClass("Cavendish Banana", "Fruit", "null", "src\\gui\\static\\images\\fruits\\cavendish.png", "1100g - 1300g", 128.70),
        new ItemClass("Lemon", "Fruit", "null", "src\\gui\\static\\images\\fruits\\lemon.png", "3 pcs", 70.00),
        new ItemClass("Banana Lacatan", "Fruit", "null", "src\\gui\\static\\images\\fruits\\lacatan.png", "1100g - 1300g", 195.00),
        new ItemClass("Mandarin Oranges", "Fruit", "null", "src\\gui\\static\\images\\fruits\\mandarin.png", "6 pcs", 232.00),
        new ItemClass("Honeydew", "Fruit", "null", "src\\gui\\static\\images\\fruits\\honeydew.png", "100g - 1500g", 247.50),
        new ItemClass("Banana Saba", "Fruit","null" , "src\\gui\\static\\images\\fruits\\saba.png", "1000g - 1500g", 103.50),
        new ItemClass("Avocado", "Fruit", "null", "src\\gui\\static\\images\\fruits\\avocado.png", "900g - 1000g", 299.00),
        new ItemClass("Mango Ripe", "Fruit", "null", "src\\gui\\static\\images\\fruits\\ripemango.png", "900g - 1000g", 290.00),
        new ItemClass("Gala Apple", "Fruit", "null", "src\\gui\\static\\images\\fruits\\gala.png", "3 pcs", 148.00),
        new ItemClass("Flame Red Seedless Grapes", "Fruit", "null", "src\\gui\\static\\images\\fruits\\flame.png", "700g - 800g", 349.60),
        new ItemClass("Lanzones", "Fruit", "null", "src\\gui\\static\\images\\fruits\\lanzones.png", "900g - 1000g", 350.00),
        new ItemClass("Crimson Seedless Grapes", "Fruit", "null", "src\\gui\\static\\images\\fruits\\crimson.png", "700g - 800g", 205.80),
        new ItemClass("Green Kiwi", "Fruit", "null", "src\\gui\\static\\images\\fruits\\kiwi.png", "6 pcs", 272.00),
        new ItemClass("Pineapple", "Fruit", "null", "src\\gui\\static\\images\\fruits\\pineapple.png", "pc", 133.00),
        new ItemClass("Red Lady Papaya", "Fruit", "null", "src\\gui\\static\\images\\fruits\\redpapaya.png", "1000g-1500g", 73.50),
        new ItemClass("Pomelo", "Fruit", "null", "src\\gui\\static\\images\\fruits\\pomelo.png", "850g-1000g", 210.00),
        new ItemClass("Wasington Red Apples", "Fruit", "null", "src\\gui\\static\\images\\fruits\\washington.png", "3 pcs", 112.00),
        new ItemClass("Papaya", "Fruit", "null", "src\\gui\\static\\images\\fruits\\papaya.png", "500g-700g", 52.50),
        new ItemClass("Mangosteen", "Fruit", "null", "src\\gui\\static\\images\\fruits\\mangosteen.png", "900g-1000g", 204.00),
        new ItemClass("Guyabano", "Fruit", "null", "src\\gui\\static\\images\\fruits\\guyabano.png", "500g-1000g", 165.00),
        new ItemClass("Granny Smith Apple", "Fruit", "null", "src\\gui\\static\\images\\fruits\\granny.png", "6 pcs", 249.00),
        new ItemClass("Guava", "Fruit", "null", "src\\gui\\static\\images\\fruits\\guava.png", "800g-1000g", 190.00),
        
        // Vegetable items
        new ItemClass ("Ampalaya", "Vegetable", "null", "src\\gui\\static\\images\\vegetables\\Ampalaya.png", "500g-600g", 73.20),
        new ItemClass ("Carrot", "Vegetable", "null", "src\\gui\\static\\images\\vegetables\\Carrot.png", "0.344kg", 150.00),
        new ItemClass ("Cabbage", "Vegetable", "null", "src\\gui\\static\\images\\vegetables\\Cabbage.png", "0.34kg", 46.10),
        new ItemClass ("Lettuce", "Vegetable", "null", "src\\gui\\static\\images\\vegetables\\Lettuce.png", "0.366kg", 91.50),
        new ItemClass ("Red Chili Pepper", "Vegetable", "null", "src\\gui\\static\\images\\vegetables\\Red Chili.png", "0.88kg", 51.70),
        new ItemClass ("Baguio Beans", "Vegetable", "null", "src\\gui\\static\\images\\vegetables\\Baguio Beans.png", "0.258kg", 41.95),
        new ItemClass ("Pechay Baguio", "Vegetable", "null", "src\\gui\\static\\images\\vegetables\\Pechay Baguio.png", "0.438kg", 87.50),
        new ItemClass ("Pechay Tagalog", "Vegetable", "null", "src\\gui\\static\\images\\vegetables\\Pechay Tagalog.png", "150g - 200g", 15.80),
        new ItemClass ("Kangkong", "Vegetable", "null", "src\\gui\\static\\images\\vegetables\\Kangkong.png", "350g - 400g", 22.80),
        new ItemClass ("Okra", "Vegetable", "null", "src\\gui\\static\\images\\vegetables\\Okra.png", "350g - 400g", 36.00),
        new ItemClass ("Tomatoes", "Vegetable", "null", "src\\gui\\static\\images\\vegetables\\Tomatoes.png", "350g - 400g", 45.60),
        new ItemClass ("EggPlant", "Vegetable", "null", "src\\gui\\static\\images\\vegetables\\Eggplant.png", "500g - 600g", 46.80),
        new ItemClass ("Cucumber", "Vegetable", "null", "src\\gui\\static\\images\\vegetables\\Cucumber.png", "400g - 500g", 43.50),
        new ItemClass ("Cauliflower", "Vegetable", "null", "src\\gui\\static\\images\\vegetables\\Cauliflower.png", "200g - 300g", 50.70),
        new ItemClass ("Broccoli", "Vegetable", "null", "src\\gui\\static\\images\\vegetables\\Broccoli.png", "400g - 500g", 148.00),
        new ItemClass ("Garlic", "Vegetable", "null", "src\\gui\\static\\images\\vegetables\\Garlic.png", "350g-400g", 64.00),
        new ItemClass ("Potatoes", "Vegetable", "null", "src\\gui\\static\\images\\vegetables\\Potato.png", "450g - 500g", 67.50),
        new ItemClass ("Onion", "Vegetable", "null", "src\\gui\\static\\images\\vegetables\\Onion.png", "1kg", 128.00),
        new ItemClass ("White Onion", "Vegetable", "null", "src\\gui\\static\\images\\vegetables\\White Onion.png", "1kg", 125.00),
        new ItemClass ("Spring Onions", "Vegetable", "null", "src\\gui\\static\\images\\vegetables\\Spring Onion.png", "1kg", 470.00), 
        new ItemClass ("Calabaza", "Vegetable", "null", "src\\gui\\static\\images\\vegetables\\Calabaza.png", "400g - 500g", 25.00),
        new ItemClass ("Malunggay", "Vegetable", "null", "src\\gui\\static\\images\\vegetables\\Malunggay.png", "1kg", 154.00),
        new ItemClass ("Tanglad", "Vegetable", "null", "src\\gui\\static\\images\\vegetables\\Tanglad.png", "1kg", 157.50),
        new ItemClass ("Patola", "Vegetable", "null", "src\\gui\\static\\images\\vegetables\\Patola.png", "1kg", 100.00),
        new ItemClass ("String Beans", "Vegetable", "null", "src\\gui\\static\\images\\vegetables\\String Beans.png", "200g - 250g", 27.00),
        new ItemClass ("Basil", "Vegetable", "null", "src\\gui\\static\\images\\vegetables\\Basil.png", "250g", 119.00),
        new ItemClass ("Ginger", "Vegetable", "null", "src\\gui\\static\\images\\vegetables\\Ginger.png", "1kg", 274.00),
        new ItemClass ("Green Bell Pepper", "Vegetable", "null", "src\\gui\\static\\images\\vegetables\\Green Pepper.png", "1kg", 385.00),
        new ItemClass ("Red Bell Pepper", "Vegetable", "null", "src\\gui\\static\\images\\vegetables\\Red Pepper.png", "1kg", 399.00),
        new ItemClass ("Celery", "Vegetable","null" , "src\\gui\\static\\images\\vegetables\\Celery.png", "200g - 250g", 29.50),
            
        // Meat Items
        new ItemClass("Chicken", "Meat", "Whole Chicken", "src\\gui\\static\\images\\meats\\chicken.png", "800g-1000g", 127.30),
        new ItemClass("Beef Sukiyaki Cut", "Meat", "Sukiyaki Sliced Beef", "src\\gui\\static\\images\\meats\\bsukiyaki.png", "500g-550g", 255.75),
        new ItemClass("Ground Pork", "Meat", "Ground Pork Meat", "src\\gui\\static\\images\\meats\\pground.png", "500g-550g", 139.70),
        new ItemClass("Pork Adobo Cut", "Meat", "null", "src\\gui\\static\\images\\meats\\padobo.png", "500g-550g", 158.40),
        new ItemClass("Pork Sinigang Cut", "Meat", "null", "src\\gui\static\\images\\meats\\psinigang.png", "400g-500g", 98.50),
        new ItemClass("Chicken Tinola Cut", "Meat", "null", "src\\gui\\static\\images\\meats\\ctinola.png", "500g-550g", 81.40),
        new ItemClass("Cicken Breast Fillet", "Meat", "null", "src\\gui\\static\\images\\meats\\cfillet.png", "500g-550g", 141.35),
        new ItemClass("Chicken Thigh Fillet", "Meat", "null", "src\\gui\\static\\images\\meats\\cthigh.png", "500g-550g", 152.90),
        new ItemClass("Ground Beef", "Meat", "null", "src\\gui\\static\\images\\meats\\bground.png", "500g-550g", 167.20),
        new ItemClass("Beef Cubes", "Meat", "null", "src\\gui\\static\\images\\meats\\bcubes.png", "500g-550g", 207.35),
        new ItemClass("Pork Kasim Cut", "Meat", "null", "src\\gui\\static\\images\\meats\\pkasim.png", "500g-550g", 145.75),
        new ItemClass("Pork Liempo Cut", "Meat", "null", "src\\gui\\static\\images\\meats\\pbelly.png", "400g-500g", 172.50),
        new ItemClass("Pork Menudo Cut", "Meat", "null", "src\\gui\\static\\images\\meats\\pmenudo.png", "500g-550g", 169.40),
        new ItemClass("Pork Cubes", "Meat", "null", "src\\gui\\static\\images\\meats\\pcubes.png", "500g-550g", 159.50),
        new ItemClass("Pork Chop", "Meat", "null", "src\\gui\\static\\images\\meats\\pchop.png", "400g-500g", 142.50),
        new ItemClass("Chicken Liver", "Meat", "null", "src\\gui\\static\\images\\meats\\cliver.png", "250g-300g", 55.20),
        new ItemClass("Chicken Gizzard", "Meat", "null", "src\\gui\\static\\images\\meats\\cgizzard.png", "250g-300g", 37.20),
        new ItemClass("Chicken Neck", "Meat", "null", "src\\gui\\static\\images\\meats\\cneck.png", "250g-300g", 27.00),
        new ItemClass("Chicken Skin", "Meat", "null", "src\\gui\\static\\images\\meats\\cskin.png", "250g-300g", 55.20),
        new ItemClass("Breakfast Steak", "Meat", "null", "src\\gui\\static\\images\\meats\\bsteak.png", "500g-550g", 249.15),
        new ItemClass("Camto", "Meat", "null", "src\\gui\\static\\images\\meats\\camto.png", "400g-500g", 209.50),
        new ItemClass("Pata Slice", "Meat", "null", "src\\gui\\static\\images\\meats\\pata.png", "400g-500g", 124.50),
        new ItemClass("Bacon Slice", "Meat", "null", "src\\gui\\static\\images\\meats\\pbacon.png", "500g-550g", 222.75),
        new ItemClass("Pork Butterfly Cut", "Meat", "null", "src\\gui\\static\\images\\meats\\pbutterfly.png", "500g-550g", 177.10),
        new ItemClass("Pork Caldereta CUt", "Meat", "null", "src\\gui\\static\\images\\meats\\pcaldereta.png", "400g-500g", 162.50),
        new ItemClass("Pork Cutlet", "Meat", "null", "src\\gui\\static\\images\\meats\\pcutlet", "500g-550g", 175.45),
        new ItemClass("Pigue", "Meat", "null", "src\\gui\\static\\images\\meats\\pigue.png", "500g-550g", 145.75),
        new ItemClass("Korean Bbq Cut", "Meat", "null", "src\\gui\\static\\images\\meats\\pkorbbq.png", "400g-500g", 193.50),
        new ItemClass("Pork Mechado Cut", "Meat", "null", "src\\gui\\static\\images\\meats\\pmechado.png", "500g-550g", 236.50),
        new ItemClass("Pork Steak", "Meat", "null", "src\\gui\\static\\images\\meats\\psteak.png", "400g-500g", 151.00),
        new ItemClass("Pork Sukiyaki", "Meat", "null", "src\\gui\\static\\images\\meats\\psukiyaki.png", "500g-550g", 187.00),
        new ItemClass("Sirloin Tips", "Meat", "null", "src\\gui\\static\\images\\meats\\sirlointips.png", "500g-550g", 262.35),

        // Fish Items
        new ItemClass ("Daing na Bangus", "Fish", "null", "src\\gui\\static\\images\\fish\\Bangus.png", "400g| 3 pcs", 177.00),
        new ItemClass ("Tilapia Large", "Fish", "null", "src\\gui\\static\\images\\fish\\Tilapia.png", "350g - 438g", 74.6),
        new ItemClass ("Galunggong Tunay", "Fish", "null", "src\\gui\\static\\images\\fish\\Galunggong Tunay.png", "450g - 500g", 183.50),
        new ItemClass ("Pink Salmon Steak", "Fish", "null", "src\\gui\\static\\images\\fish\\Pink Salmon Steak.png", "450g - 500g", 497.50),
        new ItemClass ("Oceans Harvest Salmon Belly Strip", "Fish", "null", "src\\gui\\static\\images\\fish\\Salmon Belly Strip.png", "1kg", 344.00),
        new ItemClass ("Fish Fillet", "Fish", "null", "src\\gui\\static\\images\\fish\\Fish Fillet.png", "900g-1000g", 120.00),
        new ItemClass ("Seaking Bangus Unseasoned", "Fish", "null", "src\\gui\\static\\images\\fish\\Seaking Bangus.png", "520g", 238.00),
        new ItemClass ("Fisher Farms Nobashi Ebi Shrimps", "Fish", "null", "src\\gui\\static\\images\\fish\\Ebi Shrimps.png", "200-240g", 237.00),
        new ItemClass ("Suahe", "Fish", "null", "src\\gui\\static\\images\\fish\\Suahe.png", "450g-500g", 249.50),
        new ItemClass ("Pink Salmon Belly", "Fish", "null", "src\\gui\\static\\images\\fish\\Pink Salmon Belly.png", "450g-500g", 216.00),
        new ItemClass ("Fisher Farms Shrimp Kurin Peeled", "Fish", "null", "src\\gui\\static\\images\\fish\\Shrimp Kurin.png", "500g", 310.00),
        new ItemClass ("Bangus Boneless", "Fish", "null", "src\\gui\\static\\images\\fish\\Bangus Boneless.png", "350g-500g", 164.00),
        new ItemClass ("Pampano White", "Fish", "null", "src\\gui\\static\\images\\fish\\Pampano White.png", "1kg", 609.00),
        new ItemClass ("Galunggong Big", "Fish", "null", "src\\gui\\static\\images\\fish\\Galunggong Big.png", "1kg", 350.00),
        new ItemClass ("Maya Maya", "Fish", "null", "src\\gui\\static\\images\\fish\\Maya Maya.png", "1kg", 550.00),
        new ItemClass ("Carballas", "Fish", "null", "src\\gui\\static\\images\\fish\\Carballas.png", "1kg", 330.00),
        new ItemClass ("Blue Marlin", "Fish", "null", "src\\gui\\static\\images\\fish\\Blue Marlin.png", "1kg", 495.00),
        new ItemClass ("Anduhaw", "Fish", "null", "src\\gui\\static\\images\\fish\\Anduhaw.png", "1kg", 340.00),
        new ItemClass ("Bilong Bilong", "Fish", "null", "src\\gui\\static\\images\\fish\\Bilong Bilong.png", "1kg", 330.00),
        new ItemClass ("Lagao", "Fish", "null", "src\\gui\\static\\images\\fish\\Lagao.png", "1kg", 480.00),
        new ItemClass ("Tamarong", "Fish", "null", "src\\gui\\static\\images\\fish\\Tamarong.png", "1kg", 350.00),
        new ItemClass ("Lapu Lapu", "Fish", "null", "src\\gui\\static\\images\\fish\\Lapu Lapu.png", "1kg", 859.00),
        new ItemClass ("Hasa Hasa", "Fish", "null", "src\\gui\\static\\images\\fish\\Hasa Hasa.png", "1kg", 479.00),
        new ItemClass ("Matambaka", "Fish", "null", "src\\gui\\static\\images\\fish\\Matambaka.png", "1kg", 379.00),
        new ItemClass ("Imelda", "Fish", "null", "src\\gui\\static\\images\\fish\\Imelda.png", "1kg", 249.00),
        new ItemClass ("Espada", "Fish", "null", "src\\gui\\static\\images\\fish\\Espada.png", "1kg", 529.00),
        new ItemClass ("Salmon Whole", "Fish", "null", "src\\gui\\static\\images\\fish\\Salmon.png", "1kg", 999.00),
        new ItemClass ("Pasayan", "Fish", "null", "src\\gui\\static\\images\\fish\\Pasayan.png", "1kg", 495.00),
        new ItemClass ("Talangka", "Fish", "null", "src\\gui\\static\\images\\fish\\Talangka.png", "1kg", 469.00),
        new ItemClass ("Tarorot", "Fish", "null", "src\\gui\\static\\images\\fish\\Tarorot.png", "1kg", 480.00)



    ));

    public static ArrayList<ItemClass> meatList;
    public static ArrayList<ItemClass> fishList;
    public static ArrayList<ItemClass> fruitList;
    public static ArrayList<ItemClass> vegetableList;

    public static HashMap<String ,ItemClass> loweredItems;

    public static HashMap<String, ItemClass> items;
    HashMap<ItemClass, Integer> itemStock = new HashMap<>();

    public Items() {

        items.forEach((key, value) -> {
            itemStock.put(value, 100);
        });
    }

    static {
        meatList = new ArrayList<>();
        fishList = new ArrayList<>();
        fruitList = new ArrayList<>();
        vegetableList = new ArrayList<>();
        loweredItems = new HashMap<>();
        items = new HashMap<>();
        
        for (ItemClass item: itemData) {
            items.put(item.getName(), item);
        }
        for (ItemClass item: itemData) {
            loweredItems.put(item.getName().toLowerCase(), item);
        }

        loadCategory("Meat", meatList);
        loadCategory("Fish", fishList);
        loadCategory("Fruit", fruitList);
        loadCategory("Vegetable", vegetableList);
    }

    private static void loadCategory(String category, ArrayList<ItemClass> list) {
        itemData.forEach(item -> {
            if (item.getCategory().equals(category)) {
                list.add(item);
            }
        });
    }

    public boolean inStock(String item, int quantity) {
        if (itemStock.get(items.get(item)) > quantity) {
            return true;
        }
        return false;
    }

    public int getStockAmount(String item) {
        return itemStock.get(items.get(item));
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
