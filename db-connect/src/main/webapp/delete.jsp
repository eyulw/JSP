<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="include/header.jsp" %>
  <form action="delete-process.jsp" method="post">
    <div class="container-sm">
      <div class="row justify-content-center">
        <div class="col-6">
          <div class="form-floating mb-3">
            <input type="text" name="userId" class="form-control" id="floatingInput" placeholder="아이디를 입력해 주세요" 
            value="<%=session.getAttribute("loggedUserId") %>" readonly/>
            <label for="floatingInput">ID</label>
          </div>
          <div class="form-floating mb-5">
            <input type="password" name="userPw" class="form-control" id="floatingPassword" placeholder="Password" />
            <label for="floatingPassword">Password</label>
          </div>
          <div class="text-center">
            <button type="submit" class="btn btn-primary btn-lg">탈퇴하기</button>
          </div>
        </div>
      </div>
    </div>
  </form>
<%@ include file="include/footer.jsp" %>