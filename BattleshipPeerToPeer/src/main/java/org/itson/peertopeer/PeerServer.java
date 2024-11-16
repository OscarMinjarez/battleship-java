package org.itson.peertopeer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class PeerServer implements Runnable {

    private ServerSocket serverSocket;
    private IServerObserver serverObserver;
    private Thread thread;

    private List<Socket> clients;
    
    public PeerServer(int port) throws IOException {
        this.clients = new ArrayList<>();
        this.serverSocket = new ServerSocket(port);
        this.thread = new Thread(this, "server");
    }
    
    public void runServer() {
        this.thread.start();
    }
    
    public void send(Object object) {
        this.serverObserver.send(object);
    }

    public void setServerObserver(IServerObserver serverObserver) {
        this.serverObserver = serverObserver;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Socket client = this.serverSocket.accept();
                synchronized (this.clients) {
                    this.clients.add(client);
                }
                System.out.println("Client connected " + client.getPort());
                new Thread(() -> this.handleClient(client)).start();
            } catch (IOException e) {
                System.out.println("Connection error: " + e.getMessage());
            }
        }
    }

    private void handleClient(Socket client) {
        try (
            ObjectInputStream input = new ObjectInputStream(client.getInputStream());
            ObjectOutputStream output = new ObjectOutputStream(client.getOutputStream());
        ) {
            while (true) {
                Object object = input.readObject();
                synchronized (this.clients) {
                    for (Socket c : this.clients) {
                        if (!c.equals(client)) {
                            try {
                                ObjectOutputStream otherOutput = new ObjectOutputStream(c.getOutputStream());
                                otherOutput.writeObject(object);
                            } catch (IOException e) {
                                System.out.println("Error sending to client: " + e.getMessage());
                            }
                        }
                    }
                }
                this.send(object);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error handling client: " + e.getMessage());
        } finally {
            synchronized (clients) {
                clients.remove(client);
            }
        }
    }
}
