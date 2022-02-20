package lesson6;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private static Socket socket;
    private static ServerSocket server;
    private static final int PORT = 8189;

    public static void main(String[] args) {
        try {
            server = new ServerSocket(PORT);
            System.out.println("Сервер запущен");

            socket = server.accept();
            System.out.println("Клиент подключился");

            Scanner scanner = new Scanner(System.in);
            Scanner in = new Scanner(socket.getInputStream());
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            new Thread(() -> {
                try {
                    while (true) {
                        String msgFromClient = in.nextLine();
                        System.out.println(msgFromClient);
                    }
                } catch (Exception e) {
                    System.out.println("Соединение разорвано");
                }
            }).start();

            while (true) {
                String str = scanner.nextLine();
                if (str.equals("/end")) {
                    break;
                }
                out.println(str);

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
