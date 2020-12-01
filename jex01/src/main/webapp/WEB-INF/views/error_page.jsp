<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-12-02
  Time: 오후 9:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" import="java.util.*"%>


<html>
<head>
    <meta http-equiv="Content-Type" content="text/html"; charset="UTF-8" />
    <title>Title</title>
</head>

<body>

<h4>
    <c:out value="${exception.getMessage()}" />
</h4>

    <ul>
        <c:forEach items="${exception.getStackTrace()}" var="stack">
            <li>
                <c:out value="${stack}" />
            </li>
        </c:forEach>
    </ul>

</body>
</html>
