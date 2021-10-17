<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="home/CSS/jquery-ui.css">
    <link rel="stylesheet" type="text/css" href="home/CSS/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="home/CSS/main.css">
    <script type="text/javascript">
        window.onload = function () {
            var username = document.getElementById("username");
            username.value = window.decodeURIComponent("${cookie.remember.value}", "utf-8");
        };

        function change() {
            document.getElementById("cimg").src = "${pageContext.request.contextPath}/checkImg?time="
                + new Date().getTime();
        };

        function findProductById(id) {
            location.href = "http://localhost:8080/Estore/ProductFindByIdServlet?id=" + id;
        };

        function phone1(obj) {
            location.href = "http://localhost:8080/Estore/showProducts";
        }

        function phone2(obj) {
            location.href = "${pageContext.request.contextPath}/FindCategoryServlet?name=" + encodeURIComponent(encodeURIComponent(obj));
        }

        function phone3(obj) {
            location.href = "${pageContext.request.contextPath}/FindCategoryServlet?name=" + encodeURIComponent(encodeURIComponent(obj));
        }

        function tocart() {

            <c:if test="${not empty user }">
            // location.href = "http://localhost:8080/Estore/showcart.jsp";
            location.href = "http://localhost:8080/Estore/showCartServlet?user_id="+ '${user.id}';
            </c:if>
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
        <a href="javascript:void(0)" onclick="phone1('商品详情')">商品详情</a>
        <a href="javascript:void(0)" onclick="phone2('订单管理')">订单管理</a>
        <a href="javascript:void(0)" onclick="phone3('用户管理')">用户管理</a>
        <i class="carts" onclick="tocart()"></i>
        <span>
            <c:if test="${not empty user }">
            <h4 class="user">${user.username}</h4>
            <a class="logout" href="${pageContext.request.contextPath}/LoginOutServlet">注销</a>
            </c:if>
			<c:if test="${ empty user }">
                <h4 class="signin" data-toggle="modal" data-target="#log-wrapper">登录</h4>
                <h4 class="signup" data-toggle="modal" data-target="#log-wrapper">注册</h4>
            </c:if>
		</span>
    </nav>
</header>



<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
        <li data-target="#carousel-example-generic" data-slide-to="1"></li>
        <li data-target="#carousel-example-generic" data-slide-to="2"></li>
        <li data-target="#carousel-example-generic" data-slide-to="3"></li>
        <li data-target="#carousel-example-generic" data-slide-to="4"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
        <div class="item active">
            <img src="home/img/22d94f6e50d98f6f68308814ff9795e2.jpg" alt="..." onclick="phone('手机')">
            <div class="carousel-caption">

            </div>
        </div>
        <div class="item">
            <img src="home/img/macbookpro_large.jpg" alt="..." onclick="phone('笔记本')">
            <div class="carousel-caption">

            </div>
        </div>
        <div class="item">
            <img src="home/img/iphone_square_large.jpg" alt="..." onclick="phone('手机')">
            <div class="carousel-caption">
            </div>
        </div>

        <div class="item">
            <img src="home/img/holiday_hero_subhead_2a_largetall.jpg" alt="..." onclick="phone('手机')">
            <div class="carousel-caption">
            </div>
        </div>

        <div class="item">
            <img src="home/img/tile_macos_large.jpg" alt="..." onclick="phone('手机')">
            <div class="carousel-caption">
            </div>
        </div>

    </div>

    <!-- Controls -->
    <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right"></span>
        <span class="sr-only">Next</span>
    </a>
</div>

<footer>
    <div>
        <ul>
            <li>开发人员1</li>
            <li>men1</li>
        </ul>
        <ul>
            <li>开发人员2</li>
            <li>men2</li>
        </ul>
    </div>
</footer>
<script type="text/javascript" src="home/JS/jquery.min.js"></script>
<script type="text/javascript" src="home/JS/jquery-ui.js"></script>
<script type="text/javascript" src="home/JS/bootstrap.min.js"></script>
<script type="text/javascript" src="home/JS/bg-canvas.js"></script>
<script type="text/javascript" src="home/JS/main.js"></script>
</body>
</html>