
package org.itson.battleshippresentation.modelView;

import Dominio.Ship;
import org.itson.battleshippresentation.model.IStrategyObserver;



/**
 *
 * @author PabloCeasxr
 */
public class StrategyModelView implements IStrategyObserver {

    private StrategyModelView strategyModel;
    private static StrategyModelView instance;

    private StrategyModelView() {

    }

    public static StrategyModelView getInstance() {
        if (instance == null) {
            instance = new StrategyModelView();
        }
        return instance;
    }

    public void setPlayerReady(boolean value) {

    }

    public void putShipOnTable(Ship ship) {
        
    }

    @Override
    public void update() {
    }
}
