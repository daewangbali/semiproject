<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="container mt-5 pt-5" align="center"  style="height: 600px;align-self: center;">
	
		<h1><mark style="background-color: #fff099;font-size: 2cm">마이페이지</mark></h1><br>
		<a class="navbar-brand font-face " href="UpdateMemberFormController.do" style="padding-bottom: 2px;color: black;font-size: 1cm;margin: 0 50px 0 0 " >회원정보수정</a> <br>
		<a class="navbar-brand font-face " href="ListMyPostController.do?pageNo=1&id=${sessionScope.mvo.id }" style="padding-bottom: 2px;color: black;font-size: 1cm;margin: 0 50px 0 0 " >내가 쓴 게시물</a><br>
		<a class="navbar-brand font-face " href="ListLikeController.do" style="padding-bottom: 2px;color: black;font-size: 1cm;margin: 0 50px 0 0 " >좋아요 게시물</a><br>
		<a class="navbar-brand font-face " href="DeleteMemberFormController.do" style="padding-bottom: 2px;color: black;font-size: 1cm;margin: 0 50px 0 0 " >회원탈퇴</a><br>
	
</div>
<br>
