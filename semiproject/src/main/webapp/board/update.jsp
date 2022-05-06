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

<form action="UpdatePostController.do" method="post">
<table class="table ">
	<tr>
		<td width="10%"><mark style="background-color: #fff099">글번호</mark> ${bvo.postNo}</td>
		
		<td width="45%"><mark style="background-color: #fff099">제목</mark> <input type="text" id="title" name="title" value="${bvo.postTitle}" size="60"></td>
		<td width="15%"><mark style="background-color: #fff099">작성자</mark> ${bvo.memberVO.name}</td>
		<td width="20%"><mark style="background-color: #fff099">작성일</mark> ${bvo.postDate}</td>
		<td width="10%"><mark style="background-color: #fff099">조회수</mark> ${bvo.hits}</td>
	</tr>
	<tr>
		<td colspan="5" height="300">
		<input type="hidden" name="no" value="${bvo.postNo}">
		<pre><font size="4"><textarea rows="10" class="form-control" name="content" placeholder="본문내용" >${bvo.postContent}</textarea></font></pre>
		</td>
	</tr>
	
	<tr>
		<td colspan="5" class="text-center">
			<button type="submit" class="btn btn-success">확인</button>
			<button type="reset" class="btn btn-light">취소</button>	
		</td>
	</tr>	
</table>
</form>	

	






