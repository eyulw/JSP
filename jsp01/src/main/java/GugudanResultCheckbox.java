

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GugudanResultCheckbox")
public class GugudanResultCheckbox extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GugudanResultCheckbox() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dans[] = request.getParameterValues("dan");
//		System.out.println(dans[0]);
//		System.out.println(dans[1]);
//		System.out.println(dans[2]);
		for(String item:dans) {
			System.out.println(item);
		}
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\'UTF-8\'>");
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body>");
//		
		for(int i=0; i<dans.length;i++) {
			int dan = Integer.parseInt(dans[i]);
			out.println("<h1>"+dan+"단을 출력합니다.</h1>");
			for(int j=1; j<10; j++) {
				out.println("<p>"+dan+"x"+j+"="+dan*j+"</p>");
			}
		}
//		
		out.println("<a href='javascript:history.back()'>뒤로가기</a>");
		out.println("<a href='GugudanForm'>GugudanForm</a>");
		out.println("</body>");
		out.println("</html>");
	}

}
