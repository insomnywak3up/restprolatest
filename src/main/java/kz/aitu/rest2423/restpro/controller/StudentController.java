package kz.aitu.rest2423.restpro.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kz.aitu.rest2423.restpro.DBConnection.DBConnectionStudent;
import kz.aitu.rest2423.restpro.Entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.sql.*;
import java.util.ArrayList;

@RestController
public class StudentController {

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/get_students")
    public String getStudents() {
        DBConnectionStudent db = new DBConnectionStudent();
        Connection con = null;
        ArrayList<Student> students = new ArrayList<>();

        try {
            con = db.connect();
            students = db.getStudents(con);
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        } finally {
            try { db.closeConnection(con); }
            catch (SQLException e) { System.out.println("Error: " + e.toString()); }
        }

        try {
            return objectMapper.writeValueAsString(students);
        } catch (JsonProcessingException e) {
            return "Error: " + e.toString();
        }
    }

    @GetMapping("/get_student_by_id")
    public String getStudentById(@RequestParam int id) {
        DBConnectionStudent db = new DBConnectionStudent();
        Connection con = null;
        Student student = new Student();

        try {
            con = db.connect();
            student = db.getStudentById(con, id);
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        } finally {
            try { db.closeConnection(con); }
            catch (SQLException e) { System.out.println("Error: " + e.toString()); }
        }

        try {
            return objectMapper.writeValueAsString(student);
        } catch (JsonProcessingException e) {
            return "Error: " + e.toString();
        }
    }

@GetMapping("/get_student_by_name")
public String getStudentByName(@RequestParam String name) {
    DBConnectionStudent db = new DBConnectionStudent();
    Connection con = null;
//    Student student = new Student();
    ArrayList<Student> students = new ArrayList<>();

    try {
        con = db.connect();
        students = db.getStudentsByName(con, name);
    } catch (Exception e) {
        System.out.println("Error: " + e.toString());
    } finally {
        try {
            db.closeConnection(con);
        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
        }
    }
    try {
        return objectMapper.writeValueAsString(students);
    } catch (JsonProcessingException e) {
        return "Error: " + e.toString();
    }
}
    @PostMapping("/add_student")
    public String addStudent(@RequestParam int id, @RequestParam String name, @RequestParam int age, @RequestParam String school, @RequestParam int grade) {
        DBConnectionStudent db = new DBConnectionStudent();
        Connection con = null;
        Student student = new Student(id, name, age, school, grade);

        try {
            con = db.connect();
            db.addStudent(con, student);
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        } finally {
            try { db.closeConnection(con); }
            catch (SQLException e) { System.out.println("Error: " + e.toString()); }
        }

        try {
            return objectMapper.writeValueAsString(student);
        } catch (JsonProcessingException e) {
            return "Error: " + e.toString();
        }
    }

    @PostMapping("/update_student")
    public String updateStudent(@RequestParam int id, @RequestParam String name, @RequestParam int age, @RequestParam String school, @RequestParam int grade) {
        DBConnectionStudent db = new DBConnectionStudent();
        Connection con = null;
        Student student = new Student(id, name, age, school, grade);

        try {
            con = db.connect();
            student = db.updateStudent(con, student, id);
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        } finally {
            try { db.closeConnection(con); }
            catch (SQLException e) { System.out.println("Error: " + e.toString()); }
        }

        try {
            return objectMapper.writeValueAsString(student);
        } catch (JsonProcessingException e) {
            return "Error: " + e.toString();
        }
    }

    @PostMapping("/delete_student")
    public String deleteStudent(@RequestParam int id) {
        DBConnectionStudent db = new DBConnectionStudent();
        Connection con = null;
        Student student = null;

        try {
            con = db.connect();
            student = db.getStudentById(con, id);
            db.deleteStudent(con, student);
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        } finally {
            try { db.closeConnection(con); }
            catch (SQLException e) { System.out.println("Error: " + e.toString()); }
        }

        try {
            return objectMapper.writeValueAsString(student);
        } catch (JsonProcessingException e) {
            return "Error: " + e.toString();
        }
    }
}
