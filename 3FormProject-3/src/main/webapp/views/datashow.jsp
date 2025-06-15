<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
<h2>Submitted Student Details</h2>
<a href="/" >Goto Form</a>
<table border="1" >
		<thead>
			<tr>
			   <th>S.NO</th>
			   <th>Name</th>
			   <th>Email</th>
			   <th>gender</th>
			   <th>course</th>
			   <th>Timings</th>
			</tr>
		</thead>
		<tbody>
        
            <c:forEach items="${students}" var="t" varStatus="index">
                <tr>
        			<td>${index.count}</td>
        			<td>${t.name}</td>
        			<td>${t.email}</td>
        			<td>${t.gender}</td>
        			<td>${t.course}</td>
        			<td>${t.timings}</td>
    			</tr>
            </c:forEach>

        </tbody>

</table>
</body>
</html>