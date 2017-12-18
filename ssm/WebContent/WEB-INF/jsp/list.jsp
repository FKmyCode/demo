<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta content="utf-8" http-equiv="charset">
</head>
<body>
<form action="${pageContext.request.contextPath }/search.action" method="post">
<input type="text" name="searchString"/>
<input type="submit" value="搜索"/>

</form>
<table>
	
	<tr>
		<td>id</td>
		<td>姓名</td>
		<td>生日</td>
	</tr>
	<c:forEach items="${userList }" var="user">
	<tr>
		<td>${user.id }</td>
		<td>${user.name }</td>
		<td><fmt:formatDate value="${user.birthday}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	</tr>
	</c:forEach>
</table>
</body>
</html>