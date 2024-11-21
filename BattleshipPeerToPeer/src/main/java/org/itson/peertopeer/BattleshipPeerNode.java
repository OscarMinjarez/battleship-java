package org.itson.peertopeer;

import java.io.IOException;

import org.itson.peertopeer.client.BattleshipPeerClient;
import org.itson.peertopeer.server.BattleshipPeerServer;

public class BattleshipPeerNode implements IServerObserver {

    private BattleshipPeerClient peerClient;
    
    public void run(int port) throws IOException {
        new Thread(() -> {
            try {
                BattleshipPeerServer server = new BattleshipPeerServer(port);
                server.runServer();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }).start();
    }

    public void connect(String host, int port) {
        try {
            this.peerClient = new BattleshipPeerClient(host, port);
            this.peerClient.setServerObserver(this);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void writeObject(Object object) throws IOException {
        this.peerClient.writeObject(object);
    }

    @Override
    public void send(Object object) {
        System.out.println(object);
    }

    public void close() {
        try {
            this.peerClient.close();
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
