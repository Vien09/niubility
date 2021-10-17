package cn.nsu.estore.web.servlet.manage.order;

import cn.nsu.estore.pojo.Order;
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
 * @Name : GetUserOrderServlet
 * @Description :
 * @Author : Vien
 */
@WebServlet("/GetUserOrderServlet")
public class GetUserOrderServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        try {
            OrderService os = new OrderService();
            List<Order> olist  = os.findUserAll(Integer.parseInt(id));

            request.getSession().setAttribute("olist", olist);
//            response.sendRedirect("ProductFindByPageCodeServlet?code="+code);
            request.getRequestDispatcher("/showUsers.jsp").forward(request, response);
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
