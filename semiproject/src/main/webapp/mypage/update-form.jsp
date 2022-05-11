<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div align="center">
<a class="navbar-brand font-face  " href="UpdateMemberFormController.do" style="padding-bottom: 2px;color: black;font-size: 1cm;margin: 0 50px 0 0 " >회원정보수정</a>
<a class="navbar-brand font-face  " href="MyPageController.do" style="padding-bottom: 2px;color: black;font-size: 1cm;margin: 0 50px 0 0 " >내 게시물</a>
<a class="navbar-brand font-face  " href="MyPageController.do" style="padding-bottom: 2px;color: black;font-size: 1cm;margin: 0 50px 0 0 " >좋아요 게시물</a>
<a class="navbar-brand font-face  " href="MyPageController.do" style="padding-bottom: 2px;color: black;font-size: 1cm;margin: 0 50px 0 0 " >회원탈퇴</a><br>
</div>
<form action="UpdateMemberController.do" method="post" style="text-align: center;">
	<div class="label" style="font-weight: bolder; font-size: 30px">아이디</div>
	<input type="text" name="id" value="${sessionScope.mvo.id}" style="width: 300px; height: 50px; text-align: center;"><br><br>
	<div class="label" style="font-weight: bolder; font-size: 30px">이름</div>
	<input type="text" name="name" value="${sessionScope.mvo.name}" required="required" style="width: 300px; height: 50px; text-align: center;"><br><br>
	<div class="label" style="font-weight: bolder; font-size: 30px">전화번호</div>
	<input type="text" name="tel" value="${sessionScope.mvo.tel}" required="required" style="width: 300px; height: 50px; text-align: center;"><br><br>
	<div class="label" style="font-weight: bolder; font-size: 30px">KOSTA기수</div>
	<input type="text" name="kostaNO" value="${sessionScope.mvo.kostaNO}" required="required" style="width: 300px; height: 50px; text-align: center;"><br><br>
	<div class="label" style="font-weight: bolder; font-size: 30px">비밀번호</div>
	<input type="password" name="password" value="${sessionScope.mvo.password}" required="required" style="width: 300px; height: 50px; text-align: center;"><br><br>
	<button type="submit" style="background-color: #FFD700; border: 0px">수정하기</button>
</form>

