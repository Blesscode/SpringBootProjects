<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h3 style="color: green;">${msg}</h3>
	<form:form action="save" method="POST" modelAttribute="student">
    <table border="0" cellpadding="10">
        <tr>
            <td>Name:</td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><form:input path="email"/></td>
        </tr>
        <tr>
            <td>Gender:</td>
            <td>
                <form:radiobutton path="gender" value="Male"/> Male
                <form:radiobutton path="gender" value="Female"/> Female
            </td>
        </tr>
        <tr>
            <td>Course:</td>
            <td>
                <form:select path="course">
                    <form:option value="">--Select--</form:option>
                    <form:options items="${courses}"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <td>Timings:</td>
            <td><form:checkboxes items="${timings}" path="timings"/> </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="Register"/>
            </td>
        </tr>
    </table>
</form:form>
    <a href="viewStudents" >View Students</a>

</body>
</html>