package org.itson.presentation.game;

import org.itson.domain.Coordiante;
import org.itson.domain.Game;
import org.itson.domain.Table;

/**
 *
 * @author PabloCeasxr
 */
public class GameModel {

    private static GameModel instance;
    private Game game;
    private IGameObserver gameOberver;
    private int actualCoordinate;
    private GameModel() {

    }

    public void update() {
        gameOberver.update();
    }

    public static GameModel getInstance() {
        if (instance == null) {
            return instance = new GameModel();
        }
        return instance;

    }

    public void shoot(Coordiante point) {
        // actualizar el tablero y el history 
        System.out.println("shoot to coordinate: "+actualCoordinate);
    }

    public void setGameObserver(IGameObserver gameObserver) {
        this.gameOberver = gameObserver;
    }
    
    public void setGame(Game game) {
        this.game = game;
    }
    
    public void setActualCoordinate(int actualCoordinate){
        this.actualCoordinate=actualCoordinate;
    } 
}
