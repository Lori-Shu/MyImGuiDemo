<%--
  Created by IntelliJ IDEA.
  User: shuguanglin
  Date: 2021/6/14
  Time: 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>级联查询</title>
    <script type="text/javascript" src="jQuery/jQuery.js"></script>
    <script type="text/javascript">
        $(function () {
             $.get("ProGet",{id:""},function (resp) {
                 $.each(resp,function (i,o) {
                     $("#s1").append("<option value='"+o.id+"'>"+o.name+"</option>");
                 });
             },"json");
             $("#s1").change(function () {
                 $.get("CityGet",{id:$("#s1").val()},function (resp) {
                  $("#s2").empty();
                     $.each(resp,function(i,o){
                         $("#s2").append("<option value='"+o.id+"'>"+o.name+"</option>");
                     });
                 },"json");
             });
        });
    </script>
</head>
<body>
<table>
    <table><tr><td> <select id="s1">
        <option>请选择</option>
    </select></td></tr>
    <tr><td><select id="s2">
    </select></td></tr>
    </table>
</table>
</body>
</html>
