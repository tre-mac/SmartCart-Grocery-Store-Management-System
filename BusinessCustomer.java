public class BusinessCustomer extends Customer {

    private String companyName;
    private String businessType;
    private String taxID;
    private String membershipTier;

    // Specific Constructor
    public BusinessCustomer(
            String customerID, String name, String email, String phone, String address,
            String companyName, String businessType, String taxID, String membershipTier) {

        super(customerID, name, email, phone, address);

        setCompanyName(companyName);
        setBusinessType(businessType);
        setTaxID(taxID);
        setMembershipTier(membershipTier);
    }

    // Accessors (Getters)
    public String getCompanyName() {
        return companyName;
    }

    public String getBusinessType() {
        return businessType;
    }

    public String getTaxID() {
        return taxID;
    }

    public String getMembershipTier() {
        return membershipTier;
    }

    // Mutators (Setters)
    public void setCompanyName(String companyName) {
        if (companyName != null && !companyName.isBlank()) {
            this.companyName = companyName;
        }
    }

    public void setBusinessType(String businessType) {
        if (businessType != null && !businessType.isBlank()) {
            this.businessType = businessType;
        }
    }

    public void setTaxID(String taxID) {
        if (taxID != null && !taxID.isBlank()) {
            this.taxID = taxID;
        }
    }

    public void setMembershipTier(String membershipTier) {
        if (membershipTier != null && !membershipTier.isBlank()) {
            this.membershipTier = membershipTier;
        }
    }

    // Abstract Method
    @Override
    public String getCustomerType() {
        return "Business Customer";
    }

    // toString Override
    @Override
    public String toString() {
        return super.toString()
                + "\nCustomer Type: " + getCustomerType()
                + "\nCompany Name: " + companyName
                + "\nBusiness Type: " + businessType
                + "\nTax ID: " + taxID
                + "\nMembership Tier: " + membershipTier;
    }
}
