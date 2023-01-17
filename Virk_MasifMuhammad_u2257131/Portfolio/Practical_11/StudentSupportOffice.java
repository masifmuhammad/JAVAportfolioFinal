package Portfolio.Practical_11;

public class StudentSupportOffice {
    public static void main(String[] args) {
        // Create student objects
        Student s1 = new Student("U0000001");
        Student s2 = new Student("U0000002");
        Student s3 = new Student("U0000003");
        Student s4 = new Student("U0000004");
        Student s5 = new Student("U0000005");

        // Create module objects
        Module cis2206 = new Module("CIS2206");
        Module cis2360 = new Module("CIS2360");
        Module cis2205 = new Module("CIS2205");

        // Register students in modules
        cis2206.registerStudent(s1);
        cis2206.registerStudent(s5);

        cis2360.registerStudent(s1);
        cis2360.registerStudent(s3);
        cis2360.registerStudent(s4);

        cis2205.registerStudent(s2);
        cis2205.registerStudent(s4);
        cis2205.registerStudent(s5);

        // Unregister and re-register students in modules
        cis2206.unregisterStudent(s5);
        cis2206.registerStudent(s3);
        cis2206.registerStudent(s4);

        cis2360.registerStudent(s2);
        cis2360.registerStudent(s5);

        cis2205.unregisterStudent(s2);
        cis2205.unregisterStudent(s5);
        cis2205.registerStudent(s1);
        cis2205.registerStudent(s3);
        cis2205.registerStudent(s3);

        // Print list of registered students for each module
        System.out.println("  " + cis2205);
        System.out.println("  " + cis2360);
        System.out.println("  " + cis2206);
    }
}
