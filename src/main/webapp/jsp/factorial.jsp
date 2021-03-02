<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--jsp 메소드, 변수 선언부 --%> 
<%!
// 메소드 선언
private int calculate(int n) {
	if(n <= 1) 
		return 1;
		
	else
		return n * calculate(n-1);
}
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	1! : <%=calculate(1) %>
	2! : <%=calculate(2) %>
	3! : <%=calculate(3) %>
	4! : <%=calculate(4) %>
	5! : <%=calculate(5) %>
</body>
</html>