package org.itson.peertopeer.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import org.itson.peertopeer.IServerObserver;
import org.itson.peertopeer.PeerNode;

public class PeerClient implements IServerObserver, Runnable {
    
    private Socket socket;
    private ObjectInputStream input;
    private ObjectOutputStream output;

    private PeerNode peerNode;
    private Thread thread;
    private InetAddress ip;
    
    public PeerClient(int port) throws UnknownHostException, IOException {
        this.peerNode = new PeerNode(port);
        this.peerNode.setServerObserver(this);
        this.ip = InetAddress.getLocalHost();
        System.out.println("Initialized PeerClient in: " + this.ip + "; Port: " + port);
        this.socket = new Socket(this.ip, port);
        this.thread = new Thread(this, "client");
    }

    public void runServer() {
        this.thread.start();
    }

    public void connect(String host, int port) {
        new Thread(() -> {
            try {
                if (this.socket == null || this.socket.isClosed()) {
                    this.socket = new Socket(host, port);
                }
                if (this.output == null) {
                    this.output = new ObjectOutputStream(this.socket.getOutputStream());
                }
                if (this.input == null) {
                    this.input = new ObjectInputStream(this.socket.getInputStream());
                }
                System.out.println("Connected to server at " + host + ":" + port);
            } catch (IOException e) {
                System.out.println("Error connecting to server: " + e.getMessage());
            }
        }).start();
    }    

    @Override
    public void send(Object object) {
        System.out.println(object);
    }

    public void writeObject(Object object) throws IOException {
        if (this.output == null) {
            this.output = new ObjectOutputStream(this.socket.getOutputStream());
        }
        this.output.writeObject(object);
    }

    @Override
    public void run() {
        this.peerNode.runServer();
    }
}
