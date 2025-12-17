import java.io.*;

public class Main05 {
    public static void main(String[] args) throws Exception {
        // 创建一个字节输入流，用于读取当前目录下source文件夹中的a.png文件
        InputStream in = new FileInputStream("a.exe");

        // 创建一个文件字节输出流，用于将读取的数据写入target目录下的文件中
        OutputStream out = new FileOutputStream("b.exe");

        int bt; // 定义一个int类型的变量len，记住每次读取的一个字节

        // 获取复制文件前的系统时间
        long begintime = System.currentTimeMillis();
        while ((bt = in.read()) != -1) { // 读取一个字节并判断是否读到文件末尾
            out.write(bt); // 将读到的字节写入文件
        }

        // 获取文件复制结束时的系统时间
        long endtime = System.currentTimeMillis();
        System.out.println("复制文件所消耗的时间是：" + (endtime - begintime) + "毫秒");

        in.close();
        out.close();
    }

}