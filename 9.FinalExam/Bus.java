/*
定义接口Flyable：有一个抽象方法fly() 
定义子类：公交车(Bus)和飞机(Airplane) 
            除继承父类的属性外，还有自定义属性座位数量(seat) 
            构造方法：带参数构造方法，能够对名称、价格和座位初始化。 
方法：重写父类work方法，输出name is working with seat(其
中name和seat为初始化后的值) 
其中，飞机实现了接口Flyable的方法，输出name is flying(其
中name为初始化后的值)
*/
public class Bus extends Device {
    private int seat;
    public int getSeat() {
        return seat;
    }
    public void setSeat(int seat) {
        this.seat = seat;
    }
    public Bus(String name, double price, int seat) {
        super(name, price);
        this.seat = seat;
    }
    @Override
    public void work() {
        System.out.println(getName() + " is working with " + seat);
    }
}
