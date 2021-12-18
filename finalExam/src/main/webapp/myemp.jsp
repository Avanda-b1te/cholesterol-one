<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>个人信息</title>
</head>
学院:
<%=request.getParameter("dept")%>
姓名
<%=request.getParameter("name")%>
出生日期
<%=request.getParameter("birthday") %>
</body>
</html>