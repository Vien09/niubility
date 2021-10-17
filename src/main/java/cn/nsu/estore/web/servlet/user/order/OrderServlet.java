package cn.nsu.estore.web.servlet.user.order;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.nsu.estore.pojo.Order;
import cn.nsu.estore.pojo.User;
import cn.nsu.estore.service.OrderService;
import cn.nsu.estore.web.servlet.BaseServlet;
import org.apache.commons.beanutils.BeanUtils;

/**
 * Servlet implementation class AddOrderServlet
 */
@WebServlet(name = "/OrderServlet", urlPatterns = {"/AddOrderServlet","/UserCheckOrderServlet"})
public class OrderServlet extends BaseServlet {
    private static final long serialVersionUID = 1L;
    Order order = new Order();
    OrderService os = new OrderService();

    protected void AddOrderServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.得到实体类对象，将数据封装至实体类中
        Order order=new Order();
        try {
            BeanUtils.populate(order, request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        OrderService service=new OrderService();

        try {
            service.addOrder(order);
            response.sendRedirect(request.getContextPath() + "/UserCheckOrderServlet");
//            response.sendRedirect(request.getContextPath() + "/index.jsp");
            return;
        }
//        catch (addOrderException e) {
//            request.setAttribute("addOrder.message", e.getMessage());
//            request.getRequestDispatcher("/error/addOrder_error.jsp").forward(request,response);
//            return;
//        }
        catch (SQLException e) {
            request.setAttribute("addOrder.message", e.getMessage());
            request.getRequestDispatcher("/error/addOrder_error.jsp").forward(request,response);
            return;
        }
    }


    public void UserCheckOrderServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        int id =Integer.parseInt( request.getParameter("id"));
        User user = (User) request.getSession().getAttribute("user");
        List<Order> orders;
        try {
            if (id != 0){
                orders  = os.CheckStateforUser(id,user.getId());

            }else {
                orders =  os.findUserAll(user.getId());
            }

            request.getSession().setAttribute("order",orders);


            request.getRequestDispatcher("ordercheck.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }

//        response.sendRedirect(request.getContextPath() + "/UserCheckOrderServlet");
    }




}
