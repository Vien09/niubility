package cn.nsu.estore.pojo;

/**
 * @Name : Cart
 * @Description :
 * @Author : Vien
 */
public class Cart {
    private int prod_id;
    private int user_id;
    private int set_num;

    public int getProd_id() {
        return prod_id;
    }

    public void setProd_id(int prod_id) {
        this.prod_id = prod_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getSet_num() {
        return set_num;
    }

    public void setSet_num(int set_num) {
        this.set_num = set_num;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "prod_id=" + prod_id +
                ", user_id=" + user_id +
                ", set_num=" + set_num +
                '}';
    }
}
