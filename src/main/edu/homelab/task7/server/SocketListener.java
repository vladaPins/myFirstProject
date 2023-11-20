package edu.homelab.task7.server;

import java.io.*;
import java.net.Socket;
import java.util.UUID;

import static edu.homelab.task7.server.Server.SOCKETS;

public class SocketListener implements Runnable {

    private final UUID id;
    private final Socket socket;
    private String username;
    private BufferedReader in;

    public SocketListener(UUID id, Socket socket) throws IOException {
        this.id = id;
        this.socket = socket;
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public Socket getSocket() {
        return socket;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String message = in.readLine();
                if (message.startsWith("userName@")) {
                    username = message.substring(8);
                    SocketListener socketListener = SOCKETS.get(id);
                    socketListener.username = username;
                    SOCKETS.put(id, socketListener);
                }
                if (message.equals("end")) {
                    System.out.println("Goodbye " + username);
                    break;
                }
                SOCKETS.forEach((id, socketListener) -> socketListener.send(message));
            }
        } catch (IOException e) {
            System.out.println("завершаем:" + e);
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void send(String message) {
        try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {
            out.write(username + ":" + message + "\n");
            out.flush();
        } catch (IOException e) {
            System.out.println("сообщение не отправлено из-за ошибки" + e);
        }
    }
}
