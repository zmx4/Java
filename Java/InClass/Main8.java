import java.io.*;

public class Main8 {
    public static void main(String[] args) throws Exception {
        // 创建一个字节输入流，用于读取当前目录下source文件夹中的a.png文件
        InputStream in = new FileInputStream("FileMain.java");


        Reader render = new InputStreamReader(in,"UTF-8");
        char[] bts = new char[1000]; // 字节缓冲区
        int len = -1;

        while ((len = (render.read(bts))) != -1) { // 读取一个字节并判断是否读到文件末尾
            System.out.println(new String(bts,0,len));
        }

        

        // System.out.println(new String(bts));
        in.close();

    }

}