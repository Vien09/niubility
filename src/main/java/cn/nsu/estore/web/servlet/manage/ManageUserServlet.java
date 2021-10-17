package cn.nsu.estore.web.servlet.manage;

import cn.nsu.estore.dao.DaoImpl.UserDao;
import cn.nsu.estore.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * @Name : ManageUserServlet
 * @Description :
 * @Author : Vien
 */
public class ManageUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String id = req.getParameter("id");

        try {
            UserDao us = new UserDao();
            List<User> ulist  = us.findAll();

            request.getSession().setAttribute("ulist", ulist);
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

