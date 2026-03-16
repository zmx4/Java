
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Tick
 */
public class Server {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        Map<String, String> users = new ConcurrentHashMap<String, String>();
        try {
            ServerSocket ss = new ServerSocket(8888);
            System.out.println("Listening");
            while (true) {
                Socket s = ss.accept();
                System.out.println("Connected from: " + s.getInetAddress());
                
            }
        } catch (IOException ex) {
            System.getLogger(Server.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        users.put("a", "111");
        users.put("b", "222");
    }

    

    

}
