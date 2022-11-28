<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="ssi.jsp"%>
<%@ include file="../header.jsp"%>

<!-- 본문 시작 memberProc.jsp-->
<h3>* 회/원/수/정 결과 *</h3>
<%
	//1)사용자가 입력 요청한 값 가져오기
	String id      =request.getParameter("id");
	String passwd  =request.getParameter("passwd");
	String mname   =request.getParameter("mname");
	String email   =request.getParameter("email");
	String tel     =request.getParameter("tel");
	String zipcode =request.getParameter("zipcode");
	String address1=request.getParameter("address1");
	String address2=request.getParameter("address2");
	String job     =request.getParameter("job");

	//2)dto객체 담기
	dto.setId(id);
	dto.setPasswd(passwd);
	dto.setMname(mname);
	dto.setEmail(email);
	dto.setTel(tel);
	dto.setZipcode(zipcode);
	dto.setAddress1(address1);
	dto.setAddress2(address2);
	dto.setJob(job);
	
	//3)member테이블에 추가하기
	int cnt=dao.update(dto); 
    if(cnt==0){
        out.println("<p>회원수정을 실패했습니다</p>");
        out.println(id);
        out.println("<p><a href='javascript:history.back()'>[다시시도]</a></p>");
    }else{
        out.println("<script>");
        out.println("    alert('회원 수정 되었습니다~');");
        out.println("    location.href='../index.jsp'");
        out.println("</script>");
    }//if end	

%>
<!-- 본문 끝 -->           
<%@ include file="../footer.jsp"%>