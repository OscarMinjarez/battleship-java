package org.itson.presentation.connection;

import java.util.Map;
import lombok.Setter;
import org.itson.domain.Game;
import org.itson.peertopeer.facade.BattleshipPeerToPeerFacade;
import org.itson.peertopeer.facade.IBattleshipPeerToPeerFacade;
import org.itson.peertopeer.model.BattleshipPeerMessage;
import org.itson.presentation.contracts.IBusinessObserver;
import org.itson.presentation.contracts.IModelObserver;
import org.itson.presentation.factories.ScreenFactory;

public class ConnectionBusiness implements IBusinessObserver {

    private static ConnectionBusiness instance;
    private IBattleshipPeerToPeerFacade facade;

    @Setter
    private IModelObserver modelObserver;

    private ConnectionBusiness() {
        this.facade = new BattleshipPeerToPeerFacade();
        this.facade.setBusinessObserver(this);
    }

    public static ConnectionBusiness getInstance() {
        if (ConnectionBusiness.instance == null) {
            ConnectionBusiness.instance = new ConnectionBusiness();
        }
        return ConnectionBusiness.instance;
    }

    public void connect(String host, int port) {
        this.facade.connect(host, port);
    }

    public void showConnectionScreen() {
        ScreenFactory.getInstance().showConnectionScreen();
    }

    @Override
    public void notify(Object object) {
        if (object instanceof BattleshipPeerMessage message) {
        Map<String, Object> notification = message.getMessage();
        if (notification != null) {
            System.out.println("Mensaje recibido: " + notification);
        } else {
            System.out.println("Mensaje vacío recibido.");
        }
    }
    }

    public static void main(String[] args) {
        ConnectionBusiness connectionBusiness = ConnectionBusiness.getInstance();
        connectionBusiness.showConnectionScreen();

    }
}
