<%--
  Created by IntelliJ IDEA.
  User: shuguanglin
  Date: 2021/5/24
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    if((Boolean) request.getAttribute("result")){
        %>
<center><font align="center" color="red" size="60" >添加成功！</font></center>
<%
    }else {
%>
<center><font align="center" color="red" size="60" >添加失败！</font></center>
<%}%>
</body>
</html>
