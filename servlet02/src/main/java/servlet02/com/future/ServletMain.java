package servlet02.com.future;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/main")	// url mappjing
public class ServletMain extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset-utf8");
		resp.setCharacterEncoding("utf-8");
		
		System.out.println("main");
		OutputStream os = resp.getOutputStream();
		PrintStream out = new PrintStream(os,true);
		out.println("main 화면 입니다.");
	}

}
