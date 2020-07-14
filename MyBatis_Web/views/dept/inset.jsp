<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>직원추가입니다</h1>

<form action="/dept/insert" method="post">

부서번호 :  <input type="text" id="deptno" name="deptno"><br>
부서이름 : <input type="text" id="dname" name="dname"><br>
위치 : <input type="text" id="loc" name="loc"><br>

<input type="submit" value="직원추가"/>
</form>
</body>
</html>
