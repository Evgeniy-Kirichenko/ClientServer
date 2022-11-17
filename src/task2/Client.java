package task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        String host = "localhost";
        // сохранить файл hosts после редактирования не дает система
        int port = 8089;

        try (Socket clientSocket = new Socket(host, port)) {
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            Scanner sc = new Scanner(System.in);
            while (true) {
                String inSting = in.readLine();
                System.out.println(inSting);
                String outString = sc.nextLine();
                out.println(outString);
            }
        }

    }
}
