
package org.itson.presentation.strategy;

import Dominio.Ship;
import org.itson.presentation.strategy.IStrategyObserver;
import org.itson.presentation.strategy.StrategyModel;
import org.itson.presentation.strategy.StrategyView;



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
