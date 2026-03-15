import java.io.*;

public class MainCopy {
    public static void main(String[] args) {
        File fileread = new File("a.txt");
        File filewrite = new File("b.txt");        
        try {
            filewrite.createNewFile();
            OutputStream os = new FileOutputStream(filewrite);
            InputStream is = new FileInputStream(fileread);
            
            byte[] f = new byte[(int)fileread.length()];
            is.read(f);
            os.write(f);
            is.close();
            os.close();

        }catch(IOException e){
            e.printStackTrace();
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
