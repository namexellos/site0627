<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script>
//클라이언트 스크립트 언어(실행인 클라이언트 측에 일어남..)
var user="scrott";
var pass="1234";
alert(user);
</script>
</head>
<body>
<%
	for(int i=1;i<=9;i++){
		out.print("2*"+i+"="+(2*i)+"<br>");
	}
out.print("2 * 1 = 2 <br>");
	
%>
</body>
</html>