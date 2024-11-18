package org.itson.peertopeer.server;

import java.io.IOException;
import java.net.ServerSocket;

import org.itson.peertopeer.IServerObserver;

public class PeerServer implements Runnable {

    private Thread thread;
    private HandleSocketsConnection handleSocketsConnection;
    private HandleClientsMessages handleClientsMessages;
    private IServerObserver serverObserver;
    
    public PeerServer(int port) throws IOException {
        this.handleSocketsConnection = new HandleSocketsConnection(new ServerSocket(port));
        this.handleClientsMessages = new HandleClientsMessages(this.handleSocketsConnection.getClientSockets());
        this.thread = new Thread(this, "Peer server thread");
    }
    
    public void runServer() {
        this.thread.start();
    }
    
    public void send(Object object) {
        this.serverObserver.send(object);
    }

    public void setServerObserver(IServerObserver serverObserver) {
        this.serverObserver = serverObserver;
        this.handleSocketsConnection.setServerObserver(serverObserver);
        this.handleClientsMessages.setServerObserver(serverObserver);
    }

    @Override
    public void run() {
        this.handleSocketsConnection.start();
        this.handleClientsMessages.start();
    }
}
