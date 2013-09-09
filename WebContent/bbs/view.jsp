<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

<table border="1">
	<tr>
		<td>�۹�ȣ</td>
		<td>${data.board_num }</td>
	</tr>
	<tr>
		<td>����</td>
		<td>${data.board_subject}</td>
	</tr>
	<tr>
		<td>����</td>
		<td>${data.board_content }</td>
	</tr>
	<tr>
		<td>�ۼ���</td>
		<td>${data.board_name }</td>
	</tr>

</table>
<a href="./bbsDelete.do?num=${data.board_num }">�����ϱ�</a>
<a href="./bbsUpdate.do?num=${data.board_num }">�����ϱ�</a>

<h4>����ۼ�</h4>
<form name="reply" action="./replyWrite.ro" method="post">
<input type="hidden" name="reply_board_num" value="${data.board_num }"/>
<!-- <input type="hidden" name="reply_date" value="now()"/> -->
<table border="1">
	<tr>
		<th>�ۼ���</th>
		<td>
			<input type="text" name="reply_name"/>
		</td>
	</tr>
	<tr>
		<th>����</th>
		<td>
			<textarea rows="20" cols="20" name="reply_content"></textarea>
		</td>
	</tr>
	<tr>
		<td colspan="2">
		<input type="submit" value="�ۼ�"/>
		</td>
	</tr>
</table>
</form>

<h3>���</h3>

<c:forEach var="reply" items="${replyList }">
	<table border='1'>
		<tr>
			<td>��۹�ȣ</td>
			<td>${reply.reply_num }</td>
			<td>�ۼ���</td>
			<td>${reply.reply_name }</td>
		</tr>
		<tr>
			<td colspan="3">${reply.reply_content }</td>
		</tr>
	</table>
</c:forEach>

</body>
</html>