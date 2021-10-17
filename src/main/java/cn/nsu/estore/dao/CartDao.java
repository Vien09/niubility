package cn.nsu.estore.dao;

import cn.nsu.estore.pojo.Cart;

import java.sql.SQLException;
import java.util.List;

/**
 * @Name : CartDao
 * @Description :
 * @Author : Vien
 */
public interface CartDao {

    //添加
    public void addProdIntoCart(int user_id, int product_id,int num) throws SQLException;

    //删除
    public int delete(int user_id, int product_id) throws SQLException;

    //查询购物车
    public List<Cart> findAll(int user_id) throws SQLException;

    public void update(int user_id, int product_id,int num) throws SQLException;
}
