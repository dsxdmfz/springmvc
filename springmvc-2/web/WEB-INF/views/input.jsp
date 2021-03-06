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

    <form action="testConversionServiceConverer" method="post">
        Employee: <input type="text" name="employee">
        <input type="submit" value="submit"/>
    </form>
    <br><br>

    <%--
        1. WHY 使用form 标签?
        可以更快速的开发出表单页面，而且可以更方便的进行表单值的回显
        2.注意：
        可以通过modelAttribute 属性指定绑定的模型属性，
        若没有制定该属性，则默认从request 域对象中读取command 的表单bean
        如果该属性值也不存在，则发生错误
    --%>
    <form:form action="${pageContext.request.contextPath }/emp" method="post" modelAttribute="employee">

        <%--<form:errors path="*"></form:errors>--%>
        <%--<br><br>--%>

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
        <form:errors path="email"></form:errors>
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

        <%--
            1.数据类型转换
            2.数据类型格式化
            3.数据校验
            1).如何校验？注解？
            ①. 使用JSR 303验证biaozh
            ②. 加入hibernate validator 验证框架的jar包
            ③. 在springMVC 配置文件中添加<mvc:annotation-driven />
            ④. 在需要的bean 的属性上添加对应的注解
            2).验证出错转向哪一个页面？
            注意：需要校验的bean 对象和其他绑定结果对象或错误对象是成对出现的，它们之间不允许声明其它的入参
            3).错误消息？如何显示，如把错误消息进行国际化
        --%>
        Birth:<form:input path="birth"/>
        <form:errors path="birth"></form:errors>
        <br>
        Salary:<form:input path="salary"/>
        <form:errors path="salary"></form:errors>
        <br>

        <input type="submit" value="submit"/>
    </form:form>
</body>
</html>
