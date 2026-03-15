import java.io.*;

public class Main06 {
    public static void main(String[] args) {
        File fileread = new File("Chrysanthemum.jpg");
        File filewrite = new File("Chrysanthemum2.txt");
        try {
            long begintime = System.currentTimeMillis();
            filewrite.createNewFile();
            OutputStream os = new FileOutputStream(filewrite);
            InputStream is = new FileInputStream(fileread);

            // byte[] f = new byte[(int) fileread.length()];
            byte[] f = new byte[1024];
            is.read(f);
            os.write(f);

            long endtime = System.currentTimeMillis();
            System.out.println("复制文件所消耗的时间是：" + (endtime - begintime) + "毫秒");

            is.close();
            os.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
