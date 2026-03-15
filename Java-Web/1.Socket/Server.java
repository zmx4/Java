import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(8888);
            System.out.println("Listening");
            while (true) {
                Socket s = ss.accept();
                System.out.println("Connected from: " + s.getInetAddress());
                BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
                PrintWriter pw = new PrintWriter(s.getOutputStream(), true);

                String message;
                while ((message = br.readLine()) != null) {
                    System.out.println("Received: " + message);
                    pw.println("Server Echo: " + message);
                }

                pw.close();
                br.close();
                s.close();
                System.out.println("Disconnected");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
