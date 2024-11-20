package org.itson.peertopeer.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;

public class BattleshipPeerServer {
    
    private ServerSocket serverSocket;
    private CopyOnWriteArrayList<ClientHandler> clients;

    public BattleshipPeerServer(int port) throws IOException {
        this.clients = new CopyOnWriteArrayList<>();
        this.serverSocket = new ServerSocket(port);
    }

    public void runServer() {
        while (true) {
            try {
                Socket socket = this.serverSocket.accept();
                System.out.println("Client connected: " + socket.toString());
                ClientHandler clientHandler = new ClientHandler(socket);
                this.clients.add(clientHandler);
                new Thread(clientHandler).start();
            } catch (IOException e) {
                System.out.println("Error accepting connection: " + e.getMessage());
            }
        }
    }

    public void broadcast(Object message) {
        for (ClientHandler client : this.clients) {
            client.sendMessage(message);
        }
    }

    private class ClientHandler implements Runnable {

        private Socket socket;
        private ObjectOutputStream output;
        private ObjectInputStream input;

        public ClientHandler(Socket socket) throws IOException {
            this.socket = socket;
            this.output = new ObjectOutputStream(this.socket.getOutputStream());
            this.input = new ObjectInputStream(this.socket.getInputStream());
        }

        @Override
        public void run() {
            try {
                Object message;
                while ((message = this.input.readObject()) != null) {
                    broadcast(message);
                }
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Connection error: " + e.getMessage());
            } finally {
                try {
                    this.socket.close();
                } catch (IOException e) {
                    System.out.println("Error closing socket: " + e.getMessage());
                }
                clients.remove(this);
            }
        }

        public void sendMessage(Object message) {
            try {
                this.output.writeObject(message);
            } catch (IOException e) {
                System.out.println("Error sending message: " + e.getMessage());
            }
        }
    }
}
