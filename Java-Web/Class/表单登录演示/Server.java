import java.net.*;
import java.io.*;

public class Server
{
    public static void main(String[] args) throws Exception
    {
         //port > 100  65535可用
        ServerSocket ss = new ServerSocket(8888);
        System.out.println("server is listening");
     
        Socket socket = null;
        int n = 0;

        while(true)
        {
           //建立连接
           socket = ss.accept();
           n++;
           ServerThread thread = new ServerThread(socket, n);
           thread.start();
       }
    }
}