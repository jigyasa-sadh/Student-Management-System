import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StudentService {
    Scanner sc = new Scanner(System.in);
    ArrayList<Student> students = new ArrayList<>();
    
// add() method-------------------------------
       void addStudent(){
        System.out.println("Enter Student Details ---------");

    // add name
           String name;
              while(true){
                System.out.print("name : ");
                name = sc.nextLine();
                
                if(!name.trim().isEmpty()){
                    break;
                }
                System.out.println("name can not be empty------------");
              }  
                
    // add id
                int id;
              while(true){
                    try{
                        while(true){
                            System.out.print("id : ");
                            id = sc.nextInt();

                            boolean exit = false;
                            for(Student s: students){
                                 if(s.getId() == id){
                                    exit = true;
                                 }
                            }

                            if(exit){
                                System.out.println("input id is already registered .. Please enter another id ----------");
                            } else {
                                break;
                            }
                        }
                    break;
                    } catch(InputMismatchException e){
                            System.out.println("invalid input ! please enter the valid input");
                            sc.nextLine();
                    }
                }

    // add age
       int age;
            while(true){
                try{
                    System.out.print("age : ");
                    age = sc.nextInt();
                    break;
                } catch(InputMismatchException e){
                    System.out.println("invalid input ! please enter the valid input");
                    sc.nextLine();
                }
            }
                
    // add course and marks  
        ArrayList<String> courses = new ArrayList<>();
        ArrayList<Double> marks = new ArrayList<>();
     
        System.out.println("Enter the no of course to be added");
        int n = sc.nextInt();
        sc.nextLine();

        for(int i = 1; i <= n; i++){
            // add course
            while(true){
                System.out.print("course " + i + " :");
                String c = sc.nextLine();
                 
                if(!c.trim().isEmpty()){
                 courses.add(c);
                 break;
                }
                System.out.println("course can not be empty");
            }

            // add marks
            while(true){
                try{
                    System.out.print("marks : ");
                    double m = sc.nextDouble();

                    if(m < 0 || m > 100){
                        System.out.println("Enter marks between 0 and 100");
                         continue;
                    }

                    marks.add(m);
                    sc.nextLine();
                    break;
                } catch(InputMismatchException e){
                    System.out.println("invalid input ! please enter the valid input");
                    sc.nextLine();
                }
            }  
        }

        sc.nextLine();
        Student s1 = new Student(name, id, age, courses, marks);
        updateStudentResult(s1);
        students.add(s1);
        System.out.println("successfully added-----\n");
    }

// show() method (Enhanced with Stream API option) ----------------------------- 
    void showStudent(){
       if(students.isEmpty()){
        System.out.println("student List is empty--------------");
        return;
       }

       // Stream API ka use karke percentage ke basis par high to low sort karke dikhana (Merit List style)
       List<Student> sortedStudents = students.stream()
           .sorted((s1, s2) -> Double.compare(s2.getPercentage(), s1.getPercentage()))
           .collect(Collectors.toList());

       System.out.println("============ STUDENTS DETAILS (SORTED BY MERIT) ====================");

       for(Student s: sortedStudents){
        System.out.println("Name is : " + s.getName());
        System.out.println("Id is : " + s.getId());
        System.out.println("Age is : "+ s.getAge());
        System.out.print("courses :");

        System.out.print("[");
        for(String p: s.getCourse()){
            System.out.print(p + " ");
        }
        System.out.print("]");
        System.out.println();

        System.out.print("marks : ");
        System.out.print("[");
        for(Double m: s.getMarks()){
            System.out.print(m + " ");
        }
        System.out.print("]");
        System.out.println();

        System.out.println("Percentage is : " + s.getPercentage());
        System.out.println("Grade is : " + s.getGrade());
        System.out.println("Result is : " + s.getResult());
        System.out.println("\n---------------------------------------");
       }
    }

// remove() method---------------------------
    void removeStudent(){
        if(students.isEmpty()){
                System.out.println("student list is empty-------------");
                return;
        }
        
        System.out.println("Enter essential detail to remove the student -----------");
        System.out.print("id : ");
        int id = sc.nextInt();
        
       for(Student s: students){
        if(s.getId() == id){
            System.out.println("Are you sure ...? yes or no");
            sc.nextLine();
            String confirmation = sc.nextLine();

            if(confirmation.equalsIgnoreCase("yes")){
                if(students.remove(s)){
                    System.out.println(s.getName() + " is successfully removed **********");
                    return;
                }
            } else {
                System.out.println("student is not removed");
                return;
            }
          }
        }
        System.out.println("student not found ");
    }

// search() student (Enhanced with Stream API)--------------------
    void searchStudent(){
        if(students.isEmpty()){
                System.out.println("student list is empty-------------");
                return;
        }
        
        System.out.println("Enter the student Id ");
        int id = sc.nextInt();

        // Stream API ka use karke student find karna
        boolean found = students.stream().anyMatch(s -> s.getId() == id);

        if(found){
            System.out.println("Student is found");
        } else {
            System.out.println("student not found");
        }
    }

// update() method-------------------------
  void updateStudent(){
        if(students.isEmpty()){
                System.out.println("student list is empty-------------");
                return;
        }
            
        System.out.println("Enter the student id to be updated ");
        int id = sc.nextInt();
        
        boolean studentFound = false;
        for(Student s: students){
            if(id == s.getId()){
                studentFound = true;
                System.out.println("current courses and their corresponding marks regarding entered id----------");
                for(int i = 0; i < s.getCourse().size(); i++){
                    System.out.println("Course : "+ s.getCourse().get(i) + "  " + "Marks : "+ s.getMarks().get(i));
                }
                
                System.out.println("Enter the course name whose marks you want to update ");
                sc.nextLine();
                String sub = sc.nextLine();

                boolean found = false;
                for (int i = 0; i < s.getCourse().size(); i++) {
                    if (s.getCourse().get(i).equalsIgnoreCase(sub)) {
                        System.out.println("Enter new marks:");
                        double m = sc.nextDouble();

                        s.getMarks().set(i, m);
                        updateStudentResult(s);
                        System.out.println("Marks updated successfully.");
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println(sub + " doesn't exist.");
                }
                return;
            }      
        }
        if(!studentFound){
            System.out.println("Student not found");
        }
  }

// update student result fun----------------
    private void updateStudentResult(Student s1) {
        double percentage = calculatePercentage(s1.getMarks());
        s1.setPercentage(percentage);
        s1.setGrade(calculateGrade(percentage));
        s1.setResult(calculateResult(percentage));
    }                     

// cal percentage--------------------
    public double calculatePercentage(ArrayList<Double> marks) {
        double total = 0;
        for (double mark : marks) {
            total += mark;
        }
        return total / marks.size();
    }

// cal grade fun-----------------------------------------------------------
    public String calculateGrade(double percentage) {
        if (percentage >= 90) return "A+";
        else if (percentage >= 80) return "A";
        else if (percentage >= 70) return "B";
        else if (percentage >= 60) return "C";
        else if (percentage >= 50) return "D";
        else if (percentage >= 40) return "E";
        else return "F";
   }  
           
// cal result fun---------------------------------------------------           
    public String calculateResult(double percentage) {
        if (percentage >= 40) {
            return "PASS";
        }
        return "FAIL";
    }
}