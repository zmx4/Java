import java.io.File;

public class Main02 {
    public static void main(String[] args) throws Exception {
        File file = new File("D:\\file\\a.txt"); // 使用绝对路径创建File对象
        // file.createNewFile();

        File f1 = new File("Hello.java"); // 使用相对路径创建File对象
        f1.createNewFile();

        System.out.println("文件是否存在：" + file.exists());
        System.out.println("文件名：" + file.getName());
        System.out.println("文件大小：" + file.length() + "bytes");
        System.out.println("文件相对路径：" + file.getPath());
        System.out.println("文件绝对路径：" + file.getAbsolutePath());
        System.out.println("文件是否为文件：" + file.isFile());
        System.out.println("文件删除是否成功：" + file.delete());

        file = new File("D:");
        if (file.isDirectory()) { // 判断File对象对应的目录是否存在
            String[] names = file.list(); // 获得目录下的所有文件的文件名
            for (String name : names) {
                System.out.println(name); // 输出文件名
            }
        }

        fileDir(file);
    }

    public static void fileDir(File dir) {
        File[] files = dir.listFiles(); // 获得表示目录下所有文件的数组
        for (File file : files) { // 遍历所有的子目录和文件
            if (file.isDirectory()) {
                fileDir(file); // 如果是目录，递归调用fileDir()
            }
            System.out.println(file.getAbsolutePath()); // 输出文件的绝对路径
        }
    }

}
