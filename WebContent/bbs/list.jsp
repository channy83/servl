<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�� ���</title>
</head>
<body>

	<table border='1'>
		<tr>
			<th>��ȣ</th>
			<th>����</th>
			<th>�ۼ���</th>

		</tr>

		<c:if test="${empty listBoard}">
			<tr>
				<td colspan="3">�ۼ��� ���� �����ϴ�.</td>
			</tr>
		</c:if>

		<c:forEach var="bbs" items="${listBoard}">
			<tr>
				<td>${bbs.board_num }</td>
				<td><a href="./bbsView.do?num=${bbs.board_num}">${bbs.board_subject }</a></td>
				<td>${bbs.board_name }</td>
			</tr>
		</c:forEach>

		<tr>
			<td colspan="3">
				<c:set var="startPage" value="${paging.startPage}" />
				<c:set var="endPage" value="${paging.endPage}" />
				
				<c:if test="${startPage != 1}">
					<a href="./bbsList.do?page=${startPage - 1 }">[����]</a>
				</c:if>
				
				<c:forEach var="page" begin="${startPage}" end="${endPage}">
					<a href="./bbsList.do?page=${page}">[${page}]</a>
				</c:forEach>
				
				<c:if test="${endPage < paging.lastPage}">
					<a href="./bbsList.do?page=${endPage + 1 }">[����]</a>
				</c:if>
			</td>
		</tr>
	</table>
	<a href="./bbsList.do">��Ϻ���</a>
	<a href="./bbsWrite.do">���ۼ��ϱ�</a>
	<!-- <input type="button" value="���ۼ�"  onclick="location.href='./boardWrite.do'"/> -->
</body>
</html>