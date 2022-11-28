/**
 * myscript.js
 */
 
 
 function bbsCheck(){ // 게시판 유효성 검사
 	// 1) 작성자	2글자 이상 입력
 	let wname=document.getElementById("wname").value;	// 작성자 가져오기
	wname=wname.trim();
	if(wname.length<2){ 
		alert("작정자 2글자 이상 입력해 주세요.");
		document.getElementById("wname").focus();	// 작성자 칸에 커서 생성
		return false;
	}// if end
 	// 2) 제목	2글자 이상 입력
 	let subject=document.getElementById("subject").value;	// 제목 가져오기
	subject=subject.trim();
	if(subject.length<2){ 
		alert("제목 2글자 이상 입력해 주세요.");
		document.getElementById("subject").focus();	// 제목 칸에 커서 생성
		return false;
	}// if end
 	// 3) 내용	2글자 이상 입력
	 let content=document.getElementById("content").value;	// 내용 가져오기
	 content=content.trim();
	 if(content.length<2){ 
		 alert("내용 2글자 이상 입력해 주세요.");
		 document.getElementById("content").focus();	// 내용 칸에 커서 생성
		 return false;
	 }// if end
 	// 4) 비밀번호	4글자 이상이면서, 숫자형 기호만 입력
 	let passwd=document.getElementById("passwd").value;	// 작성자 가져오기
	 passwd=passwd.trim();
	if(passwd.length<4 || isNaN(passwd)){ 
		alert("비밀번호 4글자 이상 숫자로 입력해 주세요.");
		document.getElementById("passwd").focus();	// 작성자 칸에 커서 생성
		return false;
	}// if end
	return true;	// onsubmit이벤트에서 서버로 전송	
}// bbsCheck() end


function pwCheck(){
	 	let passwd=document.getElementById("passwd").value;	// 작성자 가져오기
	 passwd=passwd.trim();
	if(passwd.length<4){ 
		alert("비밀번호 4글자 이상 숫자로 입력해 주세요.");
		document.getElementById("passwd").focus();	// 작성자 칸에 커서 생성
		return false;
	}// if end
	
	let message="진행된 내용은 복구되지 않습니다.\n계속 진행할까요?";
	if(confirm(message)){	// 확인 true, 취소 false
		return true;	// 서버로 전송	
	}else{
		return false;
	}//if end
}//pwCheck() end


function searchCheck() {
	// 검색이름 입력해야만 서버로 전송
	let word=document.getElementById("word").value;
	word=word.trim();
	if(word.length==0){
		alert("검색어를 입력해 주세요.")
		return false;
	}//if end
	return true;
}// searchCheck()end


function loginCheck() { // 로그인 유효성 검사 (아이디, 비번)
	//1) 아이디 5~10글자 이내인지 검사
	let id=document.getElementById("id").value;
	id=id.trim();
	if(!(id.length>=5 && id.length<=10)) {
		alert("아이디 5~10글자이내 입력해 주세요");
		document.getElementById("id").focus();
		return false;
	}// if end
	
	//2) 비밀번호 5~10글자 이내인지 검사
	let passwd=document.getElementById("passwd").value; 
	passwd=passwd.trim();
	if(!(passwd.length>=5 && passwd.length<=10)) {
				alert("비밀번호 5~10글자이내 입력해 주세요");
		document.getElementById("passwd").focus();
		return false;
	}// if end
}// loginCheck() end


function idCheck() { // 아이디 중복확인
	
	// 모달창
	// -> 부모창과 자식창이 한몸으로 구성되어있는것
	// -> 참조 https://www.w3schools.com/bootstrap/bootstrap_modal.asp
	
	// 새창만들기
	// -> 부모창과 자식창이 별개로 구성되어 있음
	// -> 모바일에 기반을 둔 FRONTEND단에서는 사용하지 말것!
	// -> 참조 https://www.w3schools.com/jsref/met_win_open.asp
	window.open("idCheckForm.jsp", "idwin", "width=400,height=350")
	
	
}// idCheck() end


function emailCheck() { // 이메일 중복확인
	
	window.open("emailCheckForm.jsp", "emailwin", "width=400,height=350")
	
}// idCheck() end



