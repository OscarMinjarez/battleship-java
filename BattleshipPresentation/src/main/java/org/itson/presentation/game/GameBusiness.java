package org.itson.presentation.game;

import domain.Game;
import org.itson.presentation.factories.ScreenFactory;

public class GameBusiness {
    
    private static GameBusiness instance;
    private GameModel gameModel;
    private Game game;
    
    private GameBusiness() {
        this.gameModel = GameModel.getInstance();
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
        ScreenFactory.getInstance().showGameScreen(this.game);
    }
    
    public static void main(String[] args) {
        GameBusiness gameBusiness = GameBusiness.getInstance();
        gameBusiness.showGameScreen();
    }
}
