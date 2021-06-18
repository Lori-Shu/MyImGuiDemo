<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: shuguanglin
  Date: 2021/5/26
  Time: 12:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>试题修改页</title>
</head>
<body>
<%
  List list = (List) request.getAttribute("findResult");
%>
<form action="QuestionUpdate">
<table align="center" style="background-color: aliceblue; color: deepskyblue" border="2">
  <tr>
    <td>试题编号：</td>
    <td><input type="text" name="no" value="<%=list.get(0)%>" readonly></td>
  </tr>
  <tr>
    <td>试题内容：（以问号结尾 )</td>
    <td><label>
      <textarea rows="3" cols="100" name="question"><%=list.get(1)%></textarea>
    </label></td>
  </tr>
  <tr>
    <td>A</td>
    <td><label>
      <textarea rows="3" cols="20" name="answerA"><%=list.get(2)%></textarea>
    </label></td>
  </tr>
  <tr>
    <td>B</td>
    <td><label>
      <textarea rows="3" cols="20" name="answerB"><%=list.get(3)%></textarea>
    </label></td>
  </tr>
  <tr>
    <td>C</td>
    <td><label>
      <textarea rows="3" cols="20" name="answerC"><%=list.get(4)%></textarea>
    </label></td>
  </tr>
  <tr>
    <td>D</td>
    <td><label>
      <textarea rows="3" cols="20" name="answerD"><%=list.get(5)%></textarea>
    </label></td>
  </tr>
  <tr>
    <td>正确答案</td>
    <td><label>A
      <input type="radio" name="answer" value="A" <%=list.get(6).equals("A") ? "checked":""%>>
      B
      <input type="radio" name="answer" value="B" <%=list.get(6).equals("B") ? "checked": ""%>>
      C
      <input type="radio" name="answer" value="C" <%=list.get(6).equals("C") ? "checked": ""%>>
      D
      <input type="radio" name="answer" value="D"  <%=list.get(6).equals("D") ? "checked": ""%>>
    </label></td>
  </tr>
  <tr>
    <td><input type="submit" value="确认上传"></td>
  </tr>
</table>
</form>
</body>
</html>
