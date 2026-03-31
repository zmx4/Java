public class Order {
    private String orderId;//订单编号
    private String customerName;//客户姓名
    private double totalAmount;//订单总额
    private String status;//订单状态
    private IPayment paymentMethod;//支付方式
    private ISend deliveryMethod;//配送方式

    public ISend getDeliveryMethod() {
        return deliveryMethod;
    }
    public void setDeliveryMethod(ISend deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }
    public String getOrderId() {
        return orderId;
    }
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public double getTotalAmount() {
        return totalAmount;
    }
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
    public String getStatus() {
        return status;
    }
    public IPayment getPaymentMethod() {
        return paymentMethod;
    }
    public void setPaymentMethod(IPayment paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Order(String orderId, String customerName, double totalAmount, String status) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalAmount = totalAmount;
        this.status = status;
    }
    public void displayOrderInfo(){
        System.out.println("订单编号: " + orderId);
        System.out.println("客户姓名: " + customerName);
        System.out.println("订单总额: " + totalAmount);
        System.out.println("订单状态: " + status);
    }
    public double calculateTax(double taxRate){
        return totalAmount * taxRate;
    }
    public void payOrder(){
        paymentMethod.processPayment(totalAmount);
        status = "已支付";
    }
    public void deliveryOrder(){
        deliveryMethod.SendProduct();
    }
}
