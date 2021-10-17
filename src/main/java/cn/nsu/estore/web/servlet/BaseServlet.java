package cn.nsu.estore.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @Name : BaseServlet
 * @Description :
 * @Author : Vien
 */
public abstract class BaseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//      String action = req.getParameter("action");

        String uri = req.getRequestURI();
        String action = uri.substring(uri.lastIndexOf('/') + 1);
      try {
          Method method = this.getClass().getDeclaredMethod(action,HttpServletRequest.class,HttpServletResponse.class);
          method.invoke(this,req,resp);


      }catch (Exception e){
          e.printStackTrace();
      }
    }
}
