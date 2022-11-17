package task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        int port = 8089;
        System.out.println("Сервер запущен");

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                try (Socket clientSocket = serverSocket.accept()) {
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));


                    final String name = in.readLine();
                    System.out.printf("Новое соединение порт: %d , подключился %s%n", clientSocket.getPort(),name);
                    out.println(String.format("Привет %s, вы подключились к порту %d%n", name, clientSocket.getPort()));
                }
            }
        }
    }
}
