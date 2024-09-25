package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserService;
import model.UserVO;
@WebServlet("/join.do")
public class JoinController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/view/join.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserService service = UserService.getInstance();
		UserVO vo = new UserVO();
		vo.setUserId(req.getParameter("userId"));
		vo.setUserPw(req.getParameter("userPw"));
		vo.setUserNm(req.getParameter("userNm"));
		int cnt = service.insertUser(vo);
		if(cnt>0) {
			req.setAttribute("msg", "회원가입이 되셨습니다.");
				// msg 라는 키 값에 넣어줌
			req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, resp);
				//forward - 전달 해줌
		}else {
			resp.sendRedirect("join.do");
		}
	}

}
