import java.util.ArrayList;
import java.util.Scanner;
public class StudentService {
    Scanner sc= new Scanner(System.in);
    ArrayList<Student> students=new ArrayList<>();
     
    void addStudent(){
        System.out.println("Enter Student Details ---------");
        System.out.print("name : ");
        String name= sc.nextLine();
        System.out.println();

        System.out.print("id : ");
        int id=sc.nextInt();
        System.out.println();

        System.out.print("age : ");
        int age=sc.nextInt();
        System.out.println();

        System.out.print("course : ");
        String course=sc.nextLine();
        System.out.println();

        System.out.print("marks : ");
        Double marks=sc.nextDouble();

        students.add(new Student(name, id, age, course, marks));


         

    }
}
