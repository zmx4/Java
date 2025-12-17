import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class FileMain{
    public static void main(String[] args) {
        File fio = new File("abs.txt");
        try {
            InputStream is = new FileInputStream(fio);
            long len = fio.length();
            // for()
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block你好
            e.printStackTrace();
        }
    }
}