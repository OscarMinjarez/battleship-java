package org.itson.peertopeer;

import java.io.IOException;

import org.itson.peertopeer.client.BattleshipPeerClient;
import org.itson.peertopeer.server.BattleshipPeerServer;
import org.itson.presentation.contracts.IBusinessObserver;

public class BattleshipPeerNode implements IServerObserver {

    private static BattleshipPeerNode instance;
    private BattleshipPeerClient peerClient;
    private IBusinessObserver businessObserver;
    
    private BattleshipPeerNode() {
        
    }
    
    public static BattleshipPeerNode getInstance() {
        if (BattleshipPeerNode.instance == null) {
            BattleshipPeerNode.instance = new BattleshipPeerNode();
        }
        return BattleshipPeerNode.instance;
    }
    
    public void run(int port) throws IOException {
        new Thread(() -> {
            try {
                BattleshipPeerServer server = new BattleshipPeerServer(port);
                server.setServerObserver(this);
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
        this.businessObserver.notify(object);
    }
    
    public void setBusinessObserver(IBusinessObserver businessObserver) {
        this.businessObserver = businessObserver;
    }

    public void close() {
        try {
            this.peerClient.close();
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
