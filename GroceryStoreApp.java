import javax.swing.JOptionPane;
import java.util.ArrayList;

public class GroceryStoreApp {

    public static void main(String[] args) {

        // Hardcoded Store info 
        GroceryStore store = new GroceryStore("S001", "My Grocery Store", "123 Main Street");

        int userInput = -1;

        do {
            try {
                userInput = Integer.parseInt(JOptionPane.showInputDialog(
                    "Welcome to " + store.getStoreName() + " Management System\n\n" + "Enter your choice:\n" + "1. Manage Items\n" + "2. Manage Customers\n" + "3. View Reports\n" + "4. Quit"
                ));
            } catch (NumberFormatException e) {
                userInput = -1;
            }

            switch (userInput) {
                case 1:
                    itemMenu(store);
                    break;
                case 2:
                    customerMenu(store);
                    break;
                case 3:
                    reportsMenu(store);
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Exiting program. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice. Please enter 1–4.");
            }
        } while (true);
    }

    //item Menu
    public static void itemMenu(GroceryStore store) {
        int choice = -1;

        do {
            try {
                choice = Integer.parseInt(JOptionPane.showInputDialog("Item Menu:\n" + "1. Add Item\n" + "2. Remove Item\n" + "3. View All Items\n" + "4. Search Item by ID\n" + "5. Back to Main Menu"));
            } catch (NumberFormatException e) {
                choice = -1;
            }

            switch (choice) {
                case 1:
                    addItem(store);
                    break;
                case 2:
                    removeItem(store);
                    break;
                case 3:
                    viewItems(store);
                    break;
                case 4:
                    searchItem(store);
                    break;
                case 5:
                    return; // back to main
                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice. Please enter 1–5.");
            }

        } while (true);
    }

