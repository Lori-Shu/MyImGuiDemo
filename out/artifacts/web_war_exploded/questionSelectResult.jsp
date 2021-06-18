<%@ page import="java.util.List" %>
<%@ page import="UserQuestion.Question" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: shuguanglin
  Date: 2021/5/25
  Time: 12:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>问题查询结果</title>
</head>
<body>
<table align="center" style="color: deepskyblue; border-color: rebeccapurple; background-color: aquamarine" border="20px">
       <tr>
           <th>编号</th>
           <th>问题内容</th>
           <th>选项A</th>
           <th>选项B</th>
           <th>选项C</th>
           <th>选项D</th>
           <th>正确答案</th>
           <th colspan="2">操作</th>
       </tr>
     <% List questions = (List) request.getAttribute("questions");
    for(Object q : questions) {

        int no = ((Question)q).getNo();
        String questionx = ((Question)q).getQuestion();
        String answerA = ((Question)q).getAnswerA();
        String answerB = ((Question)q).getAnswerB();
        String answerC = ((Question)q).getAnswerC();
        String answerD = ((Question)q).getAnswerD();
        String answer = ((Question)q).getAnswer();
%>
    <tr>
        <td><%=no%></td>
        <td><textarea readonly cols="70" rows="5"><%=questionx%></textarea></td>
        <td><%=answerA%></td>
        <td><%=answerB%></td>
        <td><%=answerC%></td>
        <td><%=answerD%></td>
        <td><%=answer%></td>
        <td><a href="QuestionDelete?no=<%=no%>">删除试题</a> </td>
        <td><a href="QuestionFind?no=<%=""+no%>">修改试题</a> </td>
    </tr>
    <%}%>
</table>
</body>
</html>
