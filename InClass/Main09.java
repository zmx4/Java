import java.io.*;

public class Main09
{
    public static void main(String[] args) throws Exception
    {
        InputStream in = new FileInputStream("source\\a.txt");        

        // 创建一个字符字节转换输入流
        Reader reader = new InputStreamReader(in, "UTF-8");
        
        int bt = -1;
        
        while ((bt = reader.read()) != -1) { // 读取一个字符并判断是否读到文件末尾
 	   System.out.println((char)bt);     
        }
        
        in.close();
    }

}