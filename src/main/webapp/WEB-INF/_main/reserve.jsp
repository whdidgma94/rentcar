<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../header.jsp" %>
<body>
<h1>${car.name} 예약</h1>

<div class="nav reserve">
<div class="reserveBody">
<img alt="${car.name}" src="${ctx}/img/${car.img}">
</div>
<div class="reserveBody">
<form action="${ctx}/reserveAdd.do" method="post" id="form">
<table class="table table-bordered ">
<tr><td>재고</td> <td>${car.usepeople}</td> </tr>
<tr><td>수량</td> <td><select name="qty" onchange="multi1(value)">
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
					</select></td> </tr>
<tr><td>대여기간</td> <td> <select name="dday" onchange="multi2(value)">
						<option value="1">1일</option>
						<option value="2">2일</option>
						<option value="3">3일</option>
						<option value="4">4일</option>
						<option value="5">5일</option>
						<option value="6">6일</option>
						<option value="7">7일</option>
				</select></td> </tr>
<tr><td>대여일</td> <td><input type="date" name="rday" id="today"
					size="15"></td> </tr>
<tr><td>보험적용</td><td><select name="usein" onchange="addFn(value)">
						<option value="0">비적용</option>
						<option value="1">적용</option>
				</select></td></tr>
<tr><td>Wifi 적용</td><td><select name="usewifi" onchange="addFn(value)">
						<option value="0">비적용</option>
						<option value="1">적용</option>
				</select></td></tr>
<tr><td>네비게이션 적용</td><td><select name="usenavi" onchange="addFn(value)">
						<option value="0">비적용</option>
						<option value="1">적용</option>
				</select></td></tr>
<tr><td>베이비시트 적용</td><td><select name="useseat" onchange="addFn(value)">
						<option value="0">비적용</option>
						<option value="1">적용</option>
				</select></td></tr>
<tr><td>총 가격</td><td id="totalPrice"></td></tr>
<tr><td colspan="2"><input type="button" value="차량예약하기" onclick="reserveBtn()" /></td></tr>
</table>
</form>
</div>
</div>
<script>

	let total = 0;
	let multiple1 = 1;
	let multiple2 = 1;
	let addCnt=0;
	let carPrice = ${car.price};
	
	window.addEventListener("load",()=>{
		totalPrice();
		setRday();
	});
		
	function setRday(){
    	var now = new Date().toISOString().substring(0, 10);
    	document.getElementById("today").setAttribute("min", now);
	}
	
	
	function multi1(value) {
		multiple1=value;
		totalPrice();
	}
	function multi2(value) {	
		multiple2=value;
		console.log($("input[name=rday]").val());
		totalPrice();
	}
	function addFn(value) {	
		if(value==1){
			addCnt++;
		}else{
			addCnt--;
		}
		totalPrice();
	}
	function totalPrice() {
		let price = (carPrice*1*multiple1*multiple2)+(addCnt*1000*multiple1*multiple2);
		$("#totalPrice").text(price);
	}
	
	function reserveBtn() {
		if($("input[name=rday]").val()==""){
			swal('입력 오류','대여일을 선택해주세요','error')
			.then(function(){
				history.go(0);
			});
		}else if(${car.usepeople}<$("select[name=qty]").val()){
			swal('재고 부족','해당차량의 재고가 부족합니다','error')
			.then(function(){
				history.go(0);
			});
		}else{
			swal('예약 완료','예약이 완료 되었습니다','success')
			.then(function(){
				$("#form").submit();
			});
		}
	}
</script>
</body>
</html>