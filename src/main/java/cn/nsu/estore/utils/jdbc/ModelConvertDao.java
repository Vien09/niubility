package cn.nsu.estore.utils.jdbc;

import cn.nsu.estore.utils.DataSourceUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @Name : jdbcDao
 * @Description :
 * @Author : Vien
 */
public class ModelConvertDao {


//    public List<Map<String, Object>> findAllinList(String sql) throws SQLException {
        public static List<Map<String, String >> findAllinList(String sql) throws SQLException {
        Connection conn = null;


        try {
             conn = DataSourceUtils.getConnection();

            // 通过sql关联查询出员工表信息和所在部门名称

//            String sql = "select username,email,dept_phone,dept_name from user u,dept d where u.dept_id=d.dept_id ";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            List<Map<String, String>> list = ModelConvert.convertList(rs);

            return list;

        }catch (SQLException e1) {

            e1.printStackTrace();

            throw new RuntimeException("查询用户失败", e1);

        } finally {

        DataSourceUtils.closeConnection(conn);

        }

    }



    public Map<String, Object> findAllinMap(String sql) throws SQLException {

        Connection conn = null;


        try {
            conn = DataSourceUtils.getConnection();

            // 通过sql关联查询出员工表信息和所在部门名称

//            String sql = "select username,email,dept_phone,dept_name from user u,dept d where u.dept_id=d.dept_id ";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

           Map<String, Object> map = ModelConvert.convertMap(rs);

            return map;

        }catch (SQLException e1) {

            e1.printStackTrace();

            throw new RuntimeException("查询用户失败", e1);

        } finally {

            DataSourceUtils.closeConnection(conn);

        }

    }
}
