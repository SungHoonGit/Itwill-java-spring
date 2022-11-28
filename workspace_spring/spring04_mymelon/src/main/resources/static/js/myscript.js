function pdsCheck() {	// 포토갤러리 유효성 검사
	
	//1) 제목입력
	let subject=document.getElementById("title").value;
	subject=subject.trim();
	if(subject.length==0) {
		alert("제목을 입력해 주세요");
		document.getElementById("subject").focus();
		return false;
	}// if end
	
	
	// 2) 첨부파일
	//-> 파일의 확장명이 이미지 파일(png, jpg, gif)인지 확인하시오
	

	let poster=document.getElementById("poster").value; // 예)sky.png
	poster=poster.trim();
	if(poster.length==0){
		alert("첨부 파일 선택하세요~");
		return false;
	}else{
		
		let dot=poster.lastIndexOf(".");	//filename변수값에서 마지막 . 의 순서값
		let ext=poster.substr(dot+1);		// 확장명 : 마지막 . 이후 문자열 자르기
		ext=ext.toLowerCase();				// 확장명을 전부 소문자로 치환
		
		if(ext=="png" || ext=="jpg" || ext=="gif") {
			
		}else{
			alert("이미지 파일만 업로드 가능합니다~")
			return false;
		}// if end
	}// if end	
	
	// 3) 첨부파일
	//-> 파일의 확장명이 파일(mp3, mp4)인지 확인하시오
	let filename=document.getElementById("filename").value; // 예)sky.png
	filename=filename.trim();
	if(filename.length==0){
		alert("미디어 파일 선택하세요~~");
		return false;
	}else{
		
		let dot=filename.lastIndexOf(".");	//filename변수값에서 마지막 . 의 순서값
		let ext=filename.substr(dot+1);		// 확장명 : 마지막 . 이후 문자열 자르기
		ext=ext.toLowerCase();				// 확장명을 전부 소문자로 치환
		
		if(ext=="mp3" || ext=="mp4") {
			return true;
		}else{
			alert("노래,영상 업로드 가능합니다~")
			return false;
		}// if end
	}// if end	

}//pdsChect() end

function pdsCheck2() {	// 포토갤러리 유효성 검사
	
	//1) 제목입력
	let subject=document.getElementById("title").value;
	subject=subject.trim();
	if(subject.length==0) {
		alert("제목을 입력해 주세요");
		document.getElementById("subject").focus();
		return false;
	}// if end
	
	
	// 2) 첨부파일
	//-> 파일의 확장명이 이미지 파일(png, jpg, gif)인지 확인하시오
	

	let poster=document.getElementById("poster").value; // 예)sky.png

		
		let dot=poster.lastIndexOf(".");	//filename변수값에서 마지막 . 의 순서값
		let ext=poster.substr(dot+1);		// 확장명 : 마지막 . 이후 문자열 자르기
		ext=ext.toLowerCase();				// 확장명을 전부 소문자로 치환
		
		if(poster.length!=0){

			if(ext=="png" || ext=="jpg" || ext=="gif") {
				return true;
			}else{
				
				alert("이미지 파일만 업로드 가능합니다~");
				return false;
			}// if end
		}// if end

	// 3) 첨부파일
	//-> 파일의 확장명이 파일(mp3, mp4)인지 확인하시오
	let filename=document.getElementById("filename").value; // 예)sky.png
	filename=filename.trim();

		
		let dot2=filename.lastIndexOf(".");	//filename변수값에서 마지막 . 의 순서값
		let ext2=filename.substr(dot2+1);		// 확장명 : 마지막 . 이후 문자열 자르기
		ext=ext.toLowerCase();				// 확장명을 전부 소문자로 치환
		
		if(filename.length!=0){

			if(ext2=="mp3" || ext2=="mp4") {
				return true;
			}else{
				alert("노래,영상 업로드 가능합니다~");
				return false;
			}// if end
		}// if end

}//pdsChect2() end