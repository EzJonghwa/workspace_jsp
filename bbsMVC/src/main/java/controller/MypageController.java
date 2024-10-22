package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserService;
import model.UserVO;



@WebServlet("/mypage.do")
public class MypageController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId = null;
		if(req.getSession().getAttribute("userId") != null){
			userId = (String)req.getSession().getAttribute("userId");
			UserService service = UserService.getInstance();
			UserVO vo = service.userInfo(userId);
			req.setAttribute("user",vo);
			req.getRequestDispatcher("/WEB-INF/view/mypage.jsp").forward(req, resp);
		}else{
			//client 에게 login.jsp로 다시 요청하도록 지시
			resp.sendRedirect("login.do");
		}				// 리 다이렉트 - 재요청 지시 = 로그인 페이지로 재요청을 해라
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserService service = UserService.getInstance();
		UserVO vo = new UserVO();
		vo.setUserId(req.getParameter("userId"));
		vo.setUserNm(req.getParameter("userNm"));
		int cnt = service.insertUser(vo);
		if(cnt>0) {
			req.setAttribute("msg", "회원정보 수정완료.");
			req.getRequestDispatcher("/WEB-INF/view/mypage.jsp").forward(req, resp);
				//forward - 전달 해줌
		}else {
			
		}
	}
	
}
