<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ include file="ssi.jsp"%>
<%@ include file="../member/auth.jsp" %>
<%@ include file="../header.jsp" %>
    <!-- 본문시작 template.jsp -->
	<h3> 공지사항 목록 </h3><br>
<div class="container">
	<table class="table">
	<thead>
		<tr>
			<th class="success">제목</th>
			<th class="success"><center>조회수</center></th>
			<th class="success"><center>작성자</center></th>
			<th class="success"><center>작성일</center></th>
		</tr>
	</thead>
	<tbody>
<%
// 한 페이지당 출력할 행의 갯수
	int recordPerPage = 10;

	ArrayList<NbsDTO> list=dao.list3(col, word, nowPage, recordPerPage);
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
%>
			<tr>
				<td style="text-align: left">
										
					<a href="nbsRead.jsp?nbsno=<%=dto.getNbsno()%>&col=<%=col%>&word=<%=word%>&nowPage=<%=nowPage%>"><%=dto.getSubject()%></a>
<%
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
%>
				</td>
				<td><%=dto.getReadcnt() %></td>
				<td>관리자</td>
				<td><%=dto.getRegdt().substring(0, 10) %></td>
			</tr>
<%
		}//for end
	}//if end		
		//글갯수
   	    int totalRecord=dao.count2(col, word);                                                        
/*		out.println("<tr>");
		out.println("	<td colspan='4' style='text-align:center;'>");
		out.println("		글갯수:<strong>" + totalRecord + "</strong>");
		out.println("	</td>");
		out.println("</tr>"); */

		out.println("<tr>");
		out.println("	<td colspan='4' style='text-align:center; height: 50px;'>");
		String paging = new Paging().paging3(totalRecord, nowPage, recordPerPage, col, word, "nbsList.jsp");
		out.println(paging);
		out.println("	</td>");
		out.println("</tr>");
%>
		<!-- 검색시작 -->
		<tr>
			<td colspan="4" style='text-align:center; height: 50px;'>
				<form action="nbsList.jsp" onsubmit="return searchCheck()"><!-- myscript.js 함수 작성함 -->
					<select name="col">
						<option value="subject_content">제목+내용
						<option value="subject">제목
						<option value="content">내용
						<option value="wname">작성자
					</select>
					<input type="text" name="word" id="word">
					<input type="submit" value="검색" class="btn btn-primary">
					<%if(s_mlevel.equals("A1")){ %>
					<input type="button" style="float: right;" class="btn btn-primary" onclick="location.href='nbsForm.jsp'" value="글쓰기">
					<%      }//if end  %>
				</form>
			</td>
		</tr>
		<!-- 검색끝 -->


	</tbody>
	</table>
</div>	
    <!-- 본문 끝 -->
<%@ include file="../footer.jsp"%>