<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

<form action="./bbsWriteAction.do" method="post">
<!-- <input type="hidden" name="board_num"> -->
�ۼ��� : <input type="text" name="board_name"/> <br/>
�н����� : <input type="password" name="board_pass"/> <br/>
���� : <input type="text" name="board_subject"/> <br/>
���� : <input type="text" name="board_content"/> <br/>
<input type="submit" value="�ۼ��Ϸ�"/>
</form>
</body>
</html>