package com.minha.controller.member;

import java.io.File;
import java.io.IOException;

import com.minha.model.MemberDao;
import com.minha.model.MemberDto;
import com.minha.utils.ScriptWriter;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/member/modifyProcess")
public class ModifyProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ModifyProcessController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String encoding="utf-8";
		int fileSize=1024*1024*10;
		ServletContext context = this.getServletContext();
		String savePath = "upload";
		String realPath = context.getRealPath(savePath);
		File currentDir = new File(realPath);
		if(!currentDir.exists()) {
			currentDir.mkdir();
		}
	
		DefaultFileRenamePolicy fileRenamePolicy = new DefaultFileRenamePolicy();
		MultipartRequest multipartRequest = new MultipartRequest(request, realPath, fileSize, encoding, fileRenamePolicy);
		
		MemberDao memberDao = new MemberDao();
		MemberDto memberDto= new MemberDto();
		memberDto.setId(multipartRequest.getParameter("userId"));
		memberDto.setPassword(multipartRequest.getParameter("userPw"));
		String userName = multipartRequest.getParameter("userName");
		memberDto.setName(userName);
		memberDto.setEmail(multipartRequest.getParameter("userEmail"));
		memberDto.setZonecode(Integer.parseInt(multipartRequest.getParameter("zonecode")));
		memberDto.setAddress(multipartRequest.getParameter("userAddress"));
		memberDto.setDetailaddress(multipartRequest.getParameter("detailAddress"));
		memberDto.setExtraaddress(multipartRequest.getParameter("extraAddress"));
		
		String orginalFile = multipartRequest.getOriginalFileName("profile");
		String renameFile = multipartRequest.getFilesystemName("profile");
		memberDto.setProfile(orginalFile);
		memberDto.setRealProfile(renameFile);
		
		int result = memberDao.modifyMember(memberDto);
		if(result > 0) {
			HttpSession session = request.getSession();
			session.invalidate();
			ScriptWriter.alertAndNext(response,userName+"님 회원정보가 수정되었습니다. 다시 로그인 해주세요","../member/login");
		}else {
			ScriptWriter.alertAndBack(response, "알수없는 오류 발생");
		}
	}

}
