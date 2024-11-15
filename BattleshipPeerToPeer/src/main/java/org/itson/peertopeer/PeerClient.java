package org.itson.peertopeer;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class PeerClient implements IServerObserver, Runnable {
    
    private Socket socket;
    private ObjectOutputStream output;

    private PeerNode peerNode;
    private Thread thread;
    private InetAddress ip;
    
    public PeerClient(int port) throws UnknownHostException, IOException {
        this.peerNode = new PeerNode(port);
        this.peerNode.setServerObserver(this);
        this.ip = InetAddress.getLocalHost();

        this.socket = new Socket(ip.getHostAddress(), port);
        this.output = new ObjectOutputStream(this.socket.getOutputStream());
        this.thread = new Thread("client");
    }

    public void runServer() {
        this.run();
        this.peerNode.runServer();
    }

    public void connect(String host, int port) {
        
    }

    @Override
    public void send(Object object) {
        System.out.println(object);
    }

    public void writeObject(Object object) throws IOException {
        this.output.writeObject(object);
    }

    @Override
    public void run() {
        this.thread.start();
    }
}
