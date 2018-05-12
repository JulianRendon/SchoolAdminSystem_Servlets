<%-- 
    Document   : student
    Created on : 11-Mar-2018, 9:12:39 PM
    Author     : Julian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!--<link href="/css/style.css" rel="stylesheet" type="text/css">-->
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add new student</title>
    </head>
    <body>
        <div align="left" class="smallbluetext" style="margin-bottom: 10px;">
            <a href="StudentController?action=listStudents">List all students</a>
        </div>
        <form method="POST" action="StudentController" name="frmAddStudent">
            <table align="left">
                <tr>
                    <td>Student Id</td>
                    <td><input type="text" readonly="readonly" placeholder="disable" name="studentId" value="<c:out value="${student.studentId}" />" /></td>
                </tr>
                <tr>
                    <td>First Name</td>
                    <td><input type="text" name="studentFirstname" value="<c:out value="${student.studentFirstname}"/>" /></td>
                </tr>
                <tr>
                    <td>Last Name</td>
                    <td><input type="text" name="studentLastname" value="<c:out value="${student.studentLastname}"/>" /></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit" /></td>
                </tr>
            </table>
        </form>
    </body>
</html>
