<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: 云呐的小宝贝
  Date: 2017/10/15
  Time: 22:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--
        1. WHY 使用form 标签?
        可以更快速的开发出表单页面，而且可以更方便的进行表单值的回显
        2.注意：
        可以通过modelAttribute 属性指定绑定的模型属性，
        若没有制定该属性，则默认从request 域对象中读取command 的表单bean
        如果该属性值也不存在，则发生错误
    --%>
    <form:form action="${pageContext.request.contextPath }/emp" method="post" modelAttribute="employee">
        <c:if test="${employee.id == null }">
            <!-- path 属性对应 html 表单标签的 name 属性值 -->
            LastName: <form:input path="lastName"/>
            <form:errors path="lastName"></form:errors>
        </c:if>
        <c:if test="${employee.id != null }">
            <form:hidden path="id"/>
            <input type="hidden" name="_method" value="PUT"/>
            <%-- 对于 _method 不能使用 form:hidden 标签, 因为 modelAttribute 对应的 bean 中没有 _method 这个属性 --%>
            <%--
            <form:hidden path="_method" value="PUT"/>
            --%>
        </c:if>
        <br>
        email: <form:input path="email"/>
        <br>
        <%
            Map<String, String> genders = new HashMap();
            genders.put("1", "Male");
            genders.put("0", "Female");

            request.setAttribute("genders", genders);
        %>
        gender:
        <br>
        <form:radiobuttons path="gender" items="${genders}" delimiter="<br>"/>
        <br>
        department: <form:select path="department.id" items="${departments}"
                                itemLabel="departmentName" itemValue="id"/>
        <br>
        <input type="submit" value="submit"/>
    </form:form>
</body>
</html>
