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
<form action="${ctx}/reserveAdd.do" method="post">
<table class="table table-bordered ">
<tr><td>수량</td> <td> <select name="qty">
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
					</select></td> </tr>
<tr><td>대여기간</td> <td> <select name="dday">
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
<tr><td>보험적용</td><td><select name="usein">
						<option value="1">적용(1일 1만원)</option>
						<option value="2">비적용</option>
				</select></td></tr>
<tr><td>Wifi 적용</td><td><select name="usewifi">
						<option value="1">적용(1일 1만원)</option>
						<option value="2">비적용</option>
				</select></td></tr>
<tr><td>네비게이션 적용</td><td><select name="usenavi">
						<option value="1">적용(무료)</option>
						<option value="2">비적용</option>
				</select></td></tr>
<tr><td>베이비시트 적용</td><td><select name="useseat">
						<option value="1">적용(1일 1만원)</option>
						<option value="2">비적용</option>
				</select></td></tr>
<tr><td colspan="2"><button>차량예약하기</button></td></tr>
</table>
</form>
</div>
</div>
</body>
</html>