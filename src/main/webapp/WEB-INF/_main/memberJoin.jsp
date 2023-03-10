<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../header.jsp" %>
<body>
	<h1>회원가입</h1>
	<form action="${ctx}/memberJoin.do" method="post" id="form">
	<table class="table table-bordered">
		<tr><td>아이디</td><td><input type="text" name="id" onchange="idChange()">&emsp;<input type="button" value="중복확인" onclick="idCheck()"></td></tr>
		<tr><td>비밀번호</td><td><input type="password" name="pw"></td></tr>
		<tr><td>이름</td><td><input type="text" name="name"></td></tr>
		<tr><td>나이</td><td><input type="number" name="age"></td></tr>
		<tr><td>이메일</td><td><input type="email" name="email"></td></tr>
		<tr><td>전화번호</td><td><input type="text" name="phone"></td></tr>
		<tr><td>성별</td><td><input type="radio" name="gender" value="남자" checked>남자 &emsp;<input type="radio" name="gender" value="여자">여자
	</td></tr>
	<tr><td colspan="2"><input type="button" onclick="joinBtn()" value="회원가입"></td></tr>
	</table>
	</form>
	<script>
		let confirmed=false;
		function idChange(){
			confirmed=false;
		}	
		function idCheck(){
			if ($("input[name=id]").val()) {
				let query = {
					id : $("input[name=id]").val()
				};
				$.ajax({
					type : "post",
					url : "memberIdConfirm.do",
					data : query,
					success : function(data) {
						if (data == 1) {
							swal('중복체크','이미 존재하는 아이디 입니다','error');
							 $("input[name=id]").val('');
							 confirmed=false;
						} else {
							swal('중복체크','사용 가능한 아이디 입니다','success');
							confirmed=true;
							$("input[name=pw]").focus();
						}
					}
				})	
			}else{
				swal('입력오류','아이디를 입력해 주세요','error');
			}
		}
		function check(){
			if(!confirmed){
				swal('오류','아이디 중복확인을 해 주세요','error');
				return false;
			}
			if($("input[name=id]").val()==""){
				swal('입력오류','아이디를 입력해 주세요','error');
				return false;
			}
			if($("input[name=pw]").val()==""){
				swal('입력오류','비밀번호를 입력해 주세요','error');
				return false;
			}
			if($("input[name=name]").val()==""){
				swal('입력오류','이름를 입력해 주세요','error');
				return false;
			}
			if($("input[name=age]").val()==""){
				swal('입력오류','나이를 입력해 주세요','error');
				return false;
			}
			if($("input[name=email]").val()==""){
				swal('입력오류','이메일를 입력해 주세요','error');
				return false;
			}
			if($("input[name=phone]").val()==""){
				swal('입력오류','전화번호를 입력해 주세요','error');
				return false;
			}
			
			return true;
		}
		function joinBtn(){
			if(check()){
				swal('가입 완료!','회원가입이 완료 되었습니다','success')
				.then(function(){		
					$("#form").submit();
				});
			}
		}
	</script>
</body>
</html>