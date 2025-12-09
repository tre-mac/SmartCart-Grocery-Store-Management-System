public abstract class Item {
    private String itemID;
    private String itemName;
    private int quantity;
    private double price;

    private static int itemCount = 0;

    public Item(String itemID, String itemName, int quantity, double price) {
        this.itemID = itemID;
        this.itemName = itemName;
        setQuantity(quantity);
        setPrice(price);

        itemCount++;
    }
    //accessor methods
    public String getItemID() {
        return itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public static int getItemCount() {
        return itemCount;
    }

    //mutator methods
    public void setItemID(String itemID) {
        if (itemID != null && !itemID.isBlank()) {
            this.itemID = itemID;
        }
    }

    public void setItemName(String itemName) {
        if (itemName != null && !itemName.isBlank()) {
            this.itemName = itemName;
        }
    }

    public void setQuantity(int quantity) {
        if (quantity >= 0) {
            this.quantity = quantity;
        }
    }

    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        }
    }

    // Optional: Decrement counter if needed
    public static void decrementItemCount() {
        if (itemCount > 0) {
            itemCount--;
        }
    }

    // Abstract method to get item type
    public abstract String getItemType();

    @Override
    public String toString() {
        return "Item ID: " + itemID +
               "\nItem Name: " + itemName +
               "\nQuantity: " + quantity +
               "\nPrice: $" + price +
               "\nItem Type: " + getItemType();
    }
}
