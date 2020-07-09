<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>id랑 pw form</title>
</head>
<body>

<h1>아이디랑 비밀번호 form</h1>
<hr>

<form action="/select/key" method="post">
<table>
<tr>
	<td>
	<label>아이디
	<input type="text" id="userid" name="userid" ></label>
	</td>
	<br>
	<td>
	<label>비밀번호
	<input type="password" id="userpw" name="userpw"></label>
	</td>
	
</tr>	
</table>
<button>로그인</button>
</form>

</body>
</html>
