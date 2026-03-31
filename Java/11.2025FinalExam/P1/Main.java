public class Main {
    public static void main(String[] args) {
        Order order = new Order("001", "张三", 100.0, "待支付");
        order.displayOrderInfo();
        double tax = order.calculateTax(0.1);
        System.out.println("税额: " + tax);
    }
}
