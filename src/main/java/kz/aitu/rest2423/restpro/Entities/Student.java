package kz.aitu.rest2423.restpro.Entities;

import kz.aitu.rest2423.restpro.Abstract.Person;
import java.util.ArrayList;

public class Student extends Person {
    private String school;
    private int grade; // School grade (class)

    // Default constructor
    public Student() {}

    // Constructor with name and age and id
    public Student(int id, String name, int age, String school, int grade) {
        super(name, age, id);
        this.school = school;
        this.grade = grade;
    }

    // Getters and setters
    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        if (grade > 0) {
            this.grade = grade;
        } else {
            throw new IllegalArgumentException("Grade must be a positive number");
        }
    }

//    @Override
//    public int getId() {
//        return super.getId();
//    }
//    public void setId(int id) {
//        this.id = id;
//    }

    // Method to print a list of students
    public static void printStudents(ArrayList<Student> students) {
        System.out.println("List of students:");
        for (Student student : students) {
            System.out.println(student);
            System.out.println();
        }
    }

    // Method to print full information about a student
    public void printFullInfo() {
        System.out.println("Full info about student " + this.getName() + ":");
        System.out.println(this);
    }

    @Override
    public String toString() {
        return super.toString() + "\nSchool: " + school + "\nGrade: " + grade;
    }

    // Two students are equal if they study in the same school and grade
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        if (grade != student.grade) return false;
        return school.equals(student.school);
    }

    @Override
    public int hashCode() {
        return super.hashCode() + (school == null ? 0 : school.hashCode()) + grade;
    }
}
