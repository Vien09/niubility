package cn.nsu.estore.web.servlet.user.cart;

import cn.nsu.estore.pojo.Cart;
import cn.nsu.estore.pojo.Product;
import cn.nsu.estore.pojo.User;
import cn.nsu.estore.service.CartService;
import cn.nsu.estore.service.ProductService;
import cn.nsu.estore.web.servlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Name : CartServlet
 * @Description :
 * @Author : Vien
 */
@WebServlet(name = "/CartServlet",
        urlPatterns = {"/AddProductToCartServlet","/showCartServlet","/ChangeCountServlet",
                "/RemoveProductFromCartServlet","/RemoveSelectProductFromCartServlet"})
public class CartServlet extends BaseServlet {
    private static final long serialVersionUID = 1L;
//    CartDao cd = new CartDaoImpl();
    CartService cs = new CartService();
    ProductService ps = new ProductService();

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    public void AddProductToCartServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.得到商品id
        String prod_id = request.getParameter("id");
        User user = (User) request.getSession().getAttribute("user");

        try {
            // 2.根据id查询商品
//            ProductService service = new ProductService();
            Product p = ps.findById(Integer.parseInt(prod_id));

            // 从session中获取购物车
            Map<Product, Integer> cart = (Map<Product, Integer>) request.getSession().getAttribute("cart");
            // 如果cart为null,说明，没有购物车，是第一次购物
            if (cart == null) {
                // 创建出购物车
                cart = new HashMap<Product, Integer>();
            }
            // 判断购物车中是滞有当前要买的商品
            Integer count = cart.get(p);
            if (count == null) {
                // 如果为null,说明购物车中没有这个商品，这时商品的数量就为1
                count = 1;
                cs.addProdIntoCart(user.getId(),p.getId(),count);
                cart.put(p, count);
            } else {
                // 如果不为null,说明购物车中有这个商品，这时，就将商品的数量+1

                count += 1;
                cs.update(user.getId(),p.getId(),count);
            }
            // 将商品存储到购物车中
//            cart.put(p, count);
            // 将购物车存储到session中.
            request.getSession().setAttribute("cart", cart);
            response.sendRedirect(request.getContextPath()+"/addProductToCartSuccessfull.jsp");
            //		response.getWriter().write("添加商品到购物车成功，<a href='http://localhost:8080/Estore'>继续购物</a>,<a href='http://localhost:8080/Estore/showcart.jsp'>查看购物车</a>");
            return;

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void showCartServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getSession().removeAttribute("cart");


//        String user_id = request.getParameter("user_id");
        User user = (User) request.getSession().getAttribute("user");
        //调用service中查询操作
        try {
            List<Cart> cartList = cs.findAll(user.getId());
            Map<Product,Integer> cart= new HashMap<>();
            for (Cart cart1 : cartList) {
                cart.put(ps.findById(cart1.getProd_id()), cart1.getSet_num());
            }
            request.getSession().setAttribute("cart", cart);
            request.getRequestDispatcher("/showcart.jsp" ).forward(request, response);
            return;
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public void RemoveProductFromCartServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 得到要删除的商品的id
        int id =Integer.parseInt( request.getParameter("id"));
//        String user_id = request.getParameter("user_id");
        User user = (User) request.getSession().getAttribute("user");
        // 得到购物车，从购物车中将商品删除,
        Map<Product, Integer> cart = (Map<Product, Integer>) request.getSession().getAttribute("cart");


        try {
            Product p=new Product();
            p.setId(id);
            cs.delete(user.getId(),p.getId());
//            cart.remove(p);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //如果购物车中无商品，将购物车删除。
        if (cart.size() == 0 || cart.isEmpty() ) {
            request.getSession().removeAttribute("cart");
        }
//        response.sendRedirect(request.getContextPath() + "/showcart.jsp");
        request.getRequestDispatcher("/showCartServlet").forward(request, response);
    }



    public void RemoveSelectProductFromCartServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] id = request.getParameterValues("id");
        User user = (User) request.getSession().getAttribute("user");

//        Map<Product, Integer> cart = (Map<Product, Integer>) request.getSession().getAttribute("cart");

        try {
            for (int i = 0; i < id.length; i++) {
                Product p = new Product();
                p.setId(Integer.parseInt(id[i]));
                cs.delete(user.getId(),p.getId());
//                cart.remove(p);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

//        response.sendRedirect(request.getContextPath() + "/showcart.jsp");
        request.getRequestDispatcher("/showCartServlet").forward(request, response);
    }


    public void ChangeCountServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //1.得到请求参数
        int prod_id=Integer.parseInt(request.getParameter("id"));
        int count=Integer.parseInt(request.getParameter("count"));
        User user = (User) request.getSession().getAttribute("user");

        //2.修稿购物车的指定数量
        //2.1得到购物车
        Map<Product,Integer> cart=(Map<Product, Integer>) request.getSession().getAttribute("cart");
        //2.2修改购物车中的商品
        Product p=new Product();
        p.setId(prod_id);

        try {
            if (count == 0) {
                // 删除商品
                cs.delete(user.getId(),prod_id);
//                    cart.remove(p);
            } else {
                cs.update(user.getId(),p.getId(),count);
//                    cart.put(p, count);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

//        response.sendRedirect("/showCartServlet");
        request.getRequestDispatcher("/showCartServlet").forward(request, response);
    }


}
