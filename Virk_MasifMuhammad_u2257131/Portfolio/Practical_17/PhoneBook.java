package Portfolio.Practical_17;

import java.util.Hashtable;

// Class PhoneBook:
public class PhoneBook {
    private Hashtable<String, PhoneBookEntry> phoneBook;

    // Constructor for PhoneBook class
    public PhoneBook() {
        // Initialize phoneBook Hashtable
        phoneBook = new Hashtable<String, PhoneBookEntry>();
    }

    // Method to insert a PhoneBookEntry into phoneBook
    public void insert(PhoneBookEntry entry) {
        phoneBook.put(entry.getName(), entry);
    }

    // Method to update a PhoneBookEntry in phoneBook
    public void update(PhoneBookEntry entry) {
        phoneBook.put(entry.getName(), entry);
    }

    // Method to delete a PhoneBookEntry from phoneBook
    public void delete(String name) {
        phoneBook.remove(name);
    }

    // Method to get a PhoneBookEntry from phoneBook
    public PhoneBookEntry getEntry(String name) {
        return phoneBook.get(name);
    }

    // Method to print all PhoneBookEntry objects in phoneBook
    public void printAllEntries() {
        for (PhoneBookEntry entry : phoneBook.values()) {
            System.out.println(entry);
        }
    }
}