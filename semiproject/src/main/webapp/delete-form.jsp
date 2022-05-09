<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div align="center">
<a class="navbar-brand font-face  " href="UpdateMemberFormController.do" style="padding-bottom: 2px;color: black;font-size: 1cm;margin: 0 50px 0 0 " >회원정보수정</a>
<a class="navbar-brand font-face  " href="MyPageController.do" style="padding-bottom: 2px;color: black;font-size: 1cm;margin: 0 50px 0 0 " >내 게시물</a>
<a class="navbar-brand font-face  " href="MyPageController.do" style="padding-bottom: 2px;color: black;font-size: 1cm;margin: 0 50px 0 0 " >좋아요 게시물</a>
<a class="navbar-brand font-face  " href="MyPageController.do" style="padding-bottom: 2px;color: black;font-size: 1cm;margin: 0 50px 0 0 " >회원탈퇴</a>

<form action="DeleteMemberController.do" method="post" id="deleteForm">
	<input type="password" id="password" name="password" placeholder="패스워드" required="required" onkeyup="checkPassword()"><br>
	<span id="checkPassword"></span>
	<input type="button" value="회원탈퇴" onclick="deleteaccount()">
</form>
<script type="text/javascript">
	let checkPasswodFlag = false;
	//let checkPassword = document.getElementById("checkPassword");
	
	function deleteaccount(){
		//document.getElementById("deleteForm").submit();
		if(checkPasswodFlag==false){//중복된 비밀번호 ->회원탈퇴
			document.getElementById("deleteForm").submit();
		}else{//회원정보와 다른 비밀번호
			
		}
	}
	
	function checkPassword(){
		checkPasswodFlag=false;
		let password = document.getElementById("password").value;
		let checkResult=document.getElementById("checkResult");
		
		let xhr = new XMLHttpRequest();
		xhr.onload = function(){
			
			if(xhr.responseText=="ok"){ //비밀번호가 확인된 경우
				checkResult.innerHTML = "<font color=green>본인인증이 완료되었습니다.</font>";
				checkPasswodFlag=true;
			}else{ //비밀번호가 일치하지않는 경우
				checkResult.innerHTML = "<font color=red>비밀번호를 다시 입력바랍니다.</font>";
				//checkPasswodFlag=false;
			}
		}
		xhr.open("get", "CheckPasswordController.do?password="+password);	
		xhr.send();
	}
</script>
</div>