<%--
  Created by IntelliJ IDEA.
  User: fanlx
  Date: 24/02/2017
  Time: 5:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>student list</title>
</head>
<body>
<c:if test="${!empty list}">
    <c:forEach var="student" items="${list}">
        姓名：${student.name} <br />
    </c:forEach>
</c:if>
</body>
</html>
