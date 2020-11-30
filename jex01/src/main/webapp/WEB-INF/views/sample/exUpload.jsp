<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-11-30
  Time: 오후 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<%--    <meta>--%>
    <title>Title</title>
</head>
<body>

    <form action="/sample/exUploadPost" method="post" enctype="multipart/form-data">

        <div>
            <input type="file" name="files">
        </div>
        <div>
            <input type="file" name="files">
        </div>
        <div>
            <input type="file" name="files">
        </div>
        <div>
            <input type="file" name="files">
        </div>
        <div>
            <input type="file" name="files">
        </div>

        <div>
            <input type="submit"/>
        </div>
    </form>
</body>
</html>
