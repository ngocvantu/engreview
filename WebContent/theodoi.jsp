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

<title>Theo dõi</title>
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
		<%long homnay =  Long.parseLong((String)request.getAttribute("homnay"));
		long homqua =  Long.parseLong((String)request.getAttribute("homqua"));
		long homkia =  Long.parseLong((String)request.getAttribute("homkia"));
		long homkiaf =  Long.parseLong((String)request.getAttribute("homkiaf"));
		long homkiax =  Long.parseLong((String)request.getAttribute("homkiax"));
		long homkiar =  Long.parseLong((String)request.getAttribute("homkiar"));
		long homkiaj =  Long.parseLong((String)request.getAttribute("homkiaj"));
		%>
	<canvas id="myChart" width="1100px" height="400px"></canvas>
	<hr>
	 <%@ include file="/footer.jsp" %>

<% request.removeAttribute("listTuVung") ;%>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#theodoi").addClass("active");
			 
			$("#hienthinghia").click(function() {
				$(".nghia").toggleClass("display");
				$('#hienthinghia').html()==="Hiển thị nghĩa"?$('#hienthinghia').html("Tắt nghĩa"):$('#hienthinghia').html("Hiển thị nghĩa");
			});
			
			$("#hienthixoa").click(function() {
				$(".xoa").toggleClass("display");
				$('#hienthixoa').html()==="Hiển thị xóa"?$('#hienthixoa').html("Tắt xóa"):$('#hienthixoa').html("Hiển thị xóa");
			});
			
			var data = {
				    labels: ["Hôm kịa", "Hôm kỉa", "Hôm kĩa", "Hôm kìa", "Hôm kia", "Hôm qua", "Hôm nay"],
				    datasets: [ 
				        {
				            label: "My Second dataset",
				            fillColor: "rgba(151,187,205,0.2)",
				            strokeColor: "rgba(0,0,255,1)",
				            pointColor: "rgba(0,0,255,1)",
				            pointStrokeColor: "#fff",
				            pointHighlightFill: "#fff",
				            pointHighlightStroke: "rgba(0,0,255,1)",
				            data: [<%=homkiaj %>, <%=homkiar %>, <%=homkiax %>, <%=homkiaf %>, <%=homkia %>, <%=homqua %>, <%=homnay %>]
				        }
				    ]
				};
			var ctx = document.getElementById("myChart").getContext("2d");
			var myLineChart = new Chart(ctx).Line(data, {
			    bezierCurve: false,
			    scaleFontColor: "#0000ff",
			    scaleFontSize: 13,
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