<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-12-09
  Time: 오후 6:25
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
                Board Read Page
            </div>
            <!-- /.panel-heading -->
            <div class="panel-body">

                <%-- edit here--%>

                <div class="form-group">
                    <label>Bno</label> <input class="form-control" name="bno" value='<c:out value="${board.bno}"/>'
                                              readonly="readonly"/>
                </div>

                <div class="form-group">
                    <label>Title</label> <input class="form-control" name="title"
                                                value='<c:out value="${board.title}"/>'
                                                readonly="readonly"/>
                </div>
                <div class="form-group">
                    <label>Text area</label>
                    <textarea class="form-control" rows="3" name="content" readonly="readonly"><c:out value="${board.content}"/></textarea>
                </div>
                <div class="form-group">
                    <label>Writer</label> <input class="form-control" name="writer"
                                                 value='<c:out value="${board.writer}"/>'
                                                 readonly="readonly"/>
                </div>

                <button data-oper="modify" class="btn btn-default"
                        onclick="location.href='/board/modify?bno=<c:out value="${board.bno}"/>'">
                    Modify
                </button>
                <button data-oper="list" class="btn btn-info"
                        onclick="location.href='/board/list'">List
                </button>

                <!-- edit here -->
            </div>
            <!-- /.panel-body -->
        </div>
        <!-- /.panel -->
    </div>
    <!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<%@ include file="../includes/footer.jsp" %>