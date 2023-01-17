package Portfolio.Practical_11;
import java.util.*;

public class Module {
    // Fields
    private String moduleCode; // The code of the module
    private Student[] registeredStudents; // The list of registered students in the module
    private int count; // The number of registered students in the module

    // Constructor
    public Module(String moduleCode) {
        this.moduleCode = moduleCode;
        this.registeredStudents = new Student[5]; // Initialize array with capacity of 5
        this.count = 0; // Initialize count to 0
    }

    // Getter method for moduleCode
    public String getModuleCode() {
        return moduleCode;
    }

    // Setter method for moduleCode
    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    // Getter method for registeredStudents
    public Student[] getRegisteredStudents() {
        return registeredStudents;
    }

    // Getter method for count
    public int getCount() {
        return count;
    }

    // Method to register a student in the module
    public void registerStudent(Student student) {
        // Check if student is already registered
        for (int i = 0; i < count; i++) {
            if (registeredStudents[i].getStudentID().equals(student.getStudentID())) {
                // Print error message and return
                System.out.println("Error: Cannot register student. Student is already registered in this module.\n");
                return;
            }
        }
        // Register student
        registeredStudents[count] = student;
        count++;
        Arrays.sort(registeredStudents, 0, this.count); // Sort the array of registered students
    }

    // Method to unregister a student from the module
    public void unregisterStudent(Student student) {
        // Find student in list of registered students
        for (int i = 0; i < registeredStudents.length; i++) {
            if (String.valueOf(registeredStudents[i]).equals(String.valueOf(student))) {
                registeredStudents[i] = null; // Set element to null
                count--; // Decrement count
                break;
            }
        }

        // Shift elements in array to fill gap
        int tempCount = 0;
        Student[] temp = new Student[registeredStudents.length];
        for (int i = 0; i < registeredStudents.length; i++) {
            if (registeredStudents[i] != null) {
                temp[tempCount] = registeredStudents[i];
                tempCount++;
            }
        }
        for (int i = 0; i < registeredStudents.length; i++) {
            registeredStudents[i] = temp[i];
        }
    }

    // Method to return a string representation of the module and its registered students
    @Override
    public String toString() {
        // Initialize string builder
        StringBuilder module = new StringBuilder("Module: " + moduleCode + "\nRegistered Students:\n");
        // Append each registered student to the string builder
        for (Student registeredStudent : registeredStudents) {
            if (registeredStudent == null) {
                continue; // Skip null elements
            } else {
                module.append("  ").append(registeredStudent.getStudentID()).append("\n");
            }
        }
        return module.toString();
    }
}
