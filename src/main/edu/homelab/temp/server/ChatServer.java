package edu.homelab.temp.server;

import edu.homelab.temp.network.TCPConnection;
import edu.homelab.temp.network.TCPConnectionListener;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

public class ChatServer implements TCPConnectionListener {

    public static void main(String[] args) {
        new ChatServer();
    }

    private ArrayList<TCPConnection> connections = new ArrayList<>();

    public ChatServer() {

        System.out.println("Server running...");
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            while (true) {
                try {
                    new TCPConnection(this, serverSocket.accept());

                } catch (IOException e) {
                    System.out.println("TCPConnection exception: " + e);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public synchronized void onConnectionReader(TCPConnection tcpConnection) {
        connections.add(tcpConnection);
        sendToAllConnections("Client connected: " + tcpConnection);
    }

    @Override
    public synchronized void onReceiveString(TCPConnection tcpConnection, String value) {
        sendToAllConnections(value);
    }

    @Override
    public synchronized void onDisconnect(TCPConnection tcpConnection) {
        connections.remove(tcpConnection);
        sendToAllConnections("Client disconnected: " + tcpConnection);
    }

    @Override
    public synchronized void onException(TCPConnection tcpConnection, Exception e) {
        System.out.println("TCPConnection exeption: " + e);
    }


    private void sendToAllConnections(String value) {
        System.out.println(value);
        final int cnt = connections.size();
        for (int i = 0; i < cnt; i++) connections.get(i).sendString(value);

    }
//    private void sendPrivateMsg(String value,TCPConnection connection){
//        System.out.println(value);
//        connections.get(connection).sendString(value)
//
//    }

//    private Boolean isNameInMsg(String value){
//        Boolean isNameInMsg = false;
//       if (value.contains("@")){
//
//
//           fieldNickName.getText()
//           for (String word : wordList) {
//               if (word.equals(targetWord)) {
//                   found = true;
//       }
//
//return isNameInMsg;
//    }
}

