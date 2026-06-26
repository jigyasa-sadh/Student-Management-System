import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class StudentService {
    Scanner sc= new Scanner(System.in);
    ArrayList<Student> students=new ArrayList<>();
    
        ArrayList<String> courses=new ArrayList<>();
         ArrayList<Double> marks=new ArrayList<>();
     
//add() method
    void addStudent(){
        System.out.println("Enter Student Details ---------");

        // add name
        System.out.print("name : ");
        String name= sc.nextLine();
        
      
        // add id
        System.out.print("id : ");
        int id=sc.nextInt();
      
       // add age
       int age;
       while(true){
        try{
        System.out.print("age : ");
         age=sc.nextInt();
        break;
        }catch(InputMismatchException e){
            System.out.println("invalid input ! please enter the valid input");
            sc.nextLine();
        }
    }
        
       
        System.out.println("Enter the no of course to be added");
        int n=sc.nextInt();
        for(int i=1;i<=n;i++){
            sc.nextLine();
         // add course   
        System.out.print("course " + i +" :");
        String c=sc.nextLine();
        courses.add(c);
       

        //add marks
        System.out.print("marks : " );
        marks.add(sc.nextDouble());
    
}
    sc.nextLine();
        students.add(new Student(name, id, age,courses , marks));
        System.out.println("successfully added-----");

}

// show() mwthod  
    void showStudent(){
       if(students.isEmpty()){
        System.out.println(" student List is empty");
        return;
       }
        System.out.println("============students details are ====================");
       for(Student s: students){
   
        System.out.println("Name is : " + s.getName());
        System.out.println("Id is : " + s.getId());
        System.out.println("Age is : "+ s.getAge());
        System.out.print("courses :");
        System.out.print("[");
        for(String p: s.getCourse()){
            System.out.print( p+" "  );

        }
        System.out.print("]");
        System.out.println();
        System.out.print("marks : ");
        System.out.print("[");
        for(Double m: s.getMarks()){
            System.out.print( m + " ");

        }
        System.out.print("]");
        
       System.out.println();
        System.out.println("---------------------------------------");
}
}

//removw() method
    void removeStudent(){
        System.out.println("Enter essential detail to remove the student -----------");
        System.out.print("id : ");
        int id=sc.nextInt();

        for(Student s: students){
            if(students.isEmpty()){
                System.out.println("There is no student to be delete");
        }
        if(s.getId()==id){
           if( students.remove(s)){
            System.out.println(s.getName() +" is successfully removed **********");
           }
           else{
            System.out.println("student not found ");
            }
            }
        }
    }

//search() student
    void searchStudent(){
        
        System.out.println("Enter thr student Id ");
        int id=sc.nextInt();
        for(Student s : students){
            if(s.getId()==id){
              System.out.println(s.getName() +" is found");
        return;
                
            }
           


        }
        System.out.println("student not found");

    }


  //update() method
  void updateStudent(){
   
       System.out.println("Enter the student is id to be updated ");
       
       for(Student s: students){
        int id=sc.nextInt();
           if(id==s.getId()){
            int index=0;
                  for(String i : courses){
                    System.out.print("Enter new marks for "+ i + " " );
                    double m=sc.nextDouble();
                    marks.set(index, m);
                    index++;
                  }
                  System.out.println("marks are successfully updated");
                  return;
           }
           System.out.println("Student not found");

       }

       


  }














}
