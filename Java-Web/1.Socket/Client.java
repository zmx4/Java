import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 8888);
            PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
            pw.println("Hello, Server!");
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            pw.close();
            br.close();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
