<%@page pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>joke主页</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/content/css/bootstrap.min.css"/>"/>
    <%--引入外部js文件，不要使用<script src="xx"/>这种方式，会找不到，原因未知。--%>
    <script src="<c:url value="/content/js/jquery-3.2.1.min.js"/>"></script>
    <script src="<c:url value="/content/js/bootstrap.min.js"/>"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-2">jokes</div>
    </div>
    <table class="table table-hover">
        <thead>
        <tr class="success">
            <td>#</td>
            <td>类型</td>
            <td>标签</td>
            <td>正文</td>
            <td>作者</td>
        </tr>
        </thead>
        </tbody>
    </table>
</div>
</body>
</html>
