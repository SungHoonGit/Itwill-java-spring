/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.67
 * Generated at: 2022-10-31 09:17:28 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.bbs;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.io.*;
import java.util.*;
import net.utility.*;
import net.bbs.*;

public final class bbsList_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/bbs/ssi.jsp", Long.valueOf(1666243699450L));
    _jspx_dependants.put("/bbs/../header.jsp", Long.valueOf(1666831450311L));
    _jspx_dependants.put("/bbs/../../footer.jsp", Long.valueOf(1665462013456L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("java.sql");
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("java.io");
    _jspx_imports_packages.add("net.utility");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_packages.add("net.bbs");
    _jspx_imports_classes = null;
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

      out.write("    \r\n");
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      net.bbs.BbsDAO dao = null;
      dao = (net.bbs.BbsDAO) _jspx_page_context.getAttribute("dao", javax.servlet.jsp.PageContext.PAGE_SCOPE);
      if (dao == null){
        dao = new net.bbs.BbsDAO();
        _jspx_page_context.setAttribute("dao", dao, javax.servlet.jsp.PageContext.PAGE_SCOPE);
      }
      out.write('\r');
      out.write('\n');
      net.bbs.BbsDTO dto = null;
      dto = (net.bbs.BbsDTO) _jspx_page_context.getAttribute("dto", javax.servlet.jsp.PageContext.PAGE_SCOPE);
      if (dto == null){
        dto = new net.bbs.BbsDTO();
        _jspx_page_context.setAttribute("dto", dto, javax.servlet.jsp.PageContext.PAGE_SCOPE);
      }
      out.write("\r\n");
      out.write("\r\n");
request.setCharacterEncoding("UTF-8"); 
      out.write("\r\n");
      out.write("\r\n");

//검색
	String word=request.getParameter("word");//검색어
	String col =request.getParameter("col");//검색칼럼
	word=Utility.checkNull(word);	// 문자열값이 null이면 빈문자열로 치환
	col=Utility.checkNull(col);
	
	//현재페이지-------------------------------------------------
	int nowPage=1;
	if(request.getParameter("nowPage")!=null){
	    nowPage=Integer.parseInt(request.getParameter("nowPage"));
	}//if end

      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"ko\">\r\n");
      out.write("<head>\r\n");
      out.write("  <!-- Theme Made By www.w3schools.com - No Copyright -->\r\n");
      out.write("  <title>index.jsp</title>\r\n");
      out.write("  <meta charset=\"utf-8\">\r\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\r\n");
      out.write("  <link href=\"https://fonts.googleapis.com/css?family=Montserrat\" rel=\"stylesheet\">\r\n");
      out.write("  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js\"></script>\r\n");
      out.write("  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>\r\n");
      out.write("  \r\n");
      out.write("  <!-- 사용자 정의 스타일과 자바스크립트 -->\r\n");
      out.write("  <!-- 주의사항 : CSS와 JS는 각 웹브라우저에서 쿠키삭제하고 확인할것 -->\r\n");
      out.write("  <!-- layout.css import -->\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"../css/layout.css\">\r\n");
      out.write("  <script src=\"../js/myscript.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<!-- 메인 카테고리 시작 -->\r\n");
      out.write("<nav class=\"navbar navbar-default\">\r\n");
      out.write("  <div class=\"container\">\r\n");
      out.write("    <div class=\"navbar-header\">\r\n");
      out.write("      <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#myNavbar\">\r\n");
      out.write("        <span class=\"icon-bar\"></span>\r\n");
      out.write("        <span class=\"icon-bar\"></span>\r\n");
      out.write("        <span class=\"icon-bar\"></span>                        \r\n");
      out.write("      </button>\r\n");
      out.write("      <a class=\"navbar-brand\" href=\"");
      out.print(request.getContextPath());
      out.write("/index.jsp\">HOME</a>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"collapse navbar-collapse\" id=\"myNavbar\">\r\n");
      out.write("      <ul class=\"nav navbar-nav navbar-right\">\r\n");
      out.write("        <li><a href=\"../bbs/bbsList.jsp\">게시판</a></li>\r\n");
      out.write("        <li><a href=\"../nbs/nbsList.jsp\">공지사항</a></li>\r\n");
      out.write("        \r\n");
      out.write("	");
if(session.getAttribute("s_id")==null){
		
      out.write("  <li><a href=\"../member/LoginForm.jsp\">로그인</a></li>	");

	} else { 
      out.write("<li><a href=\"../member/LoginForm.jsp\">로그아웃</a></li> ");
} 
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <li><a href=\"../pds/pdsList.jsp\">포토갤러리</a></li>\r\n");
      out.write("        <li><a href=\"../mail/mailForm.jsp\">메일보내기</a></li>\r\n");
      out.write("      </ul>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("</nav>\r\n");
      out.write("\r\n");
      out.write("<!-- Contents 시작 -->\r\n");
      out.write("<div class=\"container-fluid bg-3 text-center\">\r\n");
      out.write("  <div class=\"row\">\r\n");
      out.write("    <div class=\"col-xs-12\">\r\n");
      out.write("\r\n");
      out.write("    <!-- 본문시작 template.jsp -->\r\n");
      out.write("	<h3> 글목록 </h3><br>\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("	<table class=\"table\">\r\n");
      out.write("	<thead>\r\n");
      out.write("		<tr>\r\n");
      out.write("			<th class=\"success\">제목</th>\r\n");
      out.write("			<th class=\"success\"><center>조회수</center></th>\r\n");
      out.write("			<th class=\"success\"><center>작성자</center></th>\r\n");
      out.write("			<th class=\"success\"><center>작성일</center></th>\r\n");
      out.write("		</tr>\r\n");
      out.write("	</thead>\r\n");
      out.write("	<tbody>\r\n");

// 한 페이지당 출력할 행의 갯수
	int recordPerPage = 10;

	ArrayList<BbsDTO> list=dao.list3(col, word, nowPage, recordPerPage);
	if(list==null){
	out.println("<tr>");
	out.println("	<td colspn='4'>");
	out.println("		<strong>관련자료 없음!!</strong>");
	out.println("	</td>");
	out.println("</tr>");
	}else{
		
		// 오늘 날짜를 문자열 "2022-10-22" 만들기
		String today=Utility.getDate();
		
		for(int i=0; i<list.size(); i++) {
			dto=list.get(i);

      out.write("\r\n");
      out.write("			<tr>\r\n");
      out.write("				<td style=\"text-align: left\">\r\n");
 
					// 답변이미지 출력
					for(int n=1; n<=dto.getIndent(); n++) {
						out.println("<img src='../images/reply.gif'>");
					}//for end

      out.write("												\r\n");
      out.write("					<a href=\"bbsRead.jsp?bbsno=");
      out.print(dto.getBbsno());
      out.write("&col=");
      out.print(col);
      out.write("&word=");
      out.print(word);
      out.write("&nowPage=");
      out.print(nowPage);
      out.write('"');
      out.write('>');
      out.print(dto.getSubject());
      out.write("</a>\r\n");

					// 오늘 작성한 글제목 뒤에 new 이미지 출력
					// 작성일(regdt)에서 "년원일"만 자르기
					String regdt=dto.getRegdt().substring(0, 10);
					if(regdt.equals(today)){ // 작성일과 오늘날짜가 같다면
						out.println("<img src='../images/new.gif'>");
					}// if end
					
					//조회수가 10이상이면 hot 이미지 출력
					if(dto.getReadcnt()>=10){
						out.println("<img src='../images/hot.gif'>");
					}// if end

      out.write("\r\n");
      out.write("				</td>\r\n");
      out.write("				<td>");
      out.print(dto.getReadcnt() );
      out.write("</td>\r\n");
      out.write("				<td>");
      out.print(dto.getWname() );
      out.write("</td>\r\n");
      out.write("				<td>");
      out.print(dto.getRegdt().substring(0, 10) );
      out.write("</td>\r\n");
      out.write("			</tr>\r\n");
      out.write("\r\n");

		}//for end
	   }//if end
		//글갯수
   	    int totalRecord=dao.count2(col, word);                                                        
 /* 	out.println("<tr>");
		out.println("	<td colspan='4' style='text-align:center;'>");
		out.println("		글갯수:<strong>" + totalRecord + "</strong>");
		out.println("	</td>");
		out.println("</tr>");
 */
		out.println("<tr>");
		out.println("	<td colspan='4' style='text-align:center; height: 50px;'>");
		String paging = new Paging().paging3(totalRecord, nowPage, recordPerPage, col, word, "bbsList.jsp");
		out.println(paging);
		out.println("	</td>");
		out.println("</tr>");

      out.write("\r\n");
      out.write("		<!-- 검색시작 -->\r\n");
      out.write("		<tr>\r\n");
      out.write("			<td colspan=\"4\" style='text-align:center; height: 50px;'>\r\n");
      out.write("				<form action=\"bbsList.jsp\" onsubmit=\"return searchCheck()\"><!-- myscript.js 함수 작성함 -->\r\n");
      out.write("					<select name=\"col\">\r\n");
      out.write("						<option value=\"subject_content\">제목+내용\r\n");
      out.write("						<option value=\"subject\">제목\r\n");
      out.write("						<option value=\"content\">내용\r\n");
      out.write("						<option value=\"wname\">작성자\r\n");
      out.write("					</select>\r\n");
      out.write("					<input type=\"text\" name=\"word\" id=\"word\">\r\n");
      out.write("					<input type=\"submit\" value=\"검색\" class=\"btn btn-primary\">\r\n");
      out.write("					<input type=\"button\" style=\"float: right;\" class=\"btn btn-primary\" onclick=\"location.href='bbsForm.jsp'\" value=\"글쓰기\">\r\n");
      out.write("				</form>\r\n");
      out.write("			</td>\r\n");
      out.write("		</tr>\r\n");
      out.write("		<!-- 검색끝 -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("	</tbody>\r\n");
      out.write("	</table>\r\n");
      out.write("</div>	\r\n");
      out.write("    <!-- 본문 끝 -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </div> <!-- col 끝 -->\r\n");
      out.write("  </div> <!-- row 끝 -->\r\n");
      out.write("</div> <!-- Contents 끝 -->\r\n");
      out.write("\r\n");
      out.write("<!-- Footer -->\r\n");
      out.write("<footer class=\"container-fluid bg-4 text-center\">\r\n");
      out.write("  COpyrighy &copy; 2022 MYWEB \r\n");
      out.write("</footer>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
