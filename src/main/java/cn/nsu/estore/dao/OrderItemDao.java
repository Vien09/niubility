package cn.nsu.estore.dao;

import cn.nsu.estore.pojo.Order;
import cn.nsu.estore.pojo.OrderItem;

import java.sql.SQLException;
import java.util.List;

/**
 * @Name : OrderItemDao
 * @Description :
 * @Author : Vien
 */
public interface OrderItemDao {

    //用户下单
    public void addOrder(OrderItem orderItem) throws SQLException;

    //查询所有用户订单
    public List<OrderItem> findAll(int order_id) throws SQLException;


}
