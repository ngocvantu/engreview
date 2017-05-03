<%@page import="java.util.List"%>
<%@page import="com.object.TuVung"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/import.jsp" %> 
<style type="text/css">

	a.linktuvung{
	text-decoration: none;
	color: #3b5998;
	}
	
	a.linktuvung:HOVER {
	text-decoration: underline;	
}
</style>
<title>Việt Anh</title>
</head>
<body>
<%@ include file="/header.jsp" %> 
	<hr> 
		Số từ vựng: <%=request.getSession().getAttribute("sotuvung") %>
	<c:set var="i" value="1" scope="page" />
	<table id="tuvung" style="width: 100%" >
	<c:forEach items="${listTuVung}"  var="tuvung" >
		<tr>
			<td><a class="linktuvung" href="<%=request.getContextPath()%>/chitiet?id=${tuvung.id}" >${i}.   ${tuvung.nghia }</a></td>
			<td style="padding-left: 30px" ><a href="#" onclick="xoa(${tuvung.id })"  >Đã thuộc</a></td>
			<td style="text-align: right;" >${tuvung.tuvung } . ${i}</td>
		</tr>
		<c:set var="i" value="${i + 1}" scope="page"/>
	</c:forEach>
	</table>
	<hr>
	 <%@ include file="/footer.jsp" %>

<% request.removeAttribute("listTuVung") ;%>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#vietanh").addClass("active");
		});
// 		function xoa(id) {
// 			$.ajax({
<%-- 			    url: '<%=request.getContextPath()%>/vietanh', --%>
// 			    data: "ma=xoa&&id="+ id,
// 			    type: 'post',
// 			    dataType:'text',
// 			    success: function(data){ 
// 			    	window.location.href = "/engreview/vietanh"; 
// 			    }
// 			});	
// 		}
	</script>
	
</body>
</html>