import java.net.*;
import java.io.*;
import java.util.*;

public class ServerThread extends Thread
{
    private Socket socket;

    public ServerThread(Socket socket, int n)
    {
        this.socket = socket;
        System.out.println("Client" + n + " is connected\r\n");
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
             String request = new String(bytes, 0, n);
             String[] requestLines = request.split("\r\n");  //HTTP请求消息所有的行             
             String line = null;     //请求消息的某一行

             System.out.println("==================== 查看请求消息开始============================");
             for(int i = 0; i < requestLines.length; i++ )
             {
                 line = requestLines[i];
                 System.out.println("line" + i + ":  " + line); 
             }
             System.out.println("==================== 请求消息结束===============================" + "\r\n\r\n");

             Map<String, String> params = new HashMap<String, String>(); //保存请求参数

             //请求消息首行所有的字符串
             System.out.println("first line:" + requestLines[0]);
             String[] firstLineStrs = requestLines[0].split(" "); 
                
             //得到请求method
             String method = firstLineStrs[0];
             params.put("method", method);

             //得到请求URI
             String uri = firstLineStrs[1].substring(1, firstLineStrs[1].length());
             params.put("URI", uri);
               
             //解析请求消息的请求头
             //sessionid=xxxxxxxxxxxx
             for(int i = 1; i < requestLines.length; i++ )
             {
                line = requestLines[i];
                String[] strs = line.split(" ");
                 
                if ("Cookie:".equals(strs[0]))
                {
                   strs = strs[1].split("=");
                   params.put(strs[0], strs[1]);  //sessionid  ABCDE123456
                   System.out.println("请求头Cookie " + strs[0]+ "   " + strs[1]);
                   break;
                }    
             }

             if("GET".equals(params.get("method")))
             {
                //客户端提交的信息都在首行
                //例如：GET /login?user=abc&pass=123 HTTP/1.1
                //Todo：解析首行获得uri和请求参数
                  
              }else if("POST".equals(params.get("method")))
             { 
                //客户端提交的信息都在请求实体
                //例如：user=def&pass=456
                line = requestLines[requestLines.length-1];   //请求实体
                System.out.println("request body:" + line);

                String[] bodyStrs = line.split("&");
                String[] temp = null;                
                for(int i = 0; i < bodyStrs.length; i++)
                {
                   temp = bodyStrs[i].split("=");
                   params.put(temp[0], temp[1]); //例如：user def 或者pass 456等
                }
              }
          
             //通过连接获得输入输出流
             //将资源的内容返回浏览器客户端
             os = socket.getOutputStream();
             os.write( ("HTTP/1.1 200 OK\r\n" + "Content-Type: text/html\r\n").getBytes() );
             
             //查看一下当前params内容
             System.out.println("==================== 查看params开始============================");
             Iterator<Map.Entry<String, String>> iterator1 = params.entrySet().iterator();
             Map.Entry<String, String> entry;
             while (iterator1.hasNext()) {
                entry = iterator1.next();
                System.out.print(entry.getKey() + ":");
                System.out.println(entry.getValue());;
             }
             System.out.println("==================== 查看params结束============================\r\n\r\n");
             
             //查看一下当前用户表内容
             System.out.println("==================== 查看users开始============================");
             iterator1 = Server.users.entrySet().iterator();
             while (iterator1.hasNext()) {
                entry = iterator1.next();
                System.out.print(entry.getKey() + ":");
                System.out.println(entry.getValue());;
             }
             System.out.println("==================== 查看users结束============================\r\n\r\n");


             if ("login".equals(params.get("URI")))
             {                    
                 String user = params.get("user");
                 String pass = params.get("pass");
                                                       
                 if (pass.equals(Server.users.get(user)))   
                 {
                     System.out.println("==================== 登录成功============================\r\n\r\n");                     
                     //生成一个随机字符串sessionid
                     String sessionid = Integer.toString((int)(Math.random() * 100000 + 1));
                     Server.onlineUsers.put(sessionid, user); 

                     //返回客户端 Set-Cookie: sessionid=xxxxxxxxxxxx
                     os.write(("Set-Cookie: " + "sessionid=" + sessionid + "\r\n").getBytes());
                     os.write("\r\n".getBytes());
                     os.write("login successfully".getBytes());
                 }

             }else if ("getDateTime".equals(params.get("URI")))
            {
                //获取当前时间
                DateTimeService dts = new DateTimeService();
                String response = dts.getDateTime();
                os.write("\r\n".getBytes());
                os.write(response.getBytes());
            }
            else if ("getWeather".equals(params.get("URI")))
            {
                //检查用户是否已登录（ sessionid  ）
                if ( Server.onlineUsers.containsKey(params.get("sessionid"))  )
                {
                   //获取当前的天气
                   WeatherService wthr = new WeatherService();
                   String response = wthr.getWeather();
                   os.write("\r\n".getBytes()); 
                   os.write(response.getBytes());
                 }else
                 {   
                    os.write("\r\n".getBytes());             
                    os.write("not allowed".getBytes());   
                    os.write("<a href='index.htm'>please login</a>");             
                 }
            }
            else{
                //获取指定的静态资源的内容
                File file = new File("web/" + params.get("URI"));
                is = new FileInputStream(file);
                int filelength = is.read(bytes);
                os.write("\r\n".getBytes()); 
                os.write(bytes, 0, filelength);
             }   
          }       
          catch(Exception e)
          {
              e.printStackTrace();
          }        
          finally{
             //释放资源
             try
             {  
                is.close();
                os.close();
                socket.close();
             }catch(Exception e)
             {
                e.printStackTrace();
             }
          }          
     }
}