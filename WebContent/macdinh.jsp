<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/import.jsp" %> 
<title>Cài đặt mặc định</title>
</head>
<body>
	<%@ include file="/header.jsp" %> 
	<hr>
	 
	<!-- FORM NHAP TU VUNG -->
	<form action="<%=request.getContextPath()%>/macdinh" method="post" >
		<table>
			<tr>
				<td>Mặc định từ loại:</td>
				<td><input id="tuloai" name="tuloai" type="text" size="50" value="${sessionScope.tuloai}"  ></td>
			</tr>
			<tr>
				<td>Mặc định nơi học:</td>
				<td><input id="noihoc" name="noihoc" type="text" size="50"  value="${sessionScope.noihoc}"   ></td>
			</tr>
			<tr>
				<td>Mặc định ghi chú:</td>
				<td><input id="ghichu" name="ghichu" type="text" size="50"  value="${sessionScope.ghichu}"   ></td>
			</tr>
			<tr>
				<td> </td>
				<td> <c:out value="${daxong }"></c:out> </td>
			</tr>
			 
		</table>  
		<input type="submit" >
	</form>

	<hr>
	<%@ include file="/footer.jsp"%>

	<script type="text/javascript">
		$(document).ready(function() {
			$("#macdinh").addClass("active");
		});
	</script>
</body>
</html>