function memberCheck(){ //회원가입 유효성 검사
    //1)아이디 5~10글자 인지?
	var id=document.getElementById("id").value;
	id=id.trim();
	if(!(id.length>=5 && id.length<=10)){
		alert("아아디 5~20글자이내 입력해 주세요");
		document.getElementById("id").focus();
		return false;		
	}//if end	
	
    //2)비밀번호 5~10글자 인지?
    var passwd=document.getElementById("passwd");
	passwd=passwd.value.trim();
	if(!(passwd.length>=5 && passwd.length<=10)){
		alert("비밀번호 5~20글자이내 입력해 주세요");
		document.getElementById("passwd").focus();
		return false;		
	}//if end
	
    //3)비밀번호와 비밀번호확인이 서로 일치하는지?
	var repasswd=document.getElementById("repasswd").value;
	repasswd=repasswd.trim();
	if(passwd!=repasswd){
	    alert("비밀번호 2개를 똑같이 입력해 주세요");
	    document.getElementById("passwd").focus();
	    return false;
	}//if end

    //4)이름 두글자 이상 인지?
  	var mname=document.getElementById("mname").value;
	mname=mname.trim();
	if(mname.length<=1){
	    alert("이름 두글자 이상 입력해 주세요");
	    document.getElementById("mname").focus();
	    return false;
	}//if end 

    //5)이메일 5글자 인지?
	var email=document.getElementById("email").value;
	email=email.trim();
	if(email.length<5){
	    alert("이메일 5글자 이상 입력해 주세요");
	    document.getElementById("email").focus();
	    return false;
	}//if end

    //6)직업을 선택했는지?
	var job=document.getElementById("job").value;
	if(job=="0"){
	    alert("직업 선택해 주세요");
	    return false;
	}//if end

	return true;//서버로 전송

}//memberCheck() end


function pdsCheck() {	// 포토갤러리 유효성 검사
	// 1)이름
	let wname=document.getElementById("wname").value;
	wname=wname.trim();
	if(!(wname.length>=2 && wname.length<=10)) {
		alert("이름을 2~10글자이내 입력해 주세요");
		document.getElementById("wname").focus();
		return false;
	}// if end
	// 2)제목
	let subject=document.getElementById("subject").value;
	subject=subject.trim();
	if(!(subject.length>=3 && subject.length<=20)) {
		alert("제목을 3~20글자이내 입력해 주세요");
		document.getElementById("subject").focus();
		return false;
	}// if end
	// 3)비밀번호
	let passwd=document.getElementById("passwd").value;
	passwd=passwd.trim();
	if(!(passwd.length>=3 && passwd.length<=12)) {
		alert("비밀번호를 3~12글자이내 입력해 주세요");
		document.getElementById("passwd").focus();
		return false;
	}// if end
	// 4)첨부파일
	//-> 파일의 확장명이 이미지 파일(png, jpg, gif)인지 확인하시오
	let filename=document.getElementById("filename").value; // 예)sky.png
	filename=filename.trim();
	if(filename.length==0){
		alert("첨부 파일 선택하세요~");
		return false;
	}else{
		
		let dot=filename.lastIndexOf(".");	//filename변수값에서 마지막 . 의 순서값
		let ext=filename.substr(dot+1);		// 확장명 : 마지막 . 이후 문자열 자르기
		ext=ext.toLowerCase();				// 확장명을 전부 소문자로 치환
		
		if(ext=="png" || ext=="jpg" || ext=="gif") {
			return true;
		}else{
			alert("이미지 파일만 업로드 가능합니다~")
			return false;
		}// if end
	}// if end	
}//pdsChect() end


function pwCheck2(){
	let passwd=document.getElementById("passwd").value;
	passwd=passwd.trim();
	if(!(passwd.length>=4 && passwd.length<=15)) {
		alert("비밀번호를 4~15글자이내 입력해 주세요");
		document.getElementById("passwd").focus();
		return false;
	}//if end
	
	let message="첨부 파일도 삭제됩니다\n계속 진행할까요?";
	if(confirm(message)){ // 확인 true, 취소 false
		return true;	//서버로 전송
	}else{
		return false
	}//if end
}//pwCheck2() end


