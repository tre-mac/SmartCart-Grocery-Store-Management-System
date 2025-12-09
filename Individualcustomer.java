public class Individualcustomer extends Customer {


    // Instance Variables
    private int loyaltyPoints;
    private String preferredPaymentMethod;


    // Specific Constructor
    public Individualcustomer(
            String customerID, String name, String email,
            String phone, String address,
            int loyaltyPoints, String preferredPaymentMethod) {

        super(customerID, name, email, phone, address);

        setLoyaltyPoints(loyaltyPoints);
        setPreferredPaymentMethod(preferredPaymentMethod);
    }

    // Accessors (Getters)
    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public String getPreferredPaymentMethod() {
        return preferredPaymentMethod;
    }


    // Mutators (Setters)
    public void setLoyaltyPoints(int loyaltyPoints) {
        if (loyaltyPoints >= 0) {
            this.loyaltyPoints = loyaltyPoints;
        }
    }

    public void setPreferredPaymentMethod(String preferredPaymentMethod) {
        if (preferredPaymentMethod != null && !preferredPaymentMethod.isBlank()) {
            this.preferredPaymentMethod = preferredPaymentMethod;
        }
    }


    //Abstract Method
    @Override
    public String getCustomerType() {
        return "Individual Customer";
    }

    // toString Override
    @Override
    public String toString() {
        return super.toString()
                + "\nCustomer Type: " + getCustomerType()
                + "\nLoyalty Points: " + loyaltyPoints
                + "\nPreferred Payment Method: " + preferredPaymentMethod;
    }
}
