<%--
  Created by IntelliJ IDEA.
  User: 云呐的小宝贝
  Date: 2017/12/18
  Time: 21:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <fmt:message key="i18n.user"></fmt:message>

    <br><br>
    <a href="i18n2">i18n2 page</a>

    <br><br>
    <a href="i18n?locale=zh_CN">中文</a>

    <br><br>
    <a href="i18n?locale=en_US">英文</a>
</body>
</html>
