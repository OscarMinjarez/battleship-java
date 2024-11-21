package org.itson.peertopeer;

import java.io.IOException;

public interface IBattleshipPeerToPeerFacade {
    
    void run(int port) throws IOException;
    void connect(String host, int port);
    void writeObject(Object object) throws IOException;
}
