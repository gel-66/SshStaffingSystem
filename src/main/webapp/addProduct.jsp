<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!-- struts2标签库 -->
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<h1>保存商品的页面</h1>
<!-- struts2有个自带的样式 simple可以取消默认样式 -->
<s:form action="" method="" namespace="/" theme="simple">
	<table border="1" width="400">
		<tr>
			<td>商品名称</td>
			<td><s:textfield name="name"/></td>
		</tr>
		<tr>
			<td>商品价格</td>
			<td><s:textfield name="price"/></td>
		</tr>
		<tr>
			<td colspan="2"><s:submit>提交</s:submit></td>
		</tr>
	</table>
</s:form>
</body>
</html>