package org.itson.battleshippresentation.model;

import Dominio.Coordiante;
import Dominio.Game;
import Dominio.Table;

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
