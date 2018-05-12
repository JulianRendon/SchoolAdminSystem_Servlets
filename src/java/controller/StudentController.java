/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import daoimplementation.StudentDAOImplementation;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Student;

/**
 *
 * @author Julian
 */
@WebServlet(name = "StudentController", urlPatterns = {"/StudentController"})
public class StudentController extends HttpServlet {

    private static String INSERT_OR_EDIT = "/student.jsp";
    private static String LIST_STUDENTS = "/listStudents.jsp";
    private StudentDAOImplementation dao;

    public StudentController() throws Exception {
        super();
        dao = new StudentDAOImplementation();
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String forward = "";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {
            int studentId = Integer.parseInt(request.getParameter("studentId"));
            dao.deleteStudent(studentId);
            forward = LIST_STUDENTS;
            request.setAttribute("students", dao.getAllStudents());
        } else if (action.equalsIgnoreCase("edit")) {
            forward = INSERT_OR_EDIT;
            int studentId = Integer.parseInt(request.getParameter("studentId"));
            Student student = dao.getStudentById(studentId);
            request.setAttribute("student", student);
        } else if (action.equalsIgnoreCase("listStudents")) {
            forward = LIST_STUDENTS;
            request.setAttribute("students", dao.getAllStudents());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Student student = new Student();
        student.setStudentFirstname(request.getParameter("studentFirstname"));
        student.setStudentLastname(request.getParameter("studentLastname"));
        //int studentId = Integer.parseInt(request.getParameter("studentId"));
        //int studentId = Integer.valueOf(request.getParameter("studentId"));
        String studentId = request.getParameter("studentId");

        if (studentId == null || studentId.isEmpty()) {
            System.out.println("In here");
            dao.createStudent(student);
        } else {
            student.setStudentId(Integer.parseInt(studentId));
            dao.updateStudent(student);
        }

//        if(dao.getStudentById(studentId).getStudentId() == 0 ) {
//            dao.create(student);
//        } else {
//            dao.updateStudent(student);
//        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_STUDENTS);
        request.setAttribute("students", dao.getAllStudents());
        view.forward(request, response);

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
