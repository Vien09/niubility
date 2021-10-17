package cn.nsu.estore.dao.DaoImpl;

import java.sql.SQLException;
import java.util.List;

import cn.nsu.estore.pojo.NodeDate;
import cn.nsu.estore.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

public class NodeDateDao {

    QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

    public List<NodeDate> getCName(int level) throws SQLException {
        String sql = "select * from category where length(code)="+(level*2);
//        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        return runner.query(sql, new BeanListHandler<NodeDate>(NodeDate.class));
    }

    public List<NodeDate> getNextName(String code) throws SQLException {
        String sql = "select * from category where fathercode="+code;
//        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        return runner.query(sql, new BeanListHandler<NodeDate>(NodeDate.class));
    }

    public int getCode(String name) throws SQLException {
        String sql = "select * from category where name="+name;
//        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        long code = (long) runner.query(sql, new ScalarHandler());
        return (int) code;
    }

    public NodeDate getNodeDate(String name) throws SQLException {
        String sql = " select * from category where name =?";
//        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        return runner.query(sql, new BeanHandler<NodeDate>(NodeDate.class),name);
    }

}
