<%--
  Created by IntelliJ IDEA.
  User: shuguanglin
  Date: 2021/5/27
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>试题修改结果</title>
</head>
<body>
<%
if((Boolean) request.getAttribute("result")){

%>
<center><font color="red" size="50">修改成功！</font> </center>
<%
    }else{
%>
<center><font color="red" size="50">修改失败！</font> </center>
<%}%>
</body>
</html>
