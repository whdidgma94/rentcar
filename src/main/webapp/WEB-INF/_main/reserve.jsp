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
	
	window.addEventListener("load",totalPrice());
	
    var now = new Date();
    $("input[name=rday]").change(function() {
        var date = new Date($(this).val());
        if (date <= now) {
            alert("이전 날짜는 선택할 수 없습니다.");
            $(this).attr("value", null);
            history.go(0);
        }
    })
	
	function multi1(value) {
		multiple1=value;
		totalPrice();
	}
	function multi2(value) {	
		multiple2=value;
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
			alert("대여일을 입력해주세요");
			history.go(0);
		}else if(${car.usepeople}<$("select[name=qty]").val()){
			alert("해당차량 재고가 부족합니다");
			history.go(0);
		}else{
			$("#form").submit();
		}
	}
</script>
</body>
</html>