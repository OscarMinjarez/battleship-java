package org.itson.presentation.standby;

import domain.Game;
import domain.Player;
import java.io.IOException;
import org.itson.peertopeer.facade.BattleshipPeerToPeerFacade;
import org.itson.peertopeer.facade.IBattleshipPeerToPeerFacade;
import org.itson.presentation.contracts.IBusinessObserver;
import org.itson.presentation.factories.ScreenFactory;


public class StandbyBusiness implements IBusinessObserver {
    
    private IBattleshipPeerToPeerFacade facade;
    private static StandbyBusiness instance;
    private Game game;
    
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
//            this.facade.connect("localhost", 5000);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    @Override
    public void notify(Object object) {
        System.out.println(object);
    }
    
    public static void main(String[] args) {
        StandbyBusiness standbyBusiness = StandbyBusiness.getInstance();
        standbyBusiness.showStandbyScreen();
        standbyBusiness.runServer();
    }
}
