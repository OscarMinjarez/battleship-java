package org.itson.presentation.game;

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
    
}
