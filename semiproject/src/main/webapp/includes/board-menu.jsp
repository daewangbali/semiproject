<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<br>
<div>
	<c:choose>
		<c:when test="${postCategory=='소통'}">
			<div>
			<img src="images/threeperson_logo.png" width="100" > &nbsp;
			
               <a href="ListController.do?postCategory=소통" style="font-size: 1.5cm;text-decoration: none;color: black;align-items: flex-end;">소통게시판</a>
               
               <p class="mb-0"></p>
            </div>
		</c:when>
		<c:when test="${postCategory=='두시'}">
			<div>
			<img src="images/2pm_logo.png" width="100" > &nbsp;
			
               <a href="ListController.do?postCategory=두시" style="font-size: 1.5cm;text-decoration: none;color: black;align-items: flex-end;">두시의 데이트</a>
               
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