import java.util.ArrayList;

public class Cart {
    ArrayList<MeatItem> meatCart;
    ArrayList<FruitItem> fruitCart;
    ArrayList<VegetableItem> vegetableCart;
    ArrayList<FishItem> fishCart;
    double cartTotal = 0;

    public Cart() {
        meatCart = new ArrayList<MeatItem>();
        fruitCart = new ArrayList<FruitItem>();
        vegetableCart = new ArrayList<VegetableItem>();
        fishCart = new ArrayList<FishItem>();

    }

    public void addToCart(MeatItem item) {
        int indexOfItem = findIndexOf(item);
        boolean found = false;
        if (inCart(item, indexOfItem)) {
            meatCart.get(indexOfItem).addQuantity();
            found = true;
        }

        if (!found) {
            meatCart.add(item);
        }
    }

    public void subtractFromCart (MeatItem item) {
        int indexOfItem = findIndexOf(item);
        if (inCart(item, indexOfItem) && meatCart.get(indexOfItem).quantity > 1) {
            meatCart.get(indexOfItem).subtractQuantity();
        } else if (inCart(item, indexOfItem) && meatCart.get(indexOfItem).quantity < 1) {
            meatCart.remove(indexOfItem);
        }
    }

    public void setItemQuantity (MeatItem item, int quantity) {
        int indexOfItem = findIndexOf(item);
        boolean found = false;
        if (inCart(item, indexOfItem)) {
            meatCart.get(indexOfItem).setQuantity(quantity);
            found = true;
        }
        
        if (!found) {
            item.setQuantity(quantity);
            meatCart.add(item);
        }
    }

    public int findIndexOf(MeatItem item) {
        for (MeatItem meat: meatCart){
            if (meat.itemName.equals(item.itemName)) {
                return meatCart.indexOf(meat);
            }
        }

        return -1;
    }

    public boolean inCart (MeatItem item, int indexOfItem) {
        if (indexOfItem >= 0 && meatCart.get(indexOfItem).itemName.equals(item.itemName)) {
            return true;
        } else {
            return false;
        }
    }

    /*
     * Overloading the method for FishItem.
     */

    public void addToCart(FishItem item) {
        int indexOfItem = findIndexOf(item);
        boolean found = false;
        if (inCart(item, indexOfItem)) {
            fishCart.get(indexOfItem).addQuantity();
            found = true;
        }

        if (!found) {
            fishCart.add(item);
        }
    }

    public void subtractFromCart (FishItem item) {
        int indexOfItem = findIndexOf(item);
        if (inCart(item, indexOfItem) && fishCart.get(indexOfItem).quantity > 1) {
            fishCart.get(indexOfItem).subtractQuantity();
        } else if (inCart(item, indexOfItem) && fishCart.get(indexOfItem).quantity < 1) {
            fishCart.remove(indexOfItem);
        }
    }

    public void setItemQuantity (FishItem item, int quantity) {
        int indexOfItem = findIndexOf(item);
        boolean found = false;
        if (inCart(item, indexOfItem)) {
            fishCart.get(indexOfItem).setQuantity(quantity);
            found = true;
        }
        
        if (!found) {
            item.setQuantity(quantity);
            fishCart.add(item);
        }
    }

    public int findIndexOf(FishItem item) {
        for (FishItem fish: fishCart){
            if (fish.itemName.equals(item.itemName)) {
                return fishCart.indexOf(fish);
            }
        }

        return -1;
    }

    public boolean inCart (FishItem item, int indexOfItem) {
        if (indexOfItem >= 0 && fishCart.get(indexOfItem).itemName.equals(item.itemName)) {
            return true;
        } else {
            return false;
        }
    }

    /*
     * Overloading the method for FruitItem.
     */

    public void addToCart(FruitItem item) {
        int indexOfItem = findIndexOf(item);
        boolean found = false;
        if (inCart(item, indexOfItem)) {
            fruitCart.get(indexOfItem).addQuantity();
            found = true;
        }

        if (!found) {
            fruitCart.add(item);
        }
    }

    public void subtractFromCart (FruitItem item) {
        int indexOfItem = findIndexOf(item);
        if (inCart(item, indexOfItem) && fruitCart.get(indexOfItem).quantity > 1) {
            fruitCart.get(indexOfItem).subtractQuantity();
        } else if (inCart(item, indexOfItem) && fruitCart.get(indexOfItem).quantity < 1) {
            fruitCart.remove(indexOfItem);
        }
    }

    public void setItemQuantity (FruitItem item, int quantity) {
        int indexOfItem = findIndexOf(item);
        boolean found = false;
        if (inCart(item, indexOfItem)) {
            fruitCart.get(indexOfItem).setQuantity(quantity);
            found = true;
        }
        
        if (!found) {
            item.setQuantity(quantity);
            fruitCart.add(item);
        }
    }

    public int findIndexOf(FruitItem item) {
        for (FruitItem fruit: fruitCart){
            if (fruit.itemName.equals(item.itemName)) {
                return fruitCart.indexOf(fruit);
            }
        }

        return -1;
    }

    public boolean inCart (FruitItem item, int indexOfItem) {
        if (indexOfItem >= 0 && fruitCart.get(indexOfItem).itemName.equals(item.itemName)) {
            return true;
        } else {
            return false;
        }
    }

        /*
     * Overloading the method for VegetableItem.
     */

    public void addToCart(VegetableItem item) {
        int indexOfItem = findIndexOf(item);
        boolean found = false;
        if (inCart(item, indexOfItem)) {
            vegetableCart.get(indexOfItem).addQuantity();
            found = true;
        }

        if (!found) {
            vegetableCart.add(item);
        }
    }

    public void subtractFromCart (VegetableItem item) {
        int indexOfItem = findIndexOf(item);
        if (inCart(item, indexOfItem) && vegetableCart.get(indexOfItem).quantity > 1) {
            vegetableCart.get(indexOfItem).subtractQuantity();
        } else if (inCart(item, indexOfItem) && vegetableCart.get(indexOfItem).quantity < 1) {
            vegetableCart.remove(indexOfItem);
        }
    }

    public void setItemQuantity (VegetableItem item, int quantity) {
        int indexOfItem = findIndexOf(item);
        boolean found = false;
        if (inCart(item, indexOfItem)) {
            vegetableCart.get(indexOfItem).setQuantity(quantity);
            found = true;
        }
        
        if (!found) {
            item.setQuantity(quantity);
            vegetableCart.add(item);
        }
    }

    public int findIndexOf(VegetableItem item) {
        for (VegetableItem vegetable: vegetableCart){
            if (vegetable.itemName.equals(item.itemName)) {
                return vegetableCart.indexOf(vegetable);
            }
        }

        return -1;
    }

    public boolean inCart (VegetableItem item, int indexOfItem) {
        if (indexOfItem >= 0 && vegetableCart.get(indexOfItem).itemName.equals(item.itemName)) {
            return true;
        } else {
            return false;
        }
    }


}
