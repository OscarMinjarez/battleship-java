package org.itson.peertopeer.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

import org.itson.peertopeer.IServerObserver;

public class HandleClientsMessages implements Runnable {

    private Thread thread;
    private List<Socket> sockets;
    private IServerObserver serverObserver;

    public HandleClientsMessages(List<Socket> sockets) {
        this.sockets = sockets;
        this.thread = new  Thread(this, "Clients messages handler thread");
    }

    public void start() {
        this.thread.start();
    }

    @Override
    public void run() {
        while (true) {
            synchronized (this.sockets) {
                for (Socket client : this.sockets) {
                    try {
                        ObjectOutputStream output = new ObjectOutputStream(client.getOutputStream());
                        ObjectInputStream input = new ObjectInputStream(client.getInputStream());
                        Object object = input.readObject();
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
