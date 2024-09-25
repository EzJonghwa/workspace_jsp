package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.ConnectionPool;

// 비즈니스 로직을 처리하는 부분
public class UserService {
	private UserDAO dao = UserDAO.getInstance();
	private ConnectionPool cp = ConnectionPool.getInstance();
	private static UserService instance = new UserService();
	public static UserService getInstance() {
		return instance;
	}
	private UserService() {};
	
	// 로그인 처리 
	public UserVO loginUser(String id, String pw) {
		System.out.println(id);
		Connection conn = cp.getConnection();
		try {
			UserVO user = dao.loginUser(conn, id);
			// 입력 pw 와 db pw가 같을때 
			if(user.getUserId() != null && user.getUserPw().equals(pw)) {
				return user; 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn != null) cp.releaseConnection(conn); //사용 후 돌려주기
		}
		return null;
	}
	// 회원가입 처리
	public int insertUser(UserVO vo) {
		Connection conn = cp.getConnection();
		try {
			return dao.insertUser(conn, vo);
		} catch (SQLException e) {
			System.out.println(e.toString());
			System.out.println("중복된 아이디");
		} finally {
			if(conn != null) cp.releaseConnection(conn);
		}
		return 0;
	};
	
	public UserVO userInfo(String id) {
		System.out.println(id);
		Connection conn = cp.getConnection();
		try {
			UserVO user = dao.loginUser(conn, id);
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn != null) cp.releaseConnection(conn); //사용 후 돌려주기
		}
		return null;
	}
	public ArrayList<BbsVO> bbsList(){
		Connection conn = cp.getConnection();
		try {
			return dao.bbsList(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(conn != null) cp.releaseConnection(conn);
		}
		return null;
	}
	
	// 회원수정 
	public int updateUser(UserVO vo) {
		Connection conn = cp.getConnection();
		try {
			return dao.updateUser(conn, vo);
		} catch (SQLException e) {
			System.out.println("변경 내역이 없음.");
		} finally {
			if(conn != null) cp.releaseConnection(conn);
		}
		return 0;
	}
	
}
