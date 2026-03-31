public class Main {
    public static void main(String[] args) {
        Order order = new Order("001", "张三", 0, "待支付");
        PhysicalProduct physicalProduct = new PhysicalProduct("P001", "手机", 500.0, 0.5, 10);
        DigitalProduct digitalProduct = new DigitalProduct("D001", "电子书", 50.0, 100, "http://example.com/download");
        order.addProduct(physicalProduct);
        order.addProduct(digitalProduct);
        System.out.println("订单总额: " + order.calculateTotal());
    }
}
