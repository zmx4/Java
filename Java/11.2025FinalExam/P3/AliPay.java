public class AliPay implements IPayment{
    @Override
    public void processPayment(double amount) {
        System.out.println("使用支付宝处理支付，金额: " + amount);
    }
}
