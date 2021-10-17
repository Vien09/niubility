package cn.nsu.estore.dao;

import cn.nsu.estore.pojo.user_addr;

import java.sql.SQLException;
import java.util.List;

/**
 * @Name : User_addrDao
 * @Description :
 * @Author : Vien
 */
public interface User_addrDao {

    //地址添加
    public void addAddress(user_addr user_addr) throws SQLException;

    //删除单个地址信息
    public int delById(int id) throws SQLException;

    //查询所有地址信息
    public List<user_addr> findAll( int user_id) throws SQLException;

    public user_addr findById( int id) throws SQLException;

    public void update(user_addr ud) throws SQLException;
}
