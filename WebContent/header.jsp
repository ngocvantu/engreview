<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head> 
<style>
ul {
    margin: 0;
    padding: 0;
    overflow: hidden;
    border: 1px solid #e7e7e7;
    background-color: #f3f3f3;
    list-style: none;
    margin-top: 10px;
}
 
li {
 	float: left; 
}

li a {
    display: block;
    color: #666;
    text-align: center;
    padding: 5px 10px;
    text-decoration: none;
}

li a:hover:not(.active) {
    background-color: #ddd;
}

li a.active {
    color: white;
    background-color: #4CAF50;
}
</style>
</head>
<body>
	<ul>
  <li><a id="home"  href="<%=request.getContextPath()%>">Home</a></li> 
  <li><a id="anhviet" href="<%=request.getContextPath()%>/anhviet">Anh-Việt</a></li>
  <li><a id="vietanh" href="<%=request.getContextPath()%>/vietanh">Việt-Anh</a></li>
  <li><a id="chitiet" href="<%=request.getContextPath()%>/chitiet">Chi tiết</a></li>
  <li><a id="toeic600" href="<%=request.getContextPath()%>/toeic600">Toeic 600</a></li>
  <li><a id="macdinh" href="<%=request.getContextPath()%>/macdinh">Cài đặt</a></li>
  <li><a id="homnay" href="<%=request.getContextPath()%>/homnay">Hôm nay</a></li>
  <li><a id="homqua" href="<%=request.getContextPath()%>/homqua">Hôm qua</a></li>
  <li><a id="homkia" href="<%=request.getContextPath()%>/homkia">Hôm kia</a></li> 
  <li><a id="fibonaci" href="<%=request.getContextPath()%>/fibonaci">Fibonaci</a></li>
  <li><a id="ontap" href="<%=request.getContextPath()%>/ontap">Ôn tập</a></li>
  <li><a id="chat" href="<%=request.getContextPath()%>/chat">Chat</a></li>
  
  <li><a id="theodoi" href="<%=request.getContextPath()%>/theodoi">Theo dõi</a></li>
</ul>
</body>
</html>