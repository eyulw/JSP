<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../include/header.jsp" %>
<form action="../member/modifyPasswordProcecss" method="post" class="join" name="pwForm">
<input type="hidden" name="userId" value="${loggedMember.id}"/>
  <div class="container-sm">
    <div class="row justify-content-center">
      <div class="col-6">
        <div class="mb-3">
          <label for="floatingPassword">기존 비밀번호</label>
          <input type="password" name="userPw" class="form-control" id="floatingPassword" placeholder="Password" />
        </div>
        <div class="mb-3">
          <label for="floatingPassword">새 비밀번호</label>
          <input type="password" name="newUserPw" class="form-control" id="floatingPassword" placeholder="Password" />
        </div>
        <div class="mb-3">
          <label for="floatingPassword">새 비밀번호 확인</label>
          <input type="password" name="newUserPw02" class="form-control" id="floatingPassword02" placeholder="Password" />
        </div>
        
        <div class="text-center">
          <button type="submit" class="btn btn-primary btn-lg" id="btnSubmit">비밀번호 변경</button>
        </div>
      </div>
    </div>
  </div>
</form>
<script>
  const pwForm = document.forms.pwForm;
  document btnSubmit = document.querySelector('#btnSubmit');
  btnSubmit.addEventListener("click",(e)=>{
	  if(pwForm.elements.userPw.value.trim()===""){
		  e.preventDefault();
		  alert("비밀번호를 입력해주세요");
		  pwForm.elements.userPw.focus();
	  }else if(pwForm.elements.newUserPw.value.trim()===""){
		  e.preventDefault();
		  alert("새 비밀번호를 입력해주세요");
		  pwForm.elements.newUserPw.focus();
	  }else if (pwForm.elements.newUserPw.value != pwForm.elements.newUserPw02.value) {
	      e.preventDefault();
	      alert("비밀번호가 맞지않습니다.");
	      pwForm.elements.newUserPw02.focus();
	  }else if (pwForm.elements.userPw.value === pwForm.elements.newUserPw.value) {
	      e.preventDefault();
	      alert("기존 비밀번호와 같습니다.");
	      pwForm.elements.newUserPw.focus();
	  } 
  })
</script>
<%@ include file="../include/footer.jsp" %>
