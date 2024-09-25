<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--  디렉티브 page -->
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!--  설정을 가져오는 부분 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
			<!-- 선언부 이 파일 내에서 사용하는 함수들 %!-->
			<%!
				public int multiply(int x, int y){
				return x * y;
				
				
				
				
				
			}
			
			%>
			<!-- 선언부 -->
			
			<!-- 스크립트릿 : 기본 자바 코드 블럭 % -->
			<%
				Date today = new Date();
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				String dateStr = format.format(today);
				int result = multiply(2,10);
			%>
			<!-- 스크립트릿 : 기본 자바 코드 블럭 -->
			
		<h1> Hello ^^ </h1>
		<!--  표현식 : 값을 화면에 출력 %= -->
		<h1> 오늘의 날짜는 : <%=dateStr %></h1>
		<h1> 2 *10 은 : <%=result %></h1>

		
		
</body>
</html>