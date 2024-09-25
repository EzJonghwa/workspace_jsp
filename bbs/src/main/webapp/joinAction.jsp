<%@page import="java.io.PrintWriter"%>
<%@page import="jdbc.UserVO"%>
<%@page import="jdbc.UserService"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:useBean id="user" class="jdbc.UserVO" scope="page"></jsp:useBean>
<jsp:setProperty property="userId" name="user"/>    
<jsp:setProperty property="userPw" name="user"/>    
<jsp:setProperty property="userNm" name="user"/>
<% request.setCharacterEncoding("utf-8"); %>  
<%

    UserService service = UserService.getInstance();
	int cnt = service.insertUser(user);
	
	out.println("<script>");
	if(cnt >0){
		out.println("location.href='login.jsp'; ");
		
	}else{
		out.println("alert('동일 아이디가 존재합니다')");
		out.println("history.back();");
	}
	out.println("</script>");	

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 처리</title>
</head>
<body>

</body>
</html>