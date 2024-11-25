package org.itson.presentation.standby;

import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import lombok.Setter;
import org.itson.peertopeer.model.BattleshipPeerMessage;
import org.itson.presentation.contracts.IModelObserver;

public class StandbyModel implements IModelObserver {
    
    private static StandbyModel instance;
    private IStandbyObserver standbyObserver;
    private StandbyBusiness standbyBusiness;
    
    @Setter private String host;
    @Setter private int port;
    
    private StandbyModel() {
        this.standbyBusiness = StandbyBusiness.getInstance();
        this.standbyBusiness.setModelObserver(this);
    }
    
    public static StandbyModel getInstance() {
        if (StandbyModel.instance == null) {
            StandbyModel.instance = new StandbyModel();
        }
        return StandbyModel.instance;
    }
    
    public void setStandbyObserver(IStandbyObserver standbyObserver) {
        this.standbyObserver = standbyObserver;
    }
    
    @Override
    public void notify(Object object) {
        if (object instanceof BattleshipPeerMessage message) {
            Map<String, Object> notification = message.getMessage();
            if (notification != null && notification.containsKey("client")) {
                Socket socket = (Socket) notification.get("client");
                this.host = socket.getInetAddress().toString();
                this.port = socket.getLocalPort();
                Map<String, Object> screenInfo = new HashMap<>();
                screenInfo.put("host", this.host);
                screenInfo.put("port", this.port);
                this.update(screenInfo);
            }
        }
    }
    
    public void update(Object object) {
        this.standbyObserver.update(object);
    }
}
