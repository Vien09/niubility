package cn.nsu.estore.web.servlet.manage;

import cn.nsu.estore.pojo.Product;
import cn.nsu.estore.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * @Name : ManageServlet
 * @Description :
 * @Author : Vien
 */
@WebServlet("/ManageProdServlet")
public class ManageProdServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String id = req.getParameter("id");

        try {
            ProductService ps = new ProductService();
            List<Product> pro  = ps.findAll();

            request.getSession().setAttribute("pro", pro);
            request.getRequestDispatcher("/showProducts.jsp").forward(request, response);
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
