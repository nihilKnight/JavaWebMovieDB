<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/12/14
  Time: 13:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新现有演员信息</title>
    <script>
        function searchPerson() {
            var searchInput = document.getElementById("searchPersonInput").value;
            var xhr = new XMLHttpRequest();
            xhr.open("GET", "http://localhost:8080/JavaWebMoiveDB_Web_exploded/SearchActorsServlet?query=" + searchInput, true);

            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4 && xhr.status === 200) {
                    console.log(xhr.responseText);
                    var personList = JSON.parse(xhr.responseText);
                    populateDropdown(personList);
                }
            };

            xhr.send();
        }

        function populateDropdown(personList) {
            var dropdown = document.getElementById("personDropdown");
            dropdown.innerHTML = "";

            for (var i = 0; i < personList.length; i++) {
                var option = document.createElement("option");
                option.text = personList[i].id + "-" + personList[i].name + "-" + personList[i].gender;
                option.value = JSON.stringify(personList[i]);
                dropdown.appendChild(option);
            }
        }

        function addPerson() {
            // 获取用户选择的演员信息
            var selectedActorStr = document.getElementById("personDropdown").value;
            var selectedActor = JSON.parse(selectedActorStr);
            var actorIdInput = document.getElementById("actor_id_input");
            var nameInput = document.getElementById("name_input");

            console.log(selectedActor.id);
            console.log(selectedActor.name);
            // 判断演员是否已被选择
            actorIdInput.value = selectedActor.id;
            nameInput.value = selectedActor.name;

        }

        function submitCastPerson() {
            // 获取表单元素
            var form = document.forms["castPersonForm"];

            // 创建空对象来保存表单数据
            var formData = {};

            // 遍历表单元素，将每个字段添加到 formData 对象中
            for (var i = 0; i < form.elements.length; i++) {
                var element = form.elements[i];
                // 排除提交按钮和重置按钮
                if (element.type !== "submit" && element.type !== "reset" && element.name !== "gender" && element.name !== "name") {
                    formData[element.name] = element.value;
                }
            }

            // 将 formData 转换为 JSON 字符串
            var jsonData = JSON.stringify(formData);

            // 输出到控制台（可选）
            console.log(jsonData);

            var xhr = new XMLHttpRequest();
            xhr.open("POST", "http://localhost:8080/JavaWebMoiveDB_Web_exploded/castInsert", true);
            xhr.setRequestHeader("Content-Type", "application/json");
            xhr.send(jsonData);
        }
    </script>
</head>
<body>
<h1>This is the movie cast update page. Admin!</h1>
<form name="castPersonForm" onsubmit="event.preventDefault(); submitCastPerson();" method="post">
    <table border="0" align="center">
        <input type="hidden" name="movie_id" value="${castPerson.movie_id}">
        <tr>
            <td>character_name</td>
            <td><input type="text" name="character_name" value="${castPerson.character_name}"></td>
        </tr>
        <tr>
            <td>gender</td>
            <td><input type="number" name="gender" value="${castPerson.gender}"></td>
        </tr>
        <tr>
            <td>cast_id</td>
            <td><input type="number" name="cast_id" value="${castPerson.cast_id}" readonly></td>
        </tr>
        <tr>
            <td>order_of_appearance</td>
            <td><input type="number" name="order_of_appearance" value="${castPerson.order_of_appearance}"></td>
        </tr>
        <tr>
            <td>actor_id</td>
            <td><input type="number" name="actor_id" id="actor_id_input" value="${castPerson.actor_id}" readonly></td>
        </tr>
        <tr>
            <td>name</td>
            <td><input type="text" name="name" id="name_input" value="${castPerson.name}" readonly></td>
        </tr>
        <tr >
            <td align="center" colspan="2">
                <input type="submit" value="修改">
                <input type="reset" value="回退" onclick="history.back()">
            </td>
        </tr>

    </table>
</form>

<label for="searchPersonInput">Search Person:</label>
<input type="text" id="searchPersonInput" oninput="searchPerson()">

<select id="personDropdown"></select>
<button onclick="addPerson()">Add Person</button>

</body>
</html>
