package org.itson.presentation.game;

import lombok.Setter;
import org.itson.domain.Game;
import org.itson.presentation.factories.ScreenFactory;

public class GameBusiness {
    
    private static GameBusiness instance;
    @Setter private GameModel model;
    private Game game;
    
    private GameBusiness() {
    }
    
    public static GameBusiness getInstance() {
        if (GameBusiness.instance == null) {
            GameBusiness.instance = new GameBusiness();
        }
        return GameBusiness.instance;
    }
    
    
    public void setGame(Game game) {
        this.game = game;
    }
    
    public void showGameScreen() {
        ScreenFactory.getInstance().showGameScreen();
    }
    
    public boolean shoot(int index) {
       return this.game.shoot(index);
    }
    
    public static void main(String[] args) {
        GameBusiness gameBusiness = GameBusiness.getInstance();
        gameBusiness.showGameScreen();
    }
}
