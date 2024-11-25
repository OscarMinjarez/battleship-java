package org.itson.presentation.standby;

import domain.Game;
import domain.Player;
import java.io.IOException;
import java.util.Map;
import lombok.Setter;
import org.itson.peertopeer.facade.BattleshipPeerToPeerFacade;
import org.itson.peertopeer.facade.IBattleshipPeerToPeerFacade;
import org.itson.peertopeer.model.BattleshipPeerMessage;
import org.itson.presentation.contracts.IBusinessObserver;
import org.itson.presentation.contracts.IModelObserver;
import org.itson.presentation.factories.ScreenFactory;


public class StandbyBusiness implements IBusinessObserver {
    
    private static StandbyBusiness instance;
    private IBattleshipPeerToPeerFacade facade;
    private Game game;
    
    @Setter private IModelObserver modelObserver;
    
    private StandbyBusiness() {
        this.facade = new BattleshipPeerToPeerFacade();
        this.facade.setBusinessObserver(this);
        this.game = new Game();
    }
    
    public static StandbyBusiness getInstance() {
        if (StandbyBusiness.instance == null) {
            StandbyBusiness.instance = new StandbyBusiness();
        }
        return StandbyBusiness.instance;
    }
    
    public void setPlayer(Player player) {
        this.game.addPlayer(player);
    }
    
    public void showStandbyScreen() {
        ScreenFactory.getInstance().showStandbyScreen();
    }
    
    public void showGameScreen() {
        ScreenFactory.getInstance().showGameScreen(this.game);
    }
    
    public void runServer() {
        try {
            this.facade.run(0);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    @Override
    public void notify(Object object) {
        if (object instanceof BattleshipPeerMessage message) {
            Map<String, Object> notification = message.getMessage();
            if (notification != null && notification.containsKey("port")) {
                int port = (int) notification.get("port");
                this.connect(port);
                return;
            }
            if (notification != null && notification.containsKey("client")) {
                this.modelObserver.notify(object);
                return;
            }
        }
    }
    
    private void connect(int port) {
        this.facade.connect(port);
    }
    
    public static void main(String[] args) {
        StandbyBusiness standbyBusiness = StandbyBusiness.getInstance();
        standbyBusiness.showStandbyScreen();
        standbyBusiness.runServer();
    }
}
