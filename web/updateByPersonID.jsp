<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/12/13
  Time: 22:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新现有电影信息</title>
    <script>
        function submitPersonForm() {
            // 获取表单元素
            var form = document.forms["updatePersonForm"];

            // 创建空对象来保存表单数据
            var formData = {};

            // 遍历表单元素，将每个字段添加到 formData 对象中
            for (var i = 0; i < form.elements.length; i++) {
                var element = form.elements[i];
                // 排除提交按钮和重置按钮
                if (element.type !== "submit" && element.type !== "reset") {
                    formData[element.name] = element.value;
                }
            }

            // 将 formData 转换为 JSON 字符串
            var jsonData = JSON.stringify(formData);

            // 输出到控制台（可选）
            console.log(jsonData);

            var xhr = new XMLHttpRequest();
            xhr.open("POST", "http://localhost:8080/JavaWebMoiveDB_Web_exploded/personUpdate", true);
            xhr.setRequestHeader("Content-Type", "application/json");
            xhr.send(jsonData);
        }

        function confirmDeleteById(movie_id, person_id) {
            // 构造包含参数的 URL
            var url = "http://localhost:8080/JavaWebMoiveDB_Web_exploded/castDelete?movie_id=" + movie_id + "&person_id=" + person_id;
            var xhr = new XMLHttpRequest();
            xhr.open("GET", url, true);
            xhr.send();
        }



        // 添加点击事件处理程序
        document.addEventListener("DOMContentLoaded", function() {
            var newPersonButton = document.getElementById("newPerson");
            newPersonButton.addEventListener("click", function() {
                // 在这里调用你的函数
                newPerson();
            });
        });

        function newPerson() {
            console.log("hello");
            window.location.href = "#";
        }
    </script>
</head>
<body>
<h1>This is the update page. Admin!</h1>
<form name="updatePersonForm" onsubmit="event.preventDefault(); submitPersonForm();" method="post">
    <table align="center">
        <input type="hidden" name="id" value="${person.id}">
        <tr>
            <td>name</td>
            <td><input type="text" name="name" value="${person.name}"></td>
        </tr>
        <tr>
            <td>gender</td>
            <td><input type="number" name="gender" value="${person.gender}"></td>
        </tr>
        <tr >
            <td align="center" colspan="2">
                <input type="submit" value="修改">
                <input type="reset" value="回退" onclick="history.back()">
            </td>
        </tr>

    </table>
</form>


<div>
    <button id="newPerson">添加人员</button>

</div>
</body>
</html>

