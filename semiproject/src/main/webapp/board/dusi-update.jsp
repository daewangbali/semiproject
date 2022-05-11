<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 상세 게시글 보기 화면 --%>
<br>
<div>
	<div>
		<img src="images/2pm_logo.png" width="100" > &nbsp;
		<a href="DusiListController.do" style="font-size: 1.5cm;text-decoration: none;color: black;align-items: flex-end;">두시의 데이트</a>
        <p class="mb-0"></p>
	</div>
		
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
		<div class="boardviewbody" style="text-align:center;">
    <iframe width="1000" height="720" src="https://www.youtube.com/embed/${bvo.youtubeLink}" 
    title="YouTube video player"  frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen>
    </iframe>
</div>
		<pre><font size="4"><textarea rows="10" class="form-control" name="content" placeholder="본문내용" >${bvo.postContent}</textarea></font></pre>
		</td>
	</tr>
	 
	<tr>
		<td colspan="5" class="text-center">
			<input type="hidden" name="no" value="${bvo.postNo}">
			<input type="hidden" name="postCategory" value="${bvo.postCategory}">
			<button type="submit" class="btn btn-success">확인</button>
			<button type="reset" class="btn btn-light">취소</button>	
		</td>
	</tr>
	
</table>
</form>

	






