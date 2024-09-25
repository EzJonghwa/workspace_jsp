package servlet01.com.future;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletMain extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 *  서블릿 라이프 사이클(init() -> service() -> destroy())
		 * 								doGet, doPost
		 */
		System.out.println("main");
		String nm = req.getParameter("nm");
		System.out.println(nm);
		
		resp.setContentType("text/html; charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter();
		out.println("<script>");
		out.println("alert('" + nm + "님 반가워욧^^');");
		out.println("</script>");
	}

}
