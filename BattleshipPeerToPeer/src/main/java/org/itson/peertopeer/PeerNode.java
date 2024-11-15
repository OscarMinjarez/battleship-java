package org.itson.peertopeer;

import java.io.IOException;

public class PeerNode {
    
    private PeerServer peerServer;
    
    public PeerNode(int port) throws IOException {
        this.peerServer = new PeerServer(port);
    }

    public void runServer() {
        this.peerServer.runServer();
    }

    public void setServerObserver(IServerObserver serverObserver) {
        this.peerServer.setServerObserver(serverObserver);
    }
    
    public void connect(String host, int port) {
        
    }
}
