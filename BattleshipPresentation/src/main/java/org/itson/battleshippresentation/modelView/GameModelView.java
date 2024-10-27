
package org.itson.battleshippresentation.modelView;

import Dominio.Coordiante;
import org.itson.battleshippresentation.model.IGameObserver;


/**
 *
 * @author PabloCeasxr
 */
public class GameModelView implements IGameObserver{

    private static GameModelView instance;
    private GameModelView gameModel;

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

    }

    
}
