public class NonPerishable extends Item {

    private String categoryType;
    private int shelfLife; // in months

    // Specific Constructor
    public NonPerishable(String itemID, String itemName, int quantity, double price,
                         String categoryType, int shelfLife) {

        super(itemID, itemName, quantity, price);
        setCategoryType(categoryType);
        setShelfLife(shelfLife);
    }

    // Accessors (Getters)
    public String getCategoryType() {
        return categoryType;
    }

    public int getShelfLife() {
        return shelfLife;
    }

    // Mutators (Setters)
    public void setCategoryType(String categoryType) {
        if (categoryType != null && !categoryType.isBlank()) {
            this.categoryType = categoryType;
        }
    }

    public void setShelfLife(int shelfLife) {
        if (shelfLife >= 0) {
            this.shelfLife = shelfLife;
        }
    }

    // Abstract Method
    @Override
    public String getItemType() {
        return "Non-Perishable";
    }

    // toString Override
    @Override
    public String toString() {
        return super.toString()
                + "\nCategory Type: " + categoryType
                + "\nShelf Life (months): " + shelfLife;
    }
}
