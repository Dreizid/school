package core;
public class ItemClass {
    private String itemName;
    private String category;
    private String description;
    private String imagePath;
    private String unit;
    private double price;
    public ItemClass (String itemName, String category, String description, String imagePath, String unit, double price) {
        this.itemName = itemName;
        this.category = category;
        this.description = description;
        this.price = price;
        this.unit = unit;
        this.imagePath = imagePath;
    }

    public String getName() {
        return this.itemName;
    }

    public String getCategory() {
        return this.category;
    }

    public String getDescription() {
        return this.description;
    }

    public String getImagePath() {
        return this.imagePath;
    }

    public String getUnit() {
        return this.unit;
    }

    public double getPrice() {
        return this.price;
    }

    /*
     * TO DO:
     * extend JPanel
     * make loadShopItem
     * make loadCartItem
     * make loadCheckoutItem
     */
}
