package org.itson.presentation.connection;

public class ConnectionViewModel implements IConnectionObserver {

    private static ConnectionViewModel instance;
    private ConnectionModel connectionModel;
    private ConnectionView connectionView;

    private ConnectionViewModel() {
        this.connectionModel = ConnectionModel.getInstance();
        this.connectionView = ConnectionView.getInstance();
        this.connectionModel.setConnectionObserver(this);
    }

    public static ConnectionViewModel getInstance() {
        if (ConnectionViewModel.instance == null) {
            ConnectionViewModel.instance = new ConnectionViewModel();
        }
        return ConnectionViewModel.instance;
    }

    public void showConnectionScreen() {
        this.connectionView.showConnectionView();
    }

    public void connect(String host, int port) {
        this.connectionModel.connect(host, port);
    }

    @Override
    public void update(Object object) {
        this.connectionView.update(object);
    }
}
