/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoimplementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Student;
import util.ConnectionFactory;

/**
 *
 * @author Julian
 */
public class StudentDAOImplementation {

    private Connection connection;

    // Constructor 
    public StudentDAOImplementation() throws SQLException, ClassNotFoundException {
        connection = ConnectionFactory.getConnection();
    }

    // Create a new Student
    public void createStudent(Student student) {

        PreparedStatement preparedStatement;
        try {
            String createQuery = "INSERT INTO STUDENT(student_id, first_name, last_name) VALUES(STUDENTID_SEQ.NEXTVAL,?,?)";
            preparedStatement = connection.prepareStatement(createQuery);
            preparedStatement.setString(1, student.getStudentFirstname());
            preparedStatement.setString(2, student.getStudentLastname());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Find by studentId 
    public Student getStudentById(int studentId) {

        Student student = new Student();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        try {
            String selectIdQuery = "SELECT * FROM STUDENT WHERE STUDENT_ID = ?";
            preparedStatement = connection.prepareStatement(selectIdQuery);
            preparedStatement.setInt(1, studentId);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                student.setStudentId(resultSet.getInt("student_Id"));
                student.setStudentFirstname(resultSet.getString("first_name"));
                student.setStudentLastname(resultSet.getString("last_name"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return student;

    }

    // find All people
    public List<Student> getAllStudents() {

        List<Student> students = new ArrayList<>();
        Student student = null;
        ResultSet resultSet;
        PreparedStatement preparedStatement;

        try {
            String selectAllQuery = "SELECT * FROM STUDENT ORDER BY STUDENT_ID";
            preparedStatement = connection.prepareStatement(selectAllQuery);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                student = new Student();
                student.setStudentId(resultSet.getInt("student_id"));
                student.setStudentFirstname(resultSet.getString("first_name"));
                student.setStudentLastname(resultSet.getString("last_name"));
                students.add(student);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return students;
    }

    // Update student's info
    public void updateStudent(Student student) {

        PreparedStatement preparedStatement;

        try {
            String updateQuery = "UPDATE STUDENT SET FIRST_NAME = ?, LAST_NAME = ? WHERE STUDENT_ID = ?";
            //System.out.println("Query = " + updateQuery);
            preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setString(1, student.getStudentFirstname());
            preparedStatement.setString(2, student.getStudentLastname());
            preparedStatement.setInt(3, student.getStudentId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Delete student
    public void deleteStudent(int studentId) {

        PreparedStatement preparedStatement;

        try {
            String deleteQuery = "DELETE FROM STUDENT WHERE STUDENT_ID = ?";
            preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setInt(1, studentId);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
