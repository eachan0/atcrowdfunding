<%--
  Created by IntelliJ IDEA.
  User: zhuyc
  Date: 2020/4/20
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>错误</title>
</head>
<body>
    <h1>出错了</h1>
    ${requestScope.exception.message}
</body>
</html>
