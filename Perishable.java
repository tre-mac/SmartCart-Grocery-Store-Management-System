public class Perishable extends Item {

    private String expirationDate;
    private String storageType;

    // Specific Constructor
    public Perishable(String itemID, String itemName, int quantity, double price,
                      String expirationDate, String storageType) {

        super(itemID, itemName, quantity, price);
        setExpirationDate(expirationDate);
        setStorageType(storageType);
    }

    // Accessors
    public String getExpirationDate() {
        return expirationDate;
    }

    public String getStorageType() {
        return storageType;
    }

    // Mutators
    public void setExpirationDate(String expirationDate) {
        if (expirationDate != null && !expirationDate.isBlank()) {
            this.expirationDate = expirationDate;
        }
    }

    public void setStorageType(String storageType) {
        if (storageType != null && !storageType.isBlank()) {
            this.storageType = storageType;
        }
    }

    //Abstract Method
    @Override
    public String getItemType() {
        return "Perishable";
    }

    // toString Override
    @Override
    public String toString() {
        return super.toString()
                + "\nExpiration Date: " + expirationDate
                + "\nStorage Type: " + storageType;
    }
}
