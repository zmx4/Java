/*
定义父类设备类(Device)其中有： 
属性：名称(name),价格(price) 
构造方法：带参数构造方法，能够对名称和价格进行初始化 
方法：work:输出name is working(其中name为初始化后的值) 
*/
public class Device {
    private String name;
    private double price;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public Device(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public void work() {
        System.out.println(name + " is working");
    }
}
