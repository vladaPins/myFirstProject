package edu.homelab.task7.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class Server {

    private static final Integer PORT = 8080;
    public static final Map<UUID, SocketListener> SOCKETS = new ConcurrentHashMap<>();

    public static void main(String[] args) throws IOException {
        System.out.println("Server running...");
        try (ServerSocket server = new ServerSocket(PORT)) {
            while (!server.isClosed()) {
                try {
                    Socket socket = server.accept();
                    var id = UUID.randomUUID();
                    SocketListener socketListener = new SocketListener(id, socket);
                    SOCKETS.put(id, socketListener);
                    new Thread(socketListener).start();

                    System.out.println("New client has been connected, id = " + id);
                } catch (IOException e) {
                    System.out.println("Произошла ошибка: " + e);
                }
            }
        } finally {
            SOCKETS.forEach((id, socket) -> {
                try {
                    socket.getSocket().close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }
}

//    private synchronized void sendToAllConnections(String value) {
//        System.out.println(value);
//        final int cnt = connections.size();
//        for (int i = 0; i < cnt; i++) connections.get(i).(value);
//
//    }

//    private synchronized void sendPrivateMsg(String value, String userName) {
//        System.out.println(value);
//        for (Map.Entry<ServerSomething, String> user : connections.entrySet()) {
//            if (user.getValue().equals(userName)) {
//                user.getKey().se
//            }
//
//
//        }
//
//
//    }
//        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
//            String message = br.readLine();
//            while (!message.equals("exit")) {
//                System.out.println("User: " + message);
//                message = br.readLine();
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }


