<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>글 목록</title>
</head>
<body>

	<table border='1'>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>

		</tr>

		<c:if test="${empty listBoard}">
			<tr>
				<td colspan="3">작성된 글이 없습니다.</td>
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
					<a href="./bbsList.do?page=${startPage - 1 }">[이전]</a>
				</c:if>
				
				<c:forEach var="page" begin="${startPage}" end="${endPage}">
					<a href="./bbsList.do?page=${page}">[${page}]</a>
				</c:forEach>
				
				<c:if test="${endPage < paging.lastPage}">
					<a href="./bbsList.do?page=${endPage + 1 }">[다음]</a>
				</c:if>
			</td>
		</tr>
	</table>
	<a href="./bbsList.do">목록보기</a>
	<a href="./bbsWrite.do">글작성하기</a>
	<!-- <input type="button" value="글작성"  onclick="location.href='./boardWrite.do'"/> -->
</body>
</html>