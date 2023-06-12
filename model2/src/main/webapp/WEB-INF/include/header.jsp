<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!-- ~core에 핵심기능이 많고 core라서 접두어로 c를 주로 사용 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css" />
    <script src="js/bootstrap.bundle.min.js"></script>
    <!-- 주소api -->
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
  </head>
  <body>
    <div class="container">
        <header class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
          <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-body-emphasis text-decoration-none">
            MINHA
          </a>
          	<!-- el :expression language ==> ${loggedMemberId} : 세션지정한거 바로 접근가능 -->
<%--           	${loggedMemberName} --%>
          <ul class="nav nav-pills">
          <%-- 
          <!-- c:set 은 변수지정하는거 -->
          	<c:set var = "name" value= "홍길동"/>
          	<!-- test는 if문의 조건식 -->
            <c:if test="${name eq '김민하'}">
            <c:if test="${loggedMember == null}">
            <c:if test="${empty loggedMember}">
            <li class="nav-item"><a href="login-form.jsp" class="nav-link">login</a></li>
            <li class="nav-item"><a href="join-form.jsp" class="nav-link">join</a></li>
            </c:if>
            <c:if test="${loggedMember != null}">
            <!-- not empty는 null 체크가 안됨 -->
            <c:if test="${not empty loggedMember}">
            <li class="nav-item"><a href="logout.jsp" class="nav-link">logout</a></li>
            <li class="nav-item"><a href="info.jsp" class="nav-link">${loggedMemberName}</a></li>
            </c:if>
             --%>
      		<!-- 같다 다르다따질땐 eq / ne (not equal) -->
            <c:choose>
            	<c:when test="${loggedMember eq null}">
            		<li class="nav-item"><a href="../member/login" class="nav-link">login</a></li>
            		<li class="nav-item"><a href="../member/join" class="nav-link">join</a></li>   
            	</c:when>
            	<c:otherwise>
            		<li class="nav-item"><a href="../member/logout" class="nav-link">logout</a></li>
            		<li class="nav-item"><a href="../member/info?userId=${loggedMember.id}" class="nav-link">${loggedMember.name}</a></li>
            	</c:otherwise>
            </c:choose>
          </ul>
        </header>
    </div>