function memberUpdateCheck(){
	
	//1)현재 비밀번호랑 같은지
	var spwd=document.getElementById("spasswd");
	spwd=spwd.value.trim();
	var sspwd=document.getElementById("sspwd");
	sspwd=sspwd.value.trim();
	if(spwd==sspwd){
		alert("현재 비밀번호가 틀립니다.");
		document.getElementById("spasswd").focus();
		return false;
	}//if end
			
    //2)비밀번호 5~10글자 인지?
    var passwd=document.getElementById("passwd");
	passwd=passwd.value.trim();
	if(!(passwd.length>=5 && passwd.length<=10)){
		alert("비밀번호 5~20글자이내 입력해 주세요");
		document.getElementById("passwd").focus();
		return false;		
	}//if end
	
    //3)비밀번호와 비밀번호확인이 서로 일치하는지?
	var repasswd=document.getElementById("repasswd").value;
	repasswd=repasswd.trim();
	if(passwd!=repasswd){
	    alert("비밀번호 2개를 똑같이 입력해 주세요");
	    document.getElementById("passwd").focus();
	    return false;
	}//if end

    //4)이름 두글자 이상 인지?
  	var mname=document.getElementById("mname").value;
	mname=mname.trim();
	if(mname.length<=1){
	    alert("이름 두글자 이상 입력해 주세요");
	    document.getElementById("mname").focus();
	    return false;
	}//if end 

    //5)이메일 5글자 인지?
	var email=document.getElementById("email").value;
	email=email.trim();
	if(email.length<5){
	    alert("이메일 5글자 이상 입력해 주세요");
	    document.getElementById("email").focus();
	    return false;
	}//if end

    //6)직업을 선택했는지?
	var job=document.getElementById("job").value;
	if(job=="0"){
	    alert("직업 선택해 주세요");
	    return false;
	}//if end

	return true;//서버로 전송

}// memberUpdateCheck() end
		
 function nbsCheck(){ // 게시판 유효성 검사
 	// 1) 제목	2글자 이상 입력
 	let subject=document.getElementById("subject").value;	// 제목 가져오기
	subject=subject.trim();
	if(subject.length<2){ 
		alert("제목 2글자 이상 입력해 주세요.");
		document.getElementById("subject").focus();	// 제목 칸에 커서 생성
		return false;
	}// if end
 	// 2) 내용	2글자 이상 입력
	 let content=document.getElementById("content").value;	// 내용 가져오기
	 content=content.trim();
	 if(content.length<2){ 
		 alert("내용 2글자 이상 입력해 주세요.");
		 document.getElementById("content").focus();	// 내용 칸에 커서 생성
		 return false;
	 }// if end

	return true;	// onsubmit이벤트에서 서버로 전송	
}// bbsCheck() end


 function mailCheck(){ // 게시판 유효성 검사
 
 	// 1) 이메일	2글자 이상 입력
 	let to=document.getElementById("to").value;	// 작성자 가져오기
	to=to.trim();
	if(to.length<2){ 
		alert("이메일을 입력해 주세요");
		document.getElementById("to").focus();	// 작성자 칸에 커서 생성
		return false;
		
	}// if end
	
	 	let from=document.getElementById("from").value;	// 작성자 가져오기
	from=from.trim();
	if(from.length<2){ 
		alert("이메일을 입력해 주세요");
		document.getElementById("from").focus();	// 작성자 칸에 커서 생성
		return false;
		
	}// if end
	
 	// 2) 제목	2글자 이상 입력
 	let subject=document.getElementById("subject").value;	// 제목 가져오기
	subject=subject.trim();
	if(subject.length<2){ 
		alert("제목 2글자 이상 입력해 주세요.");
		document.getElementById("subject").focus();	// 제목 칸에 커서 생성
		return false;
	}// if end
	
 	// 3) 내용	2글자 이상 입력
	 let content=document.getElementById("content").value;	// 내용 가져오기
	 content=content.trim();
	 if(content.length<2){ 
		 alert("내용 2글자 이상 입력해 주세요.");
		 document.getElementById("content").focus();	// 내용 칸에 커서 생성
		 return false;
	 }// if end
	return true;	// onsubmit이벤트에서 서버로 전송	
}// mailCheck() end