package core;

public class Items {
    // name: Name, description: Kahit wala muna lagay nyolang null, imagePath: format src\\gui\\static\\images\\(itemname).png, unit: kung ilang kg, price: price
    
    // Justine
    public static MeatItem[] meatList = {
        new MeatItem("Chicken", "Whole Chicken", "src\\gui\\static\\images\\meats\\chicken.png", "800g - 1000g", 127.30),
        new MeatItem("Beef Sukiyaki Cut", "Sukiyaki Sliced Beef", "src\\gui\\static\\images\\meats\\sukiyaki.png", "500g - 550g", 255.75),
        new MeatItem("Ground Pork", "Ground Pork Meat", "src\\gui\\static\\images\\meats\\groundpork.png", "500g - 550g", 139.70),
        new MeatItem("Pork Adobo Cut", "null", "src\\gui\\static\\images\\meats\\adobo.png", "500g - 550g", 158.40),
        new MeatItem("Pork Sinigang Cut", "null", "src\\gui\static\\images\\meats\\sinigang.png", "400g - 500g", 98.50),
        new MeatItem("Chicken Tinola Cut", "null", "src\\gui\\static\\images\\meats\\tinola.png", "500g - 550g", 81.40),
        new MeatItem("Cicken Breast Fillet", "null", "src\\gui\\static\\images\\meats\\breast.png", "500g - 550g", 141.35),
        new MeatItem("Chicken Thigh Fillet", "null", "src\\gui\\static\\images\\meats\\cthighs.png", "500g - 550g", 152.90),
        new MeatItem("Ground Beef", "null", "src\\gui\\static\\images\\meats\\groundbeef.png", "500g - 550g", 167.20),
        new MeatItem("Beef Cubes", "null", "src\\gui\\static\\images\\meats\\bcubes.png", "500g - 550g", 207.35),
        new MeatItem("Pork Kasim Cut", "null", "src\\gui\\static\\images\\meats\\pkasim.png", "500g - 550g", 145.75),
        new MeatItem("Pork Liempo Cut", "null", "src\\gui\\static\\images\\meats\\liempo.png", "400g - 500g", 172.50),
        new MeatItem("Pork Menudo Cut", "null", "src\\gui\\static\\images\\meats\\pmenudo.png", "500g - 550g", 169.40),
        new MeatItem("Pork Cubes", "null", "src\\gui\\static\\images\\meats\\pcubes.png", "500g - 550g", 159.50),
        new MeatItem("Pork Chop", "null", "src\\gui\\static\\images\\meats\\chop.png", "400g - 500g", 142.50),


};

    // Ein
    public static FishItem[] fishList = {
                                        new FishItem("name", "description", "imagepath", "unit", 0)
    };

    // Justine
    public static FruitItem[] fruitList = {
        new FruitItem("Fuji Apple", "null", "src\\gui\\static\\images\\fruits\\fuji.png", "6 pcs", 169.00),
        new FruitItem("Cavendish Banana", "null", "src\\gui\\static\\images\\fruits\\bcavender.png", "1100g - 1300g", 128.70),
        new FruitItem("Lemon", "null", "src\\gui\\static\\images\\fruits\\lemon.png", "3 pcs", 70.00),
        new FruitItem("Banana Lacatan", "null", "src\\gui\\static\\images\\fruits\\blacatan.png", "1100g - 1300g", 195.00),
        new FruitItem("Mandarin Oranges", "null", "src\\gui\\static\\images\\fruits\\mandarin.png", "6 pcs", 232.00),
        new FruitItem("Honeydew", "null", "src\\gui\\static\\images\\fruits\\honeydew.png", "100g - 1500g", 247.50),
        new FruitItem("Banana Saba", "null", "src\\gui\\static\\images\\fruits\\bsaba.png", "1000g - 1500g", 103.50),
        new FruitItem("Avocado", "null", "src\\gui\\static\\images\\fruits\\avocado.png", "900g - 1000g", 299.00),
        new FruitItem("Mango Ripe", "null", "src\\gui\\static\\images\\fruits\\ripemango.png", "900g - 1000g", 290.00),
        new FruitItem("Gala Apple", "null", "src\\gui\\static\\images\\fruits\\gala.png", "3 pcs", 148.00),
        new FruitItem("Flame Red Seedless Grapes", "null", "src\\gui\\static\\images\\fruits\\frgrapes.png", "700g - 800g", 349.60),
        new FruitItem("Lanzones", "null", "src\\gui\\static\\images\\fruits\\lanzones.png", "900g - 1000g", 350.00),
        new FruitItem("Crimson Seedless Grapes", "null", "src\\gui\\static\\images\\fruits\\crimson.png", "700g - 800g", 205.80),
        new FruitItem("Green Kiwi", "null", "src\\gui\\static\\images\\fruits\\kiwi.png", "6 pcs", 272.00),
        new FruitItem("Pineapple", "null", "src\\gui\\static\\images\\fruits\\pineapple.png", "pc", 133.00),

};

    // Ein
    public static VegetableItem[] vegetableList = {
                                        new VegetableItem("name", "description", "imagepath", "unit", 0)
    };


    public Items() {

    }

    public void loadItems() {
        
    }


}
