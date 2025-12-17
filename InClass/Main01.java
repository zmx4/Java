import java.io.File;

public class Main01 {
    public static void main(String[] args) throws Exception {
        File f = new File("D:\\file\\a.txt"); // 使用绝对路径创建File对象

        f.createNewFile();

        File f1 = new File("src\\Hello.java"); // 使用相对路径创建File对象
        f1.createNewFile();

    }
}
