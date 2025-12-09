public abstract class Customer {

    private String customerID;
    private String name;
    private String email;
    private String phone;
    private String address;

    // Specific Constructor
    public Customer(String customerID, String name, String email, String phone, String address) {
        setCustomerID(customerID);
        setName(name);
        setEmail(email);
        setPhone(phone);
        setAddress(address);
    }

    // Accessors (Getters)
    public String getCustomerID() {
        return customerID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    // Mutators (Setters)
    public void setCustomerID(String customerID) {
        if (customerID != null && !customerID.isBlank()) {
            this.customerID = customerID;
        }
    }

    public void setName(String name) {
        if (name != null && !name.isBlank()) {
            this.name = name;
        }
    }

    public void setEmail(String email) {
        if (email != null && !email.isBlank()) {
            this.email = email;
        }
    }

    public void setPhone(String phone) {
        if (phone != null && !phone.isBlank()) {
            this.phone = phone;
        }
    }

    public void setAddress(String address) {
        if (address != null && !address.isBlank()) {
            this.address = address;
        }
    }


    // Abstract Method
    public abstract String getCustomerType();


    // toString Method
    @Override
    public String toString() {
        return "Customer ID: " + customerID +
               "\nName: " + name +
               "\nEmail: " + email +
               "\nPhone: " + phone +
               "\nAddress: " + address;
    }
}
