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
		<div class="boardviewbody" style="text-align:center;">
    <iframe width="1000" height="720" src="https://www.youtube.com/embed/${bvo.youtubeLink}" 
    title="YouTube video player"  frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen>
    </iframe>
</div>
		<pre><font size="4">${bvo.postContent}</font></pre>
		</td>
	</tr>
	 <%--<c:if test="${sessionScope.mvo.id==bvo.memberVO.id }"> --%>
	<tr>
		
		<td colspan="5" class="text-center">
			<form id="deleteForm" action="DeletePostController.do" method="post">
				<input type="hidden" name="no" value="${bvo.postNo}">
				<input type="hidden" name="postCategory" value="${bvo.postCategory}">
			</form> 
			 <form id="updateForm" action="UpdatePostFormController.do" method="post">
				<input type="hidden" name="no" value="${bvo.postNo}">
			</form>
				<c:if test="${sessionScope.mvo.id == bvo.memberVO.id}">
			 	<button onclick="deletePost()" type="button" class="btn btn-outline-danger">삭제</button>
				<button onclick="updatePost()" type="button" class="btn btn-outline-warning">수정</button>
				</c:if>
		</td>
	</tr>
	 <%--</c:if> --%>
	
	
</table>

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
</script>
	






