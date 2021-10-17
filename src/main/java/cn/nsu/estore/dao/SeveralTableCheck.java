package cn.nsu.estore.dao;

import cn.nsu.estore.pojo.OrderItem;

import java.sql.SQLException;

/**
 * @Name : SeveralTableCheck
 * @Description :
 * @Author : Vien
 */
public interface SeveralTableCheck {

    //用户查询订单里的商品和商品详情
    public String  CheckOrderItemForUser(OrderItem orderItem) throws SQLException;

}
