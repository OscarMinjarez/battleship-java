package org.itson.peertopeer.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class HandleMessagesFromClient implements Runnable {

    private Socket socket;
    private Thread thread;
    
    private ObjectInputStream input;

    public HandleMessagesFromClient(Socket socket) throws IOException {
        this.socket = socket;
        this.thread = new Thread(this, "Message from client handler");
        this.input = new ObjectInputStream(this.socket.getInputStream());
    }

    public void start() {
        this.thread.start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                Object object = this.input.readObject();
                System.out.println("Message from server: " + object);
            } catch (IOException | ClassNotFoundException e) {
                System.out.println(e);
            }
        }
    }
}
