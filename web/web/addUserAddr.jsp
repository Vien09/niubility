<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<%--    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">--%>
    <title>添加地址</title>
    <script type="text/javascript">
        function cancel() {
            window.location="${pageContext.request.contextPath}/ShowAllAddressServlet";
        }
        function add() {
            // var options=$("#threelevel option:selected").val();
            // document.getElementById("c3code").value=options;
            document.getElementById("add").submit();
        }

        function defalut_addr() {
            // var options=$("#threelevel option:selected").val();
            // document.getElementById("c3code").value=options;
            document.getElementsByTagName("radio");
        }

        function backtoAddress() {
            location.href="http://localhost:8080/Estore/showAddress.jsp";
        }
    </script>
</head>
<body>
<div id="preloader">
    <div id="status"></div>
</div>
<header>
    <nav class="navbar navbar-inverse" role="navigation">
        <div class="logo"></div>
        <a href="#">首页</a>
        <a href="javascript:void(0)" onclick="phone('手机')">手机</a>
        <a href="javascript:void(0)" onclick="phone('平板')">平板</a>
        <a href="javascript:void(0)" onclick="phone('笔记本')">笔记本</a>
        <a href="javascript:void(0)" onclick="phone('配件')">配件</a>
        <i class="carts" onclick="tocart()"></i>
        <span>
            <c:if test="${not empty user }">
                <h4 class="user">${user.username}</h4>
                <a class="logout" href="${pageContext.request.contextPath}/LoginOutServlet">注销</a>
            </c:if>
		</span>
    </nav>
</header>

<div>
    <tr>

        <input type="button" value="返回" onclick="backtoAddress()">&nbsp;
    </tr>

</div>



<form action="${pageContext.request.contextPath}/AddressAddServlet" method="post" id="add" >
<%--    encType="multipart/form-data" id="add"--%>
    <table border="1" align="center">
        <tr>
            <td>收货人</td>
            <td><input type="text" name="consignee" ></td>
        </tr>
        <tr>
            <td>电话号码</td>
            <td><input type="text" name="phone_no"></td>
        </tr>
        <tr>
            <td>地址</td>
            <td><input type="text" name="address">
<%--                <input type="hidden" name="address" value=""></td>--%>
<%--            id="address"--%>
        </tr>

        <tr>
            <td>默认地址</td>
            <td>
                <input type="radio" name="defalut_addr" value="1">是
                <input type="radio" name="defalut_addr" value="0" checked>否
            </td>
        </tr>

        <tr>
            <td colspan="2">
<%--                <button class="sign-button submit" type="submit">注册</button>--%>
                <input type="button" value="添加" onclick="add()">
<%--                 <input type="button" value="添加">--%>
                <input type="reset" value="取消" onclick="cancel()">
            </td>
        </tr>
    </table>
</form>
<script type="text/javascript" src="CategoryJS/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="CategoryJS/onloada.js"></script>

</body>
</html>