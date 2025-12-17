import java.io.*;

public class Main03 {
   /**
    * @param args
    * @throws Exception
    */
   public static void main(String[] args) throws Exception {
      File file = new File("a.txt");

      try (InputStream is = new FileInputStream(file)) {
         int len = (int) file.length();
         for (int i = 0; i < len; i++) {
            int tmp = is.read();

            System.out.println(tmp); // 65
         }
         is.close();
      }
      try (OutputStream os = new FileOutputStream(file)) {
         // int len = (int) file.length();
         // for (int i = 0; i < len; i++) {
         //    int tmp = os.write();

         //    System.out.println(tmp); // 65
         // }
         String str = "qwqwqwq啊啊啊啊";
         byte[] b = {66,66,67,68};
         os.write(b);
         os.write(str.getBytes());
         os.close();
      }
   }
}