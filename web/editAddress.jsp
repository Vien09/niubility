<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>My JSP 'index.jsp' starting page</title>
    <script type="text/javascript">
        function cancel() {
            window.location="ShowAllAddressServlet";
        }
        function modify() {
            document.getElementById("modif").submit();
        }
    </script>
</head>
<body>
<form action="${pageContext.request.contextPath}/EditAddressServlet" method="post" id="modif">
<%--    encType="multipart/form-data" id="modif">--%>
    <input type="hidden" name="id" value="${addr.id}">

    收货人:<input type="text" name="consignee" value="${addr.consignee}"><br>
    电话号码:<input type="text" name="phone_no" value="${addr.phone_no}">
    地址:<input type="text" name="address" value="${addr.address}"><br>
    默认地址：
    <input type="radio" name="defalut_addr" value="1" ${addr.default_addr== "1" ? "checked" : ""}>是<br>
    <input type="radio" name="defalut_addr" value="0" ${addr.default_addr== "0" ? "checked" : ""}>否<br>
    <input type="button" value="修改" onclick="modify()">
    <input type="button" value="取消" onclick="cancel()">
</form>
<script type="text/javascript" src="CategoryJS/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="CategoryJS/onloada.js"></script>

</body>
</html>
