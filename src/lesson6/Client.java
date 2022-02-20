package lesson6;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 8189;

    private static Socket socket;

    public static void main(String[] args) {
        try {
            socket = new Socket(SERVER_ADDRESS, SERVER_PORT);

            Scanner scanner = new Scanner(System.in);
            Scanner in = new Scanner(socket.getInputStream());
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            System.out.println("Клиент запущен");

            new Thread(() -> {
                try {
                    while (true) {
                        String msgFromServer = in.nextLine();
                        System.out.println(msgFromServer);
                    }
                } catch (Exception e) {
                    System.out.println("Соединение разорвано ");
                }
            }).start();

            while (true) {
                String str = scanner.nextLine();
                if (str.equals("/end")) {
                    break;
                }
                out.println(str);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
