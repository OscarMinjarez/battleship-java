package org.itson.presentation.connection;

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
    
    public void connect(String host, int port){
        this.connectionBusiness.connect(host, port);
    }

    @Override
    public void notify(Object object) {
        this.connectionObserver.update(object);
    }
    
    public void update(Object object){
        this.connectionObserver.update(object);
    }
}
