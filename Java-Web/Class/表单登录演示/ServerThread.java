import java.net.*;
import java.io.*;

public class ServerThread extends Thread
{
    private Socket socket;

    public ServerThread(Socket socket, int n)
    {
        this.socket = socket;
        System.out.println("Client" + n + "is connected");
    }

     @Override     
     public void run()
     {
          InputStream is = null;
          OutputStream os = null;
          try{
             //通过连接获得输入输出流
             is = socket.getInputStream();
  
             //读取客户端发送的信息
             byte[] bytes = new byte[1024];
             int n = 0; 
             n = is.read(bytes);
             String str = new String(bytes, 0, n);
             System.out.println("client say:" + str);

             //解析资源名称
             String[] strLines = str.split("\r\n");
             System.out.println("first line:" + strLines[0]);
             String[] strs  = strLines[0].split(" ");
                //method
                String method = strs[0];
                System.out.println("method:" + strs[0]);
               
                String[] params = null;
                String line = null;

                if("GET".equals(method))
                {
                   //客户端提交的信息都在首行
                   //例如：GET /login?user=abc&pass=123 HTTP/1.1
                   //Todo：
                  
                }else if("POST".equals(method))
                { 
                   //客户端提交的信息都在实体
                   //例如：user=def&pass=456
                   line = strLines[strLines.length-1];
                   System.out.println("request body:" + line);

                   String[] bodyLines = line.split("&");
                   //bodyLines[0]  //user=def
                   //bodyLines[1]  //pass=566
                   params = bodyLines[0].split("=");
                   //params[1]  def
                }

                //uri
                System.out.println("uri:" + strs[1]);
                String uri = strs[1].substring(1, strs[1].length());
                System.out.println("uri:" + uri);
          
             //通过连接获得输入输出流
             //将资源的内容返回浏览器客户端
             os = socket.getOutputStream();
             os.write( ("HTTP/1.1 200 OK\r\n" + "Content-Type:text/html\r\n" + "\r\n").getBytes() );
             
             if ("login".equals(uri))
             {
                //返回用户的用户名
                String response = "<font color='red'>" + params[1] + "</font>";
                os.write(response.getBytes());

             }else{
                //获取指定的静态资源的内容
                File file = new File("web/" + uri);
                is = new FileInputStream(file);
                int filelength = is.read(bytes);
                os.write(bytes, 0, filelength);
             }   
          }       
          catch(Exception e)
          {
              e.printStackTrace();
          }        
          finally{
             //释放资源
             //is.close();
             //os.close();
             //socket.close();
          }          
     }
}