package Portfolio.Practical_11;

public class Student implements Comparable<Student> {
    // Field
    private String studentID; // The ID of the student

    // Constructor
    public Student(String studentID) {
        this.studentID = studentID;
    }
    // Method
    // Return a string representation of the student
    @Override
    public String toString() {
        return " studentID='" + studentID + '\'';
    }

    // Method
    // Return the ID of the student
    public String getStudentID() {
        return studentID;
    }

    // Method
    // Compare the ID of this student to the ID of another student
    // Return a negative number if this student's ID is "less" than the other student's ID
    // Return 0 if the IDs are equal
    // Return a positive number if this student's ID is "greater" than the other student's ID
    @Override
    public int compareTo(Student other) {
        return this.studentID.compareTo(other.studentID);
    }
}