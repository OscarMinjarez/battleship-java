package org.itson.peertopeer;

import java.io.IOException;

import org.itson.peertopeer.client.BattleshipPeerClient;
import org.itson.peertopeer.server.BattleshipPeerServer;

public class BattleshipPeerNode {

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
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void writeObject(Object object) throws IOException {
        this.peerClient.writeObject(object);
    }

    public void close() {
        try {
            this.peerClient.close();
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
