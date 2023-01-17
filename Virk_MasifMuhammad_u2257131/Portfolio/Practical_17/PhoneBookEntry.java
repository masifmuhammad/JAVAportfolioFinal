package Portfolio.Practical_17;

// Class PhoneBookEntry:
public class PhoneBookEntry {
    private String name;
    private String phoneNumber;
    private String email;
    private String address;

    // Constructor for PhoneBookEntry class
    public PhoneBookEntry(String name, String phoneNumber, String email, String address) {
        // Initialize instance variables
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    // toString method for PhoneBookEntry class
    @Override
    public String toString() {
        // Return string representation of PhoneBookEntry object
        return "Name: " + name + "\nPhone Number: " + phoneNumber + "\nEmail: " + email + "\nAddress: " + address;
    }
}