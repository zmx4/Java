public class Main {
    public static void main(String[] args) {
        Order order = new Order("001", "张三", 100.0, "待支付");
        order.displayOrderInfo();
        order.setPaymentMethod(new AliPay());
        order.payOrder();
        order.setDeliveryMethod(new ShunFengSend());
        order.deliveryOrder();
    }
}
