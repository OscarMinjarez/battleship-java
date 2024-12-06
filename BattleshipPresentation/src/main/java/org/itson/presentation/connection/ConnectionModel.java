package org.itson.presentation.connection;

import org.itson.business.ConnectionBusiness;
import java.util.HashMap;
import java.util.Map;
import org.itson.peertopeer.model.BattleshipPeerMessage;
import org.itson.presentation.contracts.IModelObserver;

public class ConnectionModel implements IModelObserver {

    private static ConnectionModel instance;
    private ConnectionBusiness connectionBusiness;
    private IConnectionObserver connectionObserver;

    private ConnectionModel() {
        this.connectionBusiness = ConnectionBusiness.getInstance();
        this.connectionBusiness.setModelObserver(this);
    }

    public static ConnectionModel getInstance() {
        if (ConnectionModel.instance == null) {
            ConnectionModel.instance = new ConnectionModel();
        }
        return ConnectionModel.instance;
    }

    public void setConnectionObserver(IConnectionObserver observer) {
        this.connectionObserver = observer;
    }

    public void connect(String host, int port) {
        this.connectionBusiness.connect(host, port);
    }

    @Override
    public void notify(Object object) {
        String isConnected = "connected";
        String error = "error";
        if (object instanceof BattleshipPeerMessage msg) {
            Map<String, Object> notification = msg.getMessage();

            if (notification.containsKey("status")) {
                String status = (String) notification.get("status");
                Map<String, Object> screenInfo = new HashMap<>();
                if (isConnected.equals(status)) {
                    screenInfo.put("status", notification.get("status"));
                } else if (error.equals(status)) {
                    screenInfo.put("status", notification.get("status"));
                    screenInfo.put("message", notification.get("message"));
                }
                this.update(screenInfo);
            }
        }
    }

    public void update(Object object) {
        this.connectionObserver.update(object);
    }
}
