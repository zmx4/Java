import java.io.*;
import java.net.*;
import java.util.*;


public class Server {
    public static void main(String[] args) {
        Map<String, String> users = new HashMap<>();
        users.put("a", "111");
        try {
            ServerSocket ss = new ServerSocket(8888);
            System.out.println("Listening");
            while (true) {
                Socket s = ss.accept();
                System.out.println("Client connected: " + s.getInetAddress());
                new Thread(() -> {
                    try {
                        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
                        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
                        String request;
                        while ((request = br.readLine()) != null) {
                            System.out.println("Received request: " + request);
                            handleRequest(request, bw, users);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void handleRequest(String request, BufferedWriter bw, Map<String,String> users) throws IOException {
        String[] parts = request.split(" ");
        Command command = Command.valueOf(parts[0]);
        switch (command) {
            case LOGIN:
                handleLogin(parts, bw, users);
                break;
            case DOWNLOAD:
                handleDownload(parts, bw);
                break;
            case EXIT:
                handleExit(bw);
                break;
            default:
                bw.write("Unknown command\n");
                bw.flush();
        }
    }

    private static void handleLogin(String[] parts, BufferedWriter bw, Map<String,String>users) throws IOException {
        if (parts.length != 3) {
            bw.write("Invalid LOGIN command\n");
            bw.flush();
            return;
        }
        String username = parts[1];
        String password = parts[2];
        if (users.containsKey(username) && users.get(username).equals(password)) {
            bw.write("Login successful\n");
        } else {
            bw.write("Login failed\n");
        }
        bw.flush();
    }

    private static void  handleDownload(String[] parts, BufferedWriter bw) throws IOException {
        if (parts.length != 2) {
            bw.write("Invalid DOWNLOAD command\n");
            bw.flush();
            return;
        }
        String fileName = parts[1];
        File file = new File(fileName);
        if (!file.exists()) {
            bw.write("File not found\n");
            bw.flush();
            return;
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        bw.write(sb.toString() + "\n");
        bw.flush();
    }

    private static void handleExit(BufferedWriter bw) throws IOException {
        bw.write("Exit\n");
        bw.flush();
    }

    enum Command {
        LOGIN, DOWNLOAD, EXIT
    }
}