    public static void addItem(GroceryStore store) {
        String type = JOptionPane.showInputDialog("Enter Item Type:\n" + "1. Perishable\n" + "2. Non-Perishable");

        if (type == null) return; 

        String itemID = JOptionPane.showInputDialog("Enter Item ID:");
        String itemName = JOptionPane.showInputDialog("Enter Item Name:");

        int quantity;
        try {
            quantity = Integer.parseInt(JOptionPane.showInputDialog("Enter Quantity:"));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid quantity. Item not created.");
            return;
        }

        double price = Double.parseDouble(JOptionPane.showInputDialog("Enter Unit Price:"));

        if (type.equals("1")) {
            try {
                String expirationDate = JOptionPane.showInputDialog("Enter Expiration Date:");
                String storageType = JOptionPane.showInputDialog("Enter Storage Type (e.g., Refrigerated, Frozen):");

                if (expirationDate == null || storageType == null || expirationDate.isBlank() || storageType.isBlank()) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Perishable item not created.");
                    return;
                }

                Item p = new Perishable(itemID, itemName, quantity, price, expirationDate, storageType);
                store.addItem(p);
                JOptionPane.showMessageDialog(null, "Perishable item added successfully!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error creating perishable item. Please try again.");
            }

        } else if (type.equals("2")) {
            String categoryType = JOptionPane.showInputDialog("Enter Category Type (e.g., Canned Goods, Dry Goods):");
            int shelfLife = Integer.parseInt(JOptionPane.showInputDialog("Enter Shelf Life (months):"));

            Item np = new NonPerishable(itemID, itemName, quantity, price, categoryType, shelfLife);
            store.addItem(np);
            JOptionPane.showMessageDialog(null, "Non-perishable item added successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Invalid type. Item not created.");
        }
    }

    public static void removeItem(GroceryStore store) {
        String itemID = JOptionPane.showInputDialog("Enter Item ID to remove:");
        if (itemID == null) return;

        boolean removed = store.removeItembyID(itemID);
        if (removed) {
            JOptionPane.showMessageDialog(null, "Item removed successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Item not found.");
        }
    }

    public static void viewItems(GroceryStore store) {
        ArrayList<Item> items = store.getAllItems();
        if (items.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No items available.");
            return;
        }

        String output = "";
        for (Item item : items) {
            output += item.toString() + "\n----------------------\n";
        }

        JOptionPane.showMessageDialog(null, output);
    }

    public static void searchItem(GroceryStore store) {
        String itemID = JOptionPane.showInputDialog("Enter Item ID to search:");
        if (itemID == null) return;

        Item found = store.searchItemByID(itemID);
        if (found != null) {
            JOptionPane.showMessageDialog(null, found.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Item not found.");
        }
    }
    //customer menu
    public static void customerMenu(GroceryStore store) {
        int choice = -1;

        do {
            try {
                choice = Integer.parseInt(JOptionPane.showInputDialog("Customer Menu:\n" + "1. Add Customer\n" + "2. Remove Customer\n" + "3. View All Customers\n" + "4. Search Customer by ID\n" + "5. Back to Main Menu"));
            } catch (NumberFormatException e) {
                choice = -1;
            }

            switch (choice) {
                case 1:
                    addCustomer(store);
                    break;
                case 2:
                    removeCustomer(store);
                    break;
                case 3:
                    viewCustomers(store);
                    break;
                case 4:
                    searchCustomer(store);
                    break;
                case 5:
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice. Please enter 1–5.");
            }

        } while (true);
    }

    public static void addCustomer(GroceryStore store) {
        String type = JOptionPane.showInputDialog("Enter Customer Type:\n" + "1. Business Customer\n" + "2. Individual Customer");

        if (type == null) return;

        String customerID = JOptionPane.showInputDialog("Enter Customer ID:");
        String name = JOptionPane.showInputDialog("Enter Name:");
        String email = JOptionPane.showInputDialog("Enter Email:");
        String phone = JOptionPane.showInputDialog("Enter Phone:");
        String address = JOptionPane.showInputDialog("Enter Address:");

        if (type.equals("1")) {
            String companyName = JOptionPane.showInputDialog("Enter Company Name:");
            String businessType = JOptionPane.showInputDialog("Enter Business Type:");
            String taxID = JOptionPane.showInputDialog("Enter Tax ID:");
            String membershipTier = JOptionPane.showInputDialog("Enter Membership Tier:");

            Customer bc = new BusinessCustomer(customerID, name, email, phone, address, companyName, businessType, taxID, membershipTier);
            store.addCustomer(bc);
            JOptionPane.showMessageDialog(null, "Business customer added successfully!");

        } else if (type.equals("2")) {
            int loyaltyPoints = Integer.parseInt(JOptionPane.showInputDialog("Enter Loyalty Points:"));
            String preferredPaymentMethod = JOptionPane.showInputDialog("Enter Preferred Payment Method:");

            Customer ic = new Individualcustomer(customerID, name, email, phone, address, loyaltyPoints, preferredPaymentMethod);
            store.addCustomer(ic);
            JOptionPane.showMessageDialog(null, "Individual customer added successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Invalid type. Customer not created.");
        }
    }

    public static void removeCustomer(GroceryStore store) {
        String customerID = JOptionPane.showInputDialog("Enter Customer ID to remove:");
        if (customerID == null) return;

        boolean removed = store.removeCustomerByID(customerID);
        if (removed) {
            JOptionPane.showMessageDialog(null, "Customer removed successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Customer not found.");
        }
    }

    public static void viewCustomers(GroceryStore store) {
        ArrayList<Customer> customers = store.getAllCustomers();
        if (customers.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No customers available.");
            return;
        }

        String output = "";
        for (Customer c : customers) {
            output += c.toString() + "\n----------------------\n";
        }

        JOptionPane.showMessageDialog(null, output);
    }

    public static void searchCustomer(GroceryStore store) {
        String customerID = JOptionPane.showInputDialog("Enter Customer ID to search:");
        if (customerID == null) return;

        Customer c = store.searchCustomerByID(customerID);
        if (c != null) {
            JOptionPane.showMessageDialog(null, c.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Customer not found.");
        }
    }

    // report 
    public static void reportsMenu(GroceryStore store) {

        double totalValue = store.calculateInventoryValue();
        ArrayList<Item> items = store.getAllItems();
        ArrayList<Customer> customers = store.getAllCustomers();

        int totalItems = items.size();
        int totalCustomers = customers.size();

        String report = "Grocery Store Report\n\n";

        report += "Store Name: " + store.getStoreName() + "\n";
        report += "Store Address: " + store.getStoreAddress() + "\n\n";

        report += "Total number of items: " + totalItems + "\n";
        report += "Total number of customers: " + totalCustomers + "\n";
        report += String.format("Total inventory value: $%.2f\n", totalValue);

        if (totalItems > 0) {
            int totalQuantity = 0;
            for (Item item : items) {
                totalQuantity += item.getQuantity();
            }
            double avgQuantity = (double) totalQuantity / totalItems;
            report += String.format("Average quantity per item: %.2f\n", avgQuantity);
        }

        report += "\nDetails of all items:\n";

        if (items.isEmpty()) {
            report += "  No items in inventory.\n";
        } else {
            for (Item item : items) {
                report += "Item ID: " + item.getItemID()
                        + " | Name: " + item.getItemName()
                        + " | Type: " + item.getItemType()
                        + " | Price: $" + item.getPrice()
                        + " | Quantity: " + item.getQuantity()
                        + "\n";
            }
        }

        report += "\nDetails of all customers:\n";

        if (customers.isEmpty()) {
            report += "  No customers in the system.\n";
        } else {
            for (Customer c : customers) {
                report += "Customer ID: " + c.getCustomerID()
                        + " | Name: " + c.getName()
                        + " | Type: " + c.getCustomerType()
                        + " | Email: " + c.getEmail()
                        + " | Phone: " + c.getPhone()
                        + "\n";
            }
        }

        JOptionPane.showMessageDialog(null, report);
    }
}
