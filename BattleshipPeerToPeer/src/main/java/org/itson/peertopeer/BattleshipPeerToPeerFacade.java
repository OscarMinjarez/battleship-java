package org.itson.peertopeer;

import java.io.IOException;

public class BattleshipPeerToPeerFacade implements IBattleshipPeerToPeerFacade {

    private BattleshipPeerNode node;

    public BattleshipPeerToPeerFacade() {
        this.node = new BattleshipPeerNode();
    }

    @Override
    public void run(int port) throws IOException {
        this.node.run(port);
    }

    @Override
    public void connect(String host, int port) {
        this.node.connect(host, port);
    }

    @Override
    public void writeObject(Object object) throws IOException {
        this.node.writeObject(object);
    }
}
