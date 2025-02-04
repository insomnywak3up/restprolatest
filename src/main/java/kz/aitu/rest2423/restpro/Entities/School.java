package kz.aitu.rest2423.restpro.Entities;

import java.util.ArrayList;

public class School {
    private String name;
    private ArrayList<Student> students;
    private ArrayList<Teacher> teachers;

    public School(String name) {
        this.name = name;
        this.students = new ArrayList<>();
        this.teachers = new ArrayList<>();
    }
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student " + student.getName() + " added.");
    }
public School() {}
    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
        System.out.println("Teacher " + teacher.getName() + " added.");
    }

    public void listStudents() {
        System.out.println("Students:");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void listTeachers() {
        System.out.println("Teachers:");
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }
    }

    public ArrayList<Student> filterStudentsByGrade(int grade) {
        ArrayList<Student> filtered = new ArrayList<>();
        for (Student student : students) {
            if (student.getGrade() == grade) {
                filtered.add(student);
            }
        }
        return filtered;
    }

    public void sortStudentsByName() {
        students.sort((s1, s2) -> s1.getName().compareTo(s2.getName()));
        System.out.println("Students sorted by name.");
    }

    public ArrayList<Teacher> searchTeachersBySubject(String subject) {
        ArrayList<Teacher> result = new ArrayList<>();
        for (Teacher teacher : teachers) {
            if (teacher.getSubject().equalsIgnoreCase(subject)) {
                result.add(teacher);
            }
        }
        return result;
    }
}
