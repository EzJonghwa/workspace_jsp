package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserService;
import model.UserVO;
@WebServlet({"/login.do","/logout.do"})
// login.do = 우리가 정한 방법 
public class LoginController extends HttpServlet{
// get  요청과  post 분할하기 위해 override 에서 doGet 과 doPost 만 체크후 실행
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathString = req.getServletPath();
		if("/login.do".equals(pathString)) {
			String userId = (String)req.getSession().getAttribute("userId");
			if(userId != null) {
				// 세션에 유저정보가 있으면 index.jsp 페이지로 보냄 (로그인 할 피룡가 없으니_)
				resp.sendRedirect("index.jsp"); 	//redirect 는 클라이언트에게 다시 요청하라고전달
				// web app 안에 있기에 바로 접근이 가능하지만
			}else {
				// forward 는 정보를 해당 페이지로 전달 (req,resp 객체를 로그인 페이지로 전달함_)
				req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, resp);
				// inf 는 바로 접근이 어려워 경로를 적어줌
			}
			
		}else if("/logout.do".equals(pathString)) {
			HttpSession session = req.getSession();
			session.invalidate();
			resp.sendRedirect("index.jsp");
		}
		
	}
// 공총적으로 세션 관리를 할시 web.xml에 시간 추가해 관리가능
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("post 로 요청옴");
		UserService service = UserService.getInstance();
		UserVO vo = service.loginUser(req.getParameter("userId"),req.getParameter("userPw"));
		
		if (vo !=null) {
			HttpSession session = req.getSession();
			session.setAttribute("userId", vo.getUserId());
			resp.sendRedirect("index.jsp"); // session은 유지됨
		}else {
			resp.sendRedirect("login.do");
		}
	}
	
}
