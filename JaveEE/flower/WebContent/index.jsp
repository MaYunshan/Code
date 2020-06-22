<%@ page  isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>index.jsp</title>
		<style type="text/css">
			a{
				color: black;
				text-decoration: none;
			}
			a:hover{
				color: red;
			}
		</style>
	</head>
	<body>
		这是我的第一个jsp
		<table border='1'>
			<tr>
				<td>花卉编号</td>
				<td>花卉名称</td>
				<td>花卉价格</td>
				<td>原产地</td>
			</tr>
			<tr>
			</tr>

			<c:forEach items="${list }" var="flower">
				<tr>
					<td>${flower.id }</td>
					<td>${flower.name }</td>
					<td>${flower.price }</td>
					<td>${flower.producation }</td>
				</tr>
			</c:forEach>
		</table>
		<a href="add.jsp">添加花卉信息</a>
	</body>
</html>
