<%--
  Created by IntelliJ IDEA.
  User: shuguanglin
  Date: 2021/6/2
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>省份城市查询</title>
    <script type="text/javascript" src="jQuery/jQuery.js"></script>
    <script type="text/javascript">
        function search(){
            var proid = document.getElementById("proid");
            var proname = document.getElementById("proname");
            var jiancheng = document.getElementById("jiancheng");
            var mcity = document.getElementById("mcity");
            var xmlHR = new XMLHttpRequest();
            xmlHR.onreadystatechange = function (){
                if(xmlHR.readyState == 4 && xmlHR.status == 200){
                             var jsonpdl = xmlHR.responseText;
                             var jsonObj = eval("("+jsonpdl+")");

                          for(var i in jsonObj) {


                              proname.value = jsonObj[i].name;
                              jiancheng.value = jsonObj[i].jiancheng;
                              mcity.value = jsonObj[i].shenghui;
                          }
                }
            }
            xmlHR.open("get","ProGet?id="+proid.value,true);
            xmlHR.send();
        }
        $(function (){ $("#jQuerys").click(function () {
             $.ajax({
                 async:true,
                 contentType:"text",
                 data:"id=2",
                 dataType:"json",
                 error:function (){
                     alert("jQuery实现ajax失败！");
                 },
                 success:function (redata){
                     $.each(redata,function (i,o) {

                         alert(redata[i].name + "----------" + redata[i].jiancheng);
                     })
                 },
                 url:"ProGet",
                 type:"get"
             })
         })
        })
    </script>
</head>
<body>
<table>
    <tr>
        <td>省份编号：</td>
        <td><input type="text" id="proid"></td>
        <td><input type="button" value="查询" onclick="search();"></td>
        <td><input id="jQuerys" type="button" value="jquery查询" ></td>
    </tr>
    <tr>
        <td>省份名：</td>
        <td><input type="text" readonly id="proname"></td>
    </tr>
    <tr>
        <td>简称：</td>
        <td><input type="text" readonly id="jiancheng"></td>
    </tr>
    <tr>
        <td>省会城市：</td>
        <td><input type="text" readonly id="mcity"></td>
    </tr>
</table>
</body>
</html>
