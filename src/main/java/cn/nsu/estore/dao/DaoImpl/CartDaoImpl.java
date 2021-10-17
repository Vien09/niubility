package cn.nsu.estore.dao.DaoImpl;

import cn.nsu.estore.dao.CartDao;
import cn.nsu.estore.pojo.Cart;
import cn.nsu.estore.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @Name : CartDaoImpl
 * @Description :
 * @Author : Vien
 */
public class CartDaoImpl implements CartDao {

    QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());


    @Override
    public void addProdIntoCart(int user_id, int product_id,int num) throws SQLException {
        String sql = "insert into shopping_cart values(?,?,?)";

        runner.update(sql,user_id,product_id,num);
    }

    @Override
    public int delete(int user_id, int product_id) throws SQLException {
        String sql = "delete from shopping_cart where user_id=? and prod_id=?";
        int i =	runner.update(sql,user_id,product_id);
        return i;
    }

    @Override
    public List<Cart> findAll(int user_id) throws SQLException {
        Connection connection = DataSourceUtils.getConnection();
        String sql = "select prod_id,set_num from shopping_cart where user_id = " + user_id;
        return runner.query(connection,sql, new BeanListHandler<Cart>(Cart.class));
    }

    @Override
    public void update(int user_id, int product_id, int num) throws SQLException {
        String sql = "update shopping_cart set set_num=? where user_id=? and prod_id=?";
        runner.update(sql, num,user_id,product_id);
    }

}
