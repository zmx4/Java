import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(8888);
            System.out.println("Listening");
            Socket s = ss.accept();
            System.out.println("Connected");
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String message = br.readLine();
            System.out.println(message);
            PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
            pw.println(message);
            pw.close();
            br.close();
            s.close();
            ss.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
