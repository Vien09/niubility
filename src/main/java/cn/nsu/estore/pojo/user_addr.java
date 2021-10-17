package cn.nsu.estore.pojo;

import cn.nsu.estore.pojo.User;

/**
 * @Name : user_addr
 * @Description :
 * @Author : Vien
 */
public class user_addr {

    private int id; // 地址编号
    private int user_id; // 用户编号
    private User user;
    private String consignee; // 收货人名
    private int phone_no; // 手机号码
    private String address; // 地址
    private int default_addr; // 是否激活  1为默认地址

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public int getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(int phone_no) {
        this.phone_no = phone_no;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getDefault_addr() {
        return default_addr;
    }

    public void setDefault_addr(int default_addr) {
        this.default_addr = default_addr;
    }


    @Override
    public String toString() {
        return "user_addr{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", consignee=" + consignee +
                ", phone_no='" + phone_no + '\'' +
                ", address='" + address + '\'' +
                ", default_addr=" + default_addr +
                '}';
    }
}
