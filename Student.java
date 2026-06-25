//package Student-Management-System;

public class Student {
private String name;
private int id;
private int age;
private String course;
private double marks;

// constructor
Student(String name ,int id,int age,String course,double marks){
    this.name=name;
    this.id=id;
    this.age=age;
    this.course=course;
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
        void setCourse(String course){
        this.course=course;

        }
        void setMarks(Double marks){
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
        String getCource(){
            return course;
        }
       
        Double getMarks(){
            return marks;
        }

    // print detail method

    void printDetail(){
        System.out.println("Name is : " + this.name);
        System.out.println("Id is : " + this.id);
        System.out.println("Age is : "+this.age);
        System.out.println("Course is : "+ this.course);
        System.out.println("Marks is : "+ this.marks);
    }
    
}
