import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Pipe {
    public static void main(String[] args) {
        try {
            Pipe p = new Pipe();
            
            final PipedOutputStream output = new PipedOutputStream();
            final PipedInputStream input = new PipedInputStream(output);

            Thread receiverThread = new Thread(() -> {
                try {
                    System.out.println("接收线程：准备接收数据...");
                    byte[] buffer = new byte[1024];
                    int len;
                    while ((len = input.read(buffer)) != -1) {
                        String received = new String(buffer, 0, len);
                        System.out.print(received);
                    }
                    input.close();
                    System.out.println("\n接收线程：数据接收完毕。");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            receiverThread.start();
            System.out.println("主线程：读取文件并发送...");
            String content = p.ReadTextFile("test.txt");
            output.write(content.getBytes());
            output.close();
            System.out.println("主线程：发送完毕。");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String ReadTextFile(String fileName) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while((line = br.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }
        }
        return sb.toString();
    }

}
