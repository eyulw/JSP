package com.minha.controller.member;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.minha.model.MemberDao;
import com.minha.model.MemberDto;
import com.minha.utils.ScriptWriter;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/member/joinProcess")
public class JoinProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JoinProcessController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String encoding="utf-8";
		int fileSize=1024*1024*10;
		ServletContext context =this.getServletContext();	//file명 그대로 넘어옴
		String savePath="upload";
		String realPath = context.getRealPath(savePath);
		File currentDir = new File(realPath);
		System.out.println("realPath === "+realPath);
		if(!currentDir.exists()) {
			currentDir.mkdir();
		}
		DefaultFileRenamePolicy fileRenamePolicy = new DefaultFileRenamePolicy();
		
		
		MultipartRequest multipartRequest = new MultipartRequest(request, realPath, fileSize, encoding, fileRenamePolicy);

//		request --> multipartRequest
		
		String userId = multipartRequest.getParameter("userId");
		String userName = multipartRequest.getParameter("userName");
		String userEmail = multipartRequest.getParameter("userEmail");
		String userPw = multipartRequest.getParameter("userPw");
		int zonecode=Integer.parseInt(multipartRequest.getParameter("zonecode"));
		String userAddress = multipartRequest.getParameter("userAddress");
		String userDetailAddress = multipartRequest.getParameter("datailAddress");
		String userExtraAddress = multipartRequest.getParameter("extraAddress");
		
		String orginalFile = multipartRequest.getOriginalFileName("profile");	//보여지는 파일명
		String renameFile = multipartRequest.getFilesystemName("profile");		//fileRenamePolicy로 바껴진 이름, 이미지쓸거면 이걸 써야함
		
		
		MemberDao memberDao = new MemberDao();
		MemberDto memberDto = new MemberDto();
		memberDto.setId(userId);
		memberDto.setPassword(userPw);
		memberDto.setName(userName);
		memberDto.setEmail(userEmail);
		memberDto.setZonecode(zonecode);
		memberDto.setAddress(userAddress);
		memberDto.setDetailaddress(userDetailAddress);
		memberDto.setExtraaddress(userExtraAddress);
		memberDto.setProfile(orginalFile);
		memberDto.setRealProfile(renameFile);
		int result = memberDao.insertMember(memberDto);
		if(result>0) {
			ScriptWriter.alertAndNext(response, "회원가입 되었습니다.","../member/login");
		}else {
			ScriptWriter.alertAndBack(response, "알 수 없는 오류가 발생 되었습니다. 다시 시도해 주세요");
		}
		
	}
	
	//오늘 날짜 폴더 만드려고 오늘날짜 돌려받는 함수생성
	private String getToday() {
		return new SimpleDateFormat("YYYY-MM-DD").format(System.currentTimeMillis());
	}
}
