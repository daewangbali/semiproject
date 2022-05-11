<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="../includes/board-menu.jsp"%>
<%-- 게시글쓰기 작성폼 --%>
<form method="post" action="DusiWritePostController.do">
<table class="table">
	<hr>
	<tr>
	
        <td>  
            <div>
                <span class="line_h35">https://youtu.be/  </span>
                <input type="text" placeholder="유튜브 주소 ID"   name="youtubeLink" id="youtubeLink" style="width:300px"/>
            </div>  
            <p class="mt_10">*ID를 정확히 입력해야 Player 및 썸네일 이미지가 정상적으로 출력이 됩니다. <br>
            유튜브 주소 ID를 입력하지 않으면 기존에 등록한 썸네일 이미지로 출력이 됩니다.</p>
                
        </td>
	</tr>
	<tr>
		<td><input type="text" name="title" placeholder="글제목" required="required" size=100%></td>
	</tr>
	<tr>
		<td>
			<textarea rows="10" class="form-control" name="content" placeholder="본문내용" required="required"></textarea>
		</td>
	</tr>
	

</table>
<div class="text-center">
	<input type="hidden" id="postCategory" name="postCategory" value="${postCategory}">
	<button type="submit" class="btn btn-success">확인</button>
	<button type="reset" class="btn btn-light">취소</button>
</div>
</form>
<br>
<br>









