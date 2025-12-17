import java.io.*;

public class Main061
{
    public static void main(String[] args) throws Exception
    {
        // 创建一个字节输入流，用于读取当前目录下source文件夹中的a.png文件
        InputStream in = new FileInputStream("source\\Chrysanthemum.jpg");
        
        // 创建一个文件字节输出流，用于将读取的数据写入target目录下的文件中
        OutputStream out = new FileOutputStream("target\\Chrysanthemum.jpg");

        InputStream bis = new BufferedInputStream(in);
        OutputStream bos = new BufferedOutputStream(out);

        int bt = -1;
        
        // 获取复制文件前的系统时间
        long begintime = System.currentTimeMillis();
        
       while ((bt = bis.read()) != -1) { // 读取一个字节并判断是否读到文件末尾
 	   bos.write(bt); // 将读到的字节写入文件
        }
        
        // 获取文件复制结束时的系统时间
        long endtime = System.currentTimeMillis();
        System.out.println("复制文件所消耗的时间是：" + (endtime - begintime) + "毫秒");
        
        bos.flush();
        in.close();
        out.close();
    }

}