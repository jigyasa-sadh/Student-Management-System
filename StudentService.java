import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class StudentService {
    Scanner sc= new Scanner(System.in);
    ArrayList<Student> students=new ArrayList<>();
    ArrayList<String> courses=new ArrayList<>();
    ArrayList<Double> marks=new ArrayList<>();
     
//add() method-------------------------------
    void addStudent(){
        System.out.println("Enter Student Details ---------");

    // add name
          
              String name;

              while(true){
                
                System.out.print("name : ");
                name= sc.nextLine();
                
                if(!name.trim().isEmpty()){
                    break;
                }
                System.out.println("name can not be empty------------");
                    
              }  
                
                
    // add id
                int id;

                
                 while(true)
                    {
                    try{


                        while(true){
                    // input id------
                    System.out.print("id : ");
                    id=sc.nextInt();

                    //checks is the input id is already registeres or not
                   
                      boolean exit=false;
                       for(Student s: students){
                             if(s.getId()==id){
                                exit=true;
                             }
                       }
                       if(exit){
                        System.out.println("input id is already registered .. Plesw enter another id ----------");
                            
                       }
                       else{
                        break;
                       }
                    }

                    


                       
                    break;
                    }catch(InputMismatchException e){
                            System.out.println("invalid input ! please enter the valid input");
                            sc.nextLine();
                            
                        }
                }



      
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
                
    // add course and marks  
    
     ArrayList<String> courses=new ArrayList<>();
         ArrayList<Double> marks=new ArrayList<>();
                    System.out.println("Enter the no of course to be added");
                    int n=sc.nextInt();
                    sc.nextLine();
                for(int i=1;i<=n;i++){
                        // add course
                 while(true)
                    {
                     
                    //sc.nextLine();
                    System.out.print("course " + i +" :");
                    String c=sc.nextLine();
                    
                    if(!c.trim().isEmpty()){
                     courses.add(c);
                     break;
                    }
                    System.out.println("course can not be empty");

                    }

                    //add marks
                    while(true)
                        {
                            try{
                            System.out.print("marks : " );
                            double m=sc.nextDouble();
                            if(m<0 || m>100){
                                System.out.println("Enter marks between 0 and 100");
                                 continue;
                            }
                            marks.add(m);
                            sc.nextLine();
                           
                            break;
                            } catch(InputMismatchException e){
                                System.out.println("invalid input ! please enter the valid input");
                               //sc.nextLine();
                            }


}                  }
                
            
                     sc.nextLine();
                     // add th object od student class in students arraylist
                    students.add(new Student(name, id, age,courses , marks));
                    System.out.println("successfully added-----");
                    System.out.println();

            }

// add method completed-----------------------------------------------------------            

// show() method ----------------------------- 
    void showStudent(){
       if(students.isEmpty()){
        System.out.println("student List is empty--------------");
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

//show mathod completed-----------------------------------------------------------

//remove() method---------------------------
    void removeStudent(){

        if(students.isEmpty()){
                System.out.println("student list is empty-------------");
                return;
          }
        
          
        System.out.println("Enter essential detail to remove the student -----------");
        System.out.print("id : ");
        int id=sc.nextInt();
        
          
       
        for(Student s: students){
           
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

//remove method completed--------------------------------------------------

//search() student--------------------
    void searchStudent(){

        if(students.isEmpty()){
                System.out.println("student list is empty-------------");
                return;
          }
        
        System.out.println("Enter thr student Id ");
        int id=sc.nextInt();
        for(Student s : students){
            if(s.getId()==id){
              System.out.println("Student is found");
        return;
                
            }
           


        }
        System.out.println("student not found");
    }

    
//search student method completed---------------------------------------------------------------------

//update() method-------------------------
  void updateStudent(){
     
            //check  is list empty or not ------------------
                    if(students.isEmpty()){
                            System.out.println("student list is empty-------------");
                            return;
                    }
                    
                
            // enter the student id whose marks to be updated--------------
                System.out.println("Enter the student  id to be updated ");
                int id=sc.nextInt();
                
                // search a student in in list------------    
                for(Student s: students){
                    //int id=sc.nextInt(); 
                    if(id==s.getId()){


                            // print all registere courses and their marks----------------
                            System.out.println("current courses and their corresponding marks regarding entered id----------");
                        for(int i=0;i< s.getCourse().size();i++){
                            System.out.println("Course : "+ s.getCourse().get(i) + "  " + "Marks : "+ s.getMarks().get(i));

                        }
                        
                


                    // input sub name for updation
                    System.out.println("Enter the course name whose marks you want to update ");
                    sc.nextLine();
                    String sub=sc.nextLine();


                    // search a input  sub into the course list of entered id  
                    for(int i=0;i<s.getCourse().size();i++){
                        if(s.getCourse().get(i).equalsIgnoreCase(sub)){
                            System.out.println("enter a new marks");
                            double m=sc.nextDouble();
                            s.getMarks().set(i, m);
                            System.out.println(" marksu[dated successfully ");
                            return;
                        }
                           
                        System.out.println(sub +" doesn't exist ");
                        return;

                    }


                        }
                    }      
                            System.out.println("Student not found");

                        
                        
                     }
    }















