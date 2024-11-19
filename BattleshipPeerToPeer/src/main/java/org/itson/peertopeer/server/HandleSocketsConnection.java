package org.itson.peertopeer.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import org.itson.peertopeer.IServerObserver;

public class HandleSocketsConnection implements Runnable {
    
    private Thread thread;
    private ServerSocket serverSocket;
    private List<ClientHandler> clients;
    private IServerObserver serverObserver;

    public HandleSocketsConnection(ServerSocket serverSocket, List<ClientHandler> clients) {
        this.clients = clients;
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
                Socket socket = this.serverSocket.accept();
                ClientHandler client = new ClientHandler(socket);
                this.clients.add(client);
                System.out.println("Client connected...");
                this.serverObserver.send(client);
            } catch (IOException e) {
                System.out.println("An error ocurred in ");
            }
        }
    }

    public List<ClientHandler> getClientSockets() {
        return this.clients;
    }

    public void setServerObserver(IServerObserver serverObserver) {
        this.serverObserver = serverObserver;
    }
}
