<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includes/mypage-list.jsp"%>
<div align="center">
<br><br>
<span id="originalSentence">${sessionScope.mvo.name } 본인은 회원탈퇴를 진행하겠습니다.</span><br>
<input type="text" id="deleteSentence" name="deleteSentence" placeholder="위 문구를 입력하세요" required="required" onkeyup="checkSentence()"  style="width:600px; font-size:30px; text-align: center;">
<span id="checkSentence"></span>
<br>
<a href="#" id="deleteMemberButton" value="회원탈퇴" onclick="deleteMember()">회원탈퇴</a>
<a href="MyPageController.do">뒤로가기</a>
<form id="deleteMemberForm" method="post" action="DeleteMemberController.do"></form>
<script type="text/javascript">
	let checkSentenceFlag = false;
	let deleteMemberForm = document.getElementById("deleteMemberForm");
	deleteMemberButton.disabled=true;
	
	function deleteMember() {
		//document.getElementById("deleteForm").submit();
		if(checkSentenceFlag==false){
			alert("입력하신 문구를 다시 한번 확인하세요.");
		}else{
			if(confirm("회원탈퇴를 진행하시겠습니까?"))
				document.getElementById("deleteMemberForm").submit();
		}
	}
	
	function checkSentence(){
		let deleteSentence = document.getElementById("deleteSentence").value;
		let originalSentence = document.getElementById("originalSentence").innerHTML;
		
		if(deleteSentence == originalSentence){
			checkSentenceFlag = true;
			deleteMemberButton.disabled=false;
		}else
			deleteMemberButton.disabled=true;
	}
</script>
</div>
<br>
<br>