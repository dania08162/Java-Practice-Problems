import java.io.*; //imports for file
import java.util.Scanner;
class Student {
    private String studentID; //stores id
    private String studentName; //stores name
    public Student(String studentID, String studentName) { //construtor
        this.studentID = studentID; 
        this.studentName = studentName;
    }
    public String getStudentID() { //getter method
        return studentID;
    }
    public String getStudentName() { //getter method
        return studentName;
    }
}
public class studentManagementSystem { 
    private static final String file = "students.txt"; //file name for storage
    public static void addStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Student ID: ");
        String studentID = sc.nextLine();
        System.out.print("Enter Student Name: ");
        String studentName = sc.nextLine();
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(file, true)); //opens file to append. true --> do not overwrite
            pw.println(studentID + "," + studentName); //format
            pw.close(); //closes file
            System.out.println("Student added successfully.");
        } catch (IOException e) { //if there is an error
            System.out.println("Error writing file: " + e.getMessage()); //prints the error
        }
    }
    public static void displayStudents() {
        File f = new File(file); //makes a file object for students.txt
        if (!f.exists()) { //runs if the file doesn't exist
            System.out.println("No records found.");
            return;
        }
        try {
            Scanner fileInput = new Scanner(f);
            System.out.println("\nStudent Records:");
            System.out.println("StudentID     Name");
            while (fileInput.hasNextLine()) { //loops through each line of the file
                String line = fileInput.nextLine().trim(); //reads a line from the file
                if (!line.isEmpty()){ //skips the empty ones
                    String[] parts = line.split(",");
                    System.out.println(parts[0] + "\t" + parts[1]); //formatted output
                }
            }
            fileInput.close(); //closes the reader
        } catch (FileNotFoundException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
    public static void deleteStudent() { 
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Student ID to delete: ");
        String idToDelete = sc.nextLine();
        File inputFile = new File(file);
        File otherFile = new File("other.txt"); //makes a new file
        boolean found = false; //if student exists
        try {
            BufferedReader br = new BufferedReader(new FileReader(inputFile)); //reads each line of the file
            PrintWriter pw = new PrintWriter(new FileWriter(otherFile)); //writes in the other file
            String line;
            while ((line = br.readLine()) != null) { //reads until the file is done
                String[] parts = line.split(",");
                if (parts[0].equals(idToDelete)) { //if the ID matches, don't write it
                    found = true; //don't delete it
                    continue;
                }
                pw.println(line); //write the other students in the other file
            }
            br.close();
            pw.close();
            inputFile.delete();
            otherFile.renameTo(inputFile); //replaces old file
            if (found) { //if the student is found
                System.out.println("Student deleted successfully.");
            } else {
                System.out.println("Student ID not found.");
            }
        } catch (IOException e) {
            System.out.println("Error deleting file: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Student Record Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Delete Student");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayStudents();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Enter 1–4 only.");
            }
        } while (choice != 4);
    }
}
