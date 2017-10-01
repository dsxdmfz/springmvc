<%--
  Created by IntelliJ IDEA.
  User: 云呐的小宝贝
  Date: 2017/8/6
  Time: 22:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>index</title>
</head>
<body>

<a href="/springMVC/testRedirect">testRedirect</a>
<br><br>

<a href="/springMVC/testView">testView</a>
<br><br>

<a href="/springMVC/testViewAndViewResolver">testViewAndViewResolver</a>
<br><br>

<form action="/springMVC/testModelArribute" method="post">
  <input type="hidden" name="id" value="1">
  username:<input type="text" name="username" value="Tom"><br>
  age:<input type="text" name="age" value="13"><br>
  email:<input type="text" name="email" value="Tom@123.com"><br>
  <input type="submit" name="submit">
</form>
<br><br>

<a href="/springMVC/testSessionAttributes">testSessionAttributes</a>
<br><br>

<a href="/springMVC/testMap">testMap</a>
<br><br>

<a href="/springMVC/testModelAndView">testModelAndView</a>
<br><br>

<a href="/springMVC/testServletAPI">testServletAPI</a>
<br><br>

<form action="/springMVC/testPojo" method="post">
  username:<input type="text" name="username"><br>
  password:<input type="password" name="password"><br>
  age:<input type="text" name="age"><br>
  email:<input type="text" name="email"><br>
  province:<input type="text" name="address.province"><br>
  city:<input type="text" name="address.city"><br>
  <input type="submit" name="submit">
</form>
<br><br>

<a href="/springMVC/testCookieValue">testCookieValue</a>
<br><br>

<a href="/springMVC/testRequestHeader">testRequestHeader</a>
<br><br>

<a href="/springMVC/testRequestParam?username=zhangel&age=10">testRequestParam</a>
<br><br>

<form action="/springMVC/testRest/1" method="post">
  <input type="hidden" name="_method" value="PUT">
  <input type="submit" value="testRestPut">
</form>
<br><br>

<form action="/springMVC/testRest/1" method="post">
  <input type="hidden" name="_method" value="DELETE">
  <input type="submit" value="testRestDelete">
</form>
<br><br>

<form action="/springMVC/testRest" method="post">
  <input type="submit" value="testRestPost">
</form>
<br><br>

<a href="/springMVC/testRest/1">testRestGet</a>
<br><br>

<a href="/springMVC/testPathVariable/1">testPathVariable</a>
<br><br>

<a href="/springMVC/testAntMethod/qwe/abc">testAntMethod</a>
<br><br>

<a href="/springMVC/testParamsAndHeaders?username=zhangel&age=10">testParamsAndHeaders</a>
<br><br>

<form action="/springMVC/testMethod" method="post">
  <input type="submit" value="submit">
</form>
<br><br>

<a href="/springMVC/testMethod">testMethod</a>
<br><br>

<a href="/springMVC/testRequestMapping">Test RequestMapping</a>
<br><br>

<a href="/helloworld">Hello World</a>

</body>
</html>
