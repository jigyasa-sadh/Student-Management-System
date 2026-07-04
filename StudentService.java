import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class StudentService {
    Scanner sc= new Scanner(System.in);
    ArrayList<Student> students=new ArrayList<>();
    
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

                    //checks is the input id is already registered or not
                     boolean exit=false;
                       for(Student s: students){
                             if(s.getId()==id){
                                exit=true;
                             }
                       }

                       //if registered so enter agian-----------
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

                 //imput age------------   
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
     
        
                    
                   // input how many courses you want to add-------- 
                    System.out.println("Enter the no of course to be added");
                    int n=sc.nextInt();
                    sc.nextLine();

                    // loop for add  n courses-----------
                    for(int i=1;i<=n;i++){


                        // add course
                      while(true)
                    {
                     
                    //input course-----------
                    System.out.print("course " + i +" :");
                    String c=sc.nextLine();
                     
                    // check user enter a course or ramins empty----
                    if(!c.trim().isEmpty()){
                     courses.add(c);
                     break;
                    }

                    //if user does not etere any course show this message-----
                    System.out.println("course can not be empty");

                    }

                    //add marks
                    while(true)
                        {
                            try{
                                //input marks----
                            System.out.print("marks : " );
                            double m=sc.nextDouble();

                            //checks if user enter marks grater than 100 or less than 0 -----
                            if(m<0 || m>100){
                                System.out.println("Enter marks between 0 and 100");
                                 continue;
                            }

                            //if marks is valid so add marks--------
                            marks.add(m);
                            
                            sc.nextLine();
                           
                            break;
                            } catch(InputMismatchException e){
                                System.out.println("invalid input ! please enter the valid input");
                               //sc.nextLine();
                            }
            }  

          
           
}



                
            

           
       



                            
            
                     sc.nextLine();



                     // add th object of student class in students arraylist
                     Student s1=new Student(name, id, age,courses , marks);
                     updateStudentResult( s1);
                    students.add(s1);
                    System.out.println("successfully added-----");
                    System.out.println();

            }

// add method completed-----------------------------------------------------------            

// show() method ----------------------------- 
    void showStudent(){

        //check if the list is empty------------
       if(students.isEmpty()){
        System.out.println("student List is empty--------------");
        return;
       }

       //if list is not empty----------
       System.out.println("============students details are ====================");

       //print all students details-----
       for(Student s: students){
   
        System.out.println("Name is : " + s.getName());
        System.out.println("Id is : " + s.getId());
        System.out.println("Age is : "+ s.getAge());
        System.out.print("courses :");

        //print courses----------
        System.out.print("[");
        for(String p: s.getCourse()){
            System.out.print( p+" "  );

        }
        System.out.print("]");
        System.out.println();

        //print marks----------------
        System.out.print("marks : ");
        System.out.print("[");
        for(Double m: s.getMarks()){
            System.out.print( m + " ");

        }
        System.out.print("]");
        System.out.println();

        //print percentage-------------
          System.out.println("Percentage is : " + s.getPercentage());
          
        //print grade-------------
          System.out.println("Grade is : " + s.getGrade());

        //print result-------------
          System.out.println("Result is : " + s.getResult());
        
       System.out.println();
        System.out.println("---------------------------------------");
            }
            }

//show mathod completed-----------------------------------------------------------

//remove() method---------------------------
    void removeStudent(){
  
        //check if the list is empty------------
        if(students.isEmpty()){
                System.out.println("student list is empty-------------");
                return;
          }
        
          // input id to removed-----------
        System.out.println("Enter essential detail to remove the student -----------");
        System.out.print("id : ");
        int id=sc.nextInt();
        
         //search student in list for remove--------- 
       for(Student s: students){
           
        if(s.getId()==id){
           if( students.remove(s)){
            System.out.println(s.getName() +" is successfully removed **********");
            return;
           }
           
            System.out.println("student not found ");
            
            }
        }
    
    
}

//remove method completed--------------------------------------------------

//search() student--------------------
    void searchStudent(){
         
        //check if the list is empty------------
        if(students.isEmpty()){
                System.out.println("student list is empty-------------");
                return;
          }
        
          //input id
        System.out.println("Enter thr student Id ");
        int id=sc.nextInt();

        //check in list---
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

                //return;




                    }      
                            System.out.println("Student not found");

                        
                        
                     }
                    }
//updaete student result fun----------------
            private void updateStudentResult(Student s1) {
                double percentage = calculatePercentage(s1.getMarks());
                s1.setPercentage(percentage);
                s1.setGrade(calculateGrade(percentage));
                s1.setResult(calculateResult(percentage));
}                     


//cal percentage--------------------

            public double calculatePercentage(ArrayList<Double> marks) {

                double total = 0;

                for (double mark : marks) {
                    total += mark;
                }

                return total / marks.size();
                    }

// cal grade fun-----------------------------------------------------------
      public String calculateGrade(double percentage) {

                if (percentage >= 90) {
                    return "A+";
                } 
                else if (percentage >= 80) {
                    return "A";
                } 
                else if (percentage >= 70) {
                    return "B";
                } 
                else if (percentage >= 60) {
                    return "C";
                } 
                else if (percentage >= 50) {
                    return "D";
                } 
                else if (percentage >= 40) {
                    return "E";
                } 
                else {
                    return "F";
                } 
           }  
           
// cal result fun---------------------------------------------------           
       public String calculateResult(double percentage) {

    if (percentage >= 40) {
        return "PASS";
    }

    return "FAIL";
}








    }















