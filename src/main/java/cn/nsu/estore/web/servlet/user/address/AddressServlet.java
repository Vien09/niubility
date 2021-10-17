package cn.nsu.estore.web.servlet.user.address;

import cn.nsu.estore.pojo.Product;
import cn.nsu.estore.pojo.User;
import cn.nsu.estore.pojo.user_addr;
import cn.nsu.estore.service.UserAddrService;
import cn.nsu.estore.web.servlet.BaseServlet;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @Name : AddressServlet
 * @Description :
 * @Author : Vien
 */
@WebServlet(name = "/AddressServlet",
        urlPatterns = {"/AddressAddServlet","/EditAddressServlet","/RrmoveAddressServlet",
                "/ShowAllAddressServlet","/FindAddrByIdServlet","/RrmoveSelectAddressServlet"})
public class AddressServlet extends BaseServlet implements Serializable {

    private static final long serialVersionUID = 1L;
    user_addr user_addr = new user_addr();
    UserAddrService as = new UserAddrService();

    public void AddressAddServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = (User) request.getSession().getAttribute("user");

        try {

            //将所得信息赋给user_addr对象
            BeanUtils.populate(user_addr, request.getParameterMap());

        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            //调用service中添加方法

            user_addr.setUser_id(user.getId());
            as.add(user_addr);

//                request.getRequestDispatcher("/ShowAllAddressServlet").forward(request, response);
            response.sendRedirect(request.getContextPath() +"/ShowAllAddressServlet");
            return;
        } catch (SQLException e) {
            e.printStackTrace();
            request.getSession().setAttribute("add.message", e.getMessage());
            request.getRequestDispatcher("/addUserAddr.jsp").forward(request, response);
            return;

        }
    }



    public void EditAddressServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        int id =Integer.parseInt( request.getParameter("id"));
//        request.getSession().removeAttribute("addr");
//        user_addr user_addr = new user_addr();
//        UserAddrService as = new UserAddrService();
            try {


                BeanUtils.populate(user_addr, request.getParameterMap());
//                System.out.println(user_addr.getPhone_no());
//                System.out.println(user_addr.getAddress());
                as.update(user_addr);
                response.sendRedirect(request.getContextPath() +"/ShowAllAddressServlet");

//                request.getRequestDispatcher("/ShowAllAddressServlet").forward(request, response);
                return;
            } catch (SQLException e) {
                e.printStackTrace();
                request.getSession().setAttribute("add.message", e.getMessage());
                request.getRequestDispatcher("/addUserAddr.jsp").forward(request,
                        response);
                return;

            } catch (IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

    }



    public void RrmoveAddressServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 得到要删除的商品的id
        int id =Integer.parseInt( request.getParameter("id"));
        // 得到购物车，从购物车中将商品删除,
//        Map<user_addr, Integer> addr = (Map<user_addr, Integer>) request.getSession().getAttribute("cart");

//        user_addr ud = new user_addr();
//        ud.setId(id);
//        addr.remove(ud);
        try {
            as.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect(request.getContextPath() + "/ShowAllAddressServlet");
    }

    public void RrmoveSelectAddressServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String[] id = request.getParameterValues("id");

        try {
            for (int i = 0; i < id.length; i++) {
                as.delete(Integer.parseInt(id[i]));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect(request.getContextPath() + "/ShowAllAddressServlet");
    }



    public void ShowAllAddressServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().removeAttribute("addr");

        User user = (User) request.getSession().getAttribute("user");
//        UserAddrService service = new UserAddrService();

        try {
            List<user_addr> addr = as.findAll(user.getId());
            request.getSession().setAttribute("addr",addr);
//            response.sendRedirect(request.getContextPath() + "/showAddress.jsp");
            request.getRequestDispatcher("/showAddress.jsp" ).forward(request, response);
            return;
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().write(e.getMessage());
        }
    }

    public void FindAddrByIdServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

//        User user = (User) request.getSession().getAttribute("user");
//        UserAddrService service = new UserAddrService();

        try {

            user_addr addr = as.findById(Integer.parseInt(id));
//            List<user_addr> addr = as.findAll(user.getId());
//            System.out.println(id);
            request.getSession().setAttribute("addr",addr);
//            response.sendRedirect(request.getContextPath() + "/showAddress.jsp");
            request.getRequestDispatcher("/editAddress.jsp" ).forward(request, response);
            return;
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().write(e.getMessage());
        }
    }


    public void submitAddrToOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

//        User user = (User) request.getSession().getAttribute("user");
//        UserAddrService service = new UserAddrService();

        try {

            user_addr addr = as.findById(Integer.parseInt(id));
//            List<user_addr> addr = as.findAll(user.getId());
//            System.out.println(id);
            request.getSession().setAttribute("addr",addr);
//            response.sendRedirect(request.getContextPath() + "/showAddress.jsp");
            request.getRequestDispatcher("/order.jsp" ).forward(request, response);
            return;
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().write(e.getMessage());
        }
    }

}
