package kz.aitu.rest2423.restpro.DBConnection;

import kz.aitu.rest2423.restpro.Entities.Student;
import java.util.ArrayList;
import java.sql.*;

public class DBConnectionStudent extends DBConnection {

    // Method to get all students from the database
    public ArrayList<Student> getStudents(Connection con) throws SQLException {
        String query = "SELECT * FROM public.students";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        ArrayList<Student> students = new ArrayList<>();

        while (rs.next()) {
            Student student = new Student();
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setAge(rs.getInt("age"));
            student.setSchool(rs.getString("school"));
            student.setGrade(rs.getInt("grade"));
            students.add(student);
        }

        st.close();
        return students;
    }

    // Method to get a student by ID
    public Student getStudentById(Connection con, int id) throws SQLException {
        String query = "SELECT * FROM public.students WHERE id = ?";
        PreparedStatement st = con.prepareStatement(query);
        st.setInt(1, id);
        ResultSet rs = st.executeQuery();
        Student student = new Student();

        while (rs.next()) {
            student.setId(id);
            student.setName(rs.getString("name"));
            student.setAge(rs.getInt("age"));
            student.setSchool(rs.getString("school"));
            student.setGrade(rs.getInt("grade"));
        }

        st.close();
        return student;
    }

    // Method to get students by name
    public ArrayList<Student> getStudentsByName(Connection con, String name) throws SQLException {
        String query = "SELECT * FROM public.students WHERE name = ?";
        PreparedStatement st = con.prepareStatement(query);
        st.setString(1, name);
        ResultSet rs = st.executeQuery();
        ArrayList<Student> students = new ArrayList<>();

        while (rs.next()) {
            Student student = new Student();
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setAge(rs.getInt("age"));
            student.setSchool(rs.getString("school"));
            student.setGrade(rs.getInt("grade"));
            students.add(student);
        }

        st.close();
        return students;
    }

    // Method to add a new student
    public Student addStudent(Connection con, Student student) throws SQLException {
        String query = "INSERT INTO public.students (id, name, age, school, grade) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement st = con.prepareStatement(query);
        st.setInt(1, student.getId());
        st.setString(2, student.getName());
        st.setInt(3, student.getAge());
        st.setString(4, student.getSchool());
        st.setInt(5, student.getGrade());

        int success = st.executeUpdate();
        st.close();
        if (success > 0) {
            System.out.println("Student with name " + student.getName() + " created successfully.");
            return student;
        }
        return null;
    }

    // Method to update a student
    public Student updateStudent(Connection con, Student student, int id) throws SQLException {
        String query = "UPDATE public.students SET name = ?, age = ?, school = ?, grade = ? WHERE id = ?";
        PreparedStatement st = con.prepareStatement(query);
        st.setString(1, student.getName());
        st.setInt(2, student.getAge());
        st.setString(3, student.getSchool());
        st.setInt(4, student.getGrade());
        st.setInt(5, id);

        int success = st.executeUpdate();
        st.close();
        if (success > 0) {
            System.out.println("Student with id " + id + " updated successfully.");
            return student;
        }
        return null;
    }

    // Method to delete a student
    public Student deleteStudent(Connection con, Student student) throws SQLException {
        String query = "DELETE FROM public.students WHERE id = ?";
        PreparedStatement st = con.prepareStatement(query);
        st.setInt(1, student.getId());

        int success = st.executeUpdate();
        st.close();
        if (success > 0) {
            System.out.println("Student with id " + student.getId() + " deleted successfully.");
            return student;
        }
        return null;
    }
}
