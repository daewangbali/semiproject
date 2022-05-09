<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div align="center">
<a class="navbar-brand font-face  " href="UpdateMemberFormController.do" style="padding-bottom: 2px;color: black;font-size: 1cm;margin: 0 50px 0 0 " >회원정보수정</a>
<a class="navbar-brand font-face  " href="MyPageController.do" style="padding-bottom: 2px;color: black;font-size: 1cm;margin: 0 50px 0 0 " >내 게시물</a>
<a class="navbar-brand font-face  " href="MyPageController.do" style="padding-bottom: 2px;color: black;font-size: 1cm;margin: 0 50px 0 0 " >좋아요 게시물</a>
<a class="navbar-brand font-face  " href="MyPageController.do" style="padding-bottom: 2px;color: black;font-size: 1cm;margin: 0 50px 0 0 " >회원탈퇴</a>
</div>
<form action="DeleteMemberController.do" method="post" id="deleteForm">
	<input type="password" id="password" name="password" placeholder="password" required="required" onkeyup="checkPasswordFunc()"><br>
	<span id="id">${sessionScope.mvo.id }</span>
	<span id="checkPassword"></span>
	<input type="button" onclick="deleteForm">회원 탈퇴하기</button>
</form>
<div>
<script type="text/javascript">
	let checkPasswodFlag = false;
	let checkPassword = document.getElementById("checkPassword");
	
	function deleteForm(){
		document.getElementById("deleteForm").submit();
	}
	
	function checkPasswordFunc(){
		let password = document.getElementById("password").value;
		let xhr = new XMLHttpRequest();
		xhr.onload = function(){
			if(xhr.responseText=="ok"){ //비밀번호가 확인된 경우
				checkPassword.innerHTML = "<font color=green>본인인증이 완료되었습니다.</font>";
				checkPasswodFlag=true;
			}else{ //비밀번호가 일치하지않는 경우
				checkPassword.innerHTML = "<font color=red>비밀번호를 다시 입력바랍니다.</font>";
				checkPasswodFlag=false;
			}
		}
		xhr.open("GET", "CheckPasswordController.do");	
		xhr.send();
	}
</script>
</div>