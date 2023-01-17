package Portfolio.Practical_17;

// Class User:
public class User {
    public static void main(String[] args) {
        // Create a new PhoneBook instance
        PhoneBook phoneBook = new PhoneBook();

        // Create two PhoneBookEntry objects
        PhoneBookEntry john = new PhoneBookEntry("John", "123-456-7890", "john@example.com", "123 Main St");
        PhoneBookEntry jane = new PhoneBookEntry("Jane", "098-765-4321", "jane@example.com", "456 Main St");

        // Insert the PhoneBookEntry objects into the phone book
        phoneBook.insert(john);
        phoneBook.insert(jane);

        // Print all entries in the phone book
        phoneBook.printAllEntries();

        // Update the information for the PhoneBookEntry object with the name "Jane"
        PhoneBookEntry janeUpdated = new PhoneBookEntry("Jane", "111-111-1111", "jane@example.com", "456 Main St");
        phoneBook.update(janeUpdated);

        // Print all entries in the phone book
        phoneBook.printAllEntries();

        // Delete the PhoneBookEntry object with the name "John"
        phoneBook.delete("John");
        // Print all entries in the phone book
        phoneBook.printAllEntries();

        // Get the PhoneBookEntry object with the name "Jane"
        PhoneBookEntry entry = phoneBook.getEntry("Jane");
        // Print the PhoneBookEntry object
        System.out.println(entry);
    }
}