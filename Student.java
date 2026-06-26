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
        void setName(String name){
        this.name=name;

        }

        void setId(int id){
        this.id=id;

        }
        void setAge(int age){
        this.age=age;

        }
      void setCourse(ArrayList<String>courses){
        this.courses=courses;

        }
        void setMarks( ArrayList<Double> marks){
        this.marks=marks;

        }

//getter method
        String getName(){
            return name;
        }

        int getId(){
            return id;
        }
        int getAge(){
            return age;
        }
       ArrayList<String> getCourse(){
        
            return courses;
        }

            
        
       
       ArrayList<Double> getMarks(){
            return marks;
        }

    // print detail method

   
}
