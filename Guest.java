public class Guest {
    private String name;
    private String addressDetails;

    // Default Constructor
    public Guest() {
    }

    // Constructor (UML: create())
    public Guest(String name, String addressDetails) {
        this.name = (name != null) ? name : "Unknown";
        this.addressDetails = (addressDetails != null) ? addressDetails : "Not Provided";
    }

    public String getName() {
        return name;
    }

    public String getAddressDetails() {
        return addressDetails;
    }

    // Method logic updated (Made static for better utility)
    public static Guest create(String name, String addressDetails) {
        if (name == null || name.isEmpty()) {
            return new Guest("Default Guest", addressDetails);
        }
        return new Guest(name, addressDetails);
    }
}