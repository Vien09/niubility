<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>编辑收货地址</title>
    <link rel="stylesheet" type="text/css" href="home/CSS/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="home/CSS/main.css">

    <script type="text/javascript">

        // 1. 点击商品名称实现全选，全不选 		START
        function selectCk(main) {
            var flag = main.checked;

            var delCks = document.getElementsByName("delCk");

            for ( var i = 0; i < delCks.length; i++) {

                delCks[i].checked = flag;
            }
        }
        // 1.点击商品名称实现全选，全不选 		END

        //4.删除商品---------贼J8牛逼
        function removeAddress(id) {
            var flag = window.confirm("要删除该地址码?");

            if (flag) {
                //要删除
                location.href = "${pageContext.request.contextPath}/RrmoveAddressServlet?id=" + id;
            }
        }


        //修改地址
        function editAddress(id) {

            location.href = "${pageContext.request.contextPath}/FindAddrByIdServlet?id=" + id ;

        }


        //5.批量删除START
        function delP() {
            var param=""; //它是用于拼接参数.
            var delCks = document.getElementsByName("delCk");
            for ( var i = 0; i < delCks.length; i++) {
                if (delCks[i].checked == true) {
                    param+="id="+delCks[i].value+"&";
                }
            }

            if(param!=""){
                param=param.substring(0,param.length-1);
                location.href="${pageContext.request.contextPath}/RrmoveSelectAddressServlet?"+param;

            }
        };
        //5.批量删除END


        function submitAddress(id){
            location.href="${pageContext.request.contextPath}/submitAddrToOrder?id=" + id;
            // location.href="order.jsp";
        }
        function tocart() {
            location.href="http://localhost:8080/Estore/showcart.jsp";
        }
        function phone(obj) {
            location.href="${pageContext.request.contextPath}/FindCategoryServlet?name="+encodeURIComponent(encodeURIComponent(obj));
        }
        function Add_Address() {
            location.href="http://localhost:8080/Estore/addUserAddr.jsp";
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
        <a href="ProductFindAllServlet">首页</a>
        <a href="javascript:void(0)" onclick="phone('手机')">手机</a>
        <a href="javascript:void(0)" onclick="phone('平板')">平板</a>
        <a href="javascript:void(0)" onclick="phone('笔记本')">笔记本</a>
        <a href="javascript:void(0)" onclick="phone('配件')">配件</a>
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

        <input type="button" value="添加" onclick="Add_Address()">&nbsp;
    </tr>

</div>

<c:if test="${ empty addr }">
    还没设置收货地址！
</c:if>
<!-- 购物车里有数据时的操作			START -->
<c:if test="${not empty addr}">
    <section class="Carts">
        <div class="head">收货地址管理</div>
        <div class="title">
            <ul>
                <li>
                    <div class="Checkbox">
                        <input type="checkbox" id="all-select" value="on" onclick="selectCk(this)"	/>
                        <label for="all-select"></label>
                    </div>
                    全选
                </li>
                <li>收货人</li>
                <li>电话号码</li>
                <li>收货地址</li>
                <li>默认地址</li>
                <li>操作</li>
            </ul>
        </div>
        <ul class="carts-content">

<%--            <c:set var="totalMoney" value="0" />--%>
<%--            <c:set var="totalCount" value="0" />--%>

            <c:forEach items="${addr}" var="a">
                <%int num=(int)(Math.random()*10000);%>
                <ul>
                    <li>
                        <div class="Checkbox">
                            <input type="checkbox" id="<%=num %>"  name="delCk" value="${a.id}"	/>
                            <label for="<%=num %>"></label>
                        </div>
                    </li>
                    <li>
                        <a	href="javascript:void(0)" onclick="editAddress('${a.id}')"></a>
                        <div class="carts-details">${a.consignee}</div>
                    </li>
                    <li>
                        <a	href="javascript:void(0)" onclick="editAddress('${a.id}')"></a>
                        <div class="carts-details">${a.phone_no}</div>
                    </li>
                    <li>
                        <a	href="javascript:void(0)" onclick="editAddress('${a.id}')"></a>
                        <div class="carts-details">${a.address}</div>
                    </li>
                    <li>
                        <a	href="javascript:void(0)" onclick="editAddress('${a.id}')"></a>
                        <div class="carts-details">${a.default_addr}</div>
                    <li>
                        <a	href="javascript:void(0)" onclick="editAddress('${a.id}')">编辑</a>
                        <a	href="javascript:void(0)" onclick="removeAddress('${a.id}')">删除</a>
                    </li>
                </ul>

<%--                <c:set var="totalMoney" value="${totalMoney+c.key.price*c.value}" />--%>
<%--                <c:set var="totalCount" value="${totalCount+c.value}" />--%>

            </c:forEach>



        </ul>
        <div class="carts-foot">
            <ul>
                <li>
                    <div class="Checkbox">
                        <input type="checkbox" id="all-select-1" value="on"	 href="javascript:void(0)" onclick="selectCk(this)"	/>
                        <label for="all-select-1"></label>
                    </div>
                    全选
                </li>
                <li><a  onclick="delP();">删除</a></li>
                <li>&nbsp;</li>
<%--                <li>已选商品<span class="count">${totalCount}</span>件</li>--%>
<%--                <li>合计：<span class="price">${totalMoney}</span></li>--%>
                <li><a class="sum"	onclick="submitAddress()">确定</a></li>
            </ul>
        </div>
    </section>
</c:if>
<!-- 购物车里有数据时的操作			END -->
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