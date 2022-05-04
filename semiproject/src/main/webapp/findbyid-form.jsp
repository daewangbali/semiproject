<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
<div class="col-sm-8 offset-sm-2">
	<input type="text" name="name" required="required" placeholder="이름"><br>
	<input type="text" name="tel" required="required" placeholder="전화번호"><br>
	<input type="button" value="검색"  id="findMemberBtn" onclick="findIdByNameAndTel()">
	<br><br>
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>아이디</th>
			</tr>
		</thead>
		<tbody id="memberTbody">			
		</tbody>
	</table>
	
	<script type="text/javascript">
		function findIdByNameAndTel() {
			let memberTbody=document.getElementById("memberTbody");
			memberTbody.innerHTML="";
			let memId=document.getElementById("memberId").value;
			if(memId==""){
				alert("아이디를 입력하세요");
				return;
			}
			let xhr=new XMLHttpRequest();			
			xhr.onload=function(){
				let jsonData=JSON.parse(xhr.responseText);
				if(jsonData.fail=="true"){//회원정보가 없을 때 
					alert(jsonData.message);
				}else{//회원정보가 있을 때 
					let memInfo="<tr>";
					memInfo+="<td>"+jsonData.name+"</td>";
					memInfo+="<td>"+jsonData.address+"</td>";
					memInfo+="</tr>";
					memberTbody.innerHTML=memInfo;
				}
			}
			xhr.open("get", "FindMemberByIdController.do?id="+memId);
			xhr.send();
		}
	</script>
</div>
</div>























