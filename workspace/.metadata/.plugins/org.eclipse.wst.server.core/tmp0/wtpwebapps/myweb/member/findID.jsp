<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<!-- 본문시작 findID.jsp -->
<h3>* 아이디/비번찾기 *</h3>
<form method="post" action="findIDProc.jsp" onsubmit="return blankCheck()">
<table class="table">
		<tr>
			<td>
			</td>
		    <td>
			   <input type="text" name="mname" id="mname" placeholder="이름" maxlength="10" required>
		    </td>
		    <td rowspan="2">
		    <!-- type=image는 기본속성이 submit -->
			   <input type="image" src="../images/bt_login.gif">		   
		    </td>
		</tr>
		<tr>
			<td>
			</td>
		   <td>
		      <input type="text" name="email" id="email" placeholder="이메일" maxlength="20" required>
		   </td>
		</tr>
</table>
</form>
	<script>
	function blankCheck() {
		let id=document.getElementById("mname").value;
		let email=document.getElementById("email").value;
		id=id.trim();
		email=email.trim();
		if(id.length<=2) {
			alert("이름은 2~5글자 이내로 입력해 주세요");
			return false;
			}// if end
		if(email.length<=10) {
			alert("이메일은 10~20글자 이내로 입력해 주세요");
			return false;
			}//if end
		return true;
	}//blankCheck() end
	</script>
<%@ include file="../footer.jsp" %>
