<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2020-12-09
  Time: 오후 4:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
</div>
<!-- /#page-wrapper -->
</div>
<!-- /#wrapper -->

<!-- jQuery -->
<%--<script src="/resources/vendor/jquery/jquery.min.js"></script>--%>

<!-- Bootstrap Core JavaScript -->
<script src="/resources/vendor/bootstrap/js/bootstrap.min.js"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="/resources/vendor/metisMenu/metisMenu.min.js"></script>

<!-- DataTables JavaScript -->
<script src="/resources/vendor/datatables/js/jquery.dataTables.min.js"></script>
<script src="/resources/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
<script src="/resources/vendor/datatables-responsive/dataTables.responsive.js"></script>

<!-- Custom Theme JavaScript -->
<script src="/resources/dist/js/sb-admin-2.js"></script>

<!-- Page-Level Demo Scripts - Tables - Use for reference -->
<script>
    $(document).ready(function () {
        $('#dataTables-example').DataTable({
            responsive: true
        });
    });
</script>

<script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
            responsive: true
        });
        $(".sidebar-nav")
            .attr("class","sidebar-nav navbar-collapse collapse")
            .attr("aria-expanded",'false')
            .attr("style","height:1px");
    });
</script>

</body>

</html>

<%-- 모바일 크기에서, 새로고침 시에 메뉴가 펼쳐지는 문제를 위한 코드. 근데 그 전에도 괜찮았는데;;--%>
<%--<script>--%>
<%--    $(document).ready(function() {--%>
<%--        $('#dataTables-example').DataTable({--%>
<%--            responsive: true--%>
<%--        });--%>
<%--        $(".sidebar-nav")--%>
<%--            .attr("class", "sidebar-nav navbar-collapse collapse")--%>
<%--            .attr("aria-expanded", 'false')--%>
<%--            .attr("style", "height:1px");--%>
<%--    });--%>
<%--</script>--%>

