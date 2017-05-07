<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/import.jsp" %> 
<title>Nhập từ vựng</title>
</head>
<body>
	<%@ include file="/header.jsp" %> 
	<hr>
	hello review <br>
	
	<%
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy-HH:mm:ss");
		
		Cookie[] cookies = request.getCookies();
		String timestamp = df.format(new Date());
		System.out.print(timestamp);
		Cookie cookie = new Cookie("timestamp", timestamp);
		response.addCookie(cookie);
		
		Cookie lastVisited = null;
		for(int i = 0; i< cookies.length; i++){
			if(cookies[i].getName().equals("timestamp")){
				lastVisited = cookies[i];
				break;
			}
		}
		if(lastVisited == null){
			lastVisited = cookie;
		}
	%>
	last visited: <%=lastVisited.getValue() %>
	<a href="<%=request.getContextPath()%>/nhaptuvung" >list vocal</a>
	Số từ vựng: <%=request.getSession().getAttribute("sotuvung") %>
	<div id="divtest" ></div>
	<button id="btntest" >Test ajax</button>
	
	<!-- FORM NHAP TU VUNG -->
	<form action="<%=request.getContextPath()%>/nhaptuvung" method="post" enctype="multipart/form-data" acceptcharset="UTF-8" >
		<table>
			<tr>
				<td>Từ vựng:</td>
				<td><input id="tuvung" name="tuvung" type="text" size="50" autofocus ></td>
			</tr>
			<tr>
				<td>Nghĩa:</td>
				<td><input id="nghia" name="nghia" type="text" size="50"></td>
			</tr>
			<tr>
				<td>Ví dụ 1:</td>
				<td><input id="vidu1" name="vidu1" type="text" size="50"></td>
			</tr>
			<tr>
				<td>Ví dụ 2:</td>
				<td><input id="vidu2" name="vidu2" type="text" size="50"></td>
			</tr>
			<tr>
				<td>Từ loại:</td>
				<td><input id="tuloai" name="tuloai" type="text" size="50"  value="${sessionScope.tuloai}"  ></td>
			</tr>
			<tr>
				<td>Nơi học:</td>
				<td><input id="noihoc" name="noihoc" type="text" size="50"  value="${sessionScope.noihoc}" ></td>
			</tr>
			<tr>
				<td>Từ đồng nghĩa:</td>
				<td><input id="tudongnghia" name="tudongnghia" type="text" size="50"></td>
			</tr>
			<tr>
				<td>Từ trái nghĩa:</td>
				<td><input id="tutrainghia" name="tutrainghia" type="text" size="50"></td>
			</tr>
			<tr>
				<td>Ngày nhập:</td>
				<td><input id="ngaynhap" name="ngaynhap" type="text" size="50"></td>
			</tr>
			<tr>
				<td>Ghi chú:</td>
				<td><input id="ghichu" name="ghichu" type="text" size="50"  value="${sessionScope.ghichu}"  ></td>
				
			</tr>
			<tr>
				<td>Hình ảnh:</td>
				<td><input type="file" name="uploadFile" ></td>
				
			</tr>
			<tr>
				
				<td><input type="submit" value="Nhập" ></td>
			</tr>
		</table> 
		
	</form>


	<hr>
	 <%@ include file="/footer.jsp" %>
	 
	 
	 <script type="text/javascript">
$( document ).ready(function(){
	 
// 		alert("asdf");
		$.ajax({
		    url: '<%=request.getContextPath()%>/listvocal',
		    data: "kjh",
		    type: 'post',
		    dataType:'text',
		    success: function(data){ 
		        console.log(data);
// 		        alert(data);
		    }
		});
	 
	
	$("#home").addClass("active");
});
</script>
</body>
</html>


