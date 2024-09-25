<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>mypage</title>
</head>

<body>
<jsp:include page="/WEB-INF/inc/top.jsp"></jsp:include>

		
<!-- content 영역 -->
  <div class="container-fluid">
    <div class="row align-items-center" style="height:700px">
      <div class="col-lg-4"></div>
      <div class="col-lg-4">
        <form action="mypage.do" method="post" >
          <h3 style="text-align: center; padding-bottom: 5%; padding-top: 15%;">마이페이지</h3>
          <div class="form-group">
            <input type="text" value="${user.userId}" disabled class="form-control"
                    placeholder="아이디" maxlength="20" >
            <input type="hidden" value="${user.userId}" class="form-control"
                    placeholder="아이디" name="userId" maxlength="20" >
          </div>
          <div class="form-group pt-1">
            <input type="password" value="${user.userPw}" disabled class="form-control" placeholder="비밀번호" name="userPw" maxlength="20" >
          </div>
          <div class="form-group pt-1" style="padding-bottom: 5%;">
            <input type="text" value="${user.userNm }" class="form-control" placeholder="이름" name="userNm" maxlength="20" >
          </div>
          <input type="submit" class="btn btn-success form-control" value="수정">
        </form>
      </div>
      <div class="col-lg-4">
      </div>
    </div>
  </div>
  <!-- content 영역 끝 -->   
   

<jsp:include page="/WEB-INF/inc/footer.jsp"></jsp:include>
</body>
</html>