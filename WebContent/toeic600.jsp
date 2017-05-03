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

<title>Toeic 600</title>
<style type="text/css">
table#tuvung {
	font-size: 20px;
	color: blue;
}

a.linktuvung {
	text-decoration: none;
	color: #3b5998;
}

a.linktuvung:HOVER {
	text-decoration: underline;
}

.xoa{
	visibility:hidden
}
.nghia{
	visibility:hidden
}

.display{
	visibility:visible;
}

#hienthixoa{
	width: 100px;
}

#hienthinghia{
	width: 105px;
}
</style>
</head>
<body>
	<%@ include file="/header.jsp" %> 
	<hr>
		<%List<TuVung> listTuVung = (List<TuVung>)request.getAttribute("listTuVung");
		%>
		Số từ vựng toeic 600: <%=listTuVung.size() %> <br>
	<c:set var="i" value="1" scope="page" />
	<button id="hienthixoa" >Hiển thị xóa</button>
	<button id="hienthinghia" >Hiển thị nghĩa</button>
	<table id="tuvung" style="width: 100%" >
	<c:forEach items="${listTuVung}"  var="tuvung" >
		<tr>
			<td><a class="linktuvung" href="<%=request.getContextPath()%>/chitiet?id=${tuvung.id}" >${i}.  ${tuvung.tuvung }</a></td>
			<td class="xoa" style="padding-left: 30px" ><a href="#" onclick="xoa(${tuvung.id })"  >Xóa</a></td>
			<td class="nghia" style="text-align: right;" >${tuvung.nghia } . ${i}</td>
		</tr>
		<c:set var="i" value="${i + 1}" scope="page"/>
	</c:forEach>
	</table>
	<hr>
	 <%@ include file="/footer.jsp" %>

<% request.removeAttribute("listTuVung") ;%>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#toeic600").addClass("active");
			 
			$("#hienthinghia").click(function() {
				$(".nghia").toggleClass("display");
				$('#hienthinghia').html()==="Hiển thị nghĩa"?$('#hienthinghia').html("Tắt nghĩa"):$('#hienthinghia').html("Hiển thị nghĩa");
			});
			
			$("#hienthixoa").click(function() {
				$(".xoa").toggleClass("display");
				$('#hienthixoa').html()==="Hiển thị xóa"?$('#hienthixoa').html("Tắt xóa"):$('#hienthixoa').html("Hiển thị xóa");
			});
		});
		function xoa(id) {
			$.ajax({
			    url: '<%=request.getContextPath()%>/anhviet',
			    data: "ma=xoa&&id="+ id,
			    type: 'post',
			    dataType:'text',
			    success: function(data){ 
			    	window.location.href = "/engreview/anhviet"; 
			    }
			});	
		}
	</script>
	
	
</body>
</html>