<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title >register-form.jsp</title>
        <style type="text/css">
        	@font-face {
    		font-family: 'SBAggroB';
    		src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2108@1.1/SBAggroB.woff') format('woff');
    		font-weight: normal;
    		font-style: normal;
		}
		h1,h2 ,h3, a {
			 font-family: 'SBAggroB';
		}
		
        </style>

 <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
      <!--   <link href="css/styles.css" rel="stylesheet" /> -->

</head>
<body style="background-color: #FFD700; text-align: center">
	
            <div class="container px-lg-1">
            	<img src="images/everykostatime_logo0.png" style="width: 35px; padding-right: 3px; padding-left: 3px; padding-top: 6px">
                <a class="navbar-brand font-face  " style="width:35px; padding-bottom: 2px; color:white; font-size: 20px" >EVERY KOSTIME</a>
                <div class="collapse navbar-collapse justify-content-end" id="navbarSupportedContent">
<form action="UpdateCommentController.do" method="post" id="updateCommentForm">
	<input type="text" name="commentContent" value="${requestScope.cvo.commentContent }" placeholder="아이디" required="required" onkeyup="checkId()" style="width:250px"><br>
	<input type="number" name="commentNo" value="${requestScope.cvo.commentNo }" hidden>
	<input type="number" name="postNo" value="${requestScope.postNo }" hidden><br>
	<input type="button" value="댓글수정" onclick="updateComment()">
</form>
<script type="text/javascript">
	function updateComment(){
		document.getElementById("updateCommentForm").submit();
	}
</script>
</div>
</div>
</body>
</html>
