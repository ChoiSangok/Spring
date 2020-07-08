<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원번호</title>
</head>
<body>

<h1>디테일뷰</h1>


<table>
<thead>
<tr>
   <td>사원번호</td>
   <td>이름</td>
   <td>직무</td>
   <td>매니저</td>
   <td>입사일</td>
   <td>급여</td>
   <td>상여금</td>
   <td>부서번호</td>
</tr>
</thead>

<tbody>

<tr>

   <td>${emp.empno }</td>
   <td>${emp.ename }</td> 
   <td>${emp.job }</td>
   <td>${emp.mgr }</td>
   <td>${emp.hiredate }</td>
   <td>${emp.sal }</td>
   <td>${emp.comm }</td>
   <td>${emp.deptno}</td>

</tr>

</tbody>
</table>


</body>
</html>
