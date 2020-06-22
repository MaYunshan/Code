<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<title>Insert title here</title>
</head>
<body>
	<form action="insert" method="post">
		<table border="1" align="center">
			<tr>
				<td colspan="2" style="text-align: center; font-size:30px;font-weight:bold">花卉信息</td>
			</tr>
			<tr>
				<td><b>名称</b></td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td><b>价格</b></td>
				<td><input type="text" name="price" /></td>
			</tr>
			<tr>
				<td><b>产地</b></td>
				<td><input type="text" name="producation" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="提交" /><input type="reset" value="重置" />
				</td>
			</tr>
		</table>
	</form>
	<script type="text/javascript">
		$(function(){
			$("form").submit(function(){
				if($(":text:eq(0)").val()=="" || $(":text:eq(1)").val()=="" || $(":text:eq(2)").val()==""){
					alert("请填写完整信息");
					return  false;
				}else{
					
				}
			});
		});
	</script>
</body>
</html>