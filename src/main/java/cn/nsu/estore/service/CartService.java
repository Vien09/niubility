package cn.nsu.estore.service;

import cn.nsu.estore.dao.CartDao;
import cn.nsu.estore.dao.DaoImpl.CartDaoImpl;
import cn.nsu.estore.pojo.Cart;

import java.sql.SQLException;
import java.util.List;

/**
 * @Name : CartService
 * @Description :
 * @Author : Vien
 */
public class CartService {
    CartDao cartDao = new CartDaoImpl();

    public void addProdIntoCart(int user_id, int product_id, int num) throws SQLException {
       cartDao.addProdIntoCart(user_id, product_id,num);
    }

    public int delete(int user_id, int product_id) throws SQLException {
       return cartDao.delete(user_id, product_id);
    }

    public List<Cart> findAll(int user_id) throws SQLException {
        return cartDao.findAll(user_id);
    }

    public void update(int user_id, int product_id, int num) throws SQLException {
     cartDao.update(user_id, product_id, num);
    }
}
