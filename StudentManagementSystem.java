import java.util.Scanner;
public class StudentManagementSystem {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        StudentService s1= new StudentService();

        System.out.println("****************STUDENT MANAGEMENT SYSTEM*************************");

      System.out.println("Students Operation are======");
      System.out.println("Add Student");
      System.out.println("View Student"); 
      System.out.println("Remove Student");
      System.out.println("search Student");
      System.out.println("Update Student");
      System.out.println();
  

    System.out.println("Enter 1 for add student");
    System.out.println("Enter 2 for view student");
    System.out.println("Enter 3 for remove student");
    System.out.println("Enter 4 for search student");
    System.out.println("Enter 5 for update");
    System.out.println("Enter 6 for exit");
    System.out.println();
    

    

    while(true){
        System.out.println("Enter the choice");
         int n =sc.nextInt();
    switch(n){

        case 1:
            s1.addStudent();
            break;

         case 2:
            s1.showStudent();
            break;
          
            case 3:
                s1.removeStudent();
                break;

             case 4:
                s1.searchStudent();
                break;  
                
             case 5:
                s1.updateStudent();
                break;   
         
         case 6:
            return ;

            


            default :  {
                System.out.println(" hello ");
            } 

    }

}

       


       
    }
     
}
