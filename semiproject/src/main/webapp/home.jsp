<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <!-- Header-->
        <header class="">
            <div class="container px-lg-5">
                <div class="p-4 p-lg-5  rounded-3 text-center">
                    <div class="m-4 m-lg-5">
                        
                        <h1 class="display-5 fw-bold" style="font-size: 3cm">에브리코스타임</h1>
                       
                        
                        <form>
                        <p class="fs-4"></p>
                        <a class="btn btn-warning " style="background-color: #FFD700;border: 0px; width: 150px 100px;align-content: center; " href="HomeController.do" onclick="openPopup()">에.코.타와 함께하기</a>
                  	 </form>
                  	 <script type="text/javascript">
                  	 function openPopup(){
                  		 window.open("RegisterMemberFormController.do", "join", "width=300, height=300, left=200, top=100");
                  	 }
                  	 </script>
                  	 
                    </div>
                    
            </div>
        </header>
        <br>
        <!-- Page Content-->
        <section class="pt-4">
            <div class="container px-lg-5">
                <!-- Page Features-->
                <div class="row gx-lg-5">
                    <div class="col-lg-6 col-xxl-4 mb-5">
                        <div class="card  border-0 h-100">
                            <div class="card-body text-center p-4 p-lg-5 pt-0 pt-lg-0">
                                <div class=""><img src="images/2pm_logo.png" width="100" ></div>
                                <br>
                                <a href="ListController.do" style="font-size: 0.7cm;text-decoration: none;color: black">두시의 데이트</a>
                                <p class="mb-0"></p>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 col-xxl-4 mb-5">
                        <div class="card border-0 h-100">
                            <div class="card-body text-center p-4 p-lg-5 pt-0 pt-lg-0">
                                <div class=""><img src="images/threeperson_logo.png" width="100"></div>
                                <br>
                                <a href=".do" style="font-size: 0.7cm;text-decoration: none;color: black">소통게시판</a>
                                 <p class="mb-0"></p>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 col-xxl-4 mb-5">
                        <div class="card  border-0 h-100">
                            <div class="card-body text-center p-4 p-lg-5 pt-0 pt-lg-0">
                                <div class=""><img src="images/free_logo.png" width="100"></div>
                                <br>
                                <a href=".do" style="font-size: 0.7cm;text-decoration: none;color: black">자유게시판</a>
                                <p class="mb-0"></p>
                            </div>
                        </div>
                    </div>
                    
                   
                </div>
            </div>
        </section>

