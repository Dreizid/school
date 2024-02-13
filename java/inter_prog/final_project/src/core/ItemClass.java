package core;
public class ItemClass {
    public String itemName;
    public String description;
    public String imagePath;
    public String unit;
    public double price;
    public int quantity;
    public ItemClass (String itemName, String description, String imagePath, String unit, double price) {
        this.itemName = itemName;
        this.description = description;
        this.price = price;
        this.unit = unit;
        this.quantity = 1;
        this.imagePath = imagePath;
    }

    public void addQuantity () {
        quantity++;
    }

    public void subtractQuantity () {
        quantity--;
    }

    public void setQuantity (int quantity) {
        this.quantity = quantity;
    }

    /*
     * TO DO:
     * extend JPanel
     * make loadShopItem
     * make loadCartItem
     * make loadCheckoutItem
     */
}
