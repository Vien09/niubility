package cn.nsu.estore.pojo;

/**
 * @Name : order_status
 * @Description :
 * @Author : Vien
 */
public class order_status {

    private int id; // 订单状态编号
    private String status_name; // 订单状态名

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus_name() {
        return status_name;
    }

    public void setStatus_name(String status_name) {
        this.status_name = status_name;
    }

    @Override
    public String toString() {
        return "order_status{" +
                "id=" + id +
                ", status_name='" + status_name + '\'' +
                '}';
    }
}
