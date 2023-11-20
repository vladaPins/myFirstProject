package edu.homelab.task7.temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.out;

public class WriteMsg extends Thread{
    @Override
    public void run() {
        while (true){
            String userWord;
            try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
                userWord = reader.readLine();
                if (userWord.equals("stop")) {
                    out.write(("stop" + "\n").getBytes());
                    break; // выходим из цикла если пришло "stop"
                } else {
                    out.write((userWord + "\n").getBytes()); // отправляем на сервер
                }
                out.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
