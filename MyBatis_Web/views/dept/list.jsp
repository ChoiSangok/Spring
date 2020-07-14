<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>부서 정보 목록</h1>
<hr>

<table>
<thead>
<tr>
	<th>부서번호</th>
	<th>부서이름</th>
	<th>위치</th>
	
</thead>
<tbody>
<c:forEach items ="${deptlist }" var="dept">
<tr onclick ="location.href='/dept/detail?deptno=${dept.deptno }'">
	<td>${dept.deptno }</td>
	<td>${dept.dname }</td>
	<td>${dept.loc }</td>
</tr>
</c:forEach>
</tbody>

</table>

<button type="button" onclick="location.href='/dept/insert'">직원추가</button>

</body>
</html>
