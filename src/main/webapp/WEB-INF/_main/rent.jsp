<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../header.jsp" %>
<body>
	<h1>예약하기</h1>
	<table class="table table-bordered">
	<tr> <td>사진</td> <td>차종</td>  <td>번호</td> <td>일일대여료</td> <td>제조사</td> <td>설명</td> <td>예약</td>   </tr>
	<c:forEach var="c" items="${carList}">
	<tr>
		<td> <img alt="${c.name}" src="${ctx}/img/${c.img}" height="100px" width="100px"> </td>
		<td>${c.name}</td>
		<td>${c.no}</td>
		<td>${c.price}원/ 일</td>
		<td>${c.company}</td>
		<td>${c.info}</td>
		<c:choose>  
			<c:when test="${c.usepeople<=0}"> 
				<td> 매진 </td>
			</c:when> 
			<c:otherwise> 
				<td> <button onclick="location.href='${ctx}/reserve.do?name=${c.name}'">예약하기</button> </td>
			</c:otherwise> 
		</c:choose>  

	</tr>
	</c:forEach>
	</table>
</body>
</html>