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

<title>Ôn tập</title>
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
 
	<c:set var="i" value="1" scope="page" />
	<c:set var="j" value="1" scope="page" />
	
	<form action="lkj" method="post" onsubmit="return dosubmit();" >
	 
		<table>
			<tr>
				<td id="tuvung-text" >Inter nation</td>
				<td><input id="tuvung-input" type="text" size="50" autofocus></td>
			</tr>
			<tr>
				<td id="nghia-text">the gioi</td>
				<td><input id="nghia-input" type="text" size="50" ></td>
			</tr>
			<tr>
				<td id="vidu1">vd1</td>
				<td> </td>
			</tr>
			<tr>
				<td id="vidu2">vd2</td>
				<td> </td>
			</tr>
			<tr>
				<td> </td>
				<td><input type="submit" ></td>
			</tr>
		</table>	
		
	</form>
 
	<br>
	 
	<hr>
	 <%@ include file="/footer.jsp" %>

<% request.removeAttribute("listTuVung") ;%>
	<script type="text/javascript">
		var i = 1;
		$(document).ready(function() {
			$("#ontap").addClass("active");
			getNext();
		});
		
		function getNext() {
			alert("asdf");
		 
			$.ajax({
			    url: '<%=request.getContextPath()%>/ontap?method=ontap',
			    data: "kk" ,
			    type: 'post', 
			    dataType:'json',
			    success: function(data){  
	 		       $("#tuvung-text").html(data.tuvung);
	 		    
			    }
			});
		}
		
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
		
		function dosubmit() {
			getNext();
			return false;
		}
	</script>
	
	
</body>
</html>