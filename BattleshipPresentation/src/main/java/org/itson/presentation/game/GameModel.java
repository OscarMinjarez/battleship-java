package org.itson.presentation.game;

import org.itson.presentation.contracts.IGameObserver;
import domain.Coordiante;
import domain.Game;
import domain.Table;

/**
 *
 * @author PabloCeasxr
 */
public class GameModel {

    private static GameModel instance;
    private Game game;
    private IGameObserver gameOberver;

    private GameModel() {

    }

    public void update() {
        
    }

    public static GameModel getInstance() {
        if (instance == null) {
            return instance = new GameModel();
        }
        return instance;

    }

    public void shoot(Coordiante point) {

    }

    public void setGameObserver(IGameObserver gameObserver) {
        this.gameOberver = gameObserver;
    }
    
    public void setGame(Game game) {
        this.game = game;
    }
}
