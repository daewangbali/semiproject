<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<div align="center">
<a class="navbar-brand font-face  " href="UpdateMemberFormController.do" style="padding-bottom: 2px;color: black;font-size: 1cm;margin: 0 50px 0 0 " >회원정보수정</a>
<a class="navbar-brand font-face  " href="MyPageController.do" style="padding-bottom: 2px;color: black;font-size: 1cm;margin: 0 50px 0 0 " >내 게시물</a>
<a class="navbar-brand font-face  " href="MyPageController.do" style="padding-bottom: 2px;color: black;font-size: 1cm;margin: 0 50px 0 0 " >좋아요 게시물</a>
<!-- <a class="navbar-brand font-face  " href="DeleteMemberController.do" style="padding-bottom: 2px;color: black;font-size: 1cm;margin: 0 50px 0 0 " >회원탈퇴</a> -->
<a class="navbar-brand font-face  " onclick="checkDelete()" style="padding-bottom: 2px;color: black;font-size: 1cm;margin: 0 50px 0 0 " >회원탈퇴</a>

</div>

<script type="text/javascript">
	function checkDelete() {
		if(confirm("회원탈퇴를 하시겠습니까?")){
			location.href="DeleteMemberController.do";
		}
	}
</script>