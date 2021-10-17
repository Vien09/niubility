package cn.nsu.estore.pojo;


/**
 * 订单中一项
 */
public class OrderItem {
    private int id;
    private Order order;
    private int order_id; // 订单号
    private String consignee;
    private int phone_no; // 手机号码
    private String address; // 地址
    private String prod_name; // 名称
    private String prod_imgurl; // 名称
    private String prod_description; // 名称
    private String prod_color; // 名称
    private int buynum; // 购买数量
    private double totalpx;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
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

    public String getProd_name() {
        return prod_name;
    }

    public void setProd_name(String prod_name) {
        this.prod_name = prod_name;
    }

    public String getProd_imgurl() {
        return prod_imgurl;
    }

    public void setProd_imgurl(String prod_imgurl) {
        this.prod_imgurl = prod_imgurl;
    }

    public String getProd_description() {
        return prod_description;
    }

    public void setProd_description(String prod_description) {
        this.prod_description = prod_description;
    }

    public String getProd_color() {
        return prod_color;
    }

    public void setProd_color(String prod_color) {
        this.prod_color = prod_color;
    }

    public int getBuynum() {
        return buynum;
    }

    public void setBuynum(int buynum) {
        this.buynum = buynum;
    }

    public double getTotalpx() {
        return totalpx;
    }

    public void setTotalpx(double totalpx) {
        this.totalpx = totalpx;
    }
}
