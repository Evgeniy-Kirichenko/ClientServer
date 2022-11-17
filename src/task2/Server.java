package task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        int port = 8089;
        System.out.println("Сервер запущен");

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                try (Socket clientSocket = serverSocket.accept()) {
                    Scanner sc = new Scanner(System.in);
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                    System.out.printf("Подключение к порту: %d%n", clientSocket.getPort());

                    out.println(String.format("Привет вы подключились к порту %d . Как вас зовут?.",
                            clientSocket.getPort()));
                    final String name = in.readLine();
                    System.out.println("Подключился " + name);
                    out.println(String.format("Привет %s  Are you child? (yes/no)?.", name));
                    if (in.readLine().toLowerCase().equals("yes")) {
                        out.println(String.format("Welcome to the kids area, %s Let's play!", name));
                    }
                    else out.println(String.format("Welcome to the adult zone, %s! Have a good rest, or a good working day!", name));
                }
            }
        }
    }
}
