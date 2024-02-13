package core;

public class Items {
    // name: Name, description: Kahit wala muna lagay nyolang null, imagePath: format src\\gui\\static\\images\\(itemname).png, unit: kung ilang kg, price: price
    public static MeatItem[] meatList = {
                                        new MeatItem("Chicken", "Chickey", "null", "1 whole", 127.30),
                                        new MeatItem("Beef", "Beefy", "src\\gui\\static\\images\\beef.png", "1kg", 155.50),
                                        new MeatItem("Pork", "", "", "1kg", 230.5)
    };

    public static FishItem[] fishList = {
                                        new FishItem("name", "description", "imagepath", "unit", 0)
    };

    public static FruitItem[] fruitList = {
                                        new FruitItem("name", "description", "imagepath", "unit", 0)
    };

    public static VegetableItem[] vegetableList = {
                                        new VegetableItem("name", "description", "imagepath", "unit", 0)
    };


    public Items() {

    }

    public void loadItems() {
        
    }


}
