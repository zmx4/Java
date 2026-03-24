import java.net.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.Arrays;


public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("Listening on port 8888");
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream(), StandardCharsets.UTF_8));
                     BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream(), StandardCharsets.UTF_8))) {

                    System.out.println("Client connected: " + clientSocket.getInetAddress());
                    String line = br.readLine();
                    if (line == null) continue;
                    
                    String[] request = line.split(" ");
                    if (request.length < 2) continue;
                    String target = request[1];

                    while ((line = br.readLine()) != null && !line.isEmpty()) {
                        System.out.println(line);
                    }

                    if (target.startsWith("/")) {
                        target = target.substring(1);
                    }
                    if (target.isEmpty()) {
                        target = "index.html";
                    }

                    Path path = Path.of(target);
                    if (Files.exists(path) && !Files.isDirectory(path)) {
                        String content = readFile(path.toString());
                        bw.write("HTTP/1.1 200 OK\r\n");
                        bw.write("Content-Type: text/html; charset=UTF-8\r\n");
                        bw.write("Content-Length: " + content.getBytes(StandardCharsets.UTF_8).length + "\r\n");
                        bw.write("\r\n");
                        bw.write(content);
                        bw.flush();
                    }
                    System.out.println("\n");

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String readFile(String path) throws IOException {
        return Arrays.toString(Files.readAllBytes(Path.of(path)));
    }


}
