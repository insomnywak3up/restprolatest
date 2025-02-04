package kz.aitu.rest2423.restpro.DBConnection;

import kz.aitu.rest2423.restpro.Entities.Teacher;
import java.util.ArrayList;
import java.sql.*;

public class DBConnectionTeacher extends DBConnection {

    // Method to get all students from the database
    public ArrayList<Teacher> getTeachers(Connection con) throws SQLException {
        String query = "SELECT * FROM public.teachers";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        ArrayList<Teacher> teachers = new ArrayList<>();

        while (rs.next()) {
            Teacher teacher = new Teacher();
            teacher.setId(rs.getInt("id"));
            teacher.setName(rs.getString("name"));
            teacher.setAge(rs.getInt("age"));
            teacher.setDepartment(rs.getString("department"));
            teacher.setSubject(rs.getString("subject"));
            teachers.add(teacher);
        }

        st.close();
        return teachers;
    }

    // Method to get a student by ID
    public Teacher getTeacherById(Connection con, int id) throws SQLException {
        String query = "SELECT * FROM public.teachers WHERE id = ?";
        PreparedStatement st = con.prepareStatement(query);
        st.setInt(1, id);
        ResultSet rs = st.executeQuery();
        Teacher teacher = new Teacher();

        while (rs.next()) {
            teacher.setId(id);
            teacher.setName(rs.getString("name"));
            teacher.setAge(rs.getInt("age"));
            teacher.setDepartment(rs.getString("department"));
            teacher.setSubject(rs.getString("subject"));
        }

        st.close();
        return teacher;
    }

    // Method to get students by name
    public ArrayList<Teacher> getTeachersByName(Connection con, String name) throws SQLException {
        String query = "SELECT * FROM public.teachers WHERE name = ?";
        PreparedStatement st = con.prepareStatement(query);
        st.setString(1, name);
        ResultSet rs = st.executeQuery();
        ArrayList<Teacher> teachers = new ArrayList<>();

        while (rs.next()) {
            Teacher teacher = new Teacher();
            teacher.setId(rs.getInt("id"));
            teacher.setName(rs.getString("name"));
            teacher.setAge(rs.getInt("age"));
            teacher.setDepartment(rs.getString("department"));
            teacher.setSubject(rs.getString("subject"));
            teachers.add(teacher);
        }

        st.close();
        return teachers;
    }

    // Method to add a new student
    public Teacher addTeacher(Connection con, Teacher teacher) throws SQLException {
        String query = "INSERT INTO public.teachers (id, name, age, department, subject) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement st = con.prepareStatement(query);
        st.setInt(1, teacher.getId());
        st.setString(2, teacher.getName());
        st.setInt(3, teacher.getAge());
        st.setString(4, teacher.getDepartment());
        st.setString(5, teacher.getSubject());


        int success = st.executeUpdate();
        st.close();
        if (success > 0) {
            System.out.println("Student with name " + teacher.getName() + " created successfully.");
            return teacher;
        }
        return null;
    }

    // Method to update a student
    public Teacher updateTeacher(Connection con, Teacher teacher, int id) throws SQLException {
        String query = "UPDATE public.teachers SET name = ?, age = ?, department = ?, subject = ? WHERE id = ?";
        PreparedStatement st = con.prepareStatement(query);
        st.setString(1, teacher.getName());
        st.setInt(2, teacher.getAge());
        st.setString(3, teacher.getDepartment());
        st.setString(4, teacher.getSubject());
        st.setInt(5, id);

        int success = st.executeUpdate();
        st.close();
        if (success > 0) {
            System.out.println("Teachers with id " + id + " updated successfully.");
            return teacher;
        }
        return null;
    }

    // Method to delete a student
    public Teacher deleteTeacher(Connection con, Teacher teacher) throws SQLException {
        String query = "DELETE FROM public.teachers WHERE id = ?";
        PreparedStatement st = con.prepareStatement(query);
        st.setInt(1, teacher.getId());

        int success = st.executeUpdate();
        st.close();
        if (success > 0) {
            System.out.println("Teacher with id " + teacher.getId() + " deleted successfully.");
            return teacher;
        }
        return null;
    }
}
