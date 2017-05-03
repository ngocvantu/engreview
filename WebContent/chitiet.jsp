<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.List"%>
<%@page import="com.object.TuVung"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head> 
<%@ include file="/import.jsp" %>
<link  rel="stylesheet" href="<%=request.getContextPath()%>/css/chitiet/chitiet.css" >
<title>Chi tiết từ vựng --</title>
</head>
<body>

<%@ include file="/header.jsp" %> <hr> 
<!-- ===============================BODY==================================== -->
		<form action="<%=request.getContextPath()%>/sua?id=${listTuVung.id }" method="post" >
		Từ vựng: <c:out value="${listTuVung.tuvung }"/><input id="tuvung" name="tuvung" type="text" size="50" value="${listTuVung.tuvung }" > <br>
		Nghĩa: <c:out value="${listTuVung.nghia }"/><input id="nghia" name="nghia" type="text" size="50"  value="${listTuVung.nghia }" ><br>
		<div id="chitiet_div_vocal" class="div_all all chitiet_div" >
			
			<span id="chitiet_span_vocal" class="span_all all chitiet_span" ><c:out value="${listTuVung.tuvung }"/></span>
			
		</div>
		<div id="button" >
			<button type="button" id="chitiet_btn_back" class="btn_all all chitiet_btn" onclick="back(${listTuVung.id })"  >Back</button>
			<button type="button" id="chitiet_btn_next" class="btn_all all chitiet_btn" onclick="next(${listTuVung.id })" >Next</button>
		</div>
		<div id="chitiet_div_stuff" class="div_all all chitiet_div" >
		
		<table> 
			<tr>
				<td  >Ví dụ 1:</td>
				<td  ><span><c:out value="${listTuVung.vidu1 }"/></span> 
					<input autofocus id="vidu1" name="vidu1" type="text" size="50" value="${listTuVung.vidu1 }">
				</td>
			</tr>
			<tr>
				<td>Ví dụ 2:</td><td><span><c:out value="${listTuVung.vidu2 }"/></span>
				<input id="vidu2" name="vidu2" type="text" size="50" value="${listTuVung.vidu2 }"></td>
			</tr>
			<tr>
				<td>Từ loại:</td><td><span><c:out value="${listTuVung.tuloai }"/></span>
				<input id="tuloai" name="tuloai" type="text" size="50" value="${listTuVung.tuloai }"></td>
			</tr>
			<tr>
				<td>Nơi học:</td><td><span><c:out value="${listTuVung.noihoc }"/></span>
				<input id="noihoc" name="noihoc" type="text" size="50" value="${listTuVung.noihoc }" ></td>
			</tr>
			<tr>
				<td>Từ đồng nghĩa:</td><td><span><c:out value="${listTuVung.tudongnghia }"/></span>
				<input id="tudongnghia" name="tudongnghia" type="text" size="50" value="${listTuVung.tudongnghia }"></td>
			</tr>
			<tr>
				<td>Từ trái nghĩa:</td><td><span><c:out value="${listTuVung.tutrainghia }"/></span>
				<input id="tutrainghia" name="tutrainghia" type="text" size="50" value="${listTuVung.tutrainghia }"></td>
			</tr>
			<tr>
				<td>Ngày nhập:</td><td><span><c:out value="${listTuVung.ngaynhap }"/></span>
				<input id="ngaynhap" name="ngaynhap" type="text" size="50" value="${listTuVung.ngaynhap }"></td>
			</tr>
			<tr>
				<td>Ghi chú:</td><td><span><c:out value="${listTuVung.ghichu }"/></span>
				<input id="ghichu" name="ghichu" type="text" size="50" value="${listTuVung.ghichu }"></td>
			</tr>
			<tr>
				<td>Đã thuộc:</td><td><span><c:out value="${listTuVung.dathuoc }"/></span>
				<input id="dathuoc" name="dathuoc" type="text" size="50" value="${listTuVung.dathuoc }" ></td>
			</tr>
			<tr>
				<td>Số lần ôn:</td><td><span><c:out value="${listTuVung.solanon }"/></span>
				<input id="solanon" name="solanon" type="text" size="50" value="${listTuVung.solanon }"></td>
			</tr> 
			<tr>
				<td>Ảnh:</td><td align="center"><img width="300px" src="<%=request.getContextPath()%>/${listTuVung.ghichu }" ></td>
			</tr> 
		</table>
		<button type="button" id="chitiet_btn_sua" class="btn_all all chitiet_btn" onclick="sua()" >Sửa</button>
		<button id="chitiet_btn_xong" class="btn_all all chitiet_btn"  >Xong</button>
		</div>
		</form>
		
		
		
		
		
<!-- ===============================END BODY==================================== -->
<hr>

<%@ include file="/footer.jsp" %>

	<script type="text/javascript">
		$(document).ready(function() {
			$("#chitiet").addClass("active");
		});
		
		function sua() {
			$('#chitiet_btn_sua').html()==="Sửa"?$('#chitiet_btn_sua').html("Hủy"):$('#chitiet_btn_sua').html("Sửa");
			if($('#chitiet_btn_sua').html()==="Hủy"){
				$('#chitiet_btn_sua').addClass("btn_huy");
				$('#chitiet_btn_xong').css("display","inline");
				$("table tr td input").css("display","inline");
				$("table tr td span").css("display","none");
				$("#tuvung").css("display","inline");
				$("#nghia").css("display","inline");
			} else {
				$('#chitiet_btn_sua').removeClass("btn_huy");
				$('#chitiet_btn_xong').css("display","none");
				$("table tr td input").css("display","none");
				$("table tr td span").css("display","inline");
				$("#tuvung").css("display","none");
				$("#nghia").css("display","none");
			}
		}
		
		function next(id) {
			window.location.href="<%=request.getContextPath()%>" + "/chitiet?id=" + (id + 1) ;
		}
		
		function back(id) {
			window.location.href="<%=request.getContextPath()%>" + "/chitiet?id=" + (id - 1) ;
		}
	</script>
</body>
</html>