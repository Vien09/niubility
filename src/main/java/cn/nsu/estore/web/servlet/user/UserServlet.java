package cn.nsu.estore.web.servlet.user;

import cn.nsu.estore.pojo.User;
import cn.nsu.estore.exception.ActiveCodeException;
import cn.nsu.estore.exception.RegistException;
import cn.nsu.estore.service.UserService;
import cn.nsu.estore.utils.ActiveCodeUtils;
import cn.nsu.estore.web.servlet.BaseServlet;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;
import java.util.Map;

/**
 * @Name : UserServlet
 * @Description :
 * @Author : Vien
 */
@WebServlet(name = "/UserServlet", urlPatterns = {"/RegistServlet", "/LoginServlet", "/LoginOutServlet"})
public class UserServlet extends BaseServlet {

    UserService service = new UserService();
    User user = new User();

    public void RegistServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* 2.得到所有请求参数，封装到User对象中.	START*/

        try {
            BeanUtils.populate(user, request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        /* 2.得到所有请求参数，封装到User对象中.	END*/

        // 手动封装激活码
        user.setActivecode(ActiveCodeUtils.getActiveCode());

        /* 3.调用service完成注册操作.		START*/
//        UserService service = new UserService();
        try {
            service.regist(user);

            // 3.1注册成功
            response.sendRedirect(request.getContextPath()
                    + "/regist_success.jsp");
            return;
        } catch (RegistException e) {
            // 3.2注册失败
            request.setAttribute("regist.message", e.getMessage());
            request.getRequestDispatcher("/error/registuser_error.jsp").forward(request,
                    response);
            return;
        }
        /* 3.调用service完成注册操作.		END*/
    }


    public void LoginServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.得到所有请求参数，封装到User对象中.

//        User user = new User();

//        String username = request.getParameter("username");
//        String password = request.getParameter("password");

        try {
            BeanUtils.populate(user, request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        // 2.校验用户名密码数据是否为空为空，
        //如果用户名密码为空，即Map集合中拥有返回的错误信息，即Map的集合有大小
        Map<String, String> map = user.validation();

        if (map.size() != 0) {
            request.setAttribute("map", map);
            request.getRequestDispatcher("/home.jsp").forward(request,
                    response);
            return;
        }


        // 3.调用service中登录的方法
        UserService service = new UserService();
        try {
//            User user1 = service.login(username, password);
            User user1 = service.login(user.getUsername(), user.getPassword());
            // 登录成功

            // 判断是否勾选了记住用户名.
            String remember = request.getParameter("remember");
            if ("on".equals(remember)) {
                // 勾选了--考虑中文问题
                Cookie cookie = new Cookie("remember", URLEncoder.encode(
                        user1.getUsername(), "utf-8"));
                cookie.setMaxAge(10 * 24 * 60 * 60);
                cookie.setPath("/");
                response.addCookie(cookie);
            } else {
                // 如果用户没有勾选记住用户名，将cookie删除。删除cookie，只需要设置maxage=0或-1,注意：要与cookie的path一致.
                Cookie cookie = new Cookie("remember", URLEncoder.encode(
                        user1.getUsername(), "utf-8"));
                cookie.setMaxAge(0);
                cookie.setPath("/");
                response.addCookie(cookie);
            }

            // 自动登录

            String autologin = request.getParameter("autologin");
            if ("on".equals(autologin)) {
                Cookie cookie = new Cookie("autologin", URLEncoder.encode(
                        user1.getUsername(), "utf-8") + "::" + user1.getPassword());
                cookie.setMaxAge(10 * 24 * 60 * 60);
                cookie.setPath("/");
                response.addCookie(cookie);
            } else {
                Cookie cookie = new Cookie("autologin", URLEncoder.encode(
                        user1.getUsername(), "utf-8") + "::" + user1.getPassword());
                cookie.setMaxAge(0);
                cookie.setPath("/");
                response.addCookie(cookie);
            }

            request.getSession().invalidate();//先销毁session。

            request.getSession().setAttribute("user", user1);// 登录成功，将user存储到session中.

            response.sendRedirect("http://localhost:8080/Estore"); // 请求转发只能在本站内跳转........登录成功应该加上用户信息*******
            return;

        } catch (ActiveCodeException e) {
            e.printStackTrace();
            request.setAttribute("login.message", e.getMessage());
            request.getRequestDispatcher("/home.jsp")
                    .forward(request, response);
            return;
        } catch (javax.security.auth.login.LoginException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public void LoginOutServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 注：***************
         * 正常的cookie只能在一个应用中共享，即一个cookie只能由创建它的应用获得。
         * 	可在同一应用服务器内共享方法：设置cookie.setPath("/");
         */
        // 注销功能就是销毁session

        request.getSession().invalidate();

        // 将自动登录的cookie删除。

        Cookie cookie = new Cookie("autologin", "");
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);

        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }
}
