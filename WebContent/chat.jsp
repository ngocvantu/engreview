<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

        <table>
            <tr>
                <td colspan="2">
                    <input type="text" id="username" placeholder="Username"/>
                    <button type="button"  id = "connect"  onclick="connect();" >Connect</button>
                </td>
            </tr>
            <tr>
                <td>
                    <div id="log"></div>
                </td>
            </tr>
            <tr>
                <td>
                    <input type="text" size="15" id="to" placeholder="To"/>
                    <input type="text" size="51" id="msg" placeholder="Message" onkeypress="handle(event)" />
                    <button type="button"onclick="send();" >Send</button>
                </td>
            </tr>
        </table>
    </body>
<script type="text/javascript"  src="http://localhost:8080/ChaoStruts/js/script.js"></script>
</html>