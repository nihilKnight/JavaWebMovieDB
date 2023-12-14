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
        function submitMovieForm() {
            // 获取表单元素
            var form = document.forms["updateMovieForm"];

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
            xhr.open("POST", "http://localhost:8080/JavaWebMoiveDB/movieUpdate", true);
            xhr.setRequestHeader("Content-Type", "application/json");
            xhr.send(jsonData);
        }

        function submitGenreForm() {
            // 获取movie_id的值
            var movieId = ${movie_attribute.movie_id};
            // 获取所有选中的复选框
            var checkboxes = document.getElementsByName("id");
            var selectedIds = [];

            // 遍历复选框，将选中的值添加到数组中
            for (var i = 0; i < checkboxes.length; i++) {
                if (checkboxes[i].checked) {
                    selectedIds.push(checkboxes[i].value);
                }
            }

            // 构建JSON对象
            var data = {
                "movie_id": movieId,
                "genre_ids": selectedIds
            };
            var jsonData = JSON.stringify(data);

            // 输出选中的ID到控制台
            console.log(jsonData);

            var xhr = new XMLHttpRequest();
            xhr.open("POST", "http://localhost:8080/JavaWebMoiveDB/genreUpdate", true);
            xhr.setRequestHeader("Content-Type", "application/json");
            xhr.send(jsonData);
        }

        function confirmDeleteById(movie_id, person_id) {
            // 构造包含参数的 URL
            var url = "http://localhost:8080/JavaWebMoiveDB/castDelete?movie_id=" + movie_id + "&person_id=" + person_id;
            var xhr = new XMLHttpRequest();
            xhr.open("GET", url, true);
            xhr.send();
        }



        // 添加点击事件处理程序
        document.addEventListener("DOMContentLoaded", function() {
            var newCastMoiveButton = document.getElementById("newCastMoive");
            newCastMoiveButton.addEventListener("click", function() {
                // 在这里调用你的函数
                newCastMovie();
            });
        });

        function newCastMovie() {
            var movie_id = ${movie_attribute.movie_id};
            var maxCastId = ${maxCastId};

            console.log("newCastMovie?movie_id="+movie_id+"&cast_id="+(maxCastId+1));
            window.location.href = "newCastMovie?movie_id="+movie_id+"&cast_id="+(maxCastId+1);
        }
    </script>
</head>
<body>
<h1>This is the update page. Admin!</h1>
<form name="updateMovieForm" onsubmit="event.preventDefault(); submitMovieForm();" method="post">
    <table align="center">
        <input type="hidden" name="movie_id" value="${movie_attribute.movie_id}">
        <tr>
            <td>预算</td>
            <td><input type="number" name="budget" value="${movie_attribute.budget}"></td>
        </tr>
        <tr>
            <td>图片链接</td>
            <td><input type="text" name="homepage" value="${movie_attribute.homepage}"></td>
        </tr>
        <tr>
            <td>语言</td>
            <td><input type="text" name="original_language" value="${movie_attribute.original_language}"></td>
        </tr>
        <tr>
            <td>原始标题</td>
            <td><input type="text" name="original_title" value="${movie_attribute.original_title}"></td>
        </tr>
        <tr>
            <td>概览</td>
            <td><input type="text" name="overview" value="${movie_attribute.overview}"></td>
        </tr>
        <tr>
            <td>欢迎度</td>
            <td><input type="text" name="popularity" value="${movie_attribute.popularity}"></td>
        </tr>
        <tr>
            <td>发行日期</td>
            <td><input type="text" name="release_date" value="${movie_attribute.release_date}"></td>
        </tr>
        <tr>
            <td>收入</td>
            <td><input type="text" name="revenue" value="${movie_attribute.revenue}"></td>
        </tr>
        <tr>
            <td>时长</td>
            <td><input type="text" name="runtime" value="${movie_attribute.runtime}"></td>
        </tr>
        <tr>
            <td>状态</td>
            <td><input type="text" name="status" value="${movie_attribute.status}"></td>
        </tr>
        <tr>
            <td>标语</td>
            <td><input type="text" name="tagline" value="${movie_attribute.tagline}"></td>
        </tr>
        <tr>
            <td>标题</td>
            <td><input type="text" name="title" value="${movie_attribute.title}"></td>
        </tr>
        <tr>
            <td>平均评分</td>
            <td><input type="text" name="vote_average" value="${movie_attribute.vote_average}"></td>
        </tr>
        <tr>
            <td>评分数</td>
            <td><input type="text" name="vote_count" value="${movie_attribute.vote_count}"></td>
        </tr>
        <tr >
            <td align="center" colspan="2">
                <input type="submit" value="修改">
                <input type="reset" value="回退" onclick="history.back()">
            </td>
        </tr>

    </table>
</form>

<form name="updateGenreForm" method="post" onsubmit="event.preventDefault(); submitGenreForm()">
    <table align="center">
        <!-- 其他输入字段... -->
        <tr>
            <td>电影类型</td>
            <td>
                <!-- 使用JSTL标签遍历所有电影类型，并生成多选框 -->
                <c:forEach items="${allGenresList}" var="genre">
                    <input type="checkbox" name="id" value="${genre.id}" <c:if test="${selectedGenreList.contains(genre)}">checked</c:if>> ${genre.genre_name}
                </c:forEach>
            </td>
        </tr>
        <tr>
            <td align="center" colspan="2">
                <input type="submit" value="修改">
                <input type="reset" value="回退" onclick="history.back()">
            </td>
        </tr>
    </table>
</form>


<!-- 修改演员列表的显示方式 -->
<div>
    <table id="actorTable" align="center" border="1">
        <tr>
            <td>character_name</td>
            <td>name</td>
            <td>gender</td>
            <td>order_of_appearance</td>
            <td>action</td>
        </tr>
        <c:forEach items="${castPersonList}" var="cpl">
            <tr>
                <td>${cpl.character_name}</td>
                <td>${cpl.name}</td>
                <td>${cpl.gender}</td>
                <td>${cpl.order_of_appearance}</td>
                <td>
                    <a href="selectByMovieIDAndPersonID?movie_id=${cpl.movie_id}&person_id=${cpl.actor_id}">修改演员信息</a>
                    <a href="#" onclick="confirmDeleteById(${cpl.movie_id},${cpl.actor_id});">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<div>
    <button id="newCastMoive">添加演员信息</button>

</div>
</body>
</html>

