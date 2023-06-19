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

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.minha.model.MemberDao;
import com.minha.model.MemberDto;
import com.minha.utils.ScriptWriter;

@WebServlet("/member/joinProcess")
public class JoinProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JoinProcessController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

//		--cos--
//		DefaultFileRenamePolicy fileRenamePolicy=new DefaultFileRenamePolicy();
//		
//		int fileSize=1024*1024*10;
//		String encoding="utf-8";
//		ServletContext context = this.getServletContext();
//		String savePath="upload";
//		String realPath=context.getRealPath(savePath);
//		
//		MultipartRequest multipartRequest = new MultipartRequest(request, realPath, fileSize, encoding, fileRenamePolicy);

		/*
		int fileSize=1024*1024*10;
		String savePath="C:\\Users\\6A\\Desktop\\upload";
		File currentDir = new File(savePath);
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		diskFileItemFactory.setRepository(currentDir);		//경로 설정
		diskFileItemFactory.setSizeThreshold(fileSize);		//파일 업로드 사이즈
		ServletFileUpload upload = new ServletFileUpload(diskFileItemFactory);
		
		try {
//			List<FileItem> items= upload.parseRequest(request);
			List<FileItem> items= new ArrayList<>();
			Iterator iterator = request.getFileNames();
			while(iterator.hasNext()) {
				for(FileItem fileItem:items) {
					if(fileItem.isFormField()) {
						
					}else {
						//여기에 파일 들어옴. 여기에서 파일 관련된것들 (이름 바꾸기 ..)을 처리함.
						System.out.println("fieldName ==="+fileItem.getFieldName());	//form에서 name값 (profile)
						String originalName = fileItem.getName();	//업로드된 파일 이름
						System.out.println("originalName === "+originalName);
						String extension = originalName.substring(originalName.lastIndexOf("."));
						UUID uuid = UUID.randomUUID();
						System.out.println(uuid);
						String fileName = uuid+extension;
						File uploadPath = new File(currentDir+"\\"+getToday());
						if(!uploadPath.exists()) {
							uploadPath.mkdir();
						}
						fileItem.write(currentDir);
					}
				}
			}

		}catch(Exception e){
			e.printStackTrace();
		}
		
		*/
		
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String userEmail = request.getParameter("userEmail");
		String userPw = request.getParameter("userPw");
		int zonecode=Integer.parseInt(request.getParameter("zonecode"));
		String userAddress = request.getParameter("userAddress");
		String userDetailAddress = request.getParameter("datailAddress");
		String userExtraAddress = request.getParameter("extraAddress");
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
		int result = memberDao.insertMember(memberDto);
		if(result>0) {
			ScriptWriter.alertAndNext(response, "회원가입 되었습니다.", "../member/login");
		}else {
			ScriptWriter.alertAndBack(response, "알 수 없는 오류가 발생 되었습니다. 다시 시도해 주세요");
		}
		
	}
	
	//오늘 날짜 폴더 만드려고 오늘날짜 돌려받는 함수생성
	private String getToday() {
		return new SimpleDateFormat("YYYY-MM-DD").format(System.currentTimeMillis());
	}
}
