/*
按以下要求编写程序：(30分) 
定义父类设备类(Device)其中有： 
属性：名称(name),价格(price) 
构造方法：带参数构造方法，能够对名称和价格进行初始化 
方法：work:输出name is working(其中name为初始化后的值) 
定义接口Flyable：有一个抽象方法fly() 
定义子类：公交车(Bus)和飞机(Airplane) 
            除继承父类的属性外，还有自定义属性座位数量(seat) 
            构造方法：带参数构造方法，能够对名称、价格和座位初始化。 
方法：重写父类work方法，输出name is working with seat(其
中name和seat为初始化后的值) 
其中，飞机实现了接口Flyable的方法，输出name is flying(其
中name为初始化后的值)
*/
public class P3Test {
    public static void main(String[] args) {
        Device device = new Device("Generic Device", 1000.0);
        device.work();

        Bus bus = new Bus("City Bus", 50000.0, 40);
        bus.work();

        Airplane airplane = new Airplane("Boeing 747", 150000000.0, 366);
        airplane.work();
        airplane.fly();
    }
}
