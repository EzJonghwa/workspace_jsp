<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>
<%@page import="java.sql.Connection" %>
<%@page import="java.sql.DriverManager" %>
<%@page import="java.sql.PreparedStatement" %>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.SQLException" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

		<%! ArrayList<String> list = new ArrayList<>();%>
		
		<%
		
		Connection conn = null;
		
		PreparedStatement ps =null;
		
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 등록 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("등록 실패");
			e.printStackTrace();
			System.exit(0); // 프로그램 종료
		}
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String db_id ="java";
		String db_pw ="oracle";
		try {
			conn = DriverManager.getConnection(url,db_id,db_pw);
			System.out.println("접속 성공");
			
			StringBuffer query = new StringBuffer();
			query.append("SELECT info_no");
			query.append("		,nm");
			query.append("		,email");
			query.append("		,hobby");
			query.append(" FROM tb_info");
			query.append(" WHERE nm LIKE ? ||'%' ");
			System.out.println(query);
			
			ps = conn.prepareStatement(query.toString());
			ps.setString(1,"김");
			rs = ps.executeQuery();	// 쿼리문 실행
			
			 while(rs.next()) {
		          int no = rs.getInt("info_no");
		          String nm = rs.getString("nm");
		          String email = rs.getString("email");
		          String hobby = rs.getString("hobby");
		          
		          System.out.println("no:" +no+ "nm:" +nm
		          + "email:" + email+ "hobby:" +hobby);
		          list.add(nm);
		          
		          
		       }

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// connection 객체를 꼭 닫아야함
			// 안 닫으면 계속 쌓여서 에러 발생
				if(rs != null) {try {rs.close();} catch(SQLException e) {e.printStackTrace();}}
				if(ps != null) {try {ps.close();} catch(SQLException e) {e.printStackTrace();}}
				if(conn != null) {try {conn.close();} catch(SQLException e) {e.printStackTrace();}}
		}
		
		
		%>
		<h1>학생</h1>
		<ul>
		<%
			for(int i =0; i<list.size(); i++){
		%>
		<li>이름 : <%=list.get(i) %></li>
		<%
			}
		%>
		
		
		</ul>


</body>
</html>