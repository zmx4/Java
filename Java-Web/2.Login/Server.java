
import java.io.*;
import java.time.LocalDateTime;
import java.net.*;
import java.util.*;
import java .util.concurrent.*;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Tick
 */
public class Server {
    public static Map<String, String> users = new ConcurrentHashMap<>();
    public static LocalDateTime nowTime = LocalDateTime.now();
    

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        users.put("a", "111");
        users.put("b", "222");
        try {
            ServerSocket ss = new ServerSocket(8888);
            System.out.println("Listening");
            while (true) {
                Socket s = ss.accept();
                System.out.println("Connected from: " + s.getInetAddress());
                BufferedWriter bw = new BufferedWriter(new PrintWriter(s.getOutputStream(), true));
                BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
                pool.execute(() -> {
                    try {
                        String line;
                        while ((line = br.readLine()) != null) {
                            Command cmd = parseCommand(line);
                            if (cmd == null) {
                                bw.write("Invalid command\n");
                                bw.flush();
                                continue;
                            }
                            switch (cmd) {
                                case LOGIN:
                                    String[] parts = line.split(" ");
                                    if (parts.length == 3 && checkLogin(parts[1], parts[2])) {
                                        bw.write("Login successful\n");
                                        nowTime = LocalDateTime.now();
                                        bw.write(nowTime.toString() + "\n");
                                    } else {
                                        bw.write("Login failed\n");
                                    }
                                    bw.flush();
                                    break;
                                case TEXT:
                                    System.out.println("Received text: " + line.substring(5)); // Skip "TEXT "
                                    break;
                                case EXIT:
                                    bw.write("Goodbye!\n");
                                    bw.flush();
                                    s.close();
                                    return;
                            }
                        }
                    } catch (IOException ex) {
                        System.getLogger(Server.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                    }
                });

            }
        } catch (IOException ex) {
            System.getLogger(Server.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    public static boolean checkLogin(String username, String password) {
        if (users.containsKey(username)) {
            return users.get(username).equals(password);
        }
        return false;
    }

    public static Command parseCommand(String line) {
        try {
            return Command.valueOf(line.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            return null; // Invalid command
        }
    }

    

    public enum Command {
        LOGIN, TEXT, EXIT
    }

}
