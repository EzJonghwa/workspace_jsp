package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BbsVO;
import model.UserService;
@WebServlet("/bbs.do")
public class BbsController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserService service = UserService.getInstance();
		ArrayList<BbsVO> arrayList = service.bbsList();
		req.setAttribute("arr", arrayList);
		req.getRequestDispatcher("/WEB-INF/view/bbs.jsp").forward(req, resp);
	}

}
