package org.itson.peertopeer.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

import org.itson.peertopeer.IServerObserver;

public class HandleClientsMessages implements Runnable {

    private Thread thread;
    private List<ClientHandler> clients;
    private IServerObserver serverObserver;

    public HandleClientsMessages(List<ClientHandler> clients) {
        this.clients = clients;
        this.thread = new  Thread(this, "Clients messages handler thread");
    }

    public void start() {
        this.thread.start();
    }

    @Override
    public void run() {
        while (true) {
            synchronized (this.clients) {
                for (ClientHandler client : this.clients) {
                    try {
                        Object object = client.readObject();
                        this.serverObserver.send(object);
                    } catch (IOException | ClassNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
    }

    public void setServerObserver(IServerObserver serverObserver) {
        this.serverObserver = serverObserver;
    }
}
