<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="home/CSS/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="home/CSS/main.css">

    <script type="text/javascript">
        function toAddress() {
            // location.href="http://localhost:8080/Estore/showAddress.jsp";
            window.location="ShowAllAddressServlet";
        }
        function back_tohome() {
            // location.href="http://localhost:8080/Estore/showAddress.jsp";
            window.location="HomeServlet";
        }


        function stateSet(id){
            location.href = "${pageContext.request.contextPath}/UserCheckOrderServlet?id=" + id;
        }

        function phone(obj) {
            location.href="${pageContext.request.contextPath}/FindCategoryServlet?name="+encodeURIComponent(encodeURIComponent(obj));
        }

    </script>
</head>
<body>
<header>
    <nav class="navbar navbar-inverse" role="navigation">
        <div class="logo"></div>
<%--        <a href="ProductFindAllServlet">全部订单</a>--%>
        <a href="javascript:void(0)" onclick="stateSet('0')">全部订单</a>
        <a href="javascript:void(0)" onclick="stateSet('1')">待付款</a>
        <a href="javascript:void(0)" onclick="stateSet('2')">待发货</a>
        <a href="javascript:void(0)" onclick="stateSet('3')">待收货</a>
        <a href="javascript:void(0)" onclick="stateSet('4')">待评价</a>
        <span class="slider-bar"></span>
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

        <input type="button" value="返回" onclick="back_tohome()">&nbsp;
    </tr>

</div>

<c:if test="${ empty order }">
    还没有订单哦
</c:if>
<!-- 购物车里有数据时的操作			START -->
<c:if test="${not empty order}">
    <c:forEach items="${order}" var="o">
<section class="order">
    <div class="head">${order.id}</div>
    <div class="title">
        <ul>
            <li>商品名称</li>
            <li>单价</li>
            <li>数量</li>
            <li>总价</li>
            <li>订单状态</li>
        </ul>
        </ul>
    </div>

    <c:set value="0" var="money"></c:set>
    <ul class="order-content">

            <ul>
                <li>
                    <img src="/upload/${c.key.imgurl}">
                </li>
                <li><div class="order-details">${c.key.description}</div></li>
                <li><span class="price">${c.key.price }</span></li>
                <li><span class="order-count">${c.value}</span></li>
                <li><span class="order-state">${c.state}</span></li>
            </ul>
            <c:set value="${money+c.key.price*c.value}" var="money"></c:set>
        </c:forEach>

        <div class="order-sum">${money}</div>
    </ul>
    <div class="order-foot">
        <ul>
            <li>
                <div class="order-adress">
                    <input aria-label="送货地址" placeholder="送货地址" type="text">
                </div>
            </li>
<%--            <li><a class="sum-btn"	href="${pageContext.request.contextPath}/AddOrderServlet">生成订单</a></li>--%>

        </ul>
    </div>

</section>
</c:if>
<aside class="aside-tool">
    <ul>
        <li class="customer">
            <a href="http://wpa.qq.com/msgrd?v=3&uin=476759153&site=qq&menu=yes" target=_blank
               clickid=guanwang_navigation_customer>联系客服</a>
        </li>
        <li class="top"></li>
    </ul>
</aside>
<footer>
    <div>
        <ul>
            <li>开发人员1</li>
            <li>唐宗博</li>
        </ul>
        <ul>
            <li>开发人员2</li>
            <li>辜鹏</li>
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