<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 19/04/2023
  Time: 4:38 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Notes</title>
    <link rel="stylesheet" href="resource/style.css" type="text/css">
</head>
<body>
<header>
    <h1>List notes</h1>
    <form method="post" action="notes?action=search">
        <input type="text" name="search" placeholder="Nhập vào đây để tìm kiếm">
        <button type="submit">Tìm kiếm</button>
    </form>


</header>
<c:choose>
    <c:when test="${requestScope['searchResult']!=null}">
        <c:if test="${requestScope['alert']!=null}"><h2>${requestScope['alert']}</h2></c:if>
        <button><a href="notes">Tro lai</a></button>
        <c:if test="${requestScope['one']!=null}">
            <h2>Các kết quả: </h2>
            <div class="container">
                <c:forEach items="${requestScope['one']}" var="note">
                    <div class="note">
                        <h2>${note.getTitle()} <span style="background-color: green;color: white">${note.getType()}</span></h2>
                        <button class="delete"><a href="notes?action=delete&id=${note.getId()}">x</a></button>
                        <p>${note.getContent()}</p>
                    </div>
                </c:forEach>
            </div>
        </c:if>
        <c:if test="${requestScope['many']!=null}">
            <h2>Các kết quả: </h2>
            <div class="container">
                <c:forEach items="${requestScope['many']}" var="note">
                    <div class="note">
                        <h2>${note.getTitle()} <span style="background-color: green;color: white">${note.getType()}</span></h2>
                        <button class="delete"><a href="notes?action=delete&id=${note.getId()}">x</a></button>
                        <p>${note.getContent()}</p>
                    </div>
                </c:forEach>
            </div>
        </c:if>
    </c:when>
    <c:otherwise>

        <div class="container">
            <div class="note" style="display: flex;justify-items: center">
                <h1 style="display: flex;justify-items: center"><a href="notes?action=create" style=" font-size:100px; text-decoration: none">+</a></h1>
            </div>
            <c:forEach items="${requestScope['noteList']}" var="note">
                <div class="note">
                    <h2>${note.getTitle()} <span style="background-color: green;color: white">${note.getType()}</span></h2>
                    <button class="delete"><a href="notes?action=delete&id=${note.getId()}">x</a></button>
                    <p>${note.getContent()}</p>
                    <div style="bottom: 0">
                        <a href="notes?action=edit&id=${note.getId()}">
                            <img src="resource/editIcon.jpg" alt="" style="display: inline-block; height: 30px;width: 30px;float: right">
                        </a>
                    </div>
                </div>
            </c:forEach>
        </div>
    </c:otherwise>
</c:choose>



</body>
</html>
