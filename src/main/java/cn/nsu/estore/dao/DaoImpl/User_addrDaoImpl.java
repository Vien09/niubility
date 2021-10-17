package cn.nsu.estore.dao.DaoImpl;

import cn.nsu.estore.dao.User_addrDao;
import cn.nsu.estore.pojo.user_addr;
import cn.nsu.estore.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @Name : User_addrDaoImpl
 * @Description :
 * @Author : Vien
 */
public class User_addrDaoImpl implements User_addrDao {

    QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

    @Override
    public void addAddress(user_addr user_addr) throws SQLException {
        String sql = "insert into user_addr values(null,?,?,?,?,?)";

        runner.update(sql,user_addr.getUser_id(),user_addr.getConsignee(),
                user_addr.getPhone_no(),user_addr.getAddress(),user_addr.getDefault_addr());
    }

    @Override
    public int delById(int id) throws SQLException {
        String sql = "delete from user_addr where id=?";
//        String sql = "SET foreign_key_checks = 0;delete from user_addr where id=?;SET foreign_key_checks = 1";
//        int i =	runner.update(sql, id);

        runner.update("SET foreign_key_checks = 0");
        // 2.执行删除语句
        int i =	runner.update(sql, id);
        // 3.重新关联外键
        runner.update("SET foreign_key_checks = 1");
        return i;
    }

    @Override
    public List<user_addr> findAll( int user_id) throws SQLException {

        Connection connection = DataSourceUtils.getConnection();
        String sql = "select * from user_addr where user_id = " + user_id;
        return runner.query(connection,sql, new BeanListHandler<user_addr>(user_addr.class));
    }

    @Override
    public user_addr findById(int id) throws SQLException {
        Connection connection = DataSourceUtils.getConnection();
        String sql = "select * from user_addr where id = " + id;
        return runner.query(connection,sql,new BeanHandler<>(user_addr.class));
    }

    @Override
    public void update(user_addr ud) throws SQLException {
        String sql = "update user_addr set consignee=?,phone_no=?,address=?,default_addr=? where id=?";
        runner.update(sql, ud.getConsignee(),
                ud.getPhone_no(),ud.getAddress(),ud.getDefault_addr(), ud.getId());
    }



}
