package org.itson.peertopeer.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class HandleSocketsConnection implements Runnable {
    
    private Thread thread;
    private ServerSocket serverSocket;
    private List<Socket> sockets;

    public HandleSocketsConnection(ServerSocket serverSocket) {
        this.sockets = new ArrayList<>();
        this.thread = new Thread(this, "Sockets connection handler thread");
        this.serverSocket = serverSocket;
    }

    public void start() {
        this.thread.start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                Socket client = this.serverSocket.accept();
                synchronized (this.sockets) {
                    this.sockets.add(client);
                }
                System.out.println("Client connected from port: " + client.getPort());
            } catch (IOException e) {
                System.out.println("An error ocurred in ");
            }
        }
    }

    public List<Socket> getClientSockets() {
        return this.sockets;
    }
}
