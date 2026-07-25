import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class StudentService {
    Scanner sc = new Scanner(System.in);
    // HashMap for O(1) lookups by ID
    Map<Integer, Student> studentMap = new HashMap<>();
    private final String FILE_NAME = "students_data.txt";

    public StudentService() {
        loadFromFile(); // Program start hote hi file se data load karega
    }

    // Add Student
    void addStudent() {
        System.out.println("Enter Student Details ---------");

        String name;
        while (true) {
            System.out.print("name : ");
            name = sc.nextLine();
            if (!name.trim().isEmpty()) break;
            System.out.println("name can not be empty------------");
        }

        int id;
        while (true) {
            try {
                System.out.print("id : ");
                id = sc.nextInt();
                if (studentMap.containsKey(id)) {
                    System.out.println("input id is already registered .. Please enter another id ----------");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("invalid input ! please enter the valid input");
                sc.nextLine();
            }
        }

        int age;
        while (true) {
            try {
                System.out.print("age : ");
                age = sc.nextInt();
                if (age <= 0 || age > 100) {
                    throw new InvalidAgeException("Age must be between 1 and 100.");
                }
                break;
            } catch (InvalidAgeException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("invalid input ! please enter the valid input");
                sc.nextLine();
            }
        }

        ArrayList<String> courses = new ArrayList<>();
        ArrayList<Double> marks = new ArrayList<>();

        System.out.println("Enter the no of course to be added");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= n; i++) {
            while (true) {
                System.out.print("course " + i + " :");
                String c = sc.nextLine();
                if (!c.trim().isEmpty()) {
                    courses.add(c);
                    break;
                }
                System.out.println("course can not be empty");
            }

            while (true) {
                try {
                    System.out.print("marks : ");
                    double m = sc.nextDouble();
                    if (m < 0 || m > 100) {
                        System.out.println("Enter marks between 0 and 100");
                        continue;
                    }
                    marks.add(m);
                    sc.nextLine();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("invalid input ! please enter the valid input");
                    sc.nextLine();
                }
            }
        }

        sc.nextLine();
        Student s1 = new Student(name, id, age, courses, marks);
        updateStudentResult(s1);
        
        studentMap.put(id, s1);
        saveToFile(); // Data save to file
        System.out.println("successfully added and saved to file-----\n");
    }

    // Show Students (Sorted by Merit using Streams)
    void showStudent() {
        if (studentMap.isEmpty()) {
            System.out.println("student List is empty--------------");
            return;
        }

        List<Student> sortedStudents = studentMap.values().stream()
                .sorted((s1, s2) -> Double.compare(s2.getPercentage(), s1.getPercentage()))
                .collect(Collectors.toList());

        System.out.println("============ STUDENTS DETAILS (MERIT LIST) ====================");
        for (Student s : sortedStudents) {
            printStudentDetails(s);
        }
    }

    // Remove Student
    void removeStudent() {
        if (studentMap.isEmpty()) {
            System.out.println("student list is empty-------------");
            return;
        }

        System.out.print("Enter id to remove: ");
        int id = sc.nextInt();

        try {
            Student s = studentMap.get(id);
            if (s == null) {
                throw new StudentNotFoundException("Student with ID " + id + " not found!");
            }

            System.out.println("Are you sure ...? yes or no");
            sc.nextLine();
            String confirmation = sc.nextLine();

            if (confirmation.equalsIgnoreCase("yes")) {
                studentMap.remove(id);
                saveToFile();
                System.out.println(s.getName() + " is successfully removed **********");
            } else {
                System.out.println("student is not removed");
            }
        } catch (StudentNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    // Search Student (By ID or Name)
    void searchStudent() {
        if (studentMap.isEmpty()) {
            System.out.println("student list is empty-------------");
            return;
        }

        System.out.println("1. Search by ID\n2. Search by Name");
        int choice = sc.nextInt();
        sc.nextLine();

        if (choice == 1) {
            System.out.print("Enter Student ID: ");
            int id = sc.nextInt();
            Student s = studentMap.get(id);
            if (s != null) {
                System.out.println("Student Found!");
                printStudentDetails(s);
            } else {
                System.out.println("Student not found.");
            }
        } else if (choice == 2) {
            System.out.print("Enter Student Name: ");
            String searchName = sc.nextLine();
            List<Student> results = studentMap.values().stream()
                    .filter(s -> s.getName().equalsIgnoreCase(searchName))
                    .collect(Collectors.toList());

            if (results.isEmpty()) {
                System.out.println("No students found with name: " + searchName);
            } else {
                System.out.println("Found " + results.size() + " student(s):");
                for (Student s : results) {
                    printStudentDetails(s);
                }
            }
        }
    }

    // Update Student Marks
    void updateStudent() {
        if (studentMap.isEmpty()) {
            System.out.println("student list is empty-------------");
            return;
        }

        System.out.print("Enter student id to be updated: ");
        int id = sc.nextInt();

        Student s = studentMap.get(id);
        if (s == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.println("Current courses and marks:");
        for (int i = 0; i < s.getCourse().size(); i++) {
            System.out.println("Course : " + s.getCourse().get(i) + "  Marks : " + s.getMarks().get(i));
        }

        System.out.println("Enter the course name whose marks you want to update:");
        sc.nextLine();
        String sub = sc.nextLine();

        boolean found = false;
        for (int i = 0; i < s.getCourse().size(); i++) {
            if (s.getCourse().get(i).equalsIgnoreCase(sub)) {
                System.out.println("Enter new marks:");
                double m = sc.nextDouble();
                s.getMarks().set(i, m);
                updateStudentResult(s);
                saveToFile();
                System.out.println("Marks updated successfully.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println(sub + " doesn't exist.");
        }
    }

    // Helper method to print student details
    private void printStudentDetails(Student s) {
        System.out.println("Name is : " + s.getName());
        System.out.println("Id is : " + s.getId());
        System.out.println("Age is : " + s.getAge());
        System.out.println("Courses & Marks: " + s.getCourse() + " | " + s.getMarks());
        System.out.println("Percentage: " + s.getPercentage() + "% | Grade: " + s.getGrade() + " | Result: " + s.getResult());
        System.out.println("---------------------------------------");
    }

    private void updateStudentResult(Student s1) {
        double percentage = calculatePercentage(s1.getMarks());
        s1.setPercentage(percentage);
        s1.setGrade(calculateGrade(percentage));
        s1.setResult(calculateResult(percentage));
    }

    public double calculatePercentage(ArrayList<Double> marks) {
        double total = 0;
        for (double mark : marks) total += mark;
        return total / marks.size();
    }

    public String calculateGrade(double percentage) {
        if (percentage >= 90) return "A+";
        else if (percentage >= 80) return "A";
        else if (percentage >= 70) return "B";
        else if (percentage >= 60) return "C";
        else if (percentage >= 50) return "D";
        else if (percentage >= 40) return "E";
        else return "F";
    }

    public String calculateResult(double percentage) {
        return percentage >= 40 ? "PASS" : "FAIL";
    }

    // File Handling: Save Data
    private void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(studentMap);
        } catch (IOException e) {
            System.out.println("Error saving data to file: " + e.getMessage());
        }
    }

    // File Handling: Load Data
    @SuppressWarnings("unchecked")
    private void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            studentMap = (Map<Integer, Student>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading data from file.");
        }
    }
}