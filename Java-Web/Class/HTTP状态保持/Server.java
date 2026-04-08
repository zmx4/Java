import java.net.*;
import java.io.*;
import java.util.*;

public class Server
{
    public static Map<String, String> onlineUsers = new HashMap<String, String>();
                 
    public static Map<String, String> users = new HashMap<String, String>();
                 

    public static void main(String[] args) throws Exception
    {      
        users.put("admin", "123456");
        users.put("abc", "123");
        users.put("tom", "456");

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