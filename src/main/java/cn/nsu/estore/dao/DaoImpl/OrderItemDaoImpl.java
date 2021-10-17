package cn.nsu.estore.dao.DaoImpl;

import cn.nsu.estore.dao.OrderItemDao;
import cn.nsu.estore.pojo.OrderItem;
import cn.nsu.estore.utils.DataSourceUtils;
import cn.nsu.estore.utils.jdbc.ModelConvertDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @Name : OrderItemDaoImpl
 * @Description :
 * @Author : Vien
 */
public class OrderItemDaoImpl implements OrderItemDao {

    QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

    @Override
    public void addOrder(OrderItem orderItem) throws SQLException {
        String sql = "insert into order_item values(null,?,?,?,?,?,?,?,?,?,?)";

        runner.update(sql,orderItem.getOrder_id(),
                orderItem.getConsignee(),
                orderItem.getPhone_no(),
                orderItem.getAddress(),
                orderItem.getProd_name(),
                orderItem.getProd_imgurl(),
                orderItem.getProd_description(),
                orderItem.getProd_color(),
                orderItem.getBuynum(),
                orderItem.getTotalpx());
    }

    @Override
    public List<OrderItem> findAll(int order_id) throws SQLException {
        Connection connection = DataSourceUtils.getConnection();
        String sql = "select * from order_item where order_id = " + order_id;
        return runner.query(connection,sql, new BeanListHandler<>(OrderItem.class));
    }


//    public List<Map<String, String >> findAll(OrderItem orderItem) throws SQLException {
//        SeveralTableCheckImpl sql = new SeveralTableCheckImpl();
//        return ModelConvertDao.findAllinList( sql.CheckOrderItemForUser(orderItem));
//    }
}
