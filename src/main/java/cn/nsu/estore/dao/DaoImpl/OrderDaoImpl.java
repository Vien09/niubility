package cn.nsu.estore.dao.DaoImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import cn.nsu.estore.dao.OrderDao;
import cn.nsu.estore.pojo.Order;
import cn.nsu.estore.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class OrderDaoImpl implements OrderDao {

    QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

    @Override
    public void addOrder(Order order) throws SQLException {
        String sql = "insert into orders values(null,?,?,?,?,now())";

        runner.update(sql,order.getUser_id(),order.getMoney(),order.getUser_addr_id(),order.getState());
    }

    @Override
    public int delById(int oid) throws SQLException {
        String sql = "delete from orders where id=?";
        int i =	runner.update(sql, oid);
        return i;
    }

    @Override
    public List<Order> findAll() throws SQLException {
        Connection connection = DataSourceUtils.getConnection();
        String sql = "select * from orders ";
        return runner.query(connection,sql, new BeanListHandler<Order>(Order.class));
    }



    @Override
    public List<Order> findForState(int state_id) throws SQLException {
        Connection connection = DataSourceUtils.getConnection();
        String sql = "select * from orders where state=" + state_id;
        return runner.query(connection,sql, new BeanListHandler<Order>(Order.class));
    }

    @Override
    public List<Order> findUserAll(int user_id) throws SQLException {
        Connection connection = DataSourceUtils.getConnection();
        String sql = "select * from orders where user_id=" + user_id;
        return runner.query(connection,sql, new BeanListHandler<Order>(Order.class));
    }

    public List<Order> CheckStateforUser(int state_id,int user_id) throws SQLException {
        Connection connection = DataSourceUtils.getConnection();
        String sql = "select * from orders where state=" + state_id + "user_id=" + user_id;
        return runner.query(connection,sql, new BeanListHandler<Order>(Order.class));
    }

    @Override
    public void update(Order order) throws SQLException {
        String sql = "update orders set money=?,receiverinfo=?,state=? where id=?";
        runner.update(sql,order.getMoney(),order.getUser_addr_id(),order.getState(),order.getId() );
    }

    @Override
    public List<Order> outputforUser(int user_id) throws SQLException {
        Connection connection = DataSourceUtils.getConnection();
        String sql = "select * from orders where user_id=" + user_id;
        return runner.query(connection,sql, new BeanListHandler<Order>(Order.class));
    }


}
