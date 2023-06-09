<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css" />
    <link href="../summernote/summernote-lite.css" rel="stylesheet">
    <link rel="stylesheet" href="../css/layout.css">
    
    <script src="../js/jquery-3.7.0.min.js"></script>
    <script src="js/bootstrap.bundle.min.js"></script>
    <script src="../summernote/summernote-lite.js"></script>
    <!-- 주소api -->
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
  </head>
  <body>
    <div class="container">
        <header class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
          <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-body-emphasis text-decoration-none">
            MINHA
          </a>
          <ul class="nav nav-pills gnb">
            <c:choose>
            	<c:when test="${loggedMember eq null}">
            		<li class="nav-item"><a href="../member/login" class="nav-link">login</a></li>
            		<li class="nav-item"><a href="../member/join" class="nav-link">join</a></li> 
            		<li class="nav-item"><a href="../board/list" class="nav-link">게시판</a></li>   
            	</c:when>
            	<c:otherwise>
            		<li class="nav-item"><a href="../member/logout" class="nav-link">logout</a></li>
    		        <li class="nav-item"><a href="../board/list" class="nav-link">게시판</a></li>
    		        <li class="nav-item"><a href="../board/write" class="nav-link">글쓰기</a></li>
    		        <li class="nav-item">
            			<a href="../member/info?userId=${loggedMember.id}" class="nav-link">
            				<div class="profileBox">
            					<c:choose>
		            				<c:when test="${loggedMember.realProfile eq null}">
			            				<img src="${pageContext.request.contextPath}/upload/default.png" class="profile"/>
			            					${loggedMember.name}
		            				</c:when>
		            				<c:otherwise>
		            					<img src="${pageContext.request.contextPath}/upload/${loggedMember.realProfile}" class="profile"/>
		            						${loggedMember.name}
	            					</c:otherwise>
            					</c:choose>
            				</div>
            			</a>
            		</li>   
            	</c:otherwise>
            </c:choose>
          </ul>
        </header>
    </div>
