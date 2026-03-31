import java.io.*;
import java.util.List;

public class OrderFileManager {
    public void saveOrdersToFile(List<Order> orders, String filename)throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Order order : orders) {
                writer.write(order.toString());
                writer.newLine();
            }
        }
    }
    public void loadOrdersFromFile(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}
