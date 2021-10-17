package cn.nsu.estore.pojo;

import java.sql.Timestamp;

public class Order {


    private int id; // 订单号
    private double money; // 金额
    private user_addr receiverinfo; // 收货人信息
    private int user_addr_id;
    private order_status state; // 支付状态
    private int order_status_id;
    private Timestamp ordertime; // 下单时间
    private int user_id; // 下单用户

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public double getMoney() {
        return money;
    }
    public void setMoney(double money) {
        this.money = money;
    }

    public user_addr getReceiverinfo() {
        return receiverinfo;
    }

    public void setReceiverinfo(user_addr receiverinfo) {
        this.receiverinfo = receiverinfo;
    }

    public order_status getState() {
        return state;
    }

    public void setState(order_status state) {
        this.state = state;
    }

    public Timestamp getOrdertime() {
        return ordertime;
    }
    public void setOrdertime(Timestamp ordertime) {
        this.ordertime = ordertime;
    }
    public int getUser_id() {
        return user_id;
    }
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getUser_addr_id() {
        return user_addr_id;
    }

    public void setUser_addr_id(int user_addr_id) {
        this.user_addr_id = user_addr_id;
    }

    public int getOrder_status_id() {
        return order_status_id;
    }

    public void setOrder_status_id(int order_status_id) {
        this.order_status_id = order_status_id;
    }

    public Order() {
    }

}
