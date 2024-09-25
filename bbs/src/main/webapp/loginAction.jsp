<%@page import="java.io.PrintWriter"%>
<%@page import="jdbc.UserVO"%>
<%@page import="jdbc.UserService"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:useBean id="user" class="jdbc.UserVO" scope="page"></jsp:useBean>
<jsp:setProperty property="userId" name="user"/>    
<jsp:setProperty property="userPw" name="user"/>    
<%

   UserService service = UserService.getInstance();
//   UserVO vo = service.loginUser(request.getParameter("userId")
//                        , request.getParameter("userPw"));
   UserVO vo = service.loginUser(user.getUserId()
                        , user.getUserPw());
   System.out.println(vo);
   PrintWriter script = response.getWriter();
   script.println("<script>");
   if(vo != null){
	   /* todo  세션 등록처리*/
	   session.setAttribute("userId", user.getUserId());
	   session.setMaxInactiveInterval(5*60); //5분 디폴트 30분
      /*todo 세션 등록처리*/
      script.println("' " + vo.getUserNm()+" 님 환영! '; ");
      script.println("location.href='main.jsp'; ");
      
   }else{
      script.println("alert('아이디/비번을 확인하세요')");
      script.println("history.back();");   //뒤로가기
   }
   script.println("</script>");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 처리</title>
</head>
<body>

</body>
</html>