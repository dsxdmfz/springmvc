<%--
  Created by IntelliJ IDEA.
  User: 云呐的小宝贝
  Date: 2017/10/1
  Time: 23:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script type="text/javascript" src="scripts/jquery-1.9.1.min.js"></script>
    <script type="text/javascript">
      $(function () {
          $("#testJSON").click(function () {
              var url = this.href;
              var args = {};
              $.post(url,args,function (data) {
                  for(var i=0;i<data.length;i++){
                      var id = data[i].id;
                      var name = data[i].lastName

                      alert(id+":"+name);
                  }
              });
              return false;
          });
      })
    </script>
  </head>
  <body>
  <a href="emps">List All Employees</a>
  <br><br>
  <a href="testJSON" id="testJSON">testJSON</a>

  </body>
</html>
