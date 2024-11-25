package org.itson.peertopeer.facade;

import java.io.IOException;
import org.itson.presentation.contracts.IBusinessObserver;

public interface IBattleshipPeerToPeerFacade {
    
    void run(int port) throws IOException;
    void connect(int port);
    void connect(String host, int port);
    void writeObject(Object object) throws IOException;
    void setBusinessObserver(IBusinessObserver businessObserver);
}
