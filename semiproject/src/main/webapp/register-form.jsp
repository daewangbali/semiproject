<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>register-form.jsp</title>
</head>
<body>
<form action="RegisterMemberController.do" method="post">
	<input type="text" name="id" placeholder="아이디" required="required"><br>
	<input type="text" name="name" placeholder="이름" required="required"><br>
	<input type="password" name="password" placeholder="패스워드" required="required"><br>
	<input type="text" name="tel" placeholder="전화번호" required="required"><br>
	<input type="text" name="kostaNO" placeholder="기수" required="required"><br>
	<br>
	<button type="submit">회원가입</button>
</form>
</body>
</html>