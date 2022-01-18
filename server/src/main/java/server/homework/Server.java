package server.homework;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


public class Server {
    private ServerSocket serverSocket;
    private Socket socket;
    private final int PORT = 8000;

    private List<Client> client;

    public void serverSocket() {
        client = new CopyOnWriteArrayList<>();

        try {
            try {
                serverSocket = new ServerSocket(8000);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Waiting...");

            while (true) {
                try {
                    socket = serverSocket.accept();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Connected");
                new Thread(new Client(socket)).start();
            }
        } finally {
            try {
                socket.close();
                serverSocket.close();
                System.out.println("closed");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
