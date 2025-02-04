package kz.aitu.rest2423.restpro.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kz.aitu.rest2423.restpro.DBConnection.DBConnectionTeacher;
import kz.aitu.rest2423.restpro.Entities.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

@RestController
public class TeacherController {

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/get_teachers")
    public String getTeachers() {
        DBConnectionTeacher db = new DBConnectionTeacher();
        Connection con = null;
        ArrayList<Teacher> teachers = new ArrayList<>();

        try {
            con = db.connect();
            teachers = db.getTeachers(con);
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        } finally {
            try { db.closeConnection(con); }
            catch (SQLException e) { System.out.println("Error: " + e.toString()); }
        }

        try {
            return objectMapper.writeValueAsString(teachers);
        } catch (JsonProcessingException e) {
            return "Error: " + e.toString();
        }
    }

    @GetMapping("/get_teacher_by_id")
    public String getTeacherById(@RequestParam int id) {
        DBConnectionTeacher db = new DBConnectionTeacher();
        Connection con = null;
        Teacher teacher = new Teacher();

        try {
            con = db.connect();
            teacher = db.getTeacherById(con, id);
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        } finally {
            try { db.closeConnection(con); }
            catch (SQLException e) { System.out.println("Error: " + e.toString()); }
        }

        try {
            return objectMapper.writeValueAsString(teacher);
        } catch (JsonProcessingException e) {
            return "Error: " + e.toString();
        }
    }

    @GetMapping("/get_teacher_by_name")
    public String getTeacherByName(@RequestParam String name) {
        DBConnectionTeacher db = new DBConnectionTeacher();
        Connection con = null;
        ArrayList<Teacher> teachers = new ArrayList<>();

        try {
            con = db.connect();
            teachers = db.getTeachersByName(con, name);
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        } finally {
            try { db.closeConnection(con); }
            catch (SQLException e) { System.out.println("Error: " + e.toString()); }
        }

        try {
            return objectMapper.writeValueAsString(teachers);
        } catch (JsonProcessingException e) {
            return "Error: " + e.toString();
        }
    }

    @PostMapping("/add_teacher")
    public String addTeacher(@RequestParam int id, @RequestParam String name, @RequestParam int age, @RequestParam String department, @RequestParam String subject) {
        DBConnectionTeacher db = new DBConnectionTeacher();
        Connection con = null;
        Teacher teacher = new Teacher(id, name, age, department, subject);

        try {
            con = db.connect();
            db.addTeacher(con, teacher);
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        } finally {
            try { db.closeConnection(con); }
            catch (SQLException e) { System.out.println("Error: " + e.toString()); }
        }

        try {
            return objectMapper.writeValueAsString(teacher);
        } catch (JsonProcessingException e) {
            return "Error: " + e.toString();
        }
    }

    @PostMapping("/update_teacher")
    public String updateTeacher(@RequestParam int id, @RequestParam String name, @RequestParam int age, @RequestParam String department, @RequestParam String subject) {
        DBConnectionTeacher db = new DBConnectionTeacher();
        Connection con = null;
        Teacher teacher = new Teacher(id, name, age, department, subject);

        try {
            con = db.connect();
            teacher = db.updateTeacher(con, teacher, id);
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        } finally {
            try { db.closeConnection(con); }
            catch (SQLException e) { System.out.println("Error: " + e.toString()); }
        }

        try {
            return objectMapper.writeValueAsString(teacher);
        } catch (JsonProcessingException e) {
            return "Error: " + e.toString();
        }
    }

    @PostMapping("/delete_teacher")
    public String deleteTeacher(@RequestParam int id) {
        DBConnectionTeacher db = new DBConnectionTeacher();
        Connection con = null;
        Teacher teacher = null;

        try {
            con = db.connect();
            teacher = db.getTeacherById(con, id);
            db.deleteTeacher(con, teacher);
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        } finally {
            try { db.closeConnection(con); }
            catch (SQLException e) { System.out.println("Error: " + e.toString()); }
        }

        try {
            return objectMapper.writeValueAsString(teacher);
        } catch (JsonProcessingException e) {
            return "Error: " + e.toString();
        }
    }
}
