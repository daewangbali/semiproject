<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title >register-form.jsp</title>
        <style type="text/css">
        	@font-face {
    		font-family: 'SBAggroB';
    		src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2108@1.1/SBAggroB.woff') format('woff');
    		font-weight: normal;
    		font-style: normal;
		}
		h1,h2 ,h3, a {
			 font-family: 'SBAggroB';
		}
		
        </style>

 <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
      <!--   <link href="css/styles.css" rel="stylesheet" /> -->

</head>
<body style="background-color: #FFD700; text-align: center">
	
            <div class="container px-lg-1">
            	<img src="images/everykostatime_logo0.png" style="width: 35px; padding-right: 3px; padding-left: 3px; padding-top: 6px">
                <a class="navbar-brand font-face  " style="width:35px; padding-bottom: 2px; color:white; font-size: 20px" >EVERY KOSTIME</a>
                <div class="collapse navbar-collapse justify-content-end" id="navbarSupportedContent">
<form action="RegisterMemberController.do" method="post" id="registerForm"  >
	<input type="text" name="id" id="memberId" placeholder="아이디" required="required" onkeyup="checkId()"><br>
	<span id="checkResult"></span><br>
	<input type="text" name="name" placeholder="이름" required="required"><br>
	<input type="password" name="password" placeholder="패스워드" required="required"><br>
	<input type="text" name="tel" id="memberTel"  placeholder="전화번호" required="required" onkeyup="checkTel()"><br>
	<span id="checkTel"></span><br>
	<input type="text" name="kostaNO" id="kostaNO" placeholder="기수" required="required" onkeyup="checkKostaNO()"><br>
	<span id="checkKostaNO"></span>
	<br>
	<input type="button" value="회원가입" onclick="register()">
</form>
<script type="text/javascript">
	let checkIdFlag=false;
	let checkKostaNo=false;
	let checkTelFlag=false;
	
	function register() {
		if(checkIdFlag==false){//중복된 아이디
			//alert("아이디 중복확인하세요");
		}else if(checkKostaNo==false){
			alert("입력하신 KostaNo를 확인하세요");
		}else{
			document.getElementById("registerForm").submit();
		}
	}
	function checkId() {
		checkIdFlag=false;
		let memberId=document.getElementById("memberId").value;
		let checkResult=document.getElementById("checkResult");
		if(memberId.length<4){
			checkResult.innerHTML="<font color=white>아이디는 4자이상</font>";
		}else{
			let xhr=new XMLHttpRequest();
			xhr.onload=function(){
				
				if(xhr.responseText=="ok"){
					checkResult.innerHTML="<font color=green>사용가능</font>";
					checkIdFlag=true;
				}else{
					checkResult.innerHTML="<font color=red>사용불가</font>";
				}					
			}
			xhr.open("get", "CheckIdController.do?id="+memberId);
			xhr.send();
		}
	}
	function checkTel() {
		checkTelFlag=false;
		let memberTel=document.getElementById("memberTel").value;
		let checkTel=document.getElementById("checkTel");
		let xhr=new XMLHttpRequest();
		xhr.onload = function(){
			
			if(xhr.responseText=="ok"){
			checkTel.innerHTML="";
			checkTelFlag=true;
			}else{
				checkTel.innerHTML="<font color=red>등록불가</font>";
			}
		}
		xhr.open("get", "CheckTelController.do?tel="+memberTel);
		xhr.send();
	}
	
	
	function checkKostaNO(){
		let kostaNo = document.getElementById("kostaNO").value;
		let checkKostaNO = document.getElementById("checkKostaNO");
		let xhr = new XMLHttpRequest();
		xhr.onload = function(){
			if(xhr.responseText=="ok"){
				checkKostaNO.innerHTML = "";
				checkKostaNo=true;
			}else{
				checkKostaNO.innerHTML = "<font color=red>숫자만 입력할 수 있습니다.</font>";
				checkKostaNo=false;
			}
		}
		xhr.open("get", "CheckKostaNoController.do?kostaNo="+kostaNo);
		xhr.send();
	}
	
</script>

</div>
</div>
</body>
</html>
