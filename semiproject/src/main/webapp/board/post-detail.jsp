<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 상세 게시글 보기 화면 --%>

<br>
<div>
	<c:choose>
		<c:when test="${bvo.postCategory=='소통'}">
			<div>
			<img src="images/threeperson_logo.png" width="100" > &nbsp;
			
               <a href="ListController.do?postCategory=소통" style="font-size: 1.5cm;text-decoration: none;color: black;align-items: flex-end;">소통게시판</a>
               
               <p class="mb-0"></p>
            </div>
		</c:when>
		<c:otherwise>
			<div>
			<img src="images/free_logo.png" width="100" > &nbsp;
			
               <a href="ListController.do?postCategory=자유" style="font-size: 1.5cm;text-decoration: none;color: black;align-items: flex-end;">자유게시판</a>
               
               <p class="mb-0"></p>
            </div>
		</c:otherwise>
	</c:choose>
</div>
<br>
<table class="table ">
	<tr>
		<td width="10%"><mark style="background-color: #fff099">글번호</mark> ${bvo.postNo}</td>
		<td width="45%"><mark style="background-color: #fff099">제목</mark> ${bvo.postTitle}</td>
		<td width="15%"><mark style="background-color: #fff099">작성자</mark> ${bvo.memberVO.name}</td>
		<td width="20%"><mark style="background-color: #fff099">작성일</mark> ${bvo.postDate}</td>
		<td width="10%"><mark style="background-color: #fff099">조회수</mark> ${bvo.hits}</td>
	</tr>
	<tr>
		<td colspan="5" height="300">
		<pre><font size="4">${bvo.postContent}</font></pre>
		</td>
	</tr>
	 <%--<c:if test="${sessionScope.mvo.id==bvo.memberVO.id }"> --%>
	 
	<tr>
		<td colspan="5" class="text-center">
			<input type="hidden" id="flag" name="flag" value="${flag}">
			<img id="heart" src="${src}" style="width: 1cm;float: left;"  onclick="likePost();"/>
			<p style="float: left">&nbsp;${likeNumber}개</p>
		</td>
	</tr>
	</table>
	
	<table class="table" >
	<tr>
	<c:forEach items="${requestScope.commentList }" var="list">
	 	<td width="45%">${list.commentContent }</td>
	 	
		<td width="45%">${list.memberVO.id}님</td>
		<td width="10%">${list.commentDate}</td>
		<c:if test="${list.memberVO.id==sessionScope.mvo.id }">
		<td><input type="button" onclick="updateComment(${list.commentNo}, ${bvo.postNo })" value="수정"></td>
		</c:if>
	</c:forEach>
	</tr>
	<tr>
		<td >
			<form action="RegisterCommentController.do" id="registerCommentForm" method="post">
				<input type="hidden" name="no" value="${bvo.postNo}">
				<input type="hidden" name="writerId" value="${sessionScope.mvo.id}">
				<input type="text" name="commentContent" placeholder="댓글입력" style="width:90%">
			</form>
		</td>
		<td width="10%">
			<button onclick="registerComment()" type="button" class="btn btn-warning">댓글 작성</button>
		</td>
		
	</tr>
	</table>
	<div align="center">
		<form id="deleteForm" action="DeletePostController.do" method="post">
				<input type="hidden" id="no" name="no" value="${bvo.postNo}">
				<input type="hidden" name="postCategory" value="${bvo.postCategory}">
			</form> 
			 <form id="updateForm" action="UpdatePostFormController.do" method="post">
				<input type="hidden" name="no" value="${bvo.postNo}">
			</form>
				<c:if test="${sessionScope.mvo.id == bvo.memberVO.id}">
			 	<button onclick="deletePost()" type="button" class="btn btn-outline-danger">삭제</button>
				<button onclick="updatePost()" type="button" class="btn btn-outline-warning">수정</button>
				</c:if>
	</div>
	<br>

<script type="text/javascript">
	function deletePost() {
		if(confirm("게시물을 삭제하시겠습니까?")){
			document.getElementById("deleteForm").submit();
		}
	}
	function updatePost() {
		if(confirm("게시물을 수정하시겠습니까?")){
			document.getElementById("updateForm").submit();
		}
	}
	function registerComment(){
		if(confirm("댓글을 작성하시겠습니까?")){
			document.getElementById("registerCommentForm").submit();
		}
	}
	
	function updateComment(commentNo, postNo){
		window.open("UpdateCommentFormController.do?commentNo="+commentNo+"&postNo="+postNo, "join", "width=300, height=150, left=100, top=50");
	}
	function likePost() {
		let flag = document.getElementById("flag").value;
		let no = document.getElementById("no").value;
		
		let xhr = new XMLHttpRequest();
		xhr.onload=function(){
			if(xhr.responseText == "ok"){
				document.getElementById("heart").src = "images/fullheart.png";
			}else{
				document.getElementById("heart").src = "images/emptyheart.png";	
			}
		}
		window.location.reload;
		xhr.open("get","LikeController.do?flag="+flag+"&no="+no);
		xhr.send();
	}
</script>
	






