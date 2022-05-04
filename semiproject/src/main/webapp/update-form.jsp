<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div align="center">
<a class="navbar-brand font-face  " href="UpdateMemberFormController.do" style="padding-bottom: 2px;color: black;font-size: 1cm;margin: 0 50px 0 0 " >회원정보수정</a>
<a class="navbar-brand font-face  " href="MyPageController.do" style="padding-bottom: 2px;color: black;font-size: 1cm;margin: 0 50px 0 0 " >내 게시물</a>
<a class="navbar-brand font-face  " href="MyPageController.do" style="padding-bottom: 2px;color: black;font-size: 1cm;margin: 0 50px 0 0 " >좋아요 게시물</a>
<a class="navbar-brand font-face  " href="MyPageController.do" style="padding-bottom: 2px;color: black;font-size: 1cm;margin: 0 50px 0 0 " >회원탈퇴</a>
</div>
<form action="UpdateMemberController.do" method="post">
	<input type="text" name="id" value="${sessionScope.mvo.id}" readonly="readonly"><br>
	<input type="text" name="name" value="${sessionScope.mvo.name}" required="required"><br>
	<input type="text" name="tel" value="${sessionScope.mvo.tel}" required="required"><br>
	<input type="text" name="kostaNO" value="${sessionScope.mvo.kostaNO}" required="required"><br>
	<input type="password" name="password" value="${sessionScope.mvo.password}" required="required"><br>
	<button type="submit">수정하기</button>
</form>

