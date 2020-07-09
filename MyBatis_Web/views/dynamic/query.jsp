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

<h1>전체목록</h1>

<table border="1">
<thead>
<tr>
   <td>숫자</td>
   <td>아이디</td>
   <td>비밀번호</td>

</tr>
</thead>

<tbody>
<c:forEach items="${list}" var="TestMember">
<tr>
   <td>${TestMember.NO }</td>
   <td>${TestMember.ID }</td> 
   <td>${TestMember.PW }</td>


</tr>
</c:forEach>
</tbody>
</table>


</body>
</html>
