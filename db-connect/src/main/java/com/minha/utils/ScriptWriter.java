package com.minha.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class ScriptWriter {
	//클래스 생성하지않고 바로 사용하기위해 static함수로 설정	
	public static void alert(HttpServletResponse response, String alertMsg) throws IOException {
		response.setContentType("text/html; charset = utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>alert('"+alertMsg+"')</script>");
	}
	public static void alertAndBack(HttpServletResponse response, String alertMsg) throws IOException {
		response.setContentType("text/html; charset = utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>alert('"+alertMsg+"');history.back();</script>");
	}
	public static void alertAndNext(HttpServletResponse response, String alertMsg,String next) throws IOException {
		response.setContentType("text/html; charset = utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>alert('"+alertMsg+"');location.href='"+next+"';</script>");
	}
}
