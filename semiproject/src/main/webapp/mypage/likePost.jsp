<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ include file="../includes/mypage-list.jsp"%>
<br>

<div >
	<table class="table table-bordered table-hover boardlist">
	<thead>
		<tr style="background-color:; text-align: center; ">
			<th width="10%">글번호</th>
			<th class="title" width="50%">제목</th>
			<th width="15%">작성자</th>
			<th width="15%">작성일</th>
			<th width="10%">조회</th>
		</tr>
	</thead>
	<tbody>

		<c:forEach items="${list}" var="boardVO">
			<tr style="text-align: center">
				<td>${boardVO.postNo}</td>
				<%--
					로그인 상태일때만 링크를 부여 ListMyLikePostController.do? query string 으로 pk인 게시물 no가 서버로 전달 보내기
				 --%>
				<c:choose>
					<c:when test="${sessionScope.mvo==null}">
						<td>${boardVO.postTitle}</td>
					</c:when>
					<c:otherwise>
						<td onclick=""><a href="PostDetailController.do?no=${boardVO.postNo}">${boardVO.postTitle}</a></td>
					</c:otherwise>
				</c:choose>
				<td>${boardVO.memberVO.id}</td>
				<td>${boardVO.postDate}</td>
				<td>${boardVO.hits}</td>
			</tr>
		</c:forEach>
	
	</tbody>
</table>
<br>
<br>
<br>
</div>
