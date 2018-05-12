<%-- 
    Document   : index
    Created on : 11-Mar-2018, 8:33:41 PM
    Author     : Julian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>School Admissions System</title>
    </head>
    <body>
        <h2>Main Menu</h2>
        <jsp:forward  page="/StudentController?action=listStudents" />
    </body>
</html>
