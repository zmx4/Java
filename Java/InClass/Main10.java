import java.io.*;

public class Main10 {
    public static void main(String[] args) throws Exception {
        // 创建一个字符输入流，用于读取当前目录下source文件夹中的a.txt文件
        Reader in = new FileReader("source\\Chrysanthemum.jpg");

        // 创建一个文件字节输出流，用于将读取的数据写入target目录下的文件中
        Writer out = new FileWriter("target\\b.txt");

        char[] str = new char[1024]; // 字符缓冲区
        int len = -1;

        // 获取复制文件前的系统时间
        long begintime = System.currentTimeMillis();

        while ((len = in.read(str)) != -1) { // 读取并判断是否读到文件末尾
            out.write(str); // 将读到缓冲区写入文件
        }

        // 获取文件复制结束时的系统时间
        long endtime = System.currentTimeMillis();
        System.out.println("复制文件所消耗的时间是：" + (endtime - begintime) + "毫秒");

        in.close();
        out.close();
    }

}