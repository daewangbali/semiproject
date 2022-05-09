<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../includes/board-list.jsp"%>

<button onclick="location.href ='DusiWritePostFormController.do?postCategory=${postCategory}'" type="button" class="btn btn-warning" style="float: right;color: white;">글쓰기</button>
<ul class=""> 
<c:forEach items="${list}" var="list">
<li>
<span class="">
    <a href="DusiDetailController.do?no=${list.postNo}"><img src="https://img.youtube.com/vi/${list.youtubeLink}/mqdefault.jpg" alt="유튜브 동영상 이미지입니다." ></a>
    <br>
    ${list.postTitle}
</span>
</li>
</c:forEach>
</ul>

<ul class="pagination justify-content-center" style="margin:20px 0">
 <c:if test="${pagination.previousPageGroup}">
 	<li class="page-item"><a class="page-link" href="ListController.do?pageNo=${pagination.startPageOfPageGroup-1 }&postCategory=${postCategory}">Previous</a></li>
 </c:if>
 <c:forEach begin="${pagination.startPageOfPageGroup}" end="${pagination.endPageOfPageGroup}" var="page">
 <c:choose>
 	<c:when test="${page==pagination.nowPage}">
 		<li class="page-item active"><a class="page-link" href="ListController.do?pageNo=${page}&postCategory=${postCategory}">${page}</a></li>
 	</c:when>
 	<c:otherwise>
  		<li class="page-item"><a class="page-link" href="ListController.do?pageNo=${page}&postCategory=${postCategory}">${page}</a></li>
 	</c:otherwise>
 </c:choose>
 </c:forEach>
 <c:if test="${pagination.nextPageGroup}">
 	<li class="page-item"><a class="page-link" href="ListController.do?pageNo=${pagination.endPageOfPageGroup+1 }&postCategory=${postCategory}">Next</a></li>
 </c:if>
</ul>
<%-- 로그인되어 있을 때만 글쓰기 버튼 활성화 --%>
<br>
