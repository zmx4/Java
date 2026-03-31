import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket s = new ServerSocket(8888);
        while(true) {
            Socket socket = s.accept();
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            
            IService service = null;
            
            Request req = new Request(br.readLine());
            String target = req.getTarget();
            System.out.println(target);

            switch(target) {
                case "/login":
                    service = new LoginService();
                    break;
                default:
                    break;
            }
            if(service != null)service.process(req.getParam(), br, bw);
            br.close();
            bw.close();
        }
        
    }
}
