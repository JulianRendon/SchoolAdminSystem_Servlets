<%-- 
    Document   : listStudents
    Created on : 11-Mar-2018, 8:37:33 PM
    Author     : Julian
--%>

<%--<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="daoImplementation.PersonDaoImpl"%>
<%@page import="java.util.List"%>
<%@page import="beans.Person"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show all students</title>
    </head>
    <body>
        <table cellspacing="0" cellpadding="5" border=1>
            <thead>
                <tr>
                    <th>Student Id</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th colspan="2">Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${students}" var="student">
                    <tr>
                        <td><c:out value="${student.studentId}" /></td>
                        <td><c:out value="${student.studentFirstname}" /></td>
                        <td><c:out value="${student.studentLastname}" /></td>
                        <td><a href="StudentController?action=edit&studentId=<c:out value="${student.studentId}" />">Update</a></td>
                        <td><a href="StudentController?action=delete&studentId=<c:out value="${student.studentId}" />">Delete</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <p><a href="StudentController?action=insert">Add Student</a></p>
    </body>
</html>
