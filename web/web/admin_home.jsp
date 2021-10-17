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

        function phone(obj) {
            location.href = "${pageContext.request.contextPath}/FindCategoryServlet?name=" + encodeURIComponent(encodeURIComponent(obj));
        }


        <%--function manageS(m_id){--%>
        <%--    location.href = "${pageContext.request.contextPath}/ManageServlet?m_id=" + m_id;--%>
        <%--}--%>


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
<%--        <a href="javascript:void(0)" onclick="manageS('1')">商品管理</a>--%>
        <a href="${pageContext.request.contextPath}/ManageProdServlet">商品管理</a>
        <a href="${pageContext.request.contextPath}/ManageOrderServlet">订单管理</a>
        <a href="${pageContext.request.contextPath}/ManageUserServlet">客户管理</a>
<%--        <a href="javascript:void(0)" onclick="manageS('2')">订单管理</a>--%>
<%--        <a href="javascript:void(0)" onclick="manageS('3')">客户管理</a>--%>

        <span>
            <c:if test="${not empty user }">
                <h4 class="user">${user.username}</h4>
                <a class="logout" href="${pageContext.request.contextPath}/LoginOutServlet">注销</a>
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


<section class="page">
    <aside id="aside" class="panel-group aside-menu">
<%--        <h3 class="type">${p1name }</h3>--%>
<%--        <c:forEach items="${p2name}" var="p" varStatus="vs">--%>
<%--            <dl class="panel panel-default">--%>
<%--                <dt data-toggle="collapse" data-target=".${vs.index}" aria-expanded="true" data-parent="#aside" onclick="selsct(${p.code},${vs.index})">--%>
<%--                    <i></i><span class="collapse-btn">${p.name }</span>--%>
<%--                </dt>--%>
<%--                <div class="${vs.index} collapse" id="${vs.index}">--%>

<%--                </div>--%>
<%--            </dl>--%>
<%--        </c:forEach>--%>
<%--        <c:forEach items="${p3name}" var="p" varStatus="vs">--%>
<%--            <dl class="panel panel-default">--%>
<%--                <dt data-toggle="collapse" data-target=".${vs.index}" aria-expanded="true" data-parent="#aside" onclick="selsct(${p.code},${vs.index})">--%>
<%--                    <i></i><span class="collapse-btn">${p.name }</span>--%>
<%--                </dt>--%>
<%--                <div class="${vs.index} collapse" id="${vs.index}">--%>

<%--                </div>--%>
<%--            </dl>--%>
<%--        </c:forEach>--%>
<%--        <c:forEach items="${p4name}" var="p" varStatus="vs">--%>
<%--            <dl class="panel panel-default">--%>
<%--                <dt data-toggle="collapse" data-target=".${vs.index}" aria-expanded="true" data-parent="#aside" onclick="selsct(${p.code},${vs.index})">--%>
<%--                    <i></i><span class="collapse-btn">${p.name }</span>--%>
<%--                </dt>--%>
<%--                <div class="${vs.index} collapse" id="${vs.index}">--%>

<%--                </div>--%>
<%--            </dl>--%>
<%--        </c:forEach>--%>
    </aside>


<%--    <div class="content">--%>
<%--        <c:forEach items="${pb1.pro}" var="p" varStatus="vs">--%>
<%--            <div class="product">--%>
<%--                <img src="/upload/${p.imgurl}" onclick="findProductById('${p.id}')">--%>
<%--                <span class="brand">${p.name}</span>--%>
<%--                <span class="title">${p.description}</span>--%>
<%--                <span class="price">${p.price}</span>--%>
<%--                <a href="${pageContext.request.contextPath}/ProductFindByIdServlet?id=${p.id}"><em class="fast-buy"></em></a>--%>
<%--            </div>--%>
<%--        </c:forEach>--%>
<%--    </div>--%>
<%--    <ul class="pagination">--%>
<%--        <li><a href="${pageContext.request.contextPath}/ProductFindByPageCodeServlet?pageNum=1&currentPage=${pb1.currentPage}">首页</a></li>--%>
<%--        <li><c:if test="${pb1.pageNum==1}"><a>上一页</a></c:if></li>--%>
<%--        <li><c:if test="${pb1.pageNum!=1}"><a href="${pageContext.request.contextPath}/ProductFindByPageCodeServlet?pageNum=${pb1.pageNum-1}&currentPage=${pb1.currentPage}">上一页</a></c:if></li>--%>
<%--        <c:if test="${pb1.pageNum==pb1.totalPage}"><li><a>下一页</a></li><li><a>尾页</a></li></c:if>--%>
<%--        <li><c:if test="${pb1.pageNum!=pb1.totalPage}">--%>
<%--            <a href="${pageContext.request.contextPath}/ProductFindByPageCodeServlet?pageNum=${pb1.pageNum+1 }&currentPage=${pb1.currentPage}">下一页</a>--%>
<%--            <a href="${pageContext.request.contextPath}/ProductFindByPageCodeServlet?pageNum=${pb1.totalPage }&currentPage=${pb1.currentPage}">尾页</a>--%>
<%--        </c:if></li>--%>
<%--    </ul>--%>
</section>




<aside class="aside-tool">
    <ul>
        <li class="customer">
            <a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=77363191&site=qq&menu=yes">联系客服</a>
        </li>
        <li class="top"></li>
    </ul>
</aside>
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