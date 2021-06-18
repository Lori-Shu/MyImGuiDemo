<%@ page import="java.util.List" %>
<%@ page import="UserQuestion.Question" %><%--
  Created by IntelliJ IDEA.
  User: shuguanglin
  Date: 2021/5/27
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>考试页面</title>
</head>
<body>
 <%
 List testList = (List) request.getAttribute("testList");
 %>
<form action="TestManage">
    <table border="1" align="center" >
        <tr>
            <th>问题区</th>
            <th>选项A</th>
            <th>选项B</th>
            <th>选项C</th>
            <th>选项D</th>
            <th>作答区</th>
        </tr>
        <%
        for(Object q : testList){
            Question question = (Question) q;

        %>
        <tr>
            <td><%=question.getQuestion()%></td>
            <td><%=question.getAnswerA()%></td>
            <td><%=question.getAnswerB()%></td>
            <td><%=question.getAnswerC()%></td>
            <td><%=question.getAnswerD()%></td>
            <td><label>A
                <input type="radio" name="answer_<%=question.getNo()%>" value="A">
                B
                <input type="radio" name="answer_<%=question.getNo()%>" value="B">
                C
                <input type="radio" name="answer_<%=question.getNo()%>" value="C">
                D
                <input type="radio" name="answer_<%=question.getNo()%>" value="D">
                <input type="text" name="no" value="<%=question.getNo()%>" hidden>
            </label></td>
        </tr>
        <%}%>
        <tr>
            <td colspan="2"><input type="submit" value="提交试卷"></td>
        </tr>
    </table>
</form>
</body>
</html>
