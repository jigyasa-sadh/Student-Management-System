//package Student-Management-System;

import java.util.ArrayList;

public class Student {
private String name;
private int id;
private int age;
private ArrayList<String> courses;
private ArrayList<Double> marks;

// constructor
Student(String name ,int id,int age, ArrayList<String> courses,  ArrayList<Double>marks){
    this.name=name;
    this.id=id;
    this.age=age;
  this. courses=courses;
    this.marks=marks;

}

//setter method
       public void setName(String name){
        this.name=name;

        }

       public void setId(int id){
        this.id=id;

        }
        public void setAge(int age){
        this.age=age;

        }
      public void setCourse(ArrayList<String>courses){
        this.courses=courses;

        }
        public void setMarks( ArrayList<Double> marks){
        this.marks=marks;

        }

//getter method
       public  String getName(){
            return name;
        }

        public int getId(){
            return id;
        }
        public int getAge(){
            return age;
        }
      public ArrayList<String> getCourse(){
        
            return courses;
        }

            
        
       
       ArrayList<Double> getMarks(){
            return marks;
        }


   
}
