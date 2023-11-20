package edu.homelab.task7.client;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;

public class Client {

    private static final String IP_ADDR = "127.0.0.1";
    private static final int PORT = 8080;
    private static Socket clientSocket;
    private static BufferedReader reader;
    private static BufferedReader in;
    private static BufferedWriter out;
    private static String userName = "newName";
    private static String msg = "";

    public static void main(String[] args) throws IOException {
        AtomicInteger firstMessage = new AtomicInteger(1);

        try {
            try {
                clientSocket = new Socket("localhost", PORT);
                reader = new BufferedReader(new InputStreamReader(System.in));
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                System.out.println("Секретный чат приветствует вас!");
                System.out.println("Введите свое имя до начала общения и нажмите Enter: ");
                userName = reader.readLine();
                out.write("userName@" + userName + "\n");
                out.flush();


                new Thread(() -> {
                    try {

                        String serverResponse;
                        while ((serverResponse = in.readLine()) != null) {
                            if (firstMessage.getAndSet(2) == 1) {
                                System.out.println("Приятно познакомиться " + userName + "!");
                                System.out.println("Вы присоединились к беседе, можете начать общение в чате.");
                            } else {
                                System.out.println(serverResponse);
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();

                String message;
                while ((message = reader.readLine()) != null) {
                    out.write(message + "\r\n");
                    out.flush();
                }


            } finally {
                System.out.println("Клиент был закрыт...");
                clientSocket.close();
                in.close();
                out.close();

            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }


}
