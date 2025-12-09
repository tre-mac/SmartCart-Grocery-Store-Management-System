import java.util.ArrayList;

public class GroceryStore{ 
    private String storeID;
    private String storeName;
    private String storeAddress;

    private ArrayList<Item> allItems;
    private ArrayList<Customer> allCustomers;

    private static int storeCount = 0;

     public GroceryStore(String storeID, String storeName, String storeAddress) {
        this.storeID = storeID;
        this.storeName = storeName;
        this.storeAddress = storeAddress;

        this.allItems = new ArrayList<>();
        this.allCustomers = new ArrayList<>();

        storeCount++;
    }
    //accessor methods
    public String getStoreID() {
        return storeID;
    }
    public String getStoreName() {
        return storeName;
    }
    public String getStoreAddress() {
        return storeAddress;
    }
    public ArrayList<Item> getAllItems() {
        return allItems;
    }
    public ArrayList<Customer> getAllCustomers() {
        return allCustomers;
    }
    public static int getStoreCount() {
        return storeCount;
    }
    //mutator methods
    public void setStoreID(String storeID) {
        if (storeID != null && !storeID.isEmpty()) {
            this.storeID = storeID;
        }
    }

    public void setStoreName(String storeName) {
        if (storeName != null && !storeName.isEmpty()) {
            this.storeName = storeName;
        }
    }

    public void setStoreAddress(String storeAddress) {
        if (storeAddress != null && !storeAddress.isEmpty()) {
            this.storeAddress = storeAddress;
        }
    }
    //item management 
    public void addItem(Item item){
        if(item != null){
            allItems.add(item);
        }
    }
    public boolean removeItembyID(String itemID){
        if(itemID == null){
            return false;
        }
        for(int i = 0; i < allItems.size(); i++){
            if(allItems.get(i).getItemID().equalsIgnoreCase(itemID)){
                allItems.remove(i);
                return true;
            }
        }
        return false;
    }
public Item searchItemByID(String itemID){
        if(itemID == null){
            return null;
        }
        for(Item item : allItems){
            if(item.getItemID().equalsIgnoreCase(itemID)){
                return item;
            }
        }
        return null;
    }

public ArrayList<Item> searchItemsByName(String name){
        ArrayList<Item> results = new ArrayList<>();
        if(name == null){
            return results;
}
        for(Item item : allItems){
            if(item.getItemName().equalsIgnoreCase(name)){
                results.add(item);
            }
        }
        return results;
    }
    public double calculateInventoryValue(){
        double totalValue = 0.0;
        for(Item item : allItems){
            totalValue += item.getPrice() * item.getQuantity();
        }
        return totalValue;
    }
    public void addCustomer(Customer customer){
        if(customer != null){
            allCustomers.add(customer);
        }
    }
    public boolean removeCustomerByID(String customerID) {
        if (customerID == null) {
            return false;
        }
        for (int i = 0; i < allCustomers.size(); i++) {
            if (allCustomers.get(i).getCustomerID().equalsIgnoreCase(customerID)) {
                allCustomers.remove(i);
                return true;
            }
        }
        return false;
    }

    public Customer searchCustomerByID(String customerID) {
        if (customerID == null) {
            return null;
        }
        for (Customer c : allCustomers) {
            if (c.getCustomerID().equalsIgnoreCase(customerID)) {
                return c;
            }
        }
        return null;
    }

    public ArrayList<Customer> searchCustomersByName(String name) {
        ArrayList<Customer> results = new ArrayList<>();
        if (name == null) {
            return results;
        }
        for (Customer c : allCustomers) {
            if (c.getName().equalsIgnoreCase(name)) {
                results.add(c);
            }
        }
        return results;
    }

    public String toString() {
        return "Store ID: " + storeID +
               "\nStore Name: " + storeName +
               "\nStore Address: " + storeAddress +
               "\nNumber of Items: " + allItems.size() +
               "\nNumber of Customers: " + allCustomers.size();
    }
}

