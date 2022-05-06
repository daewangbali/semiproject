<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
<div class="col-sm-8 offset-sm-2">
	<input type="text" name="name" id="memberName" required="required" placeholder="이름"><br>
	<input type="text" name="tel" id="memberTel" required="required" placeholder="전화번호"><br>
	<input type="button" value="검색"  id="findIdBnt" onclick="findIdByNameAndTel()">
	<br><br>
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>아이디</th>
			</tr>
		</thead>
		<tbody id="idTbody">			
		</tbody>
	</table>
	
	<script type="text/javascript">
		function findIdByNameAndTel() {
			let idTbody=document.getElementById("idTbody");
			idTbody.innerHTML="";
			let memName=document.getElementById("memberName").value;
			let memTel=document.getElementById("memberTel").value;
			if(memName==""){
				alert("이름을 입력하세요");
				return;
			}else if(memTel==""){
				alert("전화번호를 입력하세요");
				return;
			}
			let xhr=new XMLHttpRequest();			
			xhr.onload=function(){
				let jsonData=JSON.parse(xhr.responseText);
				if(jsonData.fail=="true"){//회원정보가 없을 때 
					alert(jsonData.message);
				}else{//회원정보가 있을 때 
					let memInfo="<tr>";
					memInfo+="<td>"+jsonData.id+"</td>";
					memInfo+="</tr>";
					idTbody.innerHTML=memInfo;
				}
			}
			xhr.open("get", "FindIdByNameAndTelController.do?name="+memName+"&tel="+memTel);
			xhr.send();
		}
	</script>
</div>
</div>























