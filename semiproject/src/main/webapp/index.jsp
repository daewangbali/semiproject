<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title >every kostime</title>
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
        <link href="css/styles.css" rel="stylesheet" />
    </head>
    <body>
        <!-- Responsive navbar-->
        <nav class="navbar navbar-expand-lg navbar-dark " style="background-color: 	#FFD700">
            <div class="container px-lg-5">
            	<img src="images/everykostatime_logo0.png" style="width: 35px; padding-right: 4px">
                <a class="navbar-brand font-face  " href="#!" style="padding-bottom: 2px" >EVERY KOSTIME</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
<!--                         <li class="nav-item"><a class="nav-link active" aria-current="page" href="#!">Home</a></li> -->
                        <li style="padding: 5px"><input class="id" id="id" placeholder="아이디" style="border-color:#FFD700"></li>
                        <li style="padding: 5px"><input class="id" id="password" placeholder="패스워드"style="border-color:#FFD700"></li>
                        <li class="nav-item"><a class="nav-link" href="#!" style="color: white; ">Login</a></li>
                      <!--   <li class="nav-item"><a class="nav-link" href="#!" style="color: white">Join</a></li> -->
                    </ul>
                </div>
            </div>
        </nav>
        <!-- Header-->
        <header class="py-5">
            <div class="container px-lg-5">
                <div class="p-4 p-lg-5  rounded-3 text-center">
                    <div class="m-4 m-lg-5">
                        
                        <h1 class="display-5 fw-bold" style="font-size: 3cm">에브리코스타임</h1>
                       
                        
                        <p class="fs-4"></p>
                        <a class="btn btn-warning " style="background-color: #FFD700;border: 0px; width: 150px 100px;align-content: center; " href="#!">회원가입</a>
                    </div>
                </div>
            </div>
        </header>
        <!-- Page Content-->
        <section class="pt-4">
            <div class="container px-lg-5">
                <!-- Page Features-->
                <div class="row gx-lg-5">
                    <div class="col-lg-6 col-xxl-4 mb-5">
                        <div class="card  border-0 h-100">
                            <div class="card-body text-center p-4 p-lg-5 pt-0 pt-lg-0">
                                <div class="feature bg-warning bg-gradient text-white rounded-3 mb-4 mt-n4"><i class="bi bi-collection"></i></div>
                                <h2 class="fs-4 fw-bold ">두시의 데이트</h2>
                                <p class="mb-0"></p>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 col-xxl-4 mb-5">
                        <div class="card border-0 h-100">
                            <div class="card-body text-center p-4 p-lg-5 pt-0 pt-lg-0">
                                <div class="feature bg-warning bg-gradient text-white rounded-3 mb-4 mt-n4"><i class="bi bi-cloud-download"></i></div>
                                <h2 class="fs-4 fw-bold">소통 게시판</h2>
                                 <p class="mb-0"></p>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 col-xxl-4 mb-5">
                        <div class="card  border-0 h-100">
                            <div class="card-body text-center p-4 p-lg-5 pt-0 pt-lg-0">
                                <div class="feature bg-warning bg-gradient text-white rounded-3 mb-4 mt-n4"><i class="bi bi-card-heading"></i></div>
                                <h2 class="fs-4 fw-bold">자유게시판</h2>
                                <p class="mb-0"></p>
                            </div>
                        </div>
                    </div>
                    
                   
                </div>
            </div>
        </section>
        <!-- Footer-->
        <footer class="py-5 bg-dark">
            <div class="container"><p class="m-0 text-center text-white">Copyright &copy; Your Website 2022</p></div>
        </footer>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
    </body>
</html>
