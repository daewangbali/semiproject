<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includes/mypage-list.jsp"%>
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
	<button type="submit" class="btn btn-warning">수정하기</button>
</form>
<br>
