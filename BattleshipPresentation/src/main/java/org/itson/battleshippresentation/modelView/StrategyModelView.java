
package org.itson.battleshippresentation.modelView;

import Dominio.Ship;
import org.itson.battleshippresentation.model.IStrategyObserver;
import org.itson.battleshippresentation.model.StrategyModel;
import org.itson.battleshippresentation.view.StrategyView;



/**
 *
 * @author PabloCeasxr
 */
public class StrategyModelView implements IStrategyObserver {

    private StrategyModel strategyModel;
    private static StrategyModelView instance;
    private StrategyView strategyView;

    private StrategyModelView() {

    }

    public static StrategyModelView getInstance() {
        if (instance == null) {
            instance = new StrategyModelView();
        }
        return instance;
    }

    public void setPlayerReady(boolean value) {
        this.strategyModel.setPlayerReady(value);
    }

    public void putShipOnTable(Ship ship) {
        this.strategyModel.putShipOnTable(ship);
    }

    @Override
    public void update() {
    }
}
