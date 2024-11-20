package org.itson.peertopeer.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class BattleshipPeerClient implements AutoCloseable {
    
    private Socket socket;
    private ObjectOutputStream output;
    private ObjectInputStream input;

    public BattleshipPeerClient(int port) throws IOException {
        InetAddress ip = InetAddress.getLocalHost();
        this.socket = new Socket(ip, port);
        System.out.println("Client started in: " + ip + ":" + port);
        this.output = new ObjectOutputStream(this.socket.getOutputStream());
        this.input = new ObjectInputStream(this.socket.getInputStream());
        this.start();
    }

    public BattleshipPeerClient(String host, int port) throws IOException {
        this.socket = new Socket(host, port);
        System.out.println("Client connected in: " + host + ":" + port);
        this.output = new ObjectOutputStream(this.socket.getOutputStream());
        this.input = new ObjectInputStream(this.socket.getInputStream());
        this.start();
    }

    public void writeObject(Object object) throws IOException {
        if (this.output == null) {
            this.output = new ObjectOutputStream(this.socket.getOutputStream());
        }
        this.output.writeObject(object);
    }

    private void start() {
        new Thread(() -> {
            try {
                Object message;
                while ((message = this.input.readObject()) != null) {
                    System.out.println(message);
                }
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Connection error: " + e.getMessage());
            }
        }).start();
    }

    public void close() throws IOException {
        this.socket.close();
    }
}
