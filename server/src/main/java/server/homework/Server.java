package server.homework;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


public class Server {
    private ServerSocket server;
    private Socket socket;
    private final int PORT = 8000;

    private List<Client> client;

    public void Server() throws IOException {
        client = new CopyOnWriteArrayList<>();

        try {
            try {
                server = new ServerSocket(8000);
                client.add(new Client(socket));
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Waiting...");

            while (true) {
                    socket = server.accept();
                System.out.println("Connected");
            }
        } finally {
            try {
                socket.close();
                server.close();
                System.out.println("closed");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
