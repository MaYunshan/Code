<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	这是人员信息表格
	<table align="center" border="1">
		<tr>
			<td>编号</td>
			<td>姓名</td>
			<td>年龄</td>
		</tr>
		<c:forEach items="${list }" var="people">
			<tr>
				<td>${people.id }</td>
				<td>${people.name }</td>
				<td>${people.age }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>