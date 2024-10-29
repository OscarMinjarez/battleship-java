
package org.itson.battleshippresentation.modelView;

import Dominio.Coordiante;
import org.itson.battleshippresentation.model.GameModel;
import org.itson.battleshippresentation.model.IGameObserver;
import org.itson.battleshippresentation.view.GameView;


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
