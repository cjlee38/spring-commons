<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-12-10
  Time: 오후 9:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@include file="../includes/header.jsp" %>

<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Tables</h1>
    </div>
    <!-- /.col-lg-12 -->
</div>

<!-- /.row -->
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                [Board Modify Page]
            </div>
            <!-- /.panel-heading -->
            <div class="panel-body">

                <%-- edit here--%>
                <form role="form" action="/board/modify" method="post">
                    <div class="form-group">
                        <label>Bno</label> <input class="form-control" name="bno" value='<c:out value="${board.bno}"/>'
                                                  readonly="readonly"/>
                    </div>

                    <div class="form-group">
                        <label>Title</label> <input class="form-control" name="title"
                                                    value='<c:out value="${board.title}"/>'/>
                    </div>
                    <div class="form-group">
                        <label>Text area</label>
                        <textarea class="form-control" rows="3" name="content"><c:out value="${board.content}"/></textarea>
                    </div>
                    <div class="form-group">
                        <label>Writer</label> <input class="form-control" name="writer"
                                                     value='<c:out value="${board.writer}"/>'
                                                     readonly="readonly"/>
                    </div>

<%--                    <div class="form-group">--%>
<%--                        <label>RegDate</label>--%>
<%--                        <input class="form-control" name="regDate"--%>
<%--                               value='<fmt:formatDate pattern="yyyy-MM-dd" value="${board.regDate}"/>'--%>
<%--                               readonly="readonly">--%>
<%--                    </div>--%>

<%--                    <div class="form-group">--%>
<%--                        <label>Update Date</label>--%>
<%--                        <input class="form-control" name="updateDate"--%>
<%--                               value='<fmt:formatDate pattern="yyyy-MM-dd" value="${board.updateDate}"/>'--%>
<%--                               readonly="readonly">--%>
<%--                    </div>--%>

                    <%--에러나는 이유 : BoardVO 의 타입이 String이 아니라 Date로 되어있있어서.--%>
                   <button type="submit" data-oper="modify" class="btn btn-default">
                        Modify
                    </button>

                    <button type="submit" data-oper="remove" class="btn btn-danger">
                        Remove
                    </button>

                    <button type="submit" data-oper="list" class="btn btn-info">
                        List
                    </button>
                </form>

                <!-- edit here -->
            </div>
            <!-- /.panel-body -->
        </div>
        <!-- /.panel -->
    </div>
    <!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<script type="text/javascript">
    $(document).ready(function () {
        var formObj = $("form");

        $('button').on("click", function (e) {
            e.preventDefault();

            var operation = $(this).data("oper");

            console.log(operation);

            if (operation === "remove") {
                formObj.attr('action', "/board/remove");
            } else if (operation === "list") {
                // move to list

                // 이것도 기존 코드는 이렇게 썼는데, 밑에껄로 바꿈.
                // self.location = "/board/list";
                // return;

                formObj.attr('action', "/board/list").attr("method","get");
                formObj.empty();
            }

            formObj.submit();
        });
    });
</script>

<%@ include file="../includes/footer.jsp" %>
