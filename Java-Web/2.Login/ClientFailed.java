import java.io.*;
import java.net.*;

public class ClientFailed {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 8888);
            BufferedWriter bw = new BufferedWriter(new PrintWriter(s.getOutputStream(), true));
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            bw.write("LOGIN a 123\n");
            bw.flush();
            String response;
            while ((response = br.readLine()) != null) {
                System.out.println("Server response: " + response);
            }
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}