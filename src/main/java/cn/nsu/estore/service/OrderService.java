package cn.nsu.estore.service;

import cn.nsu.estore.dao.DaoImpl.OrderDaoImpl;
import cn.nsu.estore.pojo.Order;

import java.sql.SQLException;
import java.util.List;

public class OrderService {
//    public int addOrder(Order order) throws addOrderException {
//        OrderDao dao=new OrderDao();
//        int i = 0;
//
//        try {
//            i = dao.addOrder(order);
//        } catch (SQLException e) {
//            throw new addOrderException("订单提交失败");
//        }
//        return i;
//    }
    
    OrderDaoImpl orderDao = new OrderDaoImpl();

    
    public void addOrder(Order order) throws SQLException {
        orderDao.addOrder(order);
    }

    
    public int delById(int oid) throws SQLException {

        return orderDao.delById(oid);
    }

    
    public List<Order> findAll() throws SQLException {
        return orderDao.findAll();
    }

    
    public List<Order> findUserAll(int user_id) throws SQLException {
        return orderDao.findUserAll(user_id);
    }

    
    public List<Order> findForState(int state_id) throws SQLException {
        return orderDao.findForState(state_id);
    }

    
    public void update(Order order) throws SQLException {
        orderDao.update(order);
    }

    public List<Order> CheckStateforUser(int state_id,int user_id) throws SQLException {
       return orderDao.CheckStateforUser(state_id,user_id);
    }
    
    


}
