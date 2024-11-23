package org.itson.peertopeer.facade;

import java.io.IOException;
import org.itson.peertopeer.BattleshipPeerNode;
import org.itson.presentation.contracts.IBusinessObserver;

public class BattleshipPeerToPeerFacade implements IBattleshipPeerToPeerFacade {

    private final BattleshipPeerNode node;

    public BattleshipPeerToPeerFacade() {
        this.node = BattleshipPeerNode.getInstance();
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
    
    @Override
    public void setBusinessObserver(IBusinessObserver businessObserver) {
        this.node.setBusinessObserver(businessObserver);
    }
}
