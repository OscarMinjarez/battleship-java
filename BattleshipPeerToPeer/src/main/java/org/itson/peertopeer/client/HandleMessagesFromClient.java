package org.itson.peertopeer.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class HandleMessagesFromClient implements Runnable {

    private Socket socket;
    private Thread thread;

    private ObjectInputStream input;
    private ObjectOutputStream output;

    public HandleMessagesFromClient(Socket socket) throws IOException {
        this.socket = socket;
        this.thread = new Thread(this, "Message from client handler");
        // this.input = new ObjectInputStream(this.socket.getInputStream());
    }

    public void start() {
        this.thread.start();
    }

    @Override
    public void run() {
        while (true) {
            this.getMessages();
        }
    }

    private void getMessages() {
        new Thread(() -> {
            try {
                this.input = new ObjectInputStream(this.socket.getInputStream());
                Object object = this.input.readObject();
                System.out.println(object);
            } catch (IOException | ClassNotFoundException e) {
                System.out.println(e);
            }
        }).start();
    }

    public void sendMessages(Object object) {
        new Thread(() -> {
            while (true) {
                try {
                    this.output = new ObjectOutputStream(this.socket.getOutputStream());
                    this.output.writeObject(object);
                } catch (IOException e) {
                    System.out.println(e);
                }
            }
        }).start();
    }
}
