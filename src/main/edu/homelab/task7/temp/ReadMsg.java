package edu.homelab.task7.temp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static java.lang.System.in;

public class ReadMsg extends Thread {
    @Override
    public void run() {
        String str;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            while (true) {
                str =reader.readLine();
                if (str.equals("stop")) {
                    break;
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
