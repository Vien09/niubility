<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="home/CSS/jquery-ui.css">
    <link rel="stylesheet" type="text/css" href="home/CSS/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="home/CSS/main.css">
    <script type="text/javascript">
        function del(id) {

            var flag = window.confirm("确认删除吗");

            if (flag) {
                //确认删除
                location.href = "${pageContext.request.contextPath}/ProductDelByIdServlet?id=" + id;
            }
        };

        function change() {
            //1.得到id为main的这个checkbox
            var main = document.getElementById("main");

            var flag = main.checked;

            //2.得到所有name=ck的checkbox
            var cks = document.getElementsByName("ck");

            //3.将cks中所有的checkbox的checked值设置为flag
            for ( var i = 0; i < cks.length; i++) {
                cks[i].checked = flag;
            }
        };

        function sendDel(){
            var flag = window.confirm("确认删除吗");

            if (flag) {
                //确认删除
                document.getElementById("f").submit();//表单提交
            }

            var cks = document.getElementsByName("ck");

        };

        function sel() {
            var msg = document.getElementById("msg").value;
            if(msg==null||msg=="")
                alert("请输入你要查询的内容！！！");
            document.getElementById("s").submit();

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
        <a href="${pageContext.request.contextPath}/ManageProdServlet">商品管理</a>
        <a href="${pageContext.request.contextPath}/ManageOrderServlet">订单管理</a>
        <a href="${pageContext.request.contextPath}/ManageUserServlet">客户管理</a>

        <span>
            <c:if test="${not empty user }">
                <h4 class="user">${user.username}</h4>
                <a class="logout" href="${pageContext.request.contextPath}/LoginOutServlet">注销</a>
            </c:if>
		</span>
    </nav>
</header>

<c:if test="${empty olist}">
    该用户无订单信息<br>
    <a href="${pageContext.request.contextPath}/CategoryServlet">添加</a>
</c:if>


<c:if test="${not empty olist}">
<%--    <div align="center">--%>
<%--        <form action="${pageContext.request.contextPath}/ProductSimpleServlet" method="post" id="s">--%>
<%--            <select name="field">--%>
<%--                <option disabled="disabled">请选择条件</option>--%>
<%--                <option value="name">按商品名称查询</option>--%>
<%--                <option value="description">按商品描述查询</option>--%>
<%--            </select>--%>
<%--            <input type="text" name="msg" id="msg">--%>
<%--            <input type="button" value="查询" onclick="sel()">--%>
<%--        </form>--%>
<%--    </div>--%>
    <br>
    <form action="${pageContext.request.contextPath}/ProductDelSelectServlet" method="post" id="f">
        <table border="1" align="center" width="85%">
            <tr>
<%--                <td><input type="checkbox" id="main" onclick="change();">--%>
<%--                </td>--%>
                <td>订单编号</td>
                <td>合计</td>
                <td>收货地址</td>
                <td>订单状态</td>
                <td>下单日期</td>
                <td>操作</td>
            </tr>

            <c:forEach items="${olist}" var="o">
                <tr>
                    <td><input type="checkbox" value="${o.id}" name="ck"></td>
<%--                    点击单号进入订单详情--%>
                    <td><a href="${pageContext.request.contextPath}/GetUserOrderServlet?id=${o.id}"></a></td>
                    <td>${o.money}</td>
                    <td><a href="${pageContext.request.contextPath}/GetUserOrderServlet?id=${o.receiverinfo}">收货人</a></td>
                    <td>${o.state }</td>
                    <td>${o.ordertime }</td>
                    <td><a href="${pageContext.request.contextPath}/ProductEditServlet?id=${o.id}">编辑</a>
<%--                        <a href="javascript:void(0)" onclick="del('${o.id}')">删除</a>--%>
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="10"><a href="javascript:void(0)" onclick="sendDel();">删除选中</a></td>
                <td><a href="${pageContext.request.contextPath}/CategoryServlet">添加</a>
                </td>
            </tr>
        </table>
    </form>
</c:if>


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