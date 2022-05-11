<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../includes/board-list.jsp"%>
<div>

<br>
<div class="row" style="justify-content: space-around ; margin: 1px">

<c:forEach items="${list}" var="list">
<div class="col-lg-4 col-md-1 mb-4" style="text-align: center ; padding: 0 5px">
<span class="">
<c:choose>
	<c:when test="${sessionScope.mvo==null}">
		<img src="https://img.youtube.com/vi/${list.youtubeLink}/mqdefault.jpg" alt="유튜브 동영상 이미지입니다." >
	</c:when>
	<c:otherwise>
		<a href="DusiDetailController.do?no=${list.postNo}"><img src="https://img.youtube.com/vi/${list.youtubeLink}/mqdefault.jpg" alt="유튜브 동영상 이미지입니다." ></a>
	</c:otherwise>
</c:choose>
    

    <br>
    <b>${list.postTitle}</b>
</span>
</div>
</c:forEach>
</div>
</div>

<%-- 로그인되어 있을 때만 글쓰기 버튼 활성화 --%>
<br>
<c:if test="${sessionScope.mvo!=null}">
	<div class="">
		<button onclick="location.href ='DusiWritePostFormController.do?postCategory=${postCategory}'" type="button" class="btn btn-warning" style="float: right;color: white;">글쓰기</button>
	</div>
</c:if>
<br>
<br>
<br>