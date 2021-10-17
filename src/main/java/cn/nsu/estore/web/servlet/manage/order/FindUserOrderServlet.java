package cn.nsu.estore.web.servlet.manage.order;

import cn.nsu.estore.pojo.Order;
import cn.nsu.estore.pojo.User;
import cn.nsu.estore.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * @Name : FindUserOrderServlet
 * @Description :
 * @Author : Vien
 */
@WebServlet("/FindUserOrderServlet")
public class FindUserOrderServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            OrderService os = new OrderService();

            User user = (User) request.getSession().getAttribute("checkname");
            List<Order> orders  = os.findUserAll(user.getId());

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
