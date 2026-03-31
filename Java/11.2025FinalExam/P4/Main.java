import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Order order1 = new Order("001", "Alice", 100.0, "Pending");
        Order order2 = new Order("002", "Bob", 200.0, "Completed");
        order1.displayOrderInfo();
        System.out.println("Tax for order1: " + order1.calculateTax(0.1));
        OrderFileManager fileManager = new OrderFileManager();
        try {
            fileManager.saveOrdersToFile(List.of(order1, order2), "orders.txt");
            fileManager.loadOrdersFromFile("orders.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
