
package org.itson.presentation.game;

import domain.Coordiante;
import org.itson.presentation.game.GameView;


/**
 *
 * @author PabloCeasxr
 */
public class GameModelView implements IGameObserver{

    private static GameModelView instance;
    private GameModel gameModel;
    private GameView gameView;

    private GameModelView() {

    }

    public static GameModelView getInstance() {
        if (instance == null) {
            instance = new GameModelView();
        }

        return instance;
    }
    
    @Override
    public void update() {
    }

    public void shoot(Coordiante point) {
        this.gameModel.shoot(point);
    }

    
}
