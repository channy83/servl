<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

<form name="update" action="./bbsUpdateAction.do" method="post">
<input type="hidden" name="board_num" value="${data.board_num }"/> 
<table border='1'>
	<tr>
		<td>����</td>
		<td>
			<input type="text" name="board_subject" value="${data.board_subject}"/>
		</td>
	</tr>
	<tr>
		<td>����</td>
		<td>
			<textarea rows="20" cols="50" name="board_content">${data.board_content}</textarea>
		</td>
	</tr>
	<tr>
		<td>��й�ȣ</td>
		<td>
			<input type="password" name="board_pass"/>
		</td>
	</tr>
</table>
<input type="submit" value="�����ϱ�"/> <br/>
<input type="button" value="���" onclick="location.href='./bbsList.do'"/>
</form>
</body>
</html>