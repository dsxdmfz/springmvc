<%--
  Created by IntelliJ IDEA.
  User: zhangl
  Date: 2017/5/14
  Time: 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>success</title>
</head>
<body>
    <h4>Success Page</h4>
    time:${requestScope.time}
    <br><br>

    names:${requestScope.name}
    <br><br>

    request user:${requestScope.user}
    <br><br>

    session user:${sessionScope.user}
    <br><br>

    request school:${requestScope.school}
    <br><br>

    session school:${sessionScope.school}
    <br><br>

    <fmt:message key="i18n.username" ></fmt:message>
    <br><br>

    <fmt:message key="i18n.password" ></fmt:message>
    <br><br>

</body>
</html>
