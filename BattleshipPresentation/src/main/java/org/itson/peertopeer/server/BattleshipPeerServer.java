package org.itson.peertopeer.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.itson.peertopeer.model.BattleshipPeerMessage;
import org.itson.peertopeer.IServerObserver;

public class BattleshipPeerServer {
    
    private ServerSocket serverSocket;
    private CopyOnWriteArrayList<ClientHandler> clients;
    
    private IServerObserver serverObserver;

    public BattleshipPeerServer(int port) throws IOException {
        this.clients = new CopyOnWriteArrayList<>();
        this.serverSocket = new ServerSocket(port);
    }
    
    public void setServerObserver(IServerObserver serverObserver) {
        this.serverObserver = serverObserver;
    }

    public void runServer() {
        new Thread(() -> {
            Map<String, Object> data = new HashMap<>();
            data.put("port", this.serverSocket.getLocalPort());
            System.out.println("Port from server..." + this.serverSocket.getLocalPort());
            this.serverObserver.send(
                    new BattleshipPeerMessage(
                            data
                    )
            );
        }).start();
        while (true) {
            try {
                Socket socket = this.serverSocket.accept();
                Map<String, Object> data = new HashMap<>();
                data.put("client", socket);
                new Thread(() -> {
                    System.out.println("Client connected..." + socket.getInetAddress() + ":" + socket.getLocalPort());
                    this.serverObserver.send(
                            new BattleshipPeerMessage(
                                    data
                            )
                    );
                }).start();
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
