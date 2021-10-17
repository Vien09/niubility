package cn.nsu.estore.dao;

import cn.nsu.estore.pojo.Order;

import java.sql.SQLException;
import java.util.List;

/**
 * @Name : OrderDao
 * @Description :
 * @Author : Vien
 */
public interface OrderDao {

    //用户下单
    public void addOrder(Order order) throws SQLException;

    //系统删除订单
    public int delById(int oid) throws SQLException;

    //查询所有用户订单
    public List<Order> findAll() throws SQLException;

    //查询该用户所有订单
    public List<Order> findUserAll(int user_id) throws SQLException;

    public List<Order> findForState(int state_id) throws SQLException;

    //修改订单
    public void update(Order order) throws SQLException;

    //输出订单
    public List<Order> outputforUser(int user_id) throws SQLException;

}
