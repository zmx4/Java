import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try{
            Socket s = new Socket("localhost", 8888);
            System.out.println("Connected to server: " + s.getInetAddress());
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

            bw.write("LOGIN a 111\n");
            bw.flush();
            
            String response = br.readLine();
            System.out.println("Login response: " + response);

            if(response != null && response.equals("Login successful")){
                bw.write("DOWNLOAD p2.html\n");
                bw.flush();
                String document = br.readLine();
                System.out.println("Received document: " + document);
            }


        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
