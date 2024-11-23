package org.itson.presentation.standby;

import domain.Game;
import domain.Player;
import java.io.IOException;
import org.itson.peertopeer.BattleshipPeerToPeerFacade;
import org.itson.peertopeer.IBattleshipPeerToPeerFacade;
import org.itson.presentation.factories.ScreenFactory;


public class StandbyBusiness {
    
    private IBattleshipPeerToPeerFacade facade;
    private static StandbyBusiness instance;
    private Game game;
    
    private StandbyBusiness() {
        this.facade = new BattleshipPeerToPeerFacade();
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
    
    public static void main(String[] args) {
        StandbyBusiness standbyBusiness = StandbyBusiness.getInstance();
        standbyBusiness.showStandbyScreen();
        standbyBusiness.runServer();
    }
}
