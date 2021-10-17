package cn.nsu.estore.service;

import cn.nsu.estore.dao.User_addrDao;
import cn.nsu.estore.dao.DaoImpl.User_addrDaoImpl;
import cn.nsu.estore.pojo.user_addr;

import java.sql.SQLException;
import java.util.List;

/**
 * @Name : UserAddrService
 * @Description :
 * @Author : Vien
 */
public class UserAddrService {
    User_addrDao dao = new User_addrDaoImpl();

    //添加地址
    public void add(user_addr user_addr) throws SQLException {
        dao.addAddress(user_addr);
    }

    //查询所有商品信息
    public List<user_addr> findAll(int user_id) throws SQLException {
        return dao.findAll(user_id);
    }


    //修改产品信息
    public void update(user_addr user_addr) throws SQLException {
        dao.update(user_addr);
    }

    //删除单个数据
    public void delete(int id) throws SQLException {
        dao.delById(id);
    }

    public user_addr findById(int id) throws SQLException {
        return dao.findById(id);
    }

}
