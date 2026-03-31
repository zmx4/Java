import java.io.*;

public class LoginService implements IService {
    @Override
    public void process(String param, BufferedReader br, BufferedWriter bw) throws Exception {
        ParameterParser parser = new ParameterParser(param);
        String id = parser.get("username");
        String pw = parser.get("password");

        bw.write("HTTP/1.1 200 OK\r\nContent-Type: text/html\r\n\r\n");
        if(id.equals("admin") && pw.equals("1234")) {
            bw.write("<h1>Login Success</h1>");
        } else {
            bw.write("<h1>Login Failed</h1>");
        }
        
        bw.flush();
    }
    
}
