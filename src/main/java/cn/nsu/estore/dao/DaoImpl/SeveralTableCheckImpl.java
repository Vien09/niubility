package cn.nsu.estore.dao.DaoImpl;

import cn.nsu.estore.dao.SeveralTableCheck;
import cn.nsu.estore.pojo.Order;
import cn.nsu.estore.pojo.OrderItem;
import cn.nsu.estore.service.OrderService;
import cn.nsu.estore.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Name : SeveralTableCheckImpl
 * @Description :
 * @Author : Vien
 */
public class SeveralTableCheckImpl implements SeveralTableCheck {

    @Override
    public String  CheckOrderItemForUser(OrderItem orderItem) throws SQLException {
        /*  实例
        order_id
        product_name
        buynum
        totalpx
        product_pic
        product_description
        */
        String sql = "select o.order_id,o.buynum,o.totalpx,p.imgurl,p.name,p.description from order_item o,products p " +
                "where o.order_id=" + orderItem.getOrder_id() + "and p.id=" ;
        return sql;
    }




}
