package cn.nsu.estore.web.servlet.manage.order;

import cn.nsu.estore.pojo.Order;
import cn.nsu.estore.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * @Name : ManageOrderServlet
 * @Description :
 * @Author : Vien
 */
public class ManageOrderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String id = req.getParameter("id");

        try {
            OrderService os = new OrderService();
            List<Order> orders  = os.findAll();

            request.getSession().setAttribute("order", orders);
            request.getRequestDispatcher("/showOrders.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}
