import java.io.*;

public class Main7 {
    public static void main(String[] args) throws Exception {
        // 创建一个字节输入流，用于读取当前目录下source文件夹中的a.png文件
        InputStream in = new FileInputStream("source\\a.txt");

        byte[] bts = new byte[10]; // 字节缓冲区
        int len = -1;

        StringBuffer sb = new StringBuffer();

        while ((len = in.read(bts)) != -1) { // 读取一个字节并判断是否读到文件末尾
            sb.append(new String(bts, 0, len));
        }

        System.out.println(sb.toString());
        in.close();

    }

}