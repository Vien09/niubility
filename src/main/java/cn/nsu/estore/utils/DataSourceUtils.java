package cn.nsu.estore.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

public class DataSourceUtils {

    private static DruidDataSource dataSource;

    static {
        try {
            Properties properties = new Properties();

            InputStream inputStream = DataSourceUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            properties.load(inputStream);
//            properties.load(new FileInputStream(URLDecoder.decode(DataSourceUtils.class.getResource("/").getPath() + "jdbc.properties","UTF-8")));
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);

//            System.out.println(dataSource.getConnection());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    private static DataSource dataSource = new DruidDataSource();

    private static final ThreadLocal<Connection> tl = new ThreadLocal<>();

    public static DataSource getDataSource() {
        return dataSource;
    }

    // 获取绑定到ThreadLocal中的Connection。
    public static Connection getConnectionByTransaction() throws SQLException {
        Connection con = tl.get();
        if (con == null) {
            con = dataSource.getConnection();
            tl.set(con);
        }

        return con;
    }

    // 开启事务
    public static void startTransaction(Connection con) throws SQLException {
        if (con != null)
            con.setAutoCommit(false);
    }

    // 事务回滚
    public static void rollback(Connection con) throws SQLException {
        if (con != null)
            con.rollback();
    }

    public static void closeConnection(Connection con) throws SQLException {
        if (con != null) {
            con.commit();// 事务提交
            con.close();
            tl.remove();

        }
    }

    /**
     * 当DBUtils需要手动控制事务时，调用该方法获得一个连接
     *
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
