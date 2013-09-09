<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

<%
	String num = request.getParameter("num");
%>
<form name="delete" action="./bbsDeleteAction.do" method="post">
<input type="hidden" name="board_num" value="<%=num %>"/>
비밀번호 : 
<input type="password" name="board_pass"/> <br/>
<input type="submit" value="삭제하기"/>
</form>


</body>
</html>