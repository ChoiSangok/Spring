<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<h1>부서 정보 디테일</h1>
<hr>
<a href="javascript:history.go(-1)">뒤로가기</a>

<table border=1>
<thead>
<tr>
	<th>부서번호</th>
	<th>부서이름</th>
	<th>위치</th>
	
</thead>
<tbody>

<tr>
	<td>${dept.deptno }</td>
	<td>${dept.dname }</td>
	<td>${dept.loc }</td>
</tr>

</tbody>




</table>



</body>
</html>
