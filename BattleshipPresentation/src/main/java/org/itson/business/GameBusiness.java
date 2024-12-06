package org.itson.business;

import lombok.Setter;
import org.itson.domain.Game;
import org.itson.presentation.factories.ScreenFactory;
import org.itson.presentation.game.GameModel;

public class GameBusiness {
    
    private static GameBusiness instance;
    @Setter private GameModel model;
    private Game game;
    
    private GameBusiness() {
        this.game = new Game();
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
        boolean shooting = this.game.shoot(index);
        if (shooting) {
            System.out.println("Si jala");
        }
        return shooting;
    }

    public static void main(String[] args) {
        GameBusiness gameBusiness = GameBusiness.getInstance();
        gameBusiness.showGameScreen();
    }
}
