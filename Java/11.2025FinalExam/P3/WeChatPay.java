public class WeChatPay implements IPayment{
    @Override
    public void processPayment(double amount) {
        System.out.println("使用微信支付处理支付，金额: " + amount);
    }
}
