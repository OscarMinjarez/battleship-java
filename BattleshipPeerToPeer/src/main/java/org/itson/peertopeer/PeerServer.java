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
        this.thread = new Thread("server");
    }
    
    public void runServer() {
        this.run();
    }
    
    public void send(Object object) {
        this.serverObserver.send(object);
    }

    public void setServerObserver(IServerObserver serverObserver) {
        this.serverObserver = serverObserver;
    }

    @Override
    public void run() {
        this.thread.start();
        while (true) {
            try (Socket client = this.serverSocket.accept()) {
                System.out.println("Client connected " + client.getLocalPort());
                this.clients.add(client);
                for (Socket c : this.clients) {
                    ObjectInputStream input = new ObjectInputStream(c.getInputStream());
                    ObjectOutputStream output = new ObjectOutputStream(c.getOutputStream());
                    try {
                        Object object = input.readObject();
                        output.writeObject(object);
                        this.send(object);
                    } catch (ClassNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                }
            } catch (IOException e) {
                System.out.println("Connection error..." + e.getMessage());
            }
        }
    }
}
