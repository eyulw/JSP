<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container-sm mt-5">
  <table class="table">
    <tbody>
      <tr>
        <th scope="row">ID</th>
        <td><c:out value="${memberInfoDto.id}"></c:out></td>
      </tr>
      <tr>
        <th scope="row">Name</th>
        <td><c:out value="${memberInfoDto.name}"></c:out></td>
      </tr>
      <tr>
        <th scope="row">Email</th>
        <td><c:out value="${memberInfoDto.email}"></c:out></td>
      </tr>
      <tr>
        <th scope="row">주소</th>
        <td><c:out value="${memberInfoDto.address}"></c:out> / <c:out value="${detailAddress}"></c:out></td>
      </tr>
      <tr>
        <th scope="row">우편번호</th>
        <td><c:out value="${zonecode}"></c:out></td>
      </tr>
    </tbody>
  </table>
    <div class="mt-5">
    <a href="../member/modify" class="btn btn-info">회원 정보 수정</a>
    <a href="../member/modifyPassword" class="btn btn-info">비밀번호 변경</a>
    <a href="../member/delete" class="btn btn-danger">회원 탈퇴</a>
  </div>
</div>

<%@ include file="../include/footer.jsp" %>
