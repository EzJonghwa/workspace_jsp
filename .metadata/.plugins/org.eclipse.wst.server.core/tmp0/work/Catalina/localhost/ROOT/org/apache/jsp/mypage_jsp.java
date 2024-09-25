/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.95
 * Generated at: 2024-09-24 04:44:50 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import jdbc.UserVO;
import jdbc.UserService;

public final class mypage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("jar:file:/C:/dev/workspace-jsp/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/bbs/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1727139007020L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(4);
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.LinkedHashSet<>(3);
    _jspx_imports_classes.add("jdbc.UserVO");
    _jspx_imports_classes.add("jdbc.UserService");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("	<title>mypage</title>\r\n");
      out.write("</head>\r\n");

	String userId = null;
	if(session.getAttribute("userId") != null){
		userId = (String)session.getAttribute("userId");
	}else{
		//client 에게 login.jsp로 다시 요청하도록 지시
		response.sendRedirect("login.jsp");
	}				// 리 다이렉트 - 재요청 지시 = 로그인 페이지로 재요청을 해라
	//user_id 가 있을경우 user의 상세정보를 조회
	UserService service = UserService.getInstance();
	UserVO vo = service.userInfo(userId);
	pageContext.setAttribute("user",vo);


      out.write("\r\n");
      out.write("<body>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/inc/top.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("		\r\n");
      out.write("<!-- content 영역 -->\r\n");
      out.write("      <div class=\"container-fluid\">\r\n");
      out.write("         <div class=\"row align-items-center\" style=\"height:700px\">\r\n");
      out.write("        <div class=\"col-lg-4\"></div>\r\n");
      out.write("        <div class=\"col-lg-4\">\r\n");
      out.write("          <form action=\"joinAction.jsp\" method=\"post\">   <!-- 위에 있던 .needs-validation 추가해준것.-->\r\n");
      out.write("            <h3   style=\"text-align: center; padding-bottom: 5%; padding-top: 15%;\">마이페이지</h3>\r\n");
      out.write("            <div class=\"form-group\">\r\n");
      out.write("              <input type=\"text\" class=\"form-control\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.userId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" disabled class=\"form-control\" placeholder=\"아이디\"  maxlength=\"20\" >\r\n");
      out.write("              <input type=\"hidden\" class=\"form-control\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.userId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" class=\"form-control\" placeholder=\"아이디\" name=\"userId\" maxlength=\"20\" >  \r\n");
      out.write("              <div class=\"invalid-feedback\">  <!-- 필수 입력요소 없을 때 메시지 출력해주는 div-->\r\n");
      out.write("                아이디는 필수입니다.\r\n");
      out.write("              </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"form-group pt-1\">\r\n");
      out.write("              <input type=\"password\" class=\"form-control\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.userPw}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" disabled class=\"form-control\" placeholder=\"비밀번호\" name=\"userPw\" maxlength=\"20\" >\r\n");
      out.write("              <div class=\"invalid-feedback\">\r\n");
      out.write("                비밀번호는 필수입니다.\r\n");
      out.write("              </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"form-group pt-1\" style=\"padding-bottom: 5%;\">\r\n");
      out.write("              <input type=\"text\" class=\"form-control\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.userNm}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" class=\"form-control\" placeholder=\"이름\" name=\"userNm\" maxlength=\"20\" >\r\n");
      out.write("              <div class=\"invalid-feedback\">\r\n");
      out.write("                이름은 필수입니다.\r\n");
      out.write("              </div>\r\n");
      out.write("              <input type=\"submit\" class=\"btn btn-success form-control\" value=\"수정\">\r\n");
      out.write("            </div>\r\n");
      out.write("          </form>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"col-lg-4\">\r\n");
      out.write("        </div>\r\n");
      out.write("         </div>\r\n");
      out.write("       </div>\r\n");
      out.write("<!-- content 영역 끝 -->\r\n");
      out.write("\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/inc/footer.jsp", out, false);
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
