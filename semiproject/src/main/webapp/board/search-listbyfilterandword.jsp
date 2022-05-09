<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<div align="center">
<a class="navbar-brand font-face  " href="UpdateMemberFormController.do" style="padding-bottom: 2px;color: black;font-size: 1cm;margin: 0 50px 0 0 " >회원정보수정</a>
<a class="navbar-brand font-face  " href="MyPageController.do" style="padding-bottom: 2px;color: black;font-size: 1cm;margin: 0 50px 0 0 " >내 게시물</a>
<a class="navbar-brand font-face  " href="MyPageController.do" style="padding-bottom: 2px;color: black;font-size: 1cm;margin: 0 50px 0 0 " >좋아요 게시물</a>
<a class="navbar-brand font-face  " href="MyPageController.do" style="padding-bottom: 2px;color: black;font-size: 1cm;margin: 0 50px 0 0 " >회원탈퇴</a>
</div>
<br>
<br>
<div>
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

<ul class="pagination justify-content-center" style="margin:20px 0">
 <c:if test="${pagination.previousPageGroup}">
 	<li class="page-item"><a class="page-link" href="SearchListByFilterAndWord.do?pageNo=${pagination.startPageOfPageGroup-1 }&filter=name&word=${param.word}">Previous</a></li>
 </c:if>
 <c:forEach begin="${pagination.startPageOfPageGroup}" end="${pagination.endPageOfPageGroup}" var="page">
 <c:choose>
 	<c:when test="${page==pagination.nowPage}">
 		<li class="page-item active"><a class="page-link" href="SearchListByFilterAndWord.do?pageNo=${page}&filter=name&word=${param.word}">${page}</a></li>
 	</c:when>
 	<c:otherwise>
  		<li class="page-item"><a class="page-link" href="SearchListByFilterAndWord.do?pageNo=${page}&filter=name&word=${param.word}">${page}</a></li>
 	</c:otherwise>
 </c:choose>
 </c:forEach>
 <c:if test="${pagination.nextPageGroup}">
 	<li class="page-item"><a class="page-link" href="SearchListByFilterAndWord.do?pageNo=${pagination.endPageOfPageGroup+1 }&filter=name&word=${param.word}">Next</a></li>
 </c:if>
</ul>

</div>