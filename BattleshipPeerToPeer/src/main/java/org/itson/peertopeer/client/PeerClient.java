package org.itson.peertopeer.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import org.itson.peertopeer.IServerObserver;
import org.itson.peertopeer.PeerNode;

public class PeerClient implements IServerObserver {
    
    private Socket socket;
    private ObjectInputStream input;
    private ObjectOutputStream output;

    private PeerNode peerNode;
    private InetAddress ip;

    private HandleMessagesFromClient handleMessagesFromClient;
    
    public PeerClient(int port) throws UnknownHostException, IOException {
        this.peerNode = new PeerNode(port);
        this.peerNode.setServerObserver(this);
        this.ip = InetAddress.getLocalHost();
        System.out.println("Initialized PeerClient in: " + this.ip + "; Port: " + port);
        this.socket = new Socket(this.ip, port);
        this.handleMessagesFromClient = new HandleMessagesFromClient(this.socket);
    }

    public PeerClient(String host, int port) throws IOException {
        this.connect(host, port);
    }

    public void runServer() {
        this.handleMessagesFromClient.start();
        this.peerNode.runServer();
    }

    private void connect(String host, int port) throws IOException {
        this.socket = new Socket(host, port);
        System.out.println("Initialized PeerClient in: " + this.ip + "; Port: " + port);
        this.handleMessagesFromClient = new HandleMessagesFromClient(this.socket);
        this.handleMessagesFromClient.start();
    }

    @Override
    public void send(Object object) {
        System.out.println(object);
    }

    public void writeObject(Object object) throws IOException {
        this.handleMessagesFromClient.sendMessages(object);
    }
}
