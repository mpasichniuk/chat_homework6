package server.homework;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

    public class Client {
        private Socket socket;
        private Server server;
        private DataInputStream in;
        private DataOutputStream out;

        public Client(Socket socket) throws IOException {
            this.socket = socket;
            this.server = server;
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(socket.getInputStream());
            new Thread(() -> {
                try {
                    while (true) {
                        String w = in.readUTF();
                        if (w.equals("/end")) {
                            break;
                        }
                    }
                    try {
                        System.out.println("server.homework.Client disconnected");
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            });

        }

    }


