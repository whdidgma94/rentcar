<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../header.jsp" %>
<body>
	<script>

	function checkImg( fname , ftype,fsize ){
	let fileForm = /(.*?)\.(jpg|jpeg)$/;
	let maxSize = 5 * 1024 * 1024;
	if(fname != "" && fname != null) {
	    if(!fname.match(fileForm)) {
	    	alert("이미지 파일만 업로드 가능");
	        return false;
	    } else if(fsize >= maxSize) {
	    	alert("파일 사이즈는 5MB까지 가능");
	        return false;
	    }
	}
	return true;
	}
	
	function uploadFile(){
	    let form = $('#imgForm')[0];
	    let formData = new FormData(form);	 
	    $.ajax({
	    
	        url : '${ctx}/adminImgUpload.do',
	        type : 'POST',
	        data : formData,
	        contentType : false,
	        processData : false,
	        success: function(data){	        
	        	if(data == 'fail'){
	        		alert('파일 업로드 실패');
	        	}else{
	        		alert(data + " 업로드 성공");
	        	    let src = "img/" + data;
	        	    console.log("src=" + src);
	        		$("#inputImg").attr('src',src);
	                $("#imgVal").val(data);
	        	}
	        }
	    });
	}	
	function update() {
	   let file = $('#formFile')[0].files[0];
	   if(checkImg( file.name ,file.type,file.size )){
		   uploadFile();
	   }	  
	}		
	function uplaodImg(form){
		if(checkImg()){
			form.submit();
		}
	}		
	function checkSumbit(){
	
		let check = true;
		$(".fv").each(function(){
		    if($(this).val() == ""){
		    	check = false
		        alert( $(this).attr("name") + "의 값이 입력되지 않았습니다." );		  
		    	return false;
		    }
		});
	    if(check){
	    	$("#formAdd").submit();
	    }		
	}		
	function init(){
		$('input[name ="category"]').on("change click", function() {
				  $('input[name ="category"]').removeClass('fv');
			  if($(this).is(':checked')){
				  $(this).addClass('fv');
			  }
		});
	}
window.onload = ()=> {
	init();
}
	
</script>

<h1>차량 추가</h1>
<div class="content">
<!--  -->
	<div>
		<form id="imgForm" action="adminImgUpload.do" method="post"
			enctype="multipart/form-data">
				<input type="file" class="form-control" onchange="update()" id="formFile"
				type="file" name="uploadFile" accept=" .jpg"/>
		</form>
	</div>

	<div>
		<form id="formAdd"action="adminInsertCarVO.do" method="post">

			<table class="table table-bordered">
				<tr>
					<td rowspan="6" width="500" align="center"><input type="image"
						width="500" name="img" id= "inputImg"
						src="https://upload.wikimedia.org/wikipedia/commons/1/14/No_Image_Available.jpg" />
						<input class="fv" id="imgVal" type="hidden" name="img" value="" />
					</td>
					<td>차량이름</td>
					<td><input class="fv" type="text" name="name" size="15" /></td>
				</tr>
				<tr>
					<td>차량분류</td>
					<td><input type="radio" name="category" value="1" checked /> 소형
						&nbsp; <input type="radio" name="category" value="2" /> 중형 &nbsp;
						<input type="radio" name="category" value="3" /> 대형 &nbsp;</td>
				</tr>
				<tr>
					<td>대여가격</td>
					<td><input class="fv" type="number" name="price" size="15" />
						원</td>
				</tr>
				<tr>
					<td>제조회사</td>
					<td><input class="fv" type="text" name="company" size="15" /></td>
				</tr>
				<tr>
					<td>차랑 정보 등록</td>
					<td><textarea class="fv" name="info">
				  
				  </textarea></td>

				</tr>

				<tr height="40">
					<td colspan="2"><input type="button" value="차량 등록"
						onclick="checkSumbit()" /></td>
				</tr>
			</table>

		</form>
	</div>
</div>
</body>
</html